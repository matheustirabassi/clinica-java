package application;

import java.sql.Connection;

import db.DB;
import model.entities.Clinica;
import model.entities.Endereco;

public class Main {

	public static void main(String[] args) {
		Connection conn = DB.getConnection();
		DB.closeConnection();
	}
}
