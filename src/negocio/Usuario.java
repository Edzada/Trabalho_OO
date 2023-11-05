package negocio;

public abstract class Usuario {
	protected String nome;
	protected String dtNascimento;
	protected String nomeUsuario;
	protected String email;
	protected String senha;
	protected int qtdNotas;
	protected int qtdPastas;
	protected Pasta[] pastas;
	protected int numPastas;
	
	
	public Usuario(String n, String d, String nU, String e, String s) {
		this.nome = n;
		this.dtNascimento = d;
		this.nomeUsuario = nU;
		this.email = e;
		this.senha = s;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String toString() {
		return "Usuario [nome=" + nome + ", nomeUsuario=" + nomeUsuario + ", qtdNotas=" + qtdNotas + ", qtdPastas="
				+ qtdPastas + "]";
	}


	
}
