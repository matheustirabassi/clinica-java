package entidades;

import java.util.Collection;
import java.util.Date;

public class Paciente {

	private Integer id;
	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;
	private Date dataNascimento;
	private String email;
	private Collection<Consulta> consultas;

	public Paciente(Integer id, String nome, String cpf, String endereco, String telefone, Date dataNascimento,
			String email, Collection<Consulta> consultas) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.consultas = consultas;
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	public Integer getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}

	public void cadastrarPaciente() {

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Paciente [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", cpf=");
		builder.append(cpf);
		builder.append(", endereco=");
		builder.append(endereco);
		builder.append(", telefone=");
		builder.append(telefone);
		builder.append(", dataNascimento=");
		builder.append(dataNascimento);
		builder.append(", email=");
		builder.append(email);
		builder.append(", consultas=");
		builder.append(consultas);
		builder.append("]");
		return builder.toString();
	}

	
	
}
