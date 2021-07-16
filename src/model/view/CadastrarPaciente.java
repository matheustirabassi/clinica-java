package model.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import model.dao.DaoFactory;
import model.dao.PacienteDao;
import model.entities.Endereco;
import model.entities.Login;
import model.entities.Paciente;

public class CadastrarPaciente {

	public JFrame frame;
	private JTextField tfNome;
	private JTextField tfCpf;
	private JTextField tfTelefone;
	private JTextField tfEmail;
	private JTextField tfLogradouro;
	private JTextField tfNumero;
	private JTextField tfBairro;
	private JTextField tfEstado;
	private JTextField tfCidade;
	private JTextField tfCep;
	JFormattedTextField tfDtNasci = new JFormattedTextField(new MaskFormatter("##/##/####"));
	private JTextField tfComplemento;
	private JTextField tfUsuario;
	private JPasswordField tfSenha;
	private JPasswordField tfSenha2;

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
	private void initialize(Integer opcao, Paciente objPaciente) throws ParseException {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 521, 506);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNome = new JLabel("Nome completo:");
		lblNome.setBounds(22, 30, 142, 14);
		frame.getContentPane().add(lblNome);

		tfNome = new JTextField();
		tfNome.setBounds(124, 27, 144, 20);
		frame.getContentPane().add(tfNome);
		tfNome.setColumns(10);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(271, 30, 46, 14);
		frame.getContentPane().add(lblCpf);

		tfCpf = new JTextField();
		tfCpf.setText("");
		tfCpf.setBounds(308, 27, 86, 20);
		frame.getContentPane().add(tfCpf);
		tfCpf.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone: ");
		lblTelefone.setBounds(22, 65, 63, 14);
		frame.getContentPane().add(lblTelefone);

		tfTelefone = new JTextField();
		tfTelefone.setBounds(101, 62, 86, 20);
		frame.getContentPane().add(tfTelefone);
		tfTelefone.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(22, 98, 46, 14);
		frame.getContentPane().add(lblEmail);

		tfEmail = new JTextField();
		tfEmail.setText("");
		tfEmail.setBounds(102, 95, 133, 20);
		frame.getContentPane().add(tfEmail);
		tfEmail.setColumns(10);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setBounds(22, 128, 167, 14);
		frame.getContentPane().add(lblDataDeNascimento);

		tfDtNasci.setBounds(174, 126, 86, 20);
		frame.getContentPane().add(tfDtNasci);
		tfDtNasci.setColumns(10);

		JLabel lblTxtInformacoesPessoais = new JLabel("Informa\u00E7\u00F5es Pessoais");
		lblTxtInformacoesPessoais.setBounds(22, 5, 225, 14);
		frame.getContentPane().add(lblTxtInformacoesPessoais);

		JLabel lblTxtEndereco = new JLabel("Endere\u00E7o");
		lblTxtEndereco.setBounds(22, 171, 78, 14);
		frame.getContentPane().add(lblTxtEndereco);

		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setBounds(22, 208, 78, 14);
		frame.getContentPane().add(lblLogradouro);

		tfLogradouro = new JTextField();
		tfLogradouro.setBounds(102, 205, 200, 20);
		frame.getContentPane().add(tfLogradouro);
		tfLogradouro.setColumns(10);

		JLabel lblNumero = new JLabel("N\u00BA");
		lblNumero.setBounds(324, 208, 46, 14);
		frame.getContentPane().add(lblNumero);

		tfNumero = new JTextField();
		tfNumero.setBounds(348, 205, 46, 20);
		frame.getContentPane().add(tfNumero);
		tfNumero.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(22, 236, 46, 14);
		frame.getContentPane().add(lblBairro);

		tfBairro = new JTextField();
		tfBairro.setBounds(101, 233, 86, 20);
		frame.getContentPane().add(tfBairro);
		tfBairro.setColumns(10);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(200, 236, 46, 14);
		frame.getContentPane().add(lblEstado);

		tfEstado = new JTextField();
		tfEstado.setBounds(256, 236, 86, 20);
		frame.getContentPane().add(tfEstado);
		tfEstado.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(22, 267, 46, 14);
		frame.getContentPane().add(lblCidade);

		tfCidade = new JTextField();
		tfCidade.setText("");
		tfCidade.setBounds(102, 264, 86, 20);
		frame.getContentPane().add(tfCidade);
		tfCidade.setColumns(10);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(200, 267, 46, 14);
		frame.getContentPane().add(lblCep);

		tfCep = new JTextField();
		tfCep.setText("");
		tfCep.setBounds(256, 264, 86, 20);
		frame.getContentPane().add(tfCep);
		tfCep.setColumns(10);

		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(22, 301, 115, 14);
		frame.getContentPane().add(lblComplemento);

		tfComplemento = new JTextField();
		tfComplemento.setBounds(134, 298, 86, 20);
		frame.getContentPane().add(tfComplemento);
		tfComplemento.setColumns(10);

		JLabel lblTxtLogin = new JLabel("Login");
		lblTxtLogin.setBounds(22, 342, 46, 14);
		frame.getContentPane().add(lblTxtLogin);

		JLabel lblUsuario = new JLabel("Usu\u00E1rio:");
		lblUsuario.setBounds(22, 377, 63, 14);
		frame.getContentPane().add(lblUsuario);

		tfUsuario = new JTextField();
		tfUsuario.setBounds(78, 374, 86, 20);
		frame.getContentPane().add(tfUsuario);
		tfUsuario.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(22, 408, 46, 14);
		frame.getContentPane().add(lblSenha);

