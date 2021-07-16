package model.entities.Enum;

public enum StatusPagamento {

	PENDENTE("Pendente"), PROCESSANDO("Processando"), PAGO("Pago");

	private String descricao;

	private StatusPagamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
