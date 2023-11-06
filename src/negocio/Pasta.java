package negocio;

public class Pasta {
	private String tituloPasta;
	private String dtCriacaoPasta;
	private Nota[] notas;
	private int numNotas;
	
	public Pasta(String t, String d) {
		this.tituloPasta = t;
		this.dtCriacaoPasta = d;
		this.notas = new Nota[1500];
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

	public Nota[] getNotas() {
		return notas;
	}

	public void setNotas(Nota[] notas) {
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
			saida = saida + "\n" + notas[i].getTituloNota();
		}

		return saida;
	}
	
	
}
