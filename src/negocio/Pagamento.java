package negocio;

public class Pagamento {
	private String email;
	private String numCartao;
	private String validade;
	private int cvv;
	private String pais;
	
	public Pagamento(String e, String nC, String v, int c, String p) {
		this.email = e;
		this.numCartao = nC;
		this.validade = v;
		this.cvv = c;
		this.pais = p;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumCartao() {
		return numCartao;
	}

	public void setNumCartao(String numCartao) {
		this.numCartao = numCartao;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String toString() {
		return "Número do cartão: " + numCartao +
				"\nValidade: " + validade;
	}
	
	public boolean excluirCartao() {
		// Verifica se o cartão existe
		if (this.numCartao == null) {
			return false;
		}
		// Define o cartão como excluído
		this.numCartao = null;
	
		// Retorna true para indicar que o cartão foi excluído com sucesso
		return true;
	}
	
}
