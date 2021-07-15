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
import model.dao.LoginDao;
import model.entities.Consulta;
import model.entities.Endereco;
import model.entities.Login;
import model.entities.Paciente;
import model.entities.Pagamento;

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
	public Login findByLogin(String st) {
		String sql = "select * from login where usuario = ?";

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, st);
			rs = ps.executeQuery();
			Login login = new Login();
			while (rs.next()) {
				
				login.setId(rs.getInt("id"));
				login.setUsuario(rs.getString("usuario"));
				login.setSenha(rs.getString("senha"));
				login.setIdPaciente(rs.getInt("idPaciente"));

			}
			return login;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(ps);
		}
	}
	

	

}
