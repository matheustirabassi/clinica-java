package application;

import java.util.List;

import db.DB;
import model.dao.DaoFactory;
import model.dao.PacienteDao;
import model.entities.Paciente;

public class Main {

	public static void main(String[] args) {

		PacienteDao pacienteDao = DaoFactory.createPacienteDao();
		System.out.println("=== TEST 1: paciente findById ===");
		Paciente paciente = pacienteDao.findById(1);
		System.out.println(paciente);
		List<Paciente> obj = pacienteDao.findAll();
		System.out.println("=== TEST 2: paciente findAll ===");
		obj.forEach(System.out::println);
		DB.closeConnection();
	}
}
