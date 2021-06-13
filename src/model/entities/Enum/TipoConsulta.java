package model.entities.Enum;

public enum TipoConsulta {
	EXAME("Exame"), CONVENCIONAL("Consulta convencional");

	private String descricao;

	private TipoConsulta(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
