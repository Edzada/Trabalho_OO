package negocio;

import java.util.ArrayList;
import java.util.Objects;

public class Pasta {
	private String tituloPasta;
	private String dtCriacaoPasta;
	private ArrayList<Nota> notas;
	private int numNotas;
	
	public Pasta(String t, String d) {
		this.tituloPasta = t;
		this.dtCriacaoPasta = d;
		this.notas = new ArrayList<>(1500);
		this.numNotas = 0;
		
	}

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

	public String toString() {
		return "Título: " + tituloPasta +
				"\nData de criação: " + dtCriacaoPasta +
				"\nNúmero de notas: " + numNotas;
	}

	public String listarNotas() {
		String saida = ">>>>>> Lista de Notas <<<<<<\n";

		for(int i = 0; i < numNotas; i++) {
			System.out.println(i);
			saida = saida + "\n" + notas.get(i).toString();
		}

		return saida;
	}

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
