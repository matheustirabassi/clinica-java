package model.view;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.dao.ConsultaDao;
import model.dao.DaoFactory;
import model.entities.Consulta;
import model.entities.Paciente;
import model.view.util.ConsultaTableModel;

public class VisualizaConsultaView {

	public JFrame frmConsultas;
	private JTable table;

	/**
	 * Create the application.
	 */
	public VisualizaConsultaView(Paciente paciente) {
		try {
		initialize(paciente);
		}catch (RuntimeException e) {
			JOptionPane.showMessageDialog(null, "Você não tem consultas\n" + e.getMessage(), "Erro na busca de consultas",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Paciente paciente) {
		
		frmConsultas = new JFrame();
		frmConsultas.setBounds(100, 100, 594, 427);
		frmConsultas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConsultas.getContentPane().setLayout(null);
		
		ConsultaDao consultaDao = DaoFactory.createConsultaDao();
		List <Consulta> list = consultaDao.findAllByIdPaciente(paciente.getId());

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
					MainView window = new MainView(paciente.getLogin());
					window.frame.setVisible(true);
				}
			}
		});

		frmConsultas.getContentPane().add(btnVoltar);
		

	}
}
