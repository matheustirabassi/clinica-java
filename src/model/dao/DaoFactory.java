package model.dao;

import db.DB;
import model.dao.service.LoginDaoJDBC;
import model.dao.service.PacienteDaoJDBC;

public class DaoFactory {

	public static PacienteDao createPacienteDao() {
		return new PacienteDaoJDBC(DB.getConnection());
	}
	public static LoginDao createLoginDao() {
		return new LoginDaoJDBC(DB.getConnection());
	}
}
