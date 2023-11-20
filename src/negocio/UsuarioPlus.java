package negocio;

import java.util.ArrayList;

public class UsuarioPlus extends Usuario{
	private Pagamento cartao;
	
	public UsuarioPlus(String n, String d, String nU, String e, String s, Pagamento c) {
		super(n, d, nU, e, s);
		this.cartao = c;
		this.qtdPastas = 1500;
		this.pastas = new ArrayList<>(1500);
	}

	public Pagamento getCartao() {
		return cartao;
	}

	public void setCartao(Pagamento cartao) {
		this.cartao = cartao;
	}

	public boolean pagarAssinatura() {
		double assinatura = 15.90;

		// Verificando se o cartão existe
		if(cartao != null) {
			// Aqui, verificando se o limite do cartão é maior que o valor da assinatura
			if (cartao.getLimite() >= assinatura) {
				// Se for maior, é descontado o valor da assinatura no cartão
				cartao.setLimite(cartao.getLimite() - assinatura);
				return true;
			} else {
				// Caso o limite seja menor que o valor da assinatura, não é possível pagar
				return false;
			}
		} else {
			// Aqui retorna false quando o cartão não existe
			return false;
		}
	}

	public String toString() {
		return "Nome: " + nome +
				"\nNome de Usuário: " + nomeUsuario +
				"\nQuantidade de Notas: " + qtdNotas +
				"\nQuantidade de Pastas: " + qtdPastas +
				"\n" + cartao.toString();
	}

}
