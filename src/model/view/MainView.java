package model.view;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import model.dao.DaoFactory;
import model.dao.PacienteDao;
import model.entities.Login;
import model.entities.Paciente;

public class MainView {

	public JFrame frame;
	public String str;

	/**
	 * Create the application.
	 */
	public MainView(Login obj) {
		initialize(obj);
	}

	public void initialize(Login objLogin) {

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 240, 245));
		frame.setBounds(100, 100, 629, 436);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Usu\u00E1rio:");
		lblNewLabel.setBounds(10, 11, 61, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblUsuario = new JLabel("");
		lblUsuario.setBounds(81, 11, 246, 14);
		frame.getContentPane().add(lblUsuario);
		lblUsuario.setText(objLogin.getPaciente().getNome());

		Button btnAddConsulta = new Button("Adicionar Consulta");
		btnAddConsulta.setBackground(new Color(224, 255, 255));
		btnAddConsulta.setActionCommand("");
		btnAddConsulta.setBounds(84, 169, 109, 60);
		frame.getContentPane().add(btnAddConsulta);
		btnAddConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Paciente paciente = objLogin.getPaciente();
				objLogin.setPaciente(paciente);;
				frame.setVisible(false);
				CadastrarConsulta window;
				window = new CadastrarConsulta(paciente);
				window.frame.setVisible(true);
			}
		});

		Button btnAlterCadastro = new Button("Alterar Cadastro");
		btnAlterCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PacienteDao pacienteDao = DaoFactory.createPacienteDao();
				Paciente paciente = pacienteDao.findById(objLogin.getPaciente().getId());
				frame.setVisible(false);
				CadastrarPaciente window;
				try {
					objLogin.setPaciente(paciente);
					paciente.setLogin(objLogin);
					window = new CadastrarPaciente(1, paciente);
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

		Button btnCheckConsulta = new Button("Checkar Consultas");
		btnCheckConsulta.setBackground(new Color(224, 255, 255));
		btnCheckConsulta.setBounds(251, 169, 109, 60);
		frame.getContentPane().add(btnCheckConsulta);

		btnCheckConsulta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PacienteDao pacienteDao = DaoFactory.createPacienteDao();
				Paciente paciente = pacienteDao.findById(objLogin.getPaciente().getId());

				objLogin.setPaciente(paciente);
				paciente.setLogin(objLogin);
				
				if (!objLogin.getPaciente().getConsultas().isEmpty()) {
					frame.setVisible(false);
					VisualizaConsultaView visualizaConsultaView = new VisualizaConsultaView(paciente);
					visualizaConsultaView.frmConsultas.setVisible(true);
				}
				

			}
		});

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
