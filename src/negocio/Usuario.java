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
	
	// Construtor
	public Usuario(String n, String d, String nU, String e, String s) {
		this.nome = n;
		this.dtNascimento = d;
		this.nomeUsuario = nU;
		this.email = e;
		this.senha = s;
		this.qtdNotas = 1500;
		this.pastas = new ArrayList<Pasta>();
	}

	// Métodos getters e setters
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

	public ArrayList<Pasta> getPastas() {
		return pastas;
	}

	public void setPastas(ArrayList<Pasta> pastas) {
		this.pastas = pastas;
	}

	public Pasta getPasta(int i) {
		return pastas.get(i);
	}

	//Encontra a pasta pelo nome
	public Pasta getPastaNome(String nomePasta) {
		for (Pasta pasta : pastas) {
			if (pasta.getTituloPasta().equals(nomePasta)) {
				return pasta;
			}
		}
		return null; // Retorna null se a pasta não for encontrada
	}

	public void setPasta(int i, Pasta p) {
		pastas.set(i, p);
	}

	public int getNumPastas() {
		return pastas.size();
	}

	public void setNumPastas(int numPastas) {
		pastas.ensureCapacity(numPastas);
	}

	//  Método toString para representar o objeto Usuario como uma string
	public String toString() {
		return "Nome: " + nome +
				"\nNome de Usuário: " + nomeUsuario +
				"\nQuantidade de Notas: " + qtdNotas +
				"\nQuantidade de Pastas: " + qtdPastas;
	}


	// Método atribuirPasta para adicionar uma nova pasta ao usuário
	public boolean atribuirPasta(Pasta p) {
		if(pastas.size() >= qtdPastas) {  // Verifica se há limite de pastas
			return false;
		} else {
			pastas.add(p);
			return true;
		}
	}

	public boolean deletarPasta(String tituloPasta) {
		for(int i = 0; i  < pastas.size(); i++) {
			if(pastas.get(i).getTituloPasta().equalsIgnoreCase(tituloPasta)) {
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
		  if (pasta.getDtCriacaoPasta().equalsIgnoreCase(dtCriacaoPasta)) {
			pastasFiltradas.add(pasta);
		  }
		}
	  
		// Retorna uma string contendo as pastas filtradas
		return pastasFiltradas.toString();
	}

	public void preencherPastas() {
		for(int i = 0; i < 10; i++) {
			String s = String.valueOf(i);

			Pasta p = new Pasta("TituloPasta".concat(s), "DtCriacao".concat(s));
			pastas.add(i, p);
		}
	}

}
