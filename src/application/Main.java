package application;

import java.sql.Connection;

import db.DB;
import entidades.Clinica;
import entidades.Endereco;

public class Main {

	public static void main(String[] args) {
		Connection conn = DB.getConnection();
		DB.closeConnection();
	}
}
