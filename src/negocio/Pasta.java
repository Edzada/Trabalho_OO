package negocio;

import java.util.ArrayList;
import java.util.Objects;

public class Pasta {
	// Declara variáveis privadas
	private String tituloPasta;
	private String dtCriacaoPasta;
	private ArrayList<Nota> notas;
	
	// Construtor	
	public Pasta(String t, String d) {
		this.tituloPasta = t;
		this.dtCriacaoPasta = d;
		this.notas = new ArrayList<>(1500);
	}
	
	public Pasta(String nomePasta) {
    }

    //Métodos getters e setters
	public String getTituloPasta() {
		return tituloPasta;
	}

	public void setTituloPasta(String tituloPasta) {
		this.tituloPasta = tituloPasta;
	}

	public String getDtCriacaoPasta() {
		return dtCriacaoPasta;
	}

	public void setDtCriacaoPasta(String dtCriacaoPasta) {
		this.dtCriacaoPasta = dtCriacaoPasta;
	}

	public ArrayList<Nota> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<Nota> notas) {
		this.notas = notas;
	}

	public Nota getNota(int i) {
		return notas.get(i);
	}

	public void setNota(int i, Nota n) {
		notas.set(i, n);
	}

	public int getNumNotas() {
		return notas.size();
	}

	public void setNumNotas(int numNotas) {
		notas.ensureCapacity(numNotas);
	}

	//Método toString()
	public String toString() {
		return "Título: " + tituloPasta +
				"\nData de criação: " + dtCriacaoPasta +
				"\nNúmero de notas: " + notas.size();
	}

	//Método de filtraNotas()
	public String filtrarNotas(String dtCriacaoNota) {
		// Variável para armazenar as notas filtradas
		String notasFiltradas = "";

		// Itera sobre a lista de notas
		for (Nota nota : notas) {
			// Verifica se a data de criação da nota corresponde a data de criação informada
			if (nota.getDtCriacaoNota().equals(dtCriacaoNota)) {
				// Adiciona a nota filtrada a variável notasFiltradas
				notasFiltradas += nota.toString() + "\n";
			}
		}
		return notasFiltradas; // Retorna a lista de notas filtradas
	}

	public boolean acrescentarNota(Nota n) {
		if(notas.size() >= 1500) {
			return false;
		} else {
			notas.add(n);
			return true;
		}
	}

	public String pesquisarNota(String tituloNota) {
		for(int i = 0; i < notas.size(); i++) {
			  // Certifique-se de que getTituloNota() e tituloNota não são nulos antes de realizar a comparação
			  if (notas.get(i).getTituloNota() != null && tituloNota != null) {
				if (notas.get(i).getTituloNota().equalsIgnoreCase(tituloNota)) {
					// Certifique-se de que o método toString() da classe de nota está implementado corretamente
					return notas.get(i).toString();
				}
			}
		}
		return null;
	}

	public boolean deletarNota(String tituloNota) {
		for(int i =0; i < notas.size(); i++) {
			if (notas.get(i).getTituloNota().equalsIgnoreCase(tituloNota)) {
				notas.remove(i);
				return true;
			}
		}
		return false;
	}

	public void preencherNotas() {
		for(int i = 0; i < 10; i++) {
			String s = String.valueOf(i);

			Nota n = new Nota("TituloNota".concat(s), "DtCriacao".concat(s), "Conteudo".concat(s));

			notas.add(i, n);
		}
	}
	
}
