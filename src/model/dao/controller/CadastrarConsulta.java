package model.dao.controller;

import java.awt.Button;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.entities.Paciente;

public class CadastrarConsulta {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setSelectedIndex(-1);
		comboBox.setToolTipText("Selecione a especialidade");
		comboBox.setBounds(92, 108, 160, 29);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setSelectedIndex(-1);
		comboBox_1.setToolTipText("Selecione o m\u00E9dico");
		comboBox_1.setBounds(298, 108, 152, 29);
		frame.getContentPane().add(comboBox_1);
		
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
		
		Button btnCancel = new Button("Cancelar");
		btnCancel.setBounds(300, 354, 70, 22);
		frame.getContentPane().add(btnCancel);
	}
}
