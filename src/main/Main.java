package main;

import negocio.*;

import java.util.ArrayList;
import java.util.Scanner;

import dados.*;

public class Main {
	private static Dados d = new Dados();
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		int op = -1;
		d.preencherDados();

		while (op != 0) {
			System.out.print(imprimirMenu());
			op = in.nextInt();

			switch (op) {
				case 0:
					System.out.println("Obrigado por utilizar o sistema. Até logo!");
					break;
				case 1:
					cadastrarUsuario();
				case 2:
					removerUsuario();
					break;
				case 3:
					editarUsuario();
					break;
				case 4:
					listarUsuario();
					break;
				case 5:
				    filtrarUsuario();
					break;
				case 6:
					//criarPasta();
					break;
				case 7:
					//removerPasta();
					break;
				case 8:
					//editarPasta();
					break;
				case 9:
					//listarPasta();
					break;
				case 10:
					//filtrarPasta();
					break;
				case 11:
					//criarNota();
					break;
				case 12:
					//removerNota();
					break;
				case 13:
					//editarNota();
					break;
				case 14:
					//listarNota();
					break;
				case 15:
					//filtraNota();
					break;
				case 16:
					//buscarNota();
					break;

				default:
					System.out.println("\nOpção Inválida!\n");
					break;
			}
		}
		in.close();
	}

	private static void limparTela() {
	}

	private static void aguardarComando() {
	}

	private static void limparBuffer() {
	}

	public static String imprimirMenu() {
		String saida = "\n<<<< MENU >>>>\n";
		saida = saida + "0 - Sair da aplicativo\n";
		saida = saida + "1 - Cadastrar novo Usuário\n";
		saida = saida + "2 - Remover Usuário existente\n";
		saida = saida + "3 - Editar Usuário existente\n";
		saida = saida + "4 - Listar Usuários\n";
		saida = saida + "5 - Filtrar Usuários\n";
		saida = saida + "6 - Criar uma nova Pasta\n";
		saida = saida + "7 - Remover uma Pasta existente\n";
		saida = saida + "8 - Editar Pastas\n";
		saida = saida + "9 - Listar Pastas\n";
		saida = saida + "10 - Filtrar Pastas\n";
		saida = saida + "11 - Criar Nota\n";
		saida = saida + "12 - Remover Nota\n";
		saida = saida + "13 - Editar Nota\n";
		saida = saida + "14 - Listar Notas\n";
		saida = saida + "15 - Filtrar Notas\n";
		saida = saida + "16 - Buscar Notas\n";
		saida = saida + ">> Escolha uma das opções: ";

		return saida;
	}

	public static UsuarioFree lerDadosUsuarioF() {
		String nome, dtNascimento, nomeUsuario, email, senha;

		in.nextLine();

		System.out.print("Informe o nome do usuário: ");
		nome = in.nextLine();
		System.out.print("Informe a data de nascimento do usuário: ");
		dtNascimento = in.nextLine();
		System.out.print("Informe o nome de usuário: ");
		nomeUsuario = in.nextLine();
		System.out.print("Informe o email: ");
		email = in.nextLine();
		System.out.print("Informe a senha para finalizar o cadastro: ");
		senha = in.nextLine();

		return new UsuarioFree(nome, dtNascimento, nomeUsuario, email, senha);
	}

	public static UsuarioPlus lerDadosUsuarioP() {
		String nome, dtNascimento, nomeUsuario, email, senha, emailFatura, numCartao, validade, pais;
		int cvv;
		double limite;

		in.nextLine();

		System.out.print("Informe o nome do usuário: ");
		nome = in.nextLine();
		System.out.print("Informe a data de nascimento do usuário: ");
		dtNascimento = in.nextLine();
		System.out.print("Informe o nome de usuário: ");
		nomeUsuario = in.nextLine();
		System.out.print("Informe o email: ");
		email = in.nextLine();
		System.out.print("Informe a senha: ");
		senha = in.nextLine();
		System.out.print("Informe o email para o recebimento da fatura da assinatura: ");
		emailFatura = in.nextLine();
		System.out.print("Informe o número do cartão: ");
		numCartao = in.nextLine();
		System.out.print("Informe a data de validade do cartão: ");
		validade = in.nextLine();
		System.out.print("Informe o país onde o cartão foi emitido: ");
		pais = in.nextLine();
		System.out.print("Informe o CVV do cartão: ");
		cvv = in.nextInt();
		System.out.print("Informe o limite do cartão: ");
		limite = in.nextDouble();

		Pagamento cartao = new Pagamento(emailFatura, numCartao, validade, cvv, pais, limite);
		return new UsuarioPlus(nome, dtNascimento, nomeUsuario, email, senha, cartao);
	}

	public static void cadastrarUsuario(){
		System.out.print("\nEscolha o plano desejado:\n1 - Plano Free\n2 - Plano Plus\n>> ");
		int n = in.nextInt();

		if(n == 1) {
			UsuarioFree u = lerDadosUsuarioF();

			if(d.getNumUsuarios() < 200) {
				d.addUsuarioFree(u);
				System.out.println("Usuário cadastrado com sucesso!");
			} else {
				System.out.println("Não é possível cadastrar o Usuário!");
			}

		} else if(n == 2) {
			UsuarioPlus u = lerDadosUsuarioP();

			if(d.getNumUsuarios() < 200) {
				d.addUsuarioPlus(u);
				System.out.println("Usuário cadastrado com sucesso!");
			} else {
				System.out.println("Não é possível cadastrar o Usuário!");
			}

		} else {
			System.out.print("Opção Inválida\n");
		}

	}

	public static void removerUsuario() {
		in.nextLine();
		System.out.print("\nEscolha o tipo de usuário:\n1 - Usuário Free\n2 - Usuário Plus\n>> ");
		int n = in.nextInt();

		if(n == 1) {
			in.nextLine();
			System.out.print(">> Informe o nome de usuário: ");
			String nomeUsuario = in.nextLine();

			// Valida o nome do usuário
			if (nomeUsuario == null || nomeUsuario.isEmpty()) {
				System.out.println("Nome de usuário inválido!");
				return;
			}

			// Remove o usuário da base de dados
			if (d.deletarUsuarioFree(nomeUsuario)) {
				System.out.println("Usuário removido com sucesso!");
			} else {
				System.out.println("Erro ao remover o usuário: ");
			}

		} else if(n == 2) {
			in.nextLine();
			System.out.print(">> Informe o nome do usuário: ");
			String nomeUsuario = in.nextLine();

			// Valida o nome do usuário
			if (nomeUsuario == null || nomeUsuario.isEmpty()) {
				System.out.println("Nome de usuário inválido!");
				return;
			}

			// Remove o usuário da base de dados
			if (d.deletarUsuarioPlus(nomeUsuario)) {
				System.out.println("Usuário removido com sucesso!");
			} else {
				System.out.println("Erro ao remover o usuário: ");
			}

		} else {
			System.out.println("Opção Inválida!");
		}

	}

	public static void editarUsuario() {
		System.out.print("\nEscolha o tipo de usuário:\n1 - Usuário Free\n2 - Usuário Plus\n>> ");
		int n = in.nextInt();

		if(n == 1) {
			System.out.println("Escolha um dos usuários a seguir para editar as informações: ");

			System.out.println(">>>>>> Usuários Free <<<<<<");
			for(int i = 0; i < d.getUsuariosFree().size(); i++) {
				System.out.println(i + " -> " + d.getUsuariosFree().get(i).getNome());
			}
			int aux = in.nextInt();

			UsuarioFree u = lerDadosUsuarioF();

			if(aux < d.getNumUsuariosFree() && aux >= 0) {
				d.setUsuarioFree(aux, u);
				System.out.println("Informações do usuário editadas com sucesso!");
			} else {
				System.out.println("Número inválido!");
			}

		} else if(n == 2) {
			System.out.println("Escolha um dos usuários a seguir para editar as informações: ");

			System.out.println(">>>>>> Usuários Plus <<<<<<");
			for(int i = 0; i < d.getUsuariosPlus().size(); i++) {
				System.out.println(i + " -> " + d.getUsuariosPlus().get(i).getNome());
			}
			int aux = in.nextInt();

			UsuarioPlus u = lerDadosUsuarioP();

			if(aux < d.getNumUsuariosPlus() && aux >= 0) {
				d.setUsuarioPlus(aux, u);
				System.out.println("Informações do usuário editadas com sucesso!");
			} else {
				System.out.println("Número inválido!");
			}
		} else {
			System.out.println("Opção Inválida!");
		}
	}

	public static void listarUsuario() {
		in.nextLine();
		ArrayList<Usuario> aux = new ArrayList<Usuario>(d.getNumUsuarios());
		aux.addAll(d.getUsuariosFree());
		aux.addAll(d.getUsuariosPlus());

		System.out.println("\n>>>>>> Lista de Usuários <<<<<<");
		for(int i = 0; i < aux.size(); i++) {
			System.out.println(i + " -> " + aux.get(i).getNome());
		}
	}


	public static void filtrarUsuario(){
		System.out.println("Informe o nome do usuario");
		String aux;
		Scanner entrada=new Scanner(System.in);
		String nomeUsuario;
		nomeUsuario=entrada.nextLine();
		entrada.close();
		aux = d.filtrarUsuarios(nomeUsuario);
		if (aux == "[]") {
			System.out.println("Usuario nao encontrado");
		}
		else {
			System.out.println(aux);
		};
	}
}

