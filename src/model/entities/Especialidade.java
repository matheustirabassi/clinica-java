package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Especialidade {

	private Integer id;
	private String nomeEspecialidade;
	private String descricao;
	private List<Medico> medicos = new ArrayList<>();
	public Especialidade(Integer id, String nomeEspecialidade, String descricao) {
		this.id = id;
		this.nomeEspecialidade = nomeEspecialidade;
		this.descricao = descricao;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public List<Medico> getMedicos() {
		return medicos;
	}
	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	

}
