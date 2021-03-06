package model.dao.service;

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
import model.entities.Endereco;
import model.entities.Login;
import model.entities.Paciente;
import model.entities.Enum.StatusConsulta;
import model.entities.Enum.TipoConsulta;

public class PacienteDaoJDBC implements PacienteDao {

	private Connection conn;

	public PacienteDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Paciente obj, Endereco obj2, Login obj3) {
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
			st2.setString(1, obj2.getLogradouro());
			st2.setInt(2, obj2.getNumero());
			st2.setString(3, obj2.getBairro());
			st2.setString(4, obj2.getEstado());
			st2.setString(5, obj2.getCidade());
			st2.setInt(6, obj2.getCep());
			st2.setString(7, obj2.getComplemento());
			st3 = conn.prepareStatement("SELECT MAX(ID) FROM paciente");
			rs = st3.executeQuery();
			rs.next();
			st2.setInt(8, rs.getInt("MAX(ID)"));
			st2.executeUpdate();

			st4 = conn.prepareStatement(sql3);
			st4.setString(1, obj3.getUsuario());
			st4.setString(2, obj3.getSenha());
			st4.setInt(3, rs.getInt("MAX(ID)"));
			st4.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {

			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Paciente obj, Endereco obj2, Login obj3) {
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
				+ "left join login on paciente.id = login.idPaciente ORDER BY paciente.id;";

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			List<Paciente> list = new ArrayList<>();
			Map<Integer, Paciente> map = new HashMap<>();
			Consulta consulta = null;
			Endereco endereco = null;
			Login login = null;
			while (rs.next()) {
				Paciente obj = map.get(rs.getInt("paciente.id"));

				List<Consulta> consultas = new ArrayList<>();
				if (obj == null) {
					endereco = instantiateEndereco(rs);
					login = instantiateLogin(rs);
					obj = instantiatePaciente(rs, endereco, login);
					map.put(rs.getInt("paciente.id"), obj);

				}
				Consulta c = instantiateConsulta(rs);
				obj.getConsultas().add(c);
				
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
				+ "left join login on paciente.id = login.idPaciente  where paciente.id = ?";

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();
			Paciente obj = null;
			List<Consulta> list = new ArrayList<>();
			while (rs.next()) {
				list.add(instantiateConsulta(rs));
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

	private Consulta instantiateConsulta(ResultSet rs) throws SQLException {
		if (rs.getString("consulta.id") != null) {
			Consulta cons = new Consulta();
			cons.setId(rs.getInt("consulta.id"));
			cons.setDataMarcada(rs.getTimestamp("dataMarcada"));
			cons.setObservacao(rs.getString("observacao"));
			cons.setStatusConsulta(StatusConsulta.toEnum(rs.getInt("statusConsulta")));
			cons.setTipoConsulta(TipoConsulta.toEnum(rs.getInt("tipoConsulta")));
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

	private Paciente instantiatePaciente(ResultSet rs, Endereco end, Login l) throws SQLException {
		Paciente obj = new Paciente();
		obj.setId(rs.getInt("paciente.id"));
		obj.setCpf(rs.getString("cpf"));
		obj.setDataNascimento(rs.getDate("dataNascimento"));
		obj.setEmail(rs.getString("email"));
		obj.setNome(rs.getString("nome"));
		obj.setTelefone(rs.getString("telefone"));
		obj.setEndereco(end);
		obj.setLogin(l);

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
		end.setNumero(rs.getInt("numero"));
		end.setBairro(rs.getString("bairro"));
		end.setEstado(rs.getString("estado"));
		end.setComplemento(rs.getString("complemento"));
		return end;
	}

	@Override
	public Paciente findByIdLogin(Integer idPaciente) {
		String sql = "select distinct paciente.* , endereco.*, consulta.*,login.* from paciente "
				+ "left join endereco on paciente.id = endereco.idPaciente "
				+ "left join consulta on paciente.id = consulta.idPaciente "
				+ "left join login on paciente.id = login.idPaciente  where paciente.id = ?";

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, idPaciente);
			rs = st.executeQuery();
			Paciente obj = new Paciente();
			Endereco obj2 = new Endereco();
			Login obj3 = new Login();

			while (rs.next()) {
				obj.setId(idPaciente);
				obj.setNome(rs.getString("nome"));
				obj.setCpf(rs.getString("cpf"));
				obj.setTelefone(rs.getString("telefone"));
				obj.setEmail(rs.getString("email"));
				obj.setDataNascimento(rs.getDate("dataNascimento"));
				obj2.setLogradouro(rs.getString("logradouro"));
				obj2.setId(idPaciente);
				obj2.setNumero(rs.getInt("numero"));
				obj2.setBairro(rs.getString("bairro"));
				obj2.setEstado(rs.getString("estado"));
				obj2.setCidade(rs.getString("cidade"));
				obj2.setCep(rs.getInt("cep"));
				obj2.setComplemento(rs.getString("complemento"));
				obj3.setId(idPaciente);
				obj3.setUsuario(rs.getString("usuario"));
				obj3.setSenha(rs.getString("senha"));
				obj.setLogin(obj3);
				obj.setEndereco(obj2);
			}
			return obj;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

}
