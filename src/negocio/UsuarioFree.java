package negocio;

public class UsuarioFree extends Usuario{
	private String anuncio;
	
	public UsuarioFree(String n, String d, String nU, String e, String s) {
		super(n, d, nU, e, s);
		this.qtdNotas = 50;
		this.qtdPastas = 50;
		this.pastas = new Pasta[50];
		this.numPastas = 0;
	}

	public String getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(String anuncio) {
		this.anuncio = anuncio;
	}
	
	
	
	
}
