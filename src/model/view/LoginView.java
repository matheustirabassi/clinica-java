package model.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.JTextField;

import db.DB;
import model.dao.DaoFactory;
import model.dao.LoginDao;
import model.dao.PacienteDao;
import model.dao.impl.LoginDaoJDBC;
import model.entities.Login;
import model.entities.Paciente;

import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LoginView {
	Login lg = new Login();
	PacienteDao paciente = DaoFactory.createPacienteDao();
	Paciente pc = new Paciente();
	LoginDao loginDao = DaoFactory.createLoginDao();
	public JFrame frame;
	private JTextField tfUsuario;
	private JPasswordField tfSenha;

	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 521, 504);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 37));
		lblNewLabel.setBounds(174, 23, 166, 101);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Usu\u00E1rio");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(100, 180, 95, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(100, 226, 60, 14);
		frame.getContentPane().add(lblNewLabel_2);

		tfUsuario = new JTextField();
		tfUsuario.setBounds(212, 177, 118, 20);
		frame.getContentPane().add(tfUsuario);
		tfUsuario.setColumns(10);

		tfSenha = new JPasswordField();
		tfSenha.setBounds(212, 220, 118, 20);
		frame.getContentPane().add(tfSenha);

		JButton btnLogar = new JButton("Logar");
		btnLogar.setBounds(124, 299, 99, 34);
		frame.getContentPane().add(btnLogar);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(241, 299, 99, 34);
		frame.getContentPane().add(btnCadastrar);

		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				CadastrarPaciente window;
				try {
					window = new CadastrarPaciente(0, pc);
					window.frame.setVisible(true);

				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		btnLogar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (tfUsuario.getText().equals("") || tfSenha.getText().equals("")) {

					JOptionPane.showInternalMessageDialog(null, "Há campos em branco!", "AVISO ",
							JOptionPane.WARNING_MESSAGE);
				} else {
					lg = loginDao.findByLogin(tfUsuario.getText());
					System.out.println(lg.getUsuario());
					if (lg.getSenha() == null) {
						JOptionPane.showInternalMessageDialog(null, "Usuário incorreto", "AVISO ",
								JOptionPane.WARNING_MESSAGE);

					} else if (!lg.getSenha().equals(tfSenha.getText())) {
						JOptionPane.showInternalMessageDialog(null, "Senha incorreta", "AVISO ",
								JOptionPane.WARNING_MESSAGE);
					} else {
						frame.setVisible(false);

						DefaultView window;

						window = new DefaultView(lg);
						window.frame.setVisible(true);

					}
				}

			}
		});
	}
}
