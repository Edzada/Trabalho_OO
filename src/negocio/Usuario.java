package negocio;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public abstract class Usuario {
	protected String nome;
	protected String dtNascimento;
	protected String nomeUsuario;
	protected String email;
	protected String senha;
	protected int qtdNotas;
	protected int qtdPastas;
	protected ArrayList<Pasta> pastas;
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
			saida = saida + "\n" + pastas.get(i).toString();
		}

		return saida;
	}

	public boolean atribuirPasta(Pasta p) {
		if(verificarLimitePastas()) {
			return false;
		} else {
			pastas.add(p);
			numPastas++;
			return true;
		}
	}

	public boolean verificarLimitePastas() {
        return numPastas == qtdPastas-1;
	}

	public boolean deletarPasta(String tituloPasta) {
		for(int i = 0; i  < numPastas; i++) {
			if(Objects.equals(pastas.get(i).getTituloPasta(), tituloPasta)) {
				pastas.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public String filtrarPastas(String dtCriacaoPasta) {

		// Verifica se a data de criação é válida
		if (dtCriacaoPasta == null || dtCriacaoPasta.isEmpty()) {
		  return "A data de criação não é válida.";
		}
	  
		// Cria uma lista para armazenar as pastas filtradas
		List<Pasta> pastasFiltradas = new ArrayList<>();
	  
		// Itera sobre todas as pastas do usuário
		for (Pasta pasta : this.pastas) {
	  
		  // Verifica se a data de criação da pasta corresponde à data de criação fornecida
		  if (pasta.dtCriacaoPasta.equals(dtCriacaoPasta)) {
			pastasFiltradas.add(pasta);
		  }
		}
	  
		// Retorna uma string contendo as pastas filtradas
		return pastasFiltradas.toString();
	  }
}
