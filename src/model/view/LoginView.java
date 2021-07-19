package model.view;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.dao.DaoFactory;
import model.dao.LoginDao;
import model.entities.Login;

public class LoginView {

	public JFrame frame;
	private JTextField tfUsuario;
	private JPasswordField tfSenha;

	/**
	 * Create the application.
	 */
	public LoginView() {
		System.out.println("Abrindo login...");
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

		btnLogar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				try {
					LoginDao loginDao = DaoFactory.createLoginDao();
					Login login = loginDao.findByLogin(tfUsuario.getText());

					if (tfUsuario.getText().equals("") || String.copyValueOf(tfSenha.getPassword()).equals("")) {
						JOptionPane.showInternalMessageDialog(null, "Há campos em branco!", "AVISO",
								JOptionPane.WARNING_MESSAGE);
					} else if (login.getUsuario().equals(tfUsuario.getText())
							&& login.getSenha().equals(String.copyValueOf(tfSenha.getPassword()))) {
						frame.setVisible(false);

						MainView window;

						window = new MainView(login);
						window.frame.setVisible(true);
						System.out.println("Bem vindo(a) " + login.getPaciente().getNome());

					} else {
						JOptionPane.showMessageDialog(null, "Login ou senha incorreta!", "Erro no login",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Login ou senha incorreta!", "Erro no login",
							JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Abrindo tela de cadastro...");
				frame.setVisible(false);
				CadastrarPaciente window;
				try {

					window = new CadastrarPaciente(0, null);
					window.frame.setVisible(true);

				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(null, "formato da data incorreto!\n" + e1.getMessage(),
							"Erro na data", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
	}
}
