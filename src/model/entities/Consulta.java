package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import model.entities.Enum.StatusConsulta;
import model.entities.Enum.TipoConsulta;

public class Consulta {

	private Integer id;
	private Date dataMarcada;
	private String observacao;
	private Integer tipoConsulta;
	private Integer statusConsulta;
	private Pagamento pagamento;
	private Medico medico;
	private Paciente paciente;
	public Consulta() {
	}

	public Consulta(Integer id, Date dataMarcada, String observacao, Integer tipoConsulta,
			Integer statusConsulta, Pagamento pagamento) {
		this.id = id;
		this.dataMarcada = dataMarcada;
		this.observacao = observacao;

		this.tipoConsulta = tipoConsulta;
		this.statusConsulta = statusConsulta;
		this.pagamento = pagamento;
	}
	
	public Consulta(Integer id, Date dataMarcada, String observacao, Integer tipoConsulta, Integer statusConsulta,
			Pagamento pagamento, Medico medico, Paciente paciente) {
		super();
		this.id = id;
		this.dataMarcada = dataMarcada;
		this.observacao = observacao;
		this.tipoConsulta = tipoConsulta;
		this.statusConsulta = statusConsulta;
		this.pagamento = pagamento;
		this.medico = medico;
		this.paciente = paciente;
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
		return TipoConsulta.toEnum(tipoConsulta);
	}

	public void setTipoConsulta(TipoConsulta tipoConsulta) {
		this.tipoConsulta = tipoConsulta.getCod();
	}

	public StatusConsulta getStatusConsulta() {
		return StatusConsulta.toEnum(tipoConsulta);
	}

	public void setStatusConsulta(StatusConsulta statusConsulta) {
		this.statusConsulta = statusConsulta.getCod();
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
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
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

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}
