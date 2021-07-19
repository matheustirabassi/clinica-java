package application;

import java.awt.EventQueue;

import db.DB;
import model.view.LoginView;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
					window.frame.setVisible(true);
					window.frame.setTitle("Clinica");
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

		DB.closeConnection();

	}

}
