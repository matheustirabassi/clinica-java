package entidades;

import java.util.Date;

import entidades.Enum.StatusConsulta;
import entidades.Enum.TipoConsulta;

public class Consulta {

	private Integer id;
	private Date dataMarcada;
	private String observacao;
	private Medico medico;
	private Paciente paciente;
	private TipoConsulta tipoConsulta;
	private StatusConsulta statusConsulta;
	private Pagamento pagamento;

	public Consulta(Integer id, Date dataMarcada, String observacao, Medico medico, Paciente paciente,
			TipoConsulta tipoConsulta, StatusConsulta statusConsulta, Pagamento pagamento) {
		this.id = id;
		this.dataMarcada = dataMarcada;
		this.observacao = observacao;
		this.medico = medico;
		this.paciente = paciente;
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

	public Medico pesquisarMedico() {
		return null;
	}

	public Integer verificarDisponibilidade(Date dataConsulta) {
		return null;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Consulta [id=");
		builder.append(id);
		builder.append(", dataMarcada=");
		builder.append(dataMarcada);
		builder.append(", observacao=");
		builder.append(observacao);
		builder.append(", medico=");
		builder.append(medico);
		builder.append(", paciente=");
		builder.append(paciente);
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
