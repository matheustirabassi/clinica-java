package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;
import model.dao.DaoFactory;
import model.dao.PacienteDao;
import model.entities.Endereco;
import model.entities.Login;
import model.entities.Paciente;

public class Main {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		PacienteDao pacienteDao = DaoFactory.createPacienteDao();
		System.out.println("=== TEST 1: paciente findById ===");
		Paciente paciente = pacienteDao.findById(7);
		System.out.println(paciente);
		//List<Paciente> obj = pacienteDao.findAll();
		//System.out.println("=== TEST 2: paciente findAll ===");
		// obj.forEach(System.out::println);
		/*
		System.out.println("=== TEST 2: paciente insert ===");
		
		try {
			pacienteDao.insert(new Paciente(null, "Marcel", "11111111111", "15919096801", sdf.parse("23/04/2001"), "marcel@gmail.com", new Endereco("R. Laranjeiras", 99, 18520000, "SP", "Campinas", "Maria Tereza", "Casa"), new Login(null, "marcel", "1234")));
			System.out.println(paciente);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("=== TEST 3: paciente update ===");
		try {
			pacienteDao.update(new Paciente(8, "Matheus", "12345678901", "11335678901", sdf.parse("16/04/2000"), "Matheus@gmail.com", null));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("=== TEST 3: paciente deleteById ===");
		//pacienteDao.deleteById(8);
		DB.closeConnection();
	}
	
}
