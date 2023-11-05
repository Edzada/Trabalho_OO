package negocio;

public class Nota {
	private String tituloNota;
	private String dtCriacaoNota;
	private String conteudoNota;
	
	public Nota(String t, String d, String c) {
		this.tituloNota = t;
		this.dtCriacaoNota = d;
		this.conteudoNota = c;
	}

	public String getTituloNota() {
		return tituloNota;
	}

	public void setTituloNota(String tituloNota) {
		this.tituloNota = tituloNota;
	}

	public String getDtCriacaoNota() {
		return dtCriacaoNota;
	}

	public void setDtCriacaoNota(String dtCriacaoNota) {
		this.dtCriacaoNota = dtCriacaoNota;
	}

	public String getConteudoNota() {
		return conteudoNota;
	}

	public void setConteudoNota(String conteudoNota) {
		this.conteudoNota = conteudoNota;
	}

	public String toString() {
		return "Nota [tituloNota=" + tituloNota + ", dtCriacaoNota=" + dtCriacaoNota + ", conteudoNota=" + conteudoNota
				+ "]";
	}

	
	
}

