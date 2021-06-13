package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import model.entities.Enum.StatusConsulta;
import model.entities.Enum.TipoConsulta;

public class Consulta {

	private Integer id;
	private Date dataMarcada;
	private String observacao;
	private TipoConsulta tipoConsulta;
	private StatusConsulta statusConsulta;
	private Pagamento pagamento;

	public Consulta() {
	}

	public Consulta(Integer id, Date dataMarcada, String observacao, TipoConsulta tipoConsulta,
			StatusConsulta statusConsulta, Pagamento pagamento) {
		this.id = id;
		this.dataMarcada = dataMarcada;
		this.observacao = observacao;

		this.tipoConsulta = tipoConsulta;
		this.statusConsulta = statusConsulta;
		this.pagamento = pagamento;
	}

	public Date getDataMarcada() {
		return dataMarcada;
	}

	public void setDataMarcada(Date dataMarcada) {
		this.dataMarcada = dataMarcada;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public TipoConsulta getTipoConsulta() {
		return tipoConsulta;
	}

	public void setTipoConsulta(TipoConsulta tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}

	public StatusConsulta getStatusConsulta() {
		return statusConsulta;
	}

	public void setStatusConsulta(StatusConsulta statusConsulta) {
		this.statusConsulta = statusConsulta;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Medico pesquisarMedico() {
		return null;
	}

	public Integer verificarDisponibilidade(Date dataConsulta) {
		return null;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		SimpleDateFormat sdf1= new SimpleDateFormat("dd/MM/yyyy HH:mm:ssss");
		builder.append("\nConsulta [id=");
		builder.append(id);
		builder.append(", dataMarcada=");
		builder.append(sdf1.format(dataMarcada));
		builder.append(", observacao=");
		builder.append(observacao);
		builder.append(", tipoConsulta=");
		builder.append(tipoConsulta);
		builder.append(", statusConsulta=");
		builder.append(statusConsulta);
		builder.append(", pagamento=");
		builder.append(pagamento);
		builder.append("]");
		return builder.toString();
	}

	

}
