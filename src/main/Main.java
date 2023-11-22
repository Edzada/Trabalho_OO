package main;

import negocio.*;

import java.util.ArrayList;
import java.util.Scanner;

import dados.*;

public class Main {
	private static Usuario u; // Declare the variable without instantiation
	private static Dados d = new Dados();
	private static Scanner in = new Scanner(System.in);


	public static void main(String[] args) {

		int op = -1;
		d.preencherDadosUsuarios();
		d.preencherDadosPastas();
		d.preencherDadosNotas();

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
					removerUsuario();
					break;
				case 3:
					editarUsuario();
					break;
				case 4:
					d.listarUsuario();
					break;
				case 5:
					visualizarUsuario();
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
					visualizarPasta();
					break;
				case 12:
					criarNota();
					break;
				case 13:
					removerNota();
					break;
				case 14:
					editarNota();
					break;
				case 15:
					listarNota();
					break;
				case 16:
					filtrarNota();
					break;
				case 17:
					buscarNota();
					break;
				case 18:
					visualizarNota();
					break;
				default:
					System.out.println("\nOpção Inválida!\n");
					break;
			}
		}
		in.close();
	}

	public static String imprimirMenu() {
		String saida = "\n<<<< MENU >>>>\n";
		saida = saida + "0 - Sair da aplicativo\n";
		saida = saida + "1 - Cadastrar novo Usuário\n";
		saida = saida + "2 - Remover Usuário existente\n";
		saida = saida + "3 - Editar Usuário existente\n";
		saida = saida + "4 - Listar Usuários\n";
		saida = saida + "5 - Visualizar Usuário\n";
		saida = saida + "6 - Criar uma nova Pasta\n";
		saida = saida + "7 - Remover uma Pasta existente\n";
		saida = saida + "8 - Editar Pastas\n";
		saida = saida + "9 - Listar Pastas\n";
		saida = saida + "10 - Filtrar Pastas\n";
		saida = saida + "11 - Visualizar Pasta\n";
		saida = saida + "12 - Criar Nota\n";
		saida = saida + "13 - Remover Nota\n";
		saida = saida + "14 - Editar Nota\n";
		saida = saida + "15 - Listar Notas\n";
		saida = saida + "16 - Filtrar Notas\n";
		saida = saida + "17 - Buscar Notas\n";
		saida = saida + "18 - Visualizar Nota\n";
		saida = saida + ">> Escolha uma das opções: ";

		return saida;
	}

	// Funções relacionadas ao Usuário

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

	public static void cadastrarUsuario() {
		System.out.print("\nEscolha o plano desejado:\n1 - Plano Free\n2 - Plano Plus\n>> ");
		int n = in.nextInt();

		if (n == 1) {
			UsuarioFree u = lerDadosUsuarioF();

			if (d.getNumUsuarios() < 200) {
				d.addUsuarioFree(u);
				System.out.println("Usuário cadastrado com sucesso!");
			} else {
				System.out.println("Não é possível cadastrar o Usuário!");
			}

		} else if (n == 2) {
			UsuarioPlus u = lerDadosUsuarioP();

			if (d.getNumUsuarios() < 200) {
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

		if (n == 1) {
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

		} else if (n == 2) {
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

		if (n == 1) {
			System.out.println("Escolha um dos usuários a seguir para editar as informações: ");

			System.out.println(">>>>>> Usuários Free <<<<<<");
			for (int i = 0; i < d.getUsuariosFree().size(); i++) {
				System.out.println(i + " -> " + d.getUsuariosFree().get(i).getNome());
			}
			int aux = in.nextInt();

			UsuarioFree u = lerDadosUsuarioF();

			if (aux < d.getNumUsuariosFree() && aux >= 0) {
				d.setUsuarioFree(aux, u);
				System.out.println("Informações do usuário editadas com sucesso!");
			} else {
				System.out.println("Número inválido!");
			}

		} else if (n == 2) {
			System.out.println("Escolha um dos usuários a seguir para editar as informações: ");

			System.out.println(">>>>>> Usuários Plus <<<<<<");
			for (int i = 0; i < d.getUsuariosPlus().size(); i++) {
				System.out.println(i + " -> " + d.getUsuariosPlus().get(i).getNome());
			}
			int aux = in.nextInt();

			UsuarioPlus u = lerDadosUsuarioP();

			if (aux < d.getNumUsuariosPlus() && aux >= 0) {
				d.setUsuarioPlus(aux, u);
				System.out.println("Informações do usuário editadas com sucesso!");
			} else {
				System.out.println("Número inválido!");
			}
		} else {
			System.out.println("Opção Inválida!");
		}
	}


	public static void visualizarUsuario() {
		ArrayList<Usuario> aux = new ArrayList<Usuario>(d.getNumUsuarios());
		aux.addAll(d.getUsuariosFree());
		aux.addAll(d.getUsuariosPlus());

		d.listarUsuario();
		System.out.print("Informe o usuário que deseja ver as informações:\n>> ");
		int n = in.nextInt();

		if(n < aux.size() && n >= 0) {
			System.out.println("\n>>>>>> USUÁRIO " + aux.get(n).getNome() + " <<<<<<");
			System.out.println(aux.get(n).toString());
		}
	}

	// Funções relacionadas a Pastas

	public static void criarPasta() {
		ArrayList<Usuario> aux = new ArrayList<Usuario>(d.getNumUsuarios());
		aux.addAll(d.getUsuariosFree());
		aux.addAll(d.getUsuariosPlus());

		d.listarUsuario();
		System.out.print("Informe o usuário que deseja adicionar uma pasta:\n>> ");
		int n = in.nextInt();

		if(n < aux.size() && n >= 0) {
			in.nextLine();
			System.out.print("Informe o nome da nova pasta: ");
			String nomePasta = in.nextLine();

			System.out.print("Informe a data de criação nova pasta: ");
			String dtCriacao = in.nextLine();

			Pasta novaPasta = new Pasta(nomePasta, dtCriacao);
			if(aux.get(n).atribuirPasta(novaPasta)) {
				System.out.println("Pasta criada com sucesso! " + aux.get(n).getNome());
			} else {
				System.out.println("Limite de pastas excedido!");
			}
		} else {
			System.out.println("Número inválido!");
		}

	}

	public static void removerPasta(){
		ArrayList<Usuario> aux = new ArrayList<Usuario>(d.getNumUsuarios());
		aux.addAll(d.getUsuariosFree());
		aux.addAll(d.getUsuariosPlus());

		d.listarUsuario();
		System.out.print("Informe o usuário que deseja adicionar uma pasta:\n>> ");
		int n = in.nextInt();

		if(n < aux.size() && n >= 0) {
			aux.get(n).listarPastas();
			System.out.print("Informe o número da pasta que deseja remover: ");
			int numeroPasta = in.nextInt();

			if(numeroPasta < aux.get(n).getNumPastas() && numeroPasta >= 0) {
				if(aux.get(n).deletarPasta(aux.get(n).getPasta(numeroPasta).getTituloPasta())){
					System.out.println("Pasta removida com sucesso!");
				} else {
					System.out.println("Erro ao deletar a pasta!");
				}

			} else {
				System.out.println("Número inválido!");
			}

		} else {
			System.out.println("Número inválido!");
		}
	}

	public static void editarPasta(){
		ArrayList<Usuario> aux = new ArrayList<Usuario>(d.getNumUsuarios());
		aux.addAll(d.getUsuariosFree());
		aux.addAll(d.getUsuariosPlus());

		d.listarUsuario();
		System.out.print("Informe o usuário desejado:\n>> ");
		int x = in.nextInt();

		if (x < aux.size() && x >= 0) {
			aux.get(x).listarPastas();
			System.out.print("Informe o número da pasta que deseja editar: ");
			int n = in.nextInt();

			if (n < aux.get(x).getNumPastas() && n >= 0) {
				in.nextLine(); // Limpar o buffer

				System.out.print("Informe o novo título da pasta: ");
				String novoTitulo = in.nextLine();

				System.out.print("Informe a nova data de criação da pasta: ");
				String novaDataCriacao = in.nextLine();

				Pasta p = new Pasta(novoTitulo, novaDataCriacao);

				aux.get(x).setPasta(n, p);
				System.out.println("Pasta editada com sucesso!");
			} else {
				System.out.println("Número de pasta inválido!");
			}
		} else {
			System.out.println("Número inválido!");
		}


	}


	public static void listarPasta() {
		ArrayList<Usuario> aux = new ArrayList<Usuario>(d.getNumUsuarios());
		aux.addAll(d.getUsuariosFree());
		aux.addAll(d.getUsuariosPlus());

		d.listarUsuario();
		System.out.print("Informe o usuário que deseja ver a lista de pastas:\n>> ");
		int n = in.nextInt();

		if (n < aux.size() && n >= 0) {
			System.out.print("\n >>>>>> Lista de Pastas do Usuário " + aux.get(n).getNome() + " <<<<<<\n");
			aux.get(n).listarPastas();
		} else {
			System.out.println("Número inválido!");
		}

	}

	public static void visualizarPasta() {
		ArrayList<Usuario> aux = new ArrayList<Usuario>(d.getNumUsuarios());
		aux.addAll(d.getUsuariosFree());
		aux.addAll(d.getUsuariosPlus());

		d.listarUsuario();
		System.out.print("Informe o usuário que deseja consultar:\n>> ");
		int x = in.nextInt();

		if(x < aux.size() && x >= 0) {
			System.out.print("\n >>>>>> Lista de Pastas do Usuário " + aux.get(x).getNome() + " <<<<<<\n");
			aux.get(x).listarPastas();

			System.out.print("Informe a pasta que deseja ver as informações:\n>> ");
			int n = in.nextInt();

			if(n < aux.get(x).getNumPastas() && n >= 0) {
				System.out.println("\n>>>>>> PASTA " + aux.get(x).getPasta(n).getTituloPasta() + " <<<<<<");
				System.out.println(aux.get(x).getPasta(n).toString());
			} else {
				System.out.println("Número inválido");
			}
		} else {
			System.out.println("Número inválido!");
		}


	}

	public static void filtrarPasta() {
		ArrayList<Usuario> aux = new ArrayList<Usuario>(d.getNumUsuarios());
		aux.addAll(d.getUsuariosFree());
		aux.addAll(d.getUsuariosPlus());

		d.listarUsuario();
		System.out.print("Informe o usuário desejado:\n>> ");
		int n = in.nextInt();

		if(n < aux.size() && n >= 0) {
			in.nextLine();
			System.out.print("Informe a data de criação a ser filtrada:\n>> ");
			String dt = in.nextLine();

			System.out.println("\n>>>>>> PASTAS FILTRADAS <<<<<<");
			System.out.println(aux.get(n).filtrarPastas(dt));
		}
	}

	// Funções relacionadas a Notas
	
	public static void criarNota() {
		ArrayList<Usuario> aux = new ArrayList<Usuario>(d.getNumUsuarios());
		aux.addAll(d.getUsuariosFree());
		aux.addAll(d.getUsuariosPlus());

		d.listarUsuario();
		System.out.print("Informe o usuário que deseja ver a lista de pastas:\n>> ");
		int x = in.nextInt();

		if (x < aux.size() && x >= 0) {
			System.out.print("\n >>>>>> Lista de Pastas do Usuário " + aux.get(x).getNome() + " <<<<<<\n");
			aux.get(x).listarPastas();

			System.out.print("Informe a pasta que deseja adicionar a nota:\n>> ");
			int n = in.nextInt();

			if(n < aux.get(x).getNumPastas() && n >= 0) {
				in.nextLine();
				System.out.print("Informe o título da nova nota: ");
				String tituloNota = in.nextLine();

				System.out.print("Informe a data de criação da nova nota: ");
				String dtCriacao = in.nextLine();

				System.out.print("Informe o conteúdo da nota: ");
				String conteudoNota = in.nextLine();

				Nota novaNota = new Nota(tituloNota, dtCriacao, conteudoNota);
				if(aux.get(x).getPasta(n).acrescentarNota(novaNota)){
					System.out.println("Nota criada com sucesso na pasta " + aux.get(x).getPasta(n).getTituloPasta() + " para o usuário " + aux.get(x).getNome());
				} else {
					System.out.println("Limite ultrapassado!");
				}

			} else {
				System.out.println("Número inválido!");
			}

		} else {
			System.out.println("Número inválido!");
		}

	}

	public static void listarNota() {
		ArrayList<Usuario> aux = new ArrayList<Usuario>(d.getNumUsuarios());
		aux.addAll(d.getUsuariosFree());
		aux.addAll(d.getUsuariosPlus());

		d.listarUsuario();
		System.out.print("Informe o usuário que deseja ver a lista de pastas:\n>> ");
		int x = in.nextInt();

		if(x < aux.size() && x >= 0) {
			System.out.print("\n >>>>>> Lista de Pastas do Usuário " + aux.get(x).getNome() + " <<<<<<\n");
			aux.get(x).listarPastas();

			System.out.print("Informe a pasta que deseja ver a lista de notas:\n>> ");
			int n = in.nextInt();

			if (n < aux.get(x).getNumPastas() && n >= 0) {
				System.out.print("\n >>>>>> Lista de Notas da Pasta " + aux.get(x).getPasta(n).getTituloPasta() +" <<<<<<\n");
				aux.get(x).getPasta(n).listarNotas();
			} else {
				System.out.println("Número inválido!");
			}

		} else {
			System.out.println("Número inválido!");
		}
	}

	// Editar nota
	public static void editarNota() {
		ArrayList<Usuario> aux = new ArrayList<Usuario>(d.getNumUsuarios());
		aux.addAll(d.getUsuariosFree());
		aux.addAll(d.getUsuariosPlus());

		d.listarUsuario();
		System.out.print("Informe o usuário que deseja ver a lista de pastas:\n>> ");
		int x = in.nextInt();

		if (x < aux.size() && x >= 0) {
			System.out.print("\n >>>>>>>> Lista de Pastas do Usuário " + aux.get(x).getNome() + "<<<<<<<<<");
			aux.get(x).listarPastas();
			System.out.print("Informe a pasta que deseja visualizar: ");
			int n = in.nextInt();

			if (n < aux.get(x).getNumPastas() && n >= 0) {
				System.out.print("\n >>>>>>> Lista de Notas da Pasta  " + aux.get(x).getPasta(n).getTituloPasta() + "<<<<<<<<<");
				aux.get(x).getPasta(n).listarNotas();
				System.out.print("Informe a nota que deseja editar: ");
				int s = in.nextInt();

				in.nextLine();
				System.out.print("Informe o novo título da nota: ");
				String novoTitulo = in.nextLine();

				System.out.print("Informe a nova data de criação da nota: ");
				String novaDataCriacao = in.nextLine();

				System.out.print("Informe o novo conteúdo da nota: ");
				String novoConteudo = in.nextLine();

				Nota nota = new Nota(novoTitulo, novaDataCriacao, novoConteudo);

				if (s < aux.get(x).getPasta(n).getNumNotas() && s >= 0) {
					aux.get(x).getPasta(n).setNota(s, nota);
					System.out.print("Nota editada com sucesso");
				} else {
					System.out.print("Nota inválida");
				}
			} else {
				System.out.print("Pasta inválida");
			}
		} else {
			System.out.print("Usuário inválido");
		}
	}


	public static void visualizarNota() {
		ArrayList<Usuario> aux = new ArrayList<Usuario>(d.getNumUsuarios());
		aux.addAll(d.getUsuariosFree());
		aux.addAll(d.getUsuariosPlus());

		d.listarUsuario();
		System.out.print("Informe o usuário que deseja ver a lista de pastas:\n>> ");
		int x = in.nextInt();

		if(x < aux.size() && x >= 0) {
			System.out.print("\n >>>>>> Lista de Pastas do Usuário " + aux.get(x).getNome() + " <<<<<<\n");
			aux.get(x).listarPastas();

			System.out.print("Informe a pasta que deseja ver a lista de notas:\n>> ");
			int n = in.nextInt();

			if (n < aux.get(x).getNumPastas() && n >= 0) {
				System.out.print("\n >>>>>> Lista de Notas da Pasta " + aux.get(x).getPasta(n).getTituloPasta() + " <<<<<<\n");
				aux.get(x).getPasta(n).listarNotas();

				System.out.print("Informe a nota que deseja ver as informações:\n>> ");
				int z = in.nextInt();

				if(z < aux.get(x).getPasta(n).getNumNotas() && z >= 0) {
					System.out.println("\n>>>>>> Nota " + aux.get(x).getPasta(n).getNota(z).getTituloNota() + " <<<<<<");
					System.out.println(aux.get(x).getPasta(n).getNota(z).toString());
				}
			} else {
				System.out.println("Número inválido!");
			}

		} else {
			System.out.println("Número inválido!");
		}

	}

	public static void filtrarNota() {
		ArrayList<Usuario> aux = new ArrayList<Usuario>(d.getNumUsuarios());
		aux.addAll(d.getUsuariosFree());
		aux.addAll(d.getUsuariosPlus());

		d.listarUsuario();
		System.out.print("Informe o usuário que deseja consultar:\n>> ");
		int x = in.nextInt();

		if(x < aux.size() && x >= 0) {
			System.out.print("\n >>>>>> Lista de Pastas do Usuário " + aux.get(x).getNome() + " <<<<<<\n");
			aux.get(x).listarPastas();

			System.out.print("Informe a pasta desejada:\n>> ");
			int n = in.nextInt();

			if(n < aux.get(x).getNumPastas() && n >= 0) {
				in.nextLine();
				System.out.print("Informe a data de criação a ser filtrada:\n>> ");
				String dt = in.nextLine();

				System.out.println("\n>>>>>> NOTAS FILTRADAS <<<<<<");
				System.out.println(aux.get(x).getPasta(n).filtrarNotas(dt));
			} else {
				System.out.println("Número inválido");
			}
		} else {
			System.out.println("Número inválido!");
		}

	}

	public static void buscarNota() {
		ArrayList<Usuario> aux = new ArrayList<Usuario>(d.getNumUsuarios());
		aux.addAll(d.getUsuariosFree());
		aux.addAll(d.getUsuariosPlus());

		d.listarUsuario();
		System.out.print("Informe o usuário que deseja consultar:\n>> ");
		int x = in.nextInt();

		if(x < aux.size() && x >= 0) {
			System.out.print("\n >>>>>> Lista de Pastas do Usuário " + aux.get(x).getNome() + " <<<<<<\n");
			aux.get(x).listarPastas();

			System.out.print("Informe a pasta desejada para realizar a busca:\n>> ");
			int n = in.nextInt();

			if(n < aux.get(x).getNumPastas() && n >= 0) {
				in.nextLine();
				System.out.print("Informe o título da nota a ser buscada:\n>> ");
				String titulo = in.nextLine();

				System.out.println("\n>>>>>> NOTA <<<<<<");
				System.out.println(aux.get(x).getPasta(n).pesquisarNota(titulo));
			} else {
				System.out.println("Número inválido");
			}
		} else {
			System.out.println("Número inválido!");
		}

	}

	
	public static void removerNota() {
		ArrayList<Usuario>aux =new ArrayList<Usuario>(d.getNumUsuarios());
		aux.addAll(d.getUsuariosFree());
		aux.addAll(d.getUsuariosPlus());
		
		d.listarUsuario();
		System.out.println("Informe o usuário que deseja ver a lista de pastas");
		int x=in.nextInt();
		
		if(x<aux.size() && x>=0) {
			System.out.println("\n >>>>>>>> Lista de Pastas do Usuário " +aux.get(x).getNome() + "<<<<<<<<<");
			aux.get(x).listarPastas();
			System.out.print("Informe a pasta que deseja visualizar: ");
			int n=in.nextInt();
			
			if(n<aux.get(x).getNumPastas() && n>=0) {
				System.out.print("\n >>>>>>> Lista de Notas da Pasta  " +aux.get(x).getPasta(n).getTituloPasta() + "<<<<<<<<<");
				aux.get(x).getPasta(n).listarNotas();
				System.out.print("Informe a nota que deseja remover: ");
				int s=in.nextInt();
				
				
				if(aux.get(x).getPasta(n).deletarNota(aux.get(x).getPasta(n).getNota(s).getTituloNota())) {
					System.out.print("Nota removida com sucesso");
					
				}
				else {
					System.out.print("Nota invalida");
				}
			}
		}
	}
	
	
}


