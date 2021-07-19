package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.dao.PacienteDao;
import model.entities.Consulta;
import model.entities.Convencional;
import model.entities.Convenio;
import model.entities.Endereco;
import model.entities.Login;
import model.entities.Paciente;
import model.entities.Pagamento;
import model.entities.Enum.FormaPagamento;
import model.entities.Enum.StatusConsulta;
import model.entities.Enum.StatusPagamento;
import model.entities.Enum.TipoConsulta;

public class PacienteDaoJDBC implements PacienteDao {

	private Connection conn;

	public PacienteDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Paciente obj) {
		String sql = "INSERT INTO paciente(nome, cpf, telefone, email, dataNascimento) VALUES (?,?,?,?,?)";
		String sql2 = "INSERT INTO endereco(logradouro, numero, bairro, estado, cidade, cep, complemento, idPaciente) VALUES (?,?,?,?,?,?,?,?)";
		String sql3 = "INSERT INTO login(usuario, senha, idPaciente) VALUES (?,?,?)";
		PreparedStatement st = null;
		PreparedStatement st2 = null;
		PreparedStatement st3 = null;
		PreparedStatement st4 = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, obj.getNome());
			st.setString(2, obj.getCpf());
			st.setString(3, obj.getTelefone());
			st.setString(4, obj.getEmail());
			st.setDate(5, new java.sql.Date(obj.getDataNascimento().getTime()));
			st.executeUpdate();

			st2 = conn.prepareStatement(sql2);
			st2.setString(1, obj.getEndereco().getLogradouro());
			st2.setInt(2, obj.getEndereco().getNumero());
			st2.setString(3, obj.getEndereco().getBairro());
			st2.setString(4, obj.getEndereco().getEstado());
			st2.setString(5, obj.getEndereco().getCidade());
			st2.setInt(6, obj.getEndereco().getCep());
			st2.setString(7, obj.getEndereco().getComplemento());
			st3 = conn.prepareStatement("SELECT MAX(ID) FROM paciente");
			rs = st3.executeQuery();
			rs.next();
			st2.setInt(8, rs.getInt("MAX(ID)"));
			st2.executeUpdate();

			st4 = conn.prepareStatement(sql3);
			st4.setString(1, obj.getLogin().getUsuario());
			st4.setString(2, obj.getLogin().getSenha());
			st4.setInt(3, rs.getInt("MAX(ID)"));
			st4.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {

			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Paciente obj) {
		String sql = "UPDATE paciente SET nome = ?, cpf = ?, telefone = ?, email = ?, dataNascimento = ? "
				+ "WHERE id = ?";
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, obj.getNome());
			st.setString(2, obj.getCpf());
			st.setString(3, obj.getTelefone());
			st.setString(4, obj.getEmail());
			st.setDate(5, new java.sql.Date(obj.getDataNascimento().getTime()));
			st.setInt(6, obj.getId());
			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {

			DB.closeStatement(st);
		}

	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"DELETE paciente, endereco, login FROM paciente INNER JOIN endereco ON endereco.idPaciente = paciente.id INNER JOIN login ON login.idPaciente = paciente.id WHERE paciente.id = ?");
			st.setInt(1, id);

			st.executeUpdate();
		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public List<Paciente> findAll() {
		String sql = "select paciente.* , endereco.*, consulta.*, pagamento.*,login.* from paciente "
				+ "left join endereco on paciente.id = endereco.idPaciente "
				+ "left join consulta on paciente.id = consulta.idPaciente "
				+ "left join pagamento on paciente.id = pagamento.idConsulta "
				+ "left join login on paciente.id = login.idPaciente ";

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			List<Paciente> list = new ArrayList<>();
			Map<Integer, Paciente> map = new HashMap<>();

			while (rs.next()) {
				Paciente obj = map.get(rs.getInt("paciente.id"));
				Consulta consulta = null;
				Endereco endereco = null;
				Login login = null;
				List<Consulta> consultas = new ArrayList<>();
				if (obj == null) {
					endereco = instantiateEndereco(rs);
					login = instantiateLogin(rs);
					Pagamento pagamento = instantiatePagamento(rs);
					consulta = instantiateConsulta(rs, pagamento);
					consultas.add(consulta);
					map.put(rs.getInt("paciente.id"), obj);

				}
				obj = instantiatePaciente(rs, endereco, login, consultas);
				list.add(obj);

			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	@Override
	public Paciente findById(Integer id) {
		String sql = "select distinct paciente.* , endereco.*, consulta.*, pagamento.*,login.* from paciente "
				+ "left join endereco on paciente.id = endereco.idPaciente "
				+ "left join consulta on paciente.id = consulta.idPaciente "
				+ "left join pagamento on paciente.id = pagamento.idConsulta "
				+ "left join login on paciente.id = login.idPaciente where paciente.id = ?";

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();
			Paciente obj = null;
			List<Consulta> list = new ArrayList<>();
			while (rs.next()) {
				list.add(instantiateConsulta(rs, instantiatePagamento(rs)));
				obj = instantiatePaciente(rs, instantiateEndereco(rs), instantiateLogin(rs), list);
			}
			return obj;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	private Pagamento instantiatePagamento(ResultSet rs) throws SQLException {
		try {
			Pagamento pagamento = null;
			if (rs.getInt("formaPagamento") == 2) {
				pagamento = new Convencional();
				pagamento.setValor(rs.getDouble("valor"));
				((Convencional) pagamento).setFormaPagamento(FormaPagamento.values()[rs.getInt("formaPagamento") - 1]);
				((Convencional) pagamento)
						.setStatusPagamento(StatusPagamento.values()[rs.getInt("statusPagamento") - 1]);
				return pagamento;
			}
			pagamento = new Convenio();
			pagamento.setValor(rs.getDouble("valor"));
			((Convenio) pagamento).setPlano(rs.getString("convenio"));

			return pagamento;
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}

	private Consulta instantiateConsulta(ResultSet rs, Pagamento pagamento) throws SQLException {
		if (rs.getString("consulta.id") != null) {
			Consulta cons = new Consulta();
			cons.setId(rs.getInt("consulta.id"));
			cons.setDataMarcada(rs.getTimestamp("dataMarcada"));
			cons.setObservacao(rs.getString("observacao"));
			cons.setStatusConsulta(StatusConsulta.values()[rs.getInt("statusConsulta") - 1]);
			cons.setTipoConsulta(TipoConsulta.values()[rs.getInt("tipoConsulta") - 1]);
			cons.setPagamento(pagamento);
			return cons;
		}

		return null;
	}

	private Paciente instantiatePaciente(ResultSet rs, Endereco end, Login l, List<Consulta> list) throws SQLException {
		Paciente obj = new Paciente();
		obj.setId(rs.getInt("paciente.id"));
		obj.setCpf(rs.getString("cpf"));
		obj.setDataNascimento(rs.getDate("dataNascimento"));
		obj.setEmail(rs.getString("email"));
		obj.setNome(rs.getString("nome"));
		obj.setTelefone(rs.getString("telefone"));
		obj.setEndereco(end);
		obj.setLogin(l);
		obj.setConsultas(list);
		return obj;
	}

	private Login instantiateLogin(ResultSet rs) throws SQLException {
		Login l = new Login();
		l.setId(rs.getInt("login.id"));
		l.setUsuario(rs.getString("usuario"));
		l.setSenha(rs.getString("senha"));
		return l;
	}

	private Endereco instantiateEndereco(ResultSet rs) throws SQLException {
		Endereco end = new Endereco();
		end.setId(rs.getInt("endereco.id"));
		end.setCidade(rs.getString("cidade"));
		end.setLogradouro(rs.getString("logradouro"));
		end.setCep(rs.getInt("cep"));
		end.setNumero(rs.getInt("numero"));
		end.setBairro(rs.getString("bairro"));
		end.setEstado(rs.getString("estado"));
		end.setComplemento(rs.getString("complemento"));
		return end;
	}

}
