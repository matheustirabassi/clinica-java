package application;

import model.dao.DaoFactory;
import model.dao.PacienteDao;
import model.entities.Paciente;

public class Main {

	public static void main(String[] args) {

		PacienteDao pacienteDao = DaoFactory.createPacienteDao();
		System.out.println("=== TEST 1: paciente findById ===");
		Paciente paciente = pacienteDao.findById(1);
		System.out.println(paciente);
	}
}
