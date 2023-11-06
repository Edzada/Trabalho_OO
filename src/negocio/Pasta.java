package negocio;

import java.util.ArrayList;
import java.util.Objects;

public class Pasta {
	// Declara variáveis privadas
	private String tituloPasta;
	private String dtCriacaoPasta;
	private ArrayList<Nota> notas;
	private int numNotas;
	
	// Construtor	
	public Pasta(String t, String d) {
		this.tituloPasta = t;
		this.dtCriacaoPasta = d;
		this.notas = new ArrayList<>(1500);
		this.numNotas = 0;
		
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

	public int getNumNotas() {
		return numNotas;
	}

	public void setNumNotas(int numNotas) {
		this.numNotas = numNotas;
	}
	//Método toString()
	public String toString() {
		return "Título: " + tituloPasta +
				"\nData de criação: " + dtCriacaoPasta +
				"\nNúmero de notas: " + numNotas;
	}
	// Método listarNotas()
	public String listarNotas() {
		// Variável para armazenar a saída
		String saida = ">>>>>> Lista de Notas <<<<<<\n";
		// Itera sobre a lista de notas
		for(int i = 0; i < numNotas; i++) {
			// Adiciona a representação `toString()` da nota à variável saida
			System.out.println(i);
			saida = saida + "\n" + notas.get(i).toString();
		}

		return saida;
	}
	//Método de filtraNotas()
	public String filtrarNotas(String dtCriacaoNota){
		// Variável para armazenar as notas filtradas
		String notasFiltradas = "";

		// Itera sobre a lista de notas
		for (Nota nota : notas){
			// Verifica se a data de criação da nota corresponde a data de criação informada
			if(nota.getDtCriacaoNota().equals(dtCriacaoNota)){
				// Adiciona a nota filtrada a variável notasFiltradas
				notasFiltradas += nota.toString() + "\n";
			}
		}
		return notasFiltradas; // Retorna a lista de notas filtradas

	public boolean acrescentarNota(Nota n) {
		if(numNotas == 1499) {
			return false;
		} else {
			notas.add(n);
			numNotas++;
			return true;
		}
	}

	public String pesquisarNota(String tituloNota) {
		for(int i = 0; i < numNotas; i++) {
			if(Objects.equals(notas.get(i).getTituloNota(), tituloNota)) {
				return notas.get(i).toString();
			}
		}
		return null;
	}

	public boolean deletarNota(String tituloNota) {
		for(int i =0; i < numNotas; i++) {
			if (Objects.equals(notas.get(i).getTituloNota(), tituloNota)) {
				notas.remove(i);
				return true;
			}
		}
		return false;
	}
	
}