		JLabel lblConfirmacaoSenha = new JLabel("Digite novamente:");
		lblConfirmacaoSenha.setBounds(200, 408, 102, 14);
		frame.getContentPane().add(lblConfirmacaoSenha);

		JButton btnSalvar = new JButton("Salvar/Alterar");
		btnSalvar.setBounds(137, 430, 115, 23);
		frame.getContentPane().add(btnSalvar);

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PacienteDao pacienteDao = DaoFactory.createPacienteDao();

				if (tfNome.getText().equals("") || tfTelefone.getText().equals("") || tfEmail.getText().equals("")
						|| tfCpf.getText().equals("") || tfUsuario.getText().equals("")
						|| tfSenha.getPassword().toString().equals("") || tfSenha2.getPassword().toString().equals("")
						|| tfLogradouro.getText().equals("") || tfNumero.getText().equals("")
						|| tfCep.getText().equals("") || tfCidade.getText().equals("") || tfEstado.getText().equals("")
						|| tfDtNasci.getText().equals("")) {

					JOptionPane.showInternalMessageDialog(null, "Há campos em branco!", "AVISO ",
							JOptionPane.WARNING_MESSAGE);

				} else if (!String.copyValueOf(tfSenha.getPassword())
						.equals(String.copyValueOf(tfSenha2.getPassword()))) {

					JOptionPane.showInternalMessageDialog(null, "Senhas não iguais", "AVISO ",
							JOptionPane.WARNING_MESSAGE);
				} else if (opcao == 0) {

					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

					try {
						Paciente paciente = new Paciente(null, tfNome.getText(), tfCpf.getText(), tfTelefone.getText(),
								sdf.parse(tfDtNasci.getText()), tfEmail.getText(),
								new Endereco(tfLogradouro.getText(), Integer.parseInt(tfNumero.getText()),
										Integer.parseInt(tfCep.getText()), tfEstado.getText(), tfCidade.getText(),
										tfBairro.getText(), tfComplemento.getText()),
								new Login(null, tfUsuario.getText(), String.copyValueOf(tfSenha.getPassword())));
						pacienteDao.insert(paciente);
						JOptionPane.showInternalMessageDialog(null, "Salvo/Alterado com Sucesso!");

						frame.setVisible(false);
						LoginView window = new LoginView();
						window.frame.setVisible(true);
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (ParseException e1) {
						e1.printStackTrace();
					}

				} else if (opcao == 1) {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

					objPaciente.setNome(tfNome.getText());
					objPaciente.setCpf(tfCpf.getText());
					objPaciente.setTelefone(tfTelefone.getText());
					objPaciente.setEmail(tfEmail.getText());
					try {
						objPaciente.setDataNascimento(sdf.parse(tfDtNasci.getText()));
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					objPaciente.getEndereco().setLogradouro(tfLogradouro.getText());
					objPaciente.getEndereco().setNumero(Integer.parseInt(tfNumero.getText()));
					objPaciente.getEndereco().setBairro(tfBairro.getText());
					objPaciente.getEndereco().setEstado(tfEstado.getText());
					objPaciente.getEndereco().setCidade(tfCidade.getText());
					objPaciente.getEndereco().setCep(Integer.parseInt(tfCep.getText()));
					objPaciente.getEndereco().setComplemento(tfComplemento.getText());

					objPaciente.getLogin().setUsuario(tfUsuario.getText());
					objPaciente.getLogin().setSenha(String.valueOf(tfSenha.getPassword()));

					pacienteDao.update(objPaciente);

					JOptionPane.showInternalMessageDialog(null, "Salvo/Alterado com Sucesso!");

					frame.setVisible(false);
					MainView window = new MainView(objPaciente.getLogin());
					window.frame.setVisible(true);
				}
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(269, 430, 89, 23);
		frame.getContentPane().add(btnCancelar);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int escolha = JOptionPane.showConfirmDialog(null, "Gostaria de cancelar?", "Cancelar",
						JOptionPane.YES_NO_OPTION);
				if (escolha == 0 && opcao == 0) {
					LoginView window = new LoginView();
					frame.setVisible(false);
					window.frame.setVisible(true);
				} else if (escolha == 0 && opcao == 1){
					MainView window = new MainView(objPaciente.getLogin());
					frame.setVisible(false);
					window.frame.setVisible(true);
				}
			}

		});

		tfSenha = new JPasswordField();
		tfSenha.setBounds(78, 405, 86, 20);
		frame.getContentPane().add(tfSenha);

		tfSenha2 = new JPasswordField();
		tfSenha2.setBounds(337, 405, 89, 20);
		frame.getContentPane().add(tfSenha2);

		if (opcao == 1)

		{
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");

			tfNome.setText(objPaciente.getNome());
			tfTelefone.setText(objPaciente.getTelefone());
			tfEmail.setText(objPaciente.getNome());
			tfCpf.setText(objPaciente.getCpf());
			tfEmail.setText(objPaciente.getEmail());
			tfDtNasci.setText(sdf.format(objPaciente.getDataNascimento()));
			tfLogradouro.setText(objPaciente.getEndereco().getLogradouro());
			tfNumero.setText(objPaciente.getEndereco().getNumero().toString());
			tfBairro.setText(objPaciente.getEndereco().getBairro());
			tfEstado.setText(objPaciente.getEndereco().getEstado());
			tfCidade.setText(objPaciente.getEndereco().getCidade());
			tfCep.setText(objPaciente.getEndereco().getCep().toString());
			tfComplemento.setText(objPaciente.getEndereco().getComplemento());
			tfUsuario.setText(objPaciente.getLogin().getUsuario());
		}

	}
}
