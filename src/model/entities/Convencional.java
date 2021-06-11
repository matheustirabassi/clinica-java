package model.entities;

import model.entities.Enum.FormaPagamento;

public class Convencional implements Pagamento {

	private Double valor;
	private FormaPagamento formaDePagamento;

	public Convencional(Double valor, FormaPagamento formaDePagamento) {
		this.valor = valor;
		this.formaDePagamento = formaDePagamento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public FormaPagamento getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(FormaPagamento formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public void pagar() {

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Convencional [valor=");
		builder.append(valor);
		builder.append(", formaDePagamento=");
		builder.append(formaDePagamento);
		builder.append("]");
		return builder.toString();
	}

}
