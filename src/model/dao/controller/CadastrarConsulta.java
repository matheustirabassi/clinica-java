package model.dao.controller;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

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
	private JTextField textField;
	private JTextField textField_1;
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
	private void initialize(Paciente a) {
		frame = new JFrame();
		frame.setBounds(100, 100, 594, 427);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Agendar Consulta");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(218, 11, 152, 60);
		frame.getContentPane().add(lblNewLabel);

		JRadioButton rdConsulta = new JRadioButton("Consulta");
		rdConsulta.setBounds(143, 78, 109, 23);
		frame.getContentPane().add(rdConsulta);

		JRadioButton rdExame = new JRadioButton("Exame");
		rdExame.setBounds(315, 78, 109, 23);
		frame.getContentPane().add(rdExame);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdExame);
		buttonGroup.add(rdConsulta);

		JComboBox comboBox = new JComboBox();
		comboBox.setSelectedIndex(-1);
		comboBox.setToolTipText("Selecione a especialidade");
		comboBox.setBounds(92, 108, 160, 29);
		frame.getContentPane().add(comboBox);

		List<Especialidade> listaEspecialidades = cDao.findAllEspecialidade();
		for (Especialidade especial : listaEspecialidades) {
			comboBox.addItem(especial.getNomeEspecialidade());
		}

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setSelectedIndex(-1);
		comboBox_1.setToolTipText("Selecione o m\u00E9dico");
		comboBox_1.setBounds(298, 108, 152, 29);
		frame.getContentPane().add(comboBox_1);

		MedicoDao medicoDao = DaoFactory.createMedicoDao();

		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Medico> listaMedicos = medicoDao.findAll();
				comboBox_1.removeAllItems();
				for (Medico medico : listaMedicos) {
					if (comboBox.getSelectedItem().toString()
							.equals(medico.getEspecialidade().getNomeEspecialidade())) {
						comboBox_1.addItem(medico.getNome());
					}

				}

			}
		});

		textField = new JTextField();
		textField.setBounds(243, 224, 206, 111);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Observa\u00E7\u00F5es:");
		lblNewLabel_1.setBounds(92, 224, 141, 23);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Data e hora:");
		lblNewLabel_2.setBounds(92, 162, 102, 14);
		frame.getContentPane().add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setBounds(243, 159, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		Button btnSalvar = new Button("Salvar");
		btnSalvar.setBounds(163, 354, 70, 22);
		frame.getContentPane().add(btnSalvar);

		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
				try {

					ConsultaDao consultaDao = DaoFactory.createConsultaDao();
					Date dataAtual = sdf.parse(textField_1.getText());
					String observacao = textField.getText();
					Consulta obj = new Consulta();
					obj.setDataMarcada(dataAtual);
					obj.setObservacao(observacao);
					obj.setStatusConsulta(StatusConsulta.AGENDADO);
					obj.setPaciente(a);
					List<Medico> listaMedicos2 = medicoDao.findAll();
					for (Medico medico : listaMedicos2) {
						if (comboBox_1.getSelectedItem().toString().equals(medico.getNome())) {
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
					DefaultView window = new DefaultView(a.getLogin());
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
					Login lg = a.getLogin();
					DefaultView window = new DefaultView(lg);
					window.frame.setVisible(true);
				}

			}
		});

	}
}
