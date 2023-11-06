package negocio;

public class UsuarioPlus extends Usuario{
	private Pagamento cartao;
	
	public UsuarioPlus(String n, String d, String nU, String e, String s, Pagamento c) {
		super(n, d, nU, e, s);
		this.cartao = c;
		this.qtdNotas = 1500;
		this.qtdPastas = 1500;
		this.pastas = new Pasta[1500];
		this.numPastas = 0;
		
	}

	public Pagamento getCartao() {
		return cartao;
	}

	public void setCartao(Pagamento cartao) {
		this.cartao = cartao;
	}

}
