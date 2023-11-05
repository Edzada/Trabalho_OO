package negocio;

public class Pasta {
	private String tituloPasta;
	private String dtCriacaoPasta;
	private Nota[] notas;
	private int numNotas;
	
	public Pasta(String t, String d) {
		this.tituloPasta = t;
		this.dtCriacaoPasta = d;
		
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
		return "Pasta [tituloPasta=" + tituloPasta + ", dtCriacaoPasta=" + dtCriacaoPasta + ", numNotas=" + numNotas
				+ "]";
	}
	
	
}
