package entidades;

import java.util.Collection;

public class Especialidade {

	private Integer id;
	private String nomeEspecialidade;
	private String descricao;
	private Collection<Medico> medicos;

	public Especialidade(Integer id, String nomeEspecialidade, String descricao, Collection<Medico> medicos) {
		this.id = id;
		this.nomeEspecialidade = nomeEspecialidade;
		this.descricao = descricao;
		this.medicos = medicos;
	}

	public String getNomeEspecialidade() {
		return nomeEspecialidade;
	}

	public void setNomeEspecialidade(String nomeEspecialidade) {
		this.nomeEspecialidade = nomeEspecialidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Collection<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(Collection<Medico> medicos) {
		this.medicos = medicos;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Especialidade [id=");
		builder.append(id);
		builder.append(", nomeEspecialidade=");
		builder.append(nomeEspecialidade);
		builder.append(", descricao=");
		builder.append(descricao);
		builder.append(", medicos=");
		builder.append(medicos);
		builder.append("]");
		return builder.toString();
	}

	
	
}
