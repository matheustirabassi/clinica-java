package model.entities;

import model.entities.Enum.FormaPagamento;
import model.entities.Enum.StatusPagamento;

public class Convencional implements Pagamento {

	private Double valor;
	private FormaPagamento formaDePagamento;
	private StatusPagamento statusPagamento;
	public Convencional() {
	}

	public Convencional(Double valor, FormaPagamento formaDePagamento, StatusPagamento statusPagamento) {
		this.valor = valor;
		this.formaDePagamento = formaDePagamento;
		this.setStatusPagamento(statusPagamento);
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
		return "Convencional [valor=" + valor + ", formaDePagamento=" + formaDePagamento + ", statusPagamento="
				+ statusPagamento + "]";
	}

	

	

}
