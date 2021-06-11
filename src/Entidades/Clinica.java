package entidades;

import java.util.Collection;

public class Clinica {

	private Integer id;
	private String nome;
	private String cnpj;
	private Collection<Medico> medicos;
	private Gerente gerentes;
	private Collection<Gerente> gerente;

	public Clinica(Integer id, String nome, String cnpj, Collection<Medico> medicos, Gerente gerentes,
			Collection<Gerente> gerente) {
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.medicos = medicos;
		this.gerentes = gerentes;
		this.gerente = gerente;
	}
	
	public Clinica() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Collection<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(Collection<Medico> medicos) {
		this.medicos = medicos;
	}

	public Gerente getGerentes() {
		return gerentes;
	}

	public void setGerentes(Gerente gerentes) {
		this.gerentes = gerentes;
	}

	public Collection<Gerente> getGerente() {
		return gerente;
	}

	public void setGerente(Collection<Gerente> gerente) {
		this.gerente = gerente;
	}

	public Integer getId() {
		return id;
	}

	public String getCnpj() {
		return cnpj;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Clinica [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", cnpj=");
		builder.append(cnpj);
		builder.append(", medicos=");
		builder.append(medicos);
		builder.append(", gerentes=");
		builder.append(gerentes);
		builder.append(", gerente=");
		builder.append(gerente);
		builder.append("]");
		return builder.toString();
	}

	
	
}
