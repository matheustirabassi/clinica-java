package model.dao.controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;

import model.dao.DaoFactory;
import model.dao.LoginDao;
import model.dao.PacienteDao;
import model.dao.service.PacienteDaoJDBC;
import model.entities.Login;
import model.entities.Paciente;

import java.awt.Button;

public class DefaultView {
	PacienteDao pcDao = DaoFactory.createPacienteDao();
	Paciente pc = new Paciente();
	Login lg = new Login();
	LoginDao loginDao = DaoFactory.createLoginDao();
	public JFrame frame;
	public String str;
	
	

	/**
	 * Create the application.
	 */
	public DefaultView(Login obj) {
		initialize(obj);
	}

	
	
	public void initialize(Login obj) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 240, 245));
		frame.setBounds(100, 100, 629, 436);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usu\u00E1rio:");
		lblNewLabel.setBounds(10, 11, 61, 14);
		frame.getContentPane().add(lblNewLabel);
		
		
		JLabel lblUsuario = new JLabel("");
		lblUsuario.setBounds(81, 11, 70, 14);
		frame.getContentPane().add(lblUsuario);
		lblUsuario.setText(obj.getUsuario());
		
		
		Button btnAddConsulta = new Button("Adicionar Consulta");
		btnAddConsulta.setBackground(new Color(224, 255, 255));
		btnAddConsulta.setActionCommand("");
		btnAddConsulta.setBounds(84, 169, 109, 60);
		frame.getContentPane().add(btnAddConsulta);
		
		
		
		System.out.println(obj.getIdPaciente());
		pc = pcDao.findByIdLogin(obj.getIdPaciente());
		
		Button btnAlterCadastro = new Button("Alterar Cadastro");
		btnAlterCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				CadastrarPaciente window;
				try {
					window = new CadastrarPaciente(1, pc);
					window.frame.setVisible(true);
					
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAlterCadastro.setBackground(new Color(224, 255, 255));
		btnAlterCadastro.setBounds(413, 169, 109, 60);
		frame.getContentPane().add(btnAlterCadastro);
		
		Button btnCheckConsulta = new Button("Checar Consultas");
		btnCheckConsulta.setBackground(new Color(224, 255, 255));
		btnCheckConsulta.setBounds(251, 169, 109, 60);
		frame.getContentPane().add(btnCheckConsulta);
		
		Button btnSair = new Button("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				try {
				
					LoginView window = new LoginView();
					window.frame.setVisible(true);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnSair.setBackground(new Color(255, 99, 71));
		btnSair.setBounds(516, 11, 70, 22);
		frame.getContentPane().add(btnSair);
		 
		
		
	}
	
}
