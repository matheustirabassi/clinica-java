package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;
import model.dao.DaoFactory;
import model.dao.PacienteDao;
import model.entities.Endereco;
import model.entities.Login;
import model.entities.Paciente;

import java.awt.EventQueue;
import java.awt.Window;

import model.dao.controller.*;
public class Main {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
