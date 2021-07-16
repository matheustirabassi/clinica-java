package model.view;

import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import model.dao.ConsultaDao;
import model.dao.DaoFactory;
import model.dao.MedicoDao;
import model.entities.Consulta;
import model.entities.Especialidade;
import model.entities.Login;
import model.entities.Medico;
import model.entities.Paciente;
import model.entities.Enum.StatusConsulta;
import model.entities.Enum.TipoConsulta;

public class CadastrarConsulta {

	public JFrame frame;
	private JTextField textFieldObservacoes;
	private JTextField textDataHora;
	private Medico objMedico;
	ConsultaDao cDao = DaoFactory.createConsultaDao();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public CadastrarConsulta(Paciente obj) {
		initialize(obj);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Paciente paciente) {
		frame = new JFrame();
		frame.setBounds(100, 100, 594, 427);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblAgendarConsulta = new JLabel("Agendar Consulta");
		lblAgendarConsulta.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAgendarConsulta.setBounds(218, 11, 152, 60);
		frame.getContentPane().add(lblAgendarConsulta);

		JRadioButton rdConsulta = new JRadioButton("Consulta");
		rdConsulta.setSelected(true);
		rdConsulta.setBounds(143, 78, 109, 23);
		frame.getContentPane().add(rdConsulta);

		JRadioButton rdExame = new JRadioButton("Exame");
		rdExame.setBounds(315, 78, 109, 23);
		frame.getContentPane().add(rdExame);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdExame);
		buttonGroup.add(rdConsulta);

		JComboBox<String> comboBoxEspecialidade = new JComboBox<String>();
		comboBoxEspecialidade.setSelectedIndex(-1);
		comboBoxEspecialidade.setToolTipText("Selecione a especialidade");
		comboBoxEspecialidade.setBounds(92, 108, 160, 29);
		frame.getContentPane().add(comboBoxEspecialidade);

		List<Especialidade> listaEspecialidades = cDao.findAllEspecialidade();
		for (Especialidade especial : listaEspecialidades) {
			comboBoxEspecialidade.addItem(especial.getNomeEspecialidade());
		}
		comboBoxEspecialidade.setSelectedIndex(0);

		JComboBox<String> comboBoxMedico = new JComboBox<String>();

		comboBoxMedico.setToolTipText("Selecione o m\u00E9dico");
		comboBoxMedico.setBounds(298, 108, 189, 29);
		frame.getContentPane().add(comboBoxMedico);

		MedicoDao medicoDao = DaoFactory.createMedicoDao();
		List<Medico> listaMedicos = medicoDao.findAll();
		comboBoxMedico.removeAllItems();
		for (Medico medico : listaMedicos) {
			if (comboBoxEspecialidade.getSelectedItem().toString()
					.equals(medico.getEspecialidade().getNomeEspecialidade())) {
				comboBoxMedico.addItem(medico.getNome());
			}
		}

		comboBoxEspecialidade.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Medico> listaMedicos = medicoDao.findAll();
				comboBoxMedico.removeAllItems();
				for (Medico medico : listaMedicos) {
					if (comboBoxEspecialidade.getSelectedItem().toString()
							.equals(medico.getEspecialidade().getNomeEspecialidade())) {
						comboBoxMedico.addItem(medico.getNome());
					}

				}

			}
		});

		textFieldObservacoes = new JTextField();
		textFieldObservacoes.setBounds(243, 224, 206, 111);
		frame.getContentPane().add(textFieldObservacoes);
		textFieldObservacoes.setColumns(10);

		JLabel lblObservacoes = new JLabel("Observa\u00E7\u00F5es:");
		lblObservacoes.setBounds(92, 224, 141, 23);
		frame.getContentPane().add(lblObservacoes);

		JLabel lblDataHora = new JLabel("Data e hora:");
		lblDataHora.setBounds(92, 162, 102, 14);
		frame.getContentPane().add(lblDataHora);

		try {
			textDataHora = new JFormattedTextField(new MaskFormatter("##/##/#### ##:##"));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		textDataHora.setBounds(243, 159, 86, 20);
		frame.getContentPane().add(textDataHora);
		textDataHora.setColumns(10);

		Button btnSalvar = new Button("Salvar");
		btnSalvar.setBounds(163, 354, 70, 22);
		frame.getContentPane().add(btnSalvar);

		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
				try {

					ConsultaDao consultaDao = DaoFactory.createConsultaDao();
					
					Date dataAtual = sdf.parse(textDataHora.getText());
					String observacao = textFieldObservacoes.getText();
					Consulta obj = new Consulta();
					obj.setDataMarcada(dataAtual);
					obj.setObservacao(observacao);
					obj.setStatusConsulta(StatusConsulta.AGENDADO);
					obj.setPaciente(paciente);
					List<Medico> listaMedicos2 = medicoDao.findAll();
					for (Medico medico : listaMedicos2) {
						if (comboBoxMedico.getSelectedItem().toString().equals(medico.getNome())) {
							objMedico = medico;
						}

					}
					obj.setMedico(objMedico);
					if (rdConsulta.isSelected()) {
						obj.setTipoConsulta(TipoConsulta.CONVENCIONAL);
					} else {
						obj.setTipoConsulta(TipoConsulta.EXAME);
					}

					consultaDao.insert(obj);
					JOptionPane.showInternalMessageDialog(null, "Salvo/Alterado com Sucesso!");

					frame.setVisible(false);
					MainView window = new MainView(paciente.getLogin());
					window.frame.setVisible(true);

				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error no formato da data",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		Button btnCancel = new Button("Cancelar");
		btnCancel.setBounds(300, 354, 70, 22);
		frame.getContentPane().add(btnCancel);

		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int escolha = JOptionPane.showConfirmDialog(null, "Gostaria de cancelar?", "Cancelar",
						JOptionPane.YES_NO_OPTION);

				if (escolha == 0) {
					frame.setVisible(false);
					Login login = paciente.getLogin();
					login.setPaciente(paciente);
					MainView window = new MainView(login);
					window.frame.setVisible(true);
				}

			}
		});

	}
}
