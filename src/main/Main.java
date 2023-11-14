package main;

import negocio.*;

import java.util.Scanner;

import dados.*;

public class Main {
	private static Dados d = new Dados();
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		int op = -1;
		int aux;
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
					break;
				case 2:
					//removerUsuario();
					break;
				case 3:
					//editarUsuario();
					break;
				case 4:
					//listarUsuario();
					break;
				case 5:
					//filtrarUsuario();
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

	public static String imprimirMenu() {
		String saida = new String("\n<<<< MENU >>>>\n");
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

	public static void cadastrarUsuario(){
		System.out.print("\nEscolha o plano desejado:\n1 - Plano Free\n2 - Plano Plus\n>> ");
		int n = in.nextInt();

		if(n == 1) {
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

			Usuario u = new UsuarioFree(nome, dtNascimento, nomeUsuario, email, senha);

			if(d.getNumUsuarios() < 200) {
				d.addUsuario(u);
				System.out.println("Usuário cadastrado com sucesso!");
			} else {
				System.out.println("Não é possível cadastrar o Usuário!");
			}

		} else if(n == 2) {
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
			Usuario u = new UsuarioPlus(nome, dtNascimento, nomeUsuario, email, senha, cartao);

			if(d.getNumUsuarios() < 200) {
				d.addUsuario(u);
				System.out.println("Usuário cadastrado com sucesso!");
			} else {
				System.out.println("Não é possível cadastrar o Usuário!");
			}

		} else {
			System.out.print("Opção Inválida\n");
		}

	}

}

