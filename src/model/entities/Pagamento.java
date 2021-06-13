package model.entities;

public interface Pagamento {

	public abstract void pagar();
	public abstract Double getValor();
	public abstract void setValor(Double valor);
}
