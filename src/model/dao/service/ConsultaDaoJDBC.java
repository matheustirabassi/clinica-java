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
import model.dao.ConsultaDao;
import model.entities.Consulta;
import model.entities.Endereco;
import model.entities.Especialidade;
import model.entities.Login;
import model.entities.Medico;
import model.entities.Paciente;
import model.entities.Pagamento;

public class ConsultaDaoJDBC implements ConsultaDao {

	private Connection conn;

	public ConsultaDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Consulta findByIdPaciente(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Consulta> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Consulta obj) {
		String sql = "INSERT INTO consulta(dataMarcada, observacao, idMedico, idPaciente, tipoConsulta, statusConsulta) VALUES (?,?,?,?,?,?)";
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(sql);
			st.setTimestamp(1, new java.sql.Timestamp(obj.getDataMarcada().getTime()));
			st.setString(2, obj.getObservacao());
			st.setInt(3, obj.getMedico().getId());
			st.setInt(4, obj.getPaciente().getId());
			st.setInt(5, obj.getTipoConsulta().getCod());
			st.setInt(6, obj.getStatusConsulta().getCod());
			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {

			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Consulta obj, Paciente obj2, Medico obj3) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Especialidade> findAllEspecialidade() {
		String sql = "select * from especialidade";

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			List<Especialidade> especialidades = new ArrayList<>();

			while (rs.next()) {

				Especialidade esp;

				esp = instantiateEspecialidade(rs);
				especialidades.add(esp);

			}
			return especialidades;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	private Especialidade instantiateEspecialidade(ResultSet rs) throws SQLException {
		Especialidade e = new Especialidade();

		e.setNomeEspecialidade(rs.getString("nomeEspecialidade"));
		e.setId(rs.getInt("id"));
		e.setDescricao(rs.getString("descricao"));

		return e;
	}

}
