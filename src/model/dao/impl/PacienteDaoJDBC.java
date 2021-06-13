package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
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
import model.entities.Enum.TipoConsulta;

public class PacienteDaoJDBC implements PacienteDao {

	private Connection conn;

	public PacienteDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Paciente obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Paciente obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}
	@Override
	public List<Paciente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Paciente findById(Integer id) {
		String sql = "select paciente.* , endereco.*, consulta.*, pagamento.*, login.* from paciente inner join endereco on endereco.idPaciente = paciente.id inner join consulta on consulta.idPaciente= paciente.id inner join pagamento on pagamento.idConsulta = consulta.id inner join login on login.idPaciente = paciente.id where paciente.id = ?";

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			st.setInt(1, id);
			rs = st.executeQuery();

			if (rs.next()) {
				Paciente obj = instantiatePaciente(rs, instantiateEndereco(rs), instantiateLogin(rs),
						instantiateConsultas(rs));
				return obj;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	private Pagamento instantiatePagamento(ResultSet rs) throws SQLException {

		if (rs.getInt("formaPagamento") == 2) {
			Convencional pagamento = new Convencional();
			pagamento.setValor(rs.getDouble("valor"));
			pagamento.setFormaDePagamento(FormaPagamento.values()[rs.getInt("formaPagamento") - 1]);
			return pagamento;
		}
		Convenio pagamento = new Convenio();
		pagamento.setTarifa(rs.getDouble("valor"));
		pagamento.setPlano(rs.getString("convenio"));
		return pagamento;

	}

	private List<Consulta> instantiateConsultas(ResultSet rs) throws SQLException {
		List<Consulta> consultas = new ArrayList<>();
		consultas.add(instantiateConsulta(rs, instantiatePagamento(rs)));
		while (rs.next()) {
			consultas.add(instantiateConsulta(rs, instantiatePagamento(rs)));
		}
		rs.first();
		return consultas;
	}

	private Consulta instantiateConsulta(ResultSet rs, Pagamento pagamento) throws SQLException {
		Consulta cons = new Consulta();
		cons.setId(rs.getInt("consulta.id"));
		cons.setDataMarcada(rs.getTimestamp("dataMarcada"));
		cons.setObservacao(rs.getString("observacao"));
		cons.setStatusConsulta(StatusConsulta.values()[rs.getInt("statusConsulta") - 1]);
		cons.setTipoConsulta(TipoConsulta.values()[rs.getInt("tipoConsulta") - 1]);
		cons.setPagamento(pagamento);
		return cons;
	}

	private Paciente instantiatePaciente(ResultSet rs, Endereco end, Login l, List<Consulta> consultas)
			throws SQLException {
		Paciente obj = new Paciente();
		obj.setId(rs.getInt("paciente.id"));
		obj.setCpf(rs.getString("cpf"));
		obj.setDataNascimento(rs.getDate("dataNascimento"));
		obj.setEmail(rs.getString("email"));
		obj.setNome(rs.getString("nome"));
		obj.setTelefone(rs.getString("telefone"));
		obj.setEndereco(end);
		obj.setLogin(l);
		obj.setConsultas(consultas);
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

	

}
