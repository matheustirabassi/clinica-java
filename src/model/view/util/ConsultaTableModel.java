package model.view.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.entities.Consulta;
import model.entities.Enum.TipoConsulta;

public class ConsultaTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	public static final int COL_DATAMARCADA = 0;
	public static final int COL_OBSERVACAO = 1;
	public static final int COL_TIPO = 2;
	public static final int COL_MEDICO = 3;

	public List<Consulta> lista = new ArrayList<>();
	String[] colunas = { "Data Marcada", "Observação", "Tipo da consulta", "Nome do médico" };

	public ConsultaTableModel(List<Consulta> list) {
		lista = new ArrayList<Consulta>(list);
	}

	public ConsultaTableModel() {
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	public void setValueAt(Consulta aValue, int linha) {
		Consulta consulta = lista.get(linha);

		consulta.setId(aValue.getId());
		consulta.setDataMarcada(aValue.getDataMarcada());
		consulta.setObservacao(aValue.getObservacao());
		consulta.setTipoConsulta(aValue.getTipoConsulta());
		consulta.setMedico(aValue.getMedico());

	}

	public void adicionarLinha(Consulta consulta) {
		this.lista.add(consulta);
		this.fireTableDataChanged();
	}

	@Override
	public String getColumnName(int coluna) {
		return colunas[coluna];
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Consulta consulta = lista.get(rowIndex);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		switch (columnIndex) {
		case 0:
			try {
				consulta.setDataMarcada(sdf.parse(aValue.toString()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 1:
			consulta.setObservacao(aValue.toString());
			break;
		case 2:
			consulta.setObservacao(aValue.toString());
			break;
		case 3:
			consulta.setTipoConsulta(TipoConsulta.CONVENCIONAL);
			break;
		case 4:
			consulta.getMedico().setNome(aValue.toString());
			break;
		default:
			System.err.println("Índice inválido");
		}
		fireTableCellUpdated(rowIndex, columnIndex);
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		Consulta consultaSelecionada = lista.get(linha);
		String valueObject = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		switch (coluna) {
		case 0:
			valueObject = sdf.format(consultaSelecionada.getDataMarcada()).toString();
			break;
		case 1:
			valueObject = consultaSelecionada.getObservacao();
			break;
		case 2:
			valueObject = String.valueOf(consultaSelecionada.getTipoConsulta().getDescricao());
			break;
		case 3:
			valueObject = consultaSelecionada.getMedico().getNome();
			break;
		default:
			System.err.println("Índice inválido");
		}
		return valueObject;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public Consulta getConsulta(int indiceLinha) {
		return lista.get(indiceLinha);
	}

	public void limpar() {
		lista.clear();
		fireTableDataChanged();
	}

	public boolean isEmpty() {
		return lista.isEmpty();
	}

	public void addConsulta(Consulta u) {
		lista.add(u);

		int ultimoIndice = getRowCount() - 1;

		fireTableRowsInserted(ultimoIndice, ultimoIndice);
	}

}