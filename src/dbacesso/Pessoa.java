package dbacesso;

public class Pessoa {
	private int codigo;
	private String nome;
	private String sexo;
	private String email;

	public Pessoa(int codigo, String nome, String sexo, String email) {
		this.codigo = codigo;
		this.nome = nome;
		this.sexo = sexo;
		this.email = email;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Pessoa [codigo=" + codigo + ", nome=" + nome + ", sexo=" + sexo + ", email=" + email + "]";
	}

}
