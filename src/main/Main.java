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

		while(op != 0) {
			System.out.print(imprimirMenu());
			op = in.nextInt();

			 switch (op) {
			 	case 0:
			 		System.out.println("Obrigada por utilizar o sistema. Ate logo!");
			 		break;
				case 1:
					cadastrarUsuario();
					break;
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
					criarPasta();
					break;
				case 7: 
					removerPasta();
					break;
				case 8: 
					editarPasta();
					break;
				case 9:
					listarPasta();
					break;
				case 10: 
					filtrarPasta();
					break;
				case 11: 
					criarNota();
					break;
				case 12: 
					removerNota();
					break;
				case 13: 
					editarNota();
					break;
				case 14:
					listarNota();
					break;
				case 15: 
					filtraNota();
					break;
				case 16:
					buscarNota();
					break;
				
				default:
					System.out.println("\nOpcao Invalida!\n");
					break;
			 }
		}
		in.close();
	}
	
	public static String imprimirMenu() { 
		String saida = new String("Escolha uma das opcoes a seguir:\n");
		saida = saida + "00 - Sair da aplicativo\n";
		saida = saida + "01 - Cadastrar novo Usuário\n";
		saida = saida + "02 - Remover Usuário existente\n";
		saida = saida + "03 - Editar Usuário existente\n";
		saida = saida + "04 - Listar Usuários\n";
		saida = saida + "05 - Filtrar Usuários\n";
		saida = saida + "06 - Criar uma nova Pasta\n";
		saida = saida + "07 - Remover uma Pasta existente\n";
		saida = saida + "08 - Editar Pastas\n";
		saida = saida + "09 - Listar Pastas\n";
		saida = saida + "10 - Filtrar Pastas\n";
		saida = saida + "11 - Criar Nota\n";
		saida = saida + "12 - Remover Nota\n";
		saida = saida + "13 - Editar Nota\n";
		saida = saida + "14 - Listar Notas\n";
		saida = saida + "15 - Filtrar Notas\n";
		saida = saida + "16 - Buscar Notas\n";
				
		return saida;
	}	
	}


