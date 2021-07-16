package model.dao.controller;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.dao.DaoFactory;
import model.dao.PacienteDao;
import model.dao.controller.util.ConsultaTableModel;
import model.entities.Consulta;
import model.entities.Paciente;

public class VisualizaConsultaView {

	public JFrame frmConsultas;
	private JTable table;

	/**
	 * Create the application.
	 */
	public VisualizaConsultaView(Paciente paciente) {
		initialize(paciente);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Paciente paciente) {
		frmConsultas = new JFrame();
		frmConsultas.setBounds(100, 100, 594, 427);
		frmConsultas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConsultas.getContentPane().setLayout(null);

		PacienteDao pacienteDao = DaoFactory.createPacienteDao();
		List<Consulta> list = pacienteDao.findById(paciente.getId()).getConsultas();
		//list.forEach(System.out::println);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 568, 357);
		frmConsultas.getContentPane().add(scrollPane);

		table = new JTable();
		table.setAlignmentX(Component.RIGHT_ALIGNMENT);
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setModel(new ConsultaTableModel(list));

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(240, 365, 89, 23);
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int escolha = JOptionPane.showConfirmDialog(null, "Gostaria de voltar ao menu principal?", "Cancelar",
						JOptionPane.YES_NO_OPTION);
				if (escolha == 0) {
					frmConsultas.setVisible(false);
					DefaultView window = new DefaultView(paciente.getLogin());
					window.frame.setVisible(true);
				}
			}
		});

		frmConsultas.getContentPane().add(btnVoltar);

	}
}
