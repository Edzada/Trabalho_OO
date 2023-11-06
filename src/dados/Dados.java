package dados;
import negocio.*;

import java.lang.foreign.ValueLayout;
import java.util.ArrayList;
import java.util.Objects;

public class Dados {
	private ArrayList<Usuario> usuarios;
	private int numUsuarios = 0;

	public Dados() {
		this.usuarios = new ArrayList<>(200);
	}

	public ArrayList<Usuario> getUsuario() {
		return usuarios;
	}

	public Usuario getUsuario(int i) {
		return usuarios.get(i);
	}

	public String[] getNomeUsuarios() {
		String[] s = new String[numUsuarios];
		for(int i = 0; i < numUsuarios; i++) {
			s[i] = usuarios.get(i).getNome();
		}

		return s;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void setUsuario(int i, Usuario u) {
		this.usuarios.set(i, u);
	}

	public int getNumUsuarios() {
		return numUsuarios;
	}

	public void setNumUsuarios(int numUsuarios) {
		this.numUsuarios = numUsuarios;
	}

	public String listarUsuarios() {
		String saida = ">>>>>> Lista de Usuarios <<<<<<\n";

		for(int i = 0; i < numUsuarios; i++) {
			System.out.println(i);
			saida = saida + "\n" + usuarios.get(i).getNome();
		}

		return saida;
	}

	public void preencherDados() {
		int i;
		for(i = 0; i < 5; i++) {
			String s = String.valueOf(i);
			Usuario user = new UsuarioFree("Nome".concat(s), "DataNascimento".concat(s),
								"NomeUsuario".concat(s), "email".concat(s), "Senha".concat(s));
			usuarios.add(i, user);
		}

		for(i = 5; i < 10; i++) {
			String s = String.valueOf(i);
			Pagamento cartao = new Pagamento("Email".concat(s), "NumCartao".concat(s),
					"Validade".concat(s), 123, "Pais".concat(s));
			Usuario user = new UsuarioPlus("Nome".concat(s), "DataNascimento".concat(s),
					"NomeUsuario".concat(s), "email".concat(s), "Senha".concat(s), cartao);
			usuarios.add(i, user);
		}

		numUsuarios = 10;
	}

	public boolean deletarUsuario(String nome) {
		for(int i = 0; i < numUsuarios; i++) {
			if(Objects.equals(usuarios.get(i).getNome(), nome)) {
				usuarios.remove(i);
				return true;
			}
		}
		return false;
	}
}
