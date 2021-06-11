package dbacesso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;

public class CRUD {

	public void create(Pessoa p) {
		Connection conn = DB.getConnection();
		String sql = "insert into pessoa values(?,?,?,?)";
		try (PreparedStatement stm = conn.prepareStatement(sql)) {
			stm.setInt(1, p.getCodigo());
			stm.setString(2, p.getNome());
			stm.setString(3, p.getSexo());
			stm.setString(4, p.getEmail());
			stm.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	public List<Pessoa> read() {
		String sql = "select * from pessoa order by codigo";
		List<Pessoa> p = new ArrayList<>();
		try (PreparedStatement stm = DB.getConnection().prepareStatement(sql)) {
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				p.add(new Pessoa(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			DB.closeStatement(stm);
			DB.closeResultSet(rs);
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
		DB.closeConnection();
		}
		return p;
	}

	public void update(Pessoa p) {
		String sql = "update pessoa set nome = ?, sexo = ?, email = ? where codigo = ?";
		try (PreparedStatement stm = DB.getConnection().prepareStatement(sql)) {
			stm.setString(1, p.getNome());
			stm.setString(2, p.getSexo());
			stm.setString(3, p.getEmail());
			stm.setInt(4, p.getCodigo());
			stm.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	public void deleteById(Integer id) {
		String sql = "delete pessoa where codigo = ?";
		try (PreparedStatement stm = DB.getConnection().prepareStatement(sql)) {
			stm.setInt(1, id);
			stm.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}
}
