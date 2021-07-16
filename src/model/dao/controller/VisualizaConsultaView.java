package model.dao.controller;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableModel;

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
        frmConsultas .setBounds(100, 100, 594, 427);
        frmConsultas .setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmConsultas .getContentPane().setLayout(null);
        
		PacienteDao pacienteDao = DaoFactory.createPacienteDao();
		List<Consulta> list= pacienteDao.findById(paciente.getId()).getConsultas();
		list.forEach(System.out::println);
		
		
		
		TableModel tableModel;
		ConsultaTableModel consultaTableModel = new ConsultaTableModel();
		table = new JTable(consultaTableModel);
		table.setBounds(556, 371, -550, -368);
		frmConsultas.getContentPane().add(table);
		for(Consulta consulta: list) {
			
			consultaTableModel.addConsulta(consulta);
		}
		
		
		
	}
}
