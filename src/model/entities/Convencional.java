package model.entities;

import model.entities.Enum.FormaPagamento;
import model.entities.Enum.StatusPagamento;

public class Convencional implements Pagamento {

	private Double valor;
	private FormaPagamento formaPagamento;
	private StatusPagamento statusPagamento;

	public Convencional() {
	}

	public Convencional(Double valor, FormaPagamento formaPagamento, StatusPagamento statusPagamento) {
		this.valor = valor;
		this.formaPagamento = formaPagamento;
		this.setStatusPagamento(statusPagamento);
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public StatusPagamento getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(StatusPagamento statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public void pagar() {

	}

	@Override
	public String toString() {
		return "Convencional [valor=" + valor + ", formaPagamento=" + formaPagamento + ", statusPagamento="
				+ statusPagamento + "]";
	}
	
}
