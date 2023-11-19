package dados;

import negocio.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Dados {
	private ArrayList<UsuarioFree> usuariosFree;
	private ArrayList<UsuarioPlus> usuariosPlus;

	public Dados() {
		this.usuariosFree = new ArrayList<>(100);
		this.usuariosPlus = new ArrayList<>(100);
	}

	public ArrayList<UsuarioFree> getUsuariosFree() {
		return usuariosFree;
	}

	public ArrayList<UsuarioPlus> getUsuariosPlus() {
		return usuariosPlus;
	}

	public UsuarioFree getUsuarioFree(int i) {
		return usuariosFree.get(i);
	}

	public UsuarioPlus getUsuarioPlus(int i) {
		return usuariosPlus.get(i);
	}

	public String[] getNomeUsuariosFree() {
		String[] s = new String[usuariosFree.size()];
		for(int i = 0; i < usuariosFree.size(); i++) {
			s[i] = usuariosFree.get(i).getNome();
		}

		return s;
	}

	public String[] getNomeUsuariosPlus() {
		String[] s = new String[usuariosPlus.size()];
		for(int i = 0; i < usuariosPlus.size(); i++) {
			s[i] = usuariosPlus.get(i).getNome();
		}

		return s;
	}

	public void setUsuariosFree(ArrayList<UsuarioFree> usuariosF) {
		this.usuariosFree = usuariosF;
	}

	public void setUsuariosPlus(ArrayList<UsuarioPlus> usuariosP) {
		this.usuariosPlus = usuariosP;
	}

	public void setUsuarioFree(int i, UsuarioFree u) {
		this.usuariosFree.set(i, u);
	}

	public void setUsuarioPlus(int i, UsuarioPlus u) {
		this.usuariosPlus.set(i, u);
	}

	public void addUsuarioFree(UsuarioFree u) {
		this.usuariosFree.add(u);
	}

	public void addUsuarioPlus(UsuarioPlus u) {
		this.usuariosPlus.add(u);
	}

	public int getNumUsuarios() {
		return usuariosFree.size() + usuariosPlus.size();
	}

	public int getNumUsuariosFree() {
		return usuariosFree.size();
	}

	public int getNumUsuariosPlus() {
		return usuariosPlus.size();
	}

	public void setNumUsuariosFree(int numUsuarios) {
		usuariosFree.ensureCapacity(numUsuarios);
	}

	public void setNumUsuariosPlus(int numUsuarios) {
		usuariosPlus.ensureCapacity(numUsuarios);
	}

	public void preencherDados() {
		for(int i = 0; i < 10; i++) {
			String s = String.valueOf(i);

			UsuarioFree userFree = new UsuarioFree("Nome".concat(s), "DataNascimento".concat(s),
								"NomeUsuario".concat(s), "email".concat(s), "Senha".concat(s));
			usuariosFree.add(i, userFree);


			Pagamento cartao = new Pagamento("Email".concat(s), "NumCartao".concat(s),
					"Validade".concat(s), 123, "Pais".concat(s), 2000.00);
			UsuarioPlus userPlus = new UsuarioPlus("Nome".concat(s), "DataNascimento".concat(s),
					"NomeUsuario".concat(s), "email".concat(s), "Senha".concat(s), cartao);
			usuariosPlus.add(i, userPlus);


		}
	}

	public boolean deletarUsuarioFree(String nome) {
		for(int i = 0; i < usuariosFree.size(); i++) {
			if(usuariosFree.get(i).getNome().equalsIgnoreCase(nome)) {
				usuariosFree.remove(i);
				return true;
			}
		}
		return false;
	}

	public boolean deletarUsuarioPlus(String nome) {
		for(int i = 0; i < usuariosPlus.size(); i++) {
			if(usuariosPlus.get(i).getNome().equalsIgnoreCase(nome)) {
				usuariosPlus .remove(i);
				return true;
			}
		}
		return false;
	}
	  
}
