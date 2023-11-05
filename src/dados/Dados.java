package dados;
import negocio.*;

import java.lang.foreign.ValueLayout;

public class Dados {
	private Usuario[] usuarios;
	private int numUsuarios = 0;

	public Dados() {
		this.usuarios = new Usuario[200];
	}

	public Usuario[] getUsuario() {
		return usuarios;
	}

	public Usuario getUsuario(int i) {
		return usuarios[i];
	}

	public String[] getNomeUsuarios() {
		String[] s = new String[numUsuarios];
		for(int i = 0; i < numUsuarios; i++) {
			s[i] = usuarios[i].getNome();
		}

		return s;
	}

	public void setUsuarios(Usuario[] usuarios) {
		this.usuarios = usuarios;
	}

	public void setUsuario(int i, Usuario u) {
		this.usuarios[i] = u;
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
			saida = saida + "\n" + usuarios[i].getNome();
		}

		return saida;
	}

	public void preencherDados() {
		for(int i = 0; i < 5; i++) {
			String s = String.valueOf(i);
			usuarios[i] = new UsuarioFree("Nome".concat(s), "DataNascimento".concat(s),
								"NomeUsuario".concat(s), "email".concat(s), "Senha".concat(s));
		}

		for(int i = 5; i < 10; i++) {
			String s = String.valueOf(i);
			usuarios[i] = new UsuarioPlus("Nome".concat(s), "DataNascimento".concat(s),
					"NomeUsuario".concat(s), "email".concat(s), "Senha".concat(s), null);
		}

		numUsuarios = 10;
	}
}
