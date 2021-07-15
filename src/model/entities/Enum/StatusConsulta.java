package model.entities.Enum;

public enum StatusConsulta {

	AGENDADO(1, "Agendado"), FINALIZADO(2, "Finalizado");
	private int cod;
	private String descricao;


	private StatusConsulta(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public static StatusConsulta toEnum(Integer tipo) {
		if (tipo == null) {
			return null;
		}
		for (StatusConsulta x : StatusConsulta.values()) {
			if (tipo.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + tipo);
	}
}
