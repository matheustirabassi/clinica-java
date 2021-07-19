package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.ConsultaDao;
import model.entities.Consulta;
import model.entities.Especialidade;
import model.entities.Medico;
import model.entities.Paciente;

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
	public List<Especialidade> findAllEspecialidade() {
		String sql = "select * from especialidade order by especialidade.nomeEspecialidade asc";

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

	@Override
	public void update(Consulta obj) {

	}

	@Override
	public List<Consulta> findAllByIdPaciente(Integer id) {
		String sql = "select consulta.*, medico.*, paciente.id from consulta inner join medico on medico.id = consulta.idMedico inner join paciente "
				+ "where paciente.id = consulta.idPaciente and paciente.id = ? order by consulta.dataMarcada asc";
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();
			List<Consulta> list = new ArrayList<>();

			while (rs.next()) {
				Consulta consulta = new Consulta(rs.getInt("consulta.id"), rs.getTimestamp("consulta.dataMarcada"),
						rs.getString("observacao"), rs.getInt("tipoConsulta"), rs.getInt("statusConsulta"), null);
				Medico medico = new Medico(rs.getInt("medico.id"), rs.getString("medico.nome"),
						rs.getString("medico.cpf"), rs.getString("medico.cpf"), rs.getString("medico.telefone"), null,
						null, null);
				Paciente paciente = new Paciente(rs.getInt("paciente.id"), null, null, null, null, null, null);
				consulta.setPaciente(paciente);
				consulta.setMedico(medico);
				medico.getConsultas().add(consulta);
				list.add(consulta);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}

	}

}
