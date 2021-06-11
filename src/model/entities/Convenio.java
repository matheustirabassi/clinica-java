package model.entities;

public class Convenio implements Pagamento {

	private String plano;
	private Double tarifa;

	public Convenio(String plano, Double tarifa) {
		this.plano = plano;
		this.tarifa = tarifa;
	}

	public String getPlano() {
		return plano;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}

	public Double getTarifa() {
		return tarifa;
	}

	public void setTarifa(Double tarifa) {
		this.tarifa = tarifa;
	}

	public void pagar() {

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Convenio [plano=");
		builder.append(plano);
		builder.append(", tarifa=");
		builder.append(tarifa);
		builder.append("]");
		return builder.toString();
	}

}
