package entidades;

import java.util.Collection;

public class Medico {

	private Integer id;
	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;
	private String email;
	private Collection<Consulta> consultas;
	private Especialidade especialidade;
	private Clinica clinica;

	public Medico(Integer id, String nome, String cpf, String endereco, String telefone, String email,
			Collection<Consulta> consultas, Especialidade especialidade, Clinica clinica) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.consultas = consultas;
		this.especialidade = especialidade;
		this.clinica = clinica;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(Collection<Consulta> consultas) {
		this.consultas = consultas;
	}

	public Especialidade getEspecialidades() {
		return especialidade;
	}

	public void setEspecialidades(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}

	public Integer getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}

	public void receituarioMedico() {

	}

	public void encaminhamentoEspecialidade() {

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Medico [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", cpf=");
		builder.append(cpf);
		builder.append(", endereco=");
		builder.append(endereco);
		builder.append(", telefone=");
		builder.append(telefone);
		builder.append(", email=");
		builder.append(email);
		builder.append(", consultas=");
		builder.append(consultas);
		builder.append(", especialidade=");
		builder.append(especialidade);
		builder.append(", clinica=");
		builder.append(clinica);
		builder.append("]");
		return builder.toString();
	}

	
	
	
}
