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
		return "Nome: " + nome +
				"\nNome de Usuário: " + nomeUsuario +
				"\nQuantidade de Notas: " + qtdNotas +
				"\nQuantidade de Pastas: " + qtdPastas;
	}

	public String listarPastas() {
		String saida = ">>>>>> Lista de Pastas <<<<<<\n";

		for(int i = 0; i < numPastas; i++) {
			System.out.println(i);
			saida = saida + "\n" + pastas[i].toString();
		}

		return saida;
	}

	public boolean atribuirPasta(Pasta p) {
		if(numPastas == qtdPastas-1) {
			return false;
		} else {
			this.pastas[numPastas] = p;
			numPastas++;
			return true;
		}
	}
	
}
