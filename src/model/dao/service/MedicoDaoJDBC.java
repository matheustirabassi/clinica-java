package model.dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.MedicoDao;
import model.entities.Endereco;
import model.entities.Especialidade;
import model.entities.Login;
import model.entities.Medico;
import model.entities.Paciente;

public class MedicoDaoJDBC implements MedicoDao{
	private Connection conn;

	public MedicoDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	@Override
	public void insert(Medico obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Medico obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Medico findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Medico> findAll() {
		String sql = "SELECT medico.*, especialidade.* FROM Medico INNER JOIN especialidade INNER JOIN especialidade_medico ON especialidade_medico.idMedico = medico.id and especialidade_medico.idEspecialidade = especialidade.id ORDER BY medico.nome ASC;";

		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			
			List<Medico> list = new ArrayList<>();
			while (rs.next()) {
				Medico medico = instantiateMedico(rs);
				list.add(medico);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}
	private Medico instantiateMedico(ResultSet rs) throws SQLException {
		Medico obj = new Medico(rs.getInt("medico.id"), rs.getString("nome"), rs.getString("cpf"), rs.getString("telefone"), rs.getString("email"), new Especialidade(rs.getInt("especialidade.id"), rs.getString("especialidade.nomeEspecialidade"), rs.getString("especialidade.descricao")), null, null);
		return obj;
	}

}

