package model.dao;

import db.DB;
import model.dao.impl.ConsultaDaoJDBC;
import model.dao.impl.LoginDaoJDBC;
import model.dao.impl.MedicoDaoJDBC;
import model.dao.impl.PacienteDaoJDBC;

public class DaoFactory {

	public static PacienteDao createPacienteDao() {
		return new PacienteDaoJDBC(DB.getConnection());
	}

	public static LoginDao createLoginDao() {
		return new LoginDaoJDBC(DB.getConnection());
	}

	public static MedicoDao createMedicoDao() {
		return new MedicoDaoJDBC(DB.getConnection());
	}

	public static ConsultaDao createConsultaDao() {
		return new ConsultaDaoJDBC(DB.getConnection());
	}
}
