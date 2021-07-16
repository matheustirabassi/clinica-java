package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.LoginDao;
import model.entities.Login;
import model.entities.Paciente;

public class LoginDaoJDBC implements LoginDao {

	private Connection conn;

	public LoginDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Login obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Login obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Login> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Login findByLogin(String txt) {
		String sql = "select login.*, paciente.* from login inner join paciente on paciente.id = login.idPaciente where usuario = ?";

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, txt);
			rs = ps.executeQuery();
			Login login = null;
			Paciente paciente = null;
			while (rs.next()) {
				login = new Login(rs.getInt("id"), rs.getString("usuario"), rs.getString("senha"));
				paciente = new Paciente(rs.getInt("paciente.id"), rs.getString("nome"), rs.getString("cpf"),
						rs.getString("telefone"), rs.getDate("dataNascimento"), rs.getString("email"), null, login);
				login.setPaciente(paciente);

			}
			return login;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(ps);
		}
	}

	@Override
	public Login findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
