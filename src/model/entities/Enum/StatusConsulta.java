package model.entities.Enum;

public enum StatusConsulta {

	AGENDADO("Agendado"), FINALIZADO("Finalizado");

	private String descricao;

	private StatusConsulta(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
