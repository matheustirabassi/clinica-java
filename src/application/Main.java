package application;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;
import model.dao.DaoFactory;
import model.dao.PacienteDao;
import model.entities.Endereco;
import model.entities.Paciente;

public class Main {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Paciente obj = new Paciente(1, "Matheus", "48386036818", "5515991096801", sdf.parse("16/04/2000"),
					"tirabassi.matheus@aluno.ifsp.edu.br", null);
			Endereco end = new Endereco("R Humberto de campos", 118, 18520000, "sp", 
					"Cerquilho", "Jardim Esplanada","Casa");
			obj.setEndereco(end);
			
			PacienteDao pacienteDao = DaoFactory.createPacienteDao();
			
			System.out.println(obj);
		} catch (ParseException e) {
			e.getLocalizedMessage();
		}
		Connection conn = DB.getConnection();
		DB.closeConnection();
	}
}
