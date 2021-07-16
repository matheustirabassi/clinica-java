package model.entities.Enum;

public enum TipoConsulta {
	EXAME(1, "Exame"), CONVENCIONAL(2, "Consulta convencional");
	
	private int cod;
	private String descricao;

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	private TipoConsulta(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public static TipoConsulta toEnum(Integer tipo) {
		if (tipo == null) {
			return null;
		}
		for (TipoConsulta x : TipoConsulta.values()) {
			if (tipo.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + tipo);
	}

}
