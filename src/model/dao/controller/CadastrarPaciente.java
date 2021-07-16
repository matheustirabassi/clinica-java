package model.dao.controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import model.dao.DaoFactory;
import model.dao.PacienteDao;
import model.entities.Endereco;
import model.entities.Login;
import model.entities.Paciente;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarPaciente {

	Paciente pc = new Paciente();
	Endereco en = new Endereco();
	Login lg = new Login();
	PacienteDao pacienteDao = DaoFactory.createPacienteDao();
	public JFrame frame;
	private JTextField tfNome;
	private JTextField tfCpf;
	private JTextField tfTelefone;
	private JTextField tfEmail;
	private JTextField tfDtNasci;
	private JTextField tfLogra;
	private JTextField tfNum;
	private JTextField tfBairro;
	private JTextField tfEstado;
	private JTextField tfCidade;
	private JTextField tfCep;
	private JTextField tfComplemento;
	private JTextField tfUsuario;
	private JPasswordField tfSenha;
	private JPasswordField tfSenha2;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 * 
	 * @throws ParseException
	 */
	public CadastrarPaciente(Integer num, Paciente obj) throws ParseException {
		initialize(num, obj);
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws ParseException
	 */
	private void initialize(Integer opt, Paciente pa) throws ParseException {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 521, 506);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome completo:");
		lblNewLabel.setBounds(22, 30, 142, 14);
		frame.getContentPane().add(lblNewLabel);

		tfNome = new JTextField();
		tfNome.setBounds(124, 27, 144, 20);
		frame.getContentPane().add(tfNome);
		tfNome.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("CPF:");
		lblNewLabel_1.setBounds(271, 30, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);

		tfCpf = new JTextField();
		tfCpf.setText("");
		tfCpf.setBounds(308, 27, 86, 20);
		frame.getContentPane().add(tfCpf);
		tfCpf.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Telefone: ");
		lblNewLabel_2.setBounds(22, 65, 63, 14);
		frame.getContentPane().add(lblNewLabel_2);

		tfTelefone = new JTextField();
		tfTelefone.setBounds(101, 62, 86, 20);
		frame.getContentPane().add(tfTelefone);
		tfTelefone.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setBounds(22, 98, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);

		tfEmail = new JTextField();
		tfEmail.setText("");
		tfEmail.setBounds(102, 95, 133, 20);
		frame.getContentPane().add(tfEmail);
		tfEmail.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Data de Nascimento:");
		lblNewLabel_4.setBounds(22, 128, 167, 14);
		frame.getContentPane().add(lblNewLabel_4);

		JFormattedTextField tfDtNasci = new JFormattedTextField(new MaskFormatter("##/##/####"));
		tfDtNasci.setBounds(174, 126, 86, 20);
		frame.getContentPane().add(tfDtNasci);
		tfDtNasci.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Informa\u00E7\u00F5es Pessoais");
		lblNewLabel_5.setBounds(22, 5, 225, 14);
		frame.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Endere\u00E7o");
		lblNewLabel_6.setBounds(22, 171, 78, 14);
		frame.getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Logradouro:");
		lblNewLabel_7.setBounds(22, 208, 78, 14);
		frame.getContentPane().add(lblNewLabel_7);

		tfLogra = new JTextField();
		tfLogra.setBounds(102, 205, 200, 20);
		frame.getContentPane().add(tfLogra);
		tfLogra.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("N\u00BA");
		lblNewLabel_8.setBounds(324, 208, 46, 14);
		frame.getContentPane().add(lblNewLabel_8);

		tfNum = new JTextField();
		tfNum.setBounds(348, 205, 46, 20);
		frame.getContentPane().add(tfNum);
		tfNum.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Bairro:");
		lblNewLabel_9.setBounds(22, 236, 46, 14);
		frame.getContentPane().add(lblNewLabel_9);

		tfBairro = new JTextField();
		tfBairro.setBounds(101, 233, 86, 20);
		frame.getContentPane().add(tfBairro);
		tfBairro.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("Estado:");
		lblNewLabel_10.setBounds(200, 236, 46, 14);
		frame.getContentPane().add(lblNewLabel_10);

		tfEstado = new JTextField();
		tfEstado.setBounds(256, 236, 86, 20);
		frame.getContentPane().add(tfEstado);
		tfEstado.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel("Cidade:");
		lblNewLabel_11.setBounds(22, 267, 46, 14);
		frame.getContentPane().add(lblNewLabel_11);

		tfCidade = new JTextField();
		tfCidade.setText("");
		tfCidade.setBounds(102, 264, 86, 20);
		frame.getContentPane().add(tfCidade);
		tfCidade.setColumns(10);

		JLabel lblNewLabel_12 = new JLabel("CEP:");
		lblNewLabel_12.setBounds(200, 267, 46, 14);
		frame.getContentPane().add(lblNewLabel_12);

		tfCep = new JTextField();
		tfCep.setText("");
		tfCep.setBounds(256, 264, 86, 20);
		frame.getContentPane().add(tfCep);
		tfCep.setColumns(10);

		JLabel lblNewLabel_13 = new JLabel("Complemento:");
		lblNewLabel_13.setBounds(22, 301, 115, 14);
		frame.getContentPane().add(lblNewLabel_13);

		tfComplemento = new JTextField();
		tfComplemento.setBounds(134, 298, 86, 20);
		frame.getContentPane().add(tfComplemento);
		tfComplemento.setColumns(10);

		JLabel lblNewLabel_14 = new JLabel("Login");
		lblNewLabel_14.setBounds(22, 342, 46, 14);
		frame.getContentPane().add(lblNewLabel_14);

		JLabel lblNewLabel_15 = new JLabel("Usu\u00E1rio:");
		lblNewLabel_15.setBounds(22, 377, 63, 14);
		frame.getContentPane().add(lblNewLabel_15);

		tfUsuario = new JTextField();
		tfUsuario.setBounds(78, 374, 86, 20);
		frame.getContentPane().add(tfUsuario);
		tfUsuario.setColumns(10);

		JLabel lblNewLabel_16 = new JLabel("Senha:");
		lblNewLabel_16.setBounds(22, 408, 46, 14);
		frame.getContentPane().add(lblNewLabel_16);

		JLabel lblNewLabel_17 = new JLabel("Digite novamente:");
		lblNewLabel_17.setBounds(200, 408, 102, 14);
		frame.getContentPane().add(lblNewLabel_17);

		JButton btnSalvar = new JButton("Salvar/Alterar");
		btnSalvar.setBounds(137, 430, 115, 23);
		frame.getContentPane().add(btnSalvar);

		JButton btnCancelar = new JButton("Cancelar");

		btnCancelar.setBounds(269, 430, 89, 23);
		frame.getContentPane().add(btnCancelar);

		tfSenha = new JPasswordField();
		tfSenha.setBounds(78, 405, 86, 20);
		frame.getContentPane().add(tfSenha);

		tfSenha2 = new JPasswordField();
		tfSenha2.setBounds(337, 405, 89, 20);
		frame.getContentPane().add(tfSenha2);

		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int escolha = JOptionPane.showConfirmDialog(null, "Gostaria de cancelar?", "Cancelar",
						JOptionPane.YES_NO_OPTION);
				if (escolha == 0) {

					tfNome.setText("");
					tfTelefone.setText("");
					tfEmail.setText("");
					tfCpf.setText("");
					tfComplemento.setText("");
					tfUsuario.setText("");
					tfSenha.setText("");
					tfSenha2.setText("");
					tfLogra.setText("");
					tfNum.setText("");
					tfCep.setText("");
					tfCidade.setText("");
					tfEstado.setText("");
					tfDtNasci.setText("");
					btnCancelar.setEnabled(false);
					frame.setVisible(false);
					if (opt == 0) {
						LoginView window = new LoginView();
						window.frame.setVisible(true);
					} else {

						lg.setUsuario(pa.getLogin().getUsuario());
						lg.setSenha(pa.getLogin().getSenha());
						lg.setIdPaciente(pa.getId());
						lg.setId(pa.getId());
						DefaultView window = new DefaultView(lg);
						window.frame.setVisible(true);
					}
				}
			}
		});

		if (opt == 1) {
			SimpleDateFormat sdf = new SimpleDateFormat("ddmmyyyy");

			tfNome.setText(pa.getNome());
			tfTelefone.setText(pa.getTelefone());
			tfEmail.setText(pa.getNome());
			tfCpf.setText(pa.getCpf());
			tfEmail.setText(pa.getEmail());
			tfDtNasci.setText(pa.getDataNascimento().toString());
			tfLogra.setText(pa.getEndereco().getLogradouro());
			tfNum.setText(pa.getEndereco().getNumero().toString());
			tfBairro.setText(pa.getEndereco().getBairro());
			tfEstado.setText(pa.getEndereco().getEstado());
			tfCidade.setText(pa.getEndereco().getCidade());
			tfCep.setText(pa.getEndereco().getCep().toString());
			tfComplemento.setText(pa.getEndereco().getComplemento());
			tfUsuario.setText(pa.getLogin().getUsuario());
		}

		btnSalvar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				if (tfNome.getText().equals("") || tfTelefone.getText().equals("") || tfEmail.getText().equals("")
						|| tfCpf.getText().equals("") || tfUsuario.getText().equals("") || tfSenha.getText().equals("")
						|| tfSenha2.getText().equals("") || tfLogra.getText().equals("") || tfNum.getText().equals("")
						|| tfCep.getText().equals("") || tfCidade.getText().equals("") || tfEstado.getText().equals("")
						|| tfDtNasci.getText().equals("")) {

					JOptionPane.showInternalMessageDialog(null, "Há campos em branco!", "AVISO ",
							JOptionPane.WARNING_MESSAGE);
				} else if (tfSenha.getText() == tfSenha2.getText()) {

					JOptionPane.showInternalMessageDialog(null, "Senhas não iguais", "AVISO ",
							JOptionPane.WARNING_MESSAGE);
				} else if (opt == 0) {
					// nome, cpf, telefone, email, dataNascimento
					// logradouro, numero, bairro, estado, cidade, cep, complemento, idPaciente
					// usuario, senha, idPaciente
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

					pc.setNome(tfNome.getText());
					pc.setCpf(tfCpf.getText());
					pc.setTelefone(tfTelefone.getText());
					pc.setEmail(tfEmail.getText());
					try {
						pc.setDataNascimento(sdf.parse(tfDtNasci.getText()));
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					en.setLogradouro(tfLogra.getText());
					en.setNumero(Integer.parseInt(tfNum.getText()));
					en.setBairro(tfBairro.getText());
					en.setEstado(tfEstado.getText());
					en.setCidade(tfCidade.getText());
					en.setCep(Integer.parseInt(tfCep.getText()));
					en.setComplemento(tfComplemento.getText());

					lg.setUsuario(tfUsuario.getText());
					lg.setSenha(tfSenha.getText());

					pacienteDao.insert(pc, en, lg);
					JOptionPane.showInternalMessageDialog(null, "Salvo/Alterado com Sucesso!");
					tfNome.setText("");
					tfTelefone.setText("");
					tfEmail.setText("");
					tfCpf.setText("");
					tfComplemento.setText("");
					tfUsuario.setText("");
					tfSenha.setText("");
					tfSenha2.setText("");
					tfLogra.setText("");
					tfNum.setText("");
					tfCep.setText("");
					tfCidade.setText("");
					tfEstado.setText("");
					tfDtNasci.setText("");

					frame.setVisible(false);
					LoginView window = new LoginView();
					window.frame.setVisible(true);
				} else {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

					pa.setNome(tfNome.getText());
					pa.setCpf(tfCpf.getText());
					pa.setTelefone(tfTelefone.getText());
					pa.setEmail(tfEmail.getText());
					try {
						pa.setDataNascimento(sdf.parse(tfDtNasci.getText()));
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					en.setLogradouro(tfLogra.getText());
					en.setNumero(Integer.parseInt(tfNum.getText()));
					en.setBairro(tfBairro.getText());
					en.setEstado(tfEstado.getText());
					en.setCidade(tfCidade.getText());
					en.setCep(Integer.parseInt(tfCep.getText()));
					en.setComplemento(tfComplemento.getText());

					lg.setUsuario(tfUsuario.getText());
					lg.setSenha(tfSenha.getText());

					pacienteDao.update(pa, en, lg);
					lg.setIdPaciente(pa.getId());
					JOptionPane.showInternalMessageDialog(null, "Salvo/Alterado com Sucesso!");
					

					frame.setVisible(false);
					DefaultView window = new DefaultView(lg);
					window.frame.setVisible(true);
				}

			}
		});
	}
}
