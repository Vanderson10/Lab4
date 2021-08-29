package ControleAlunos;

import java.util.Scanner;
/**
 * Classe menu para ser executada
 * @author vanderson
 *
 */
public class Main {
	/**
	 * Método main o primeiro a ser executado
	 * @param args
	 */
	public static void main(String[] args) {
		ControleAlunos controle = new ControleAlunos();
		ControleGrupos grupoControle = new ControleGrupos();
		Quadro quadro = new Quadro();
		
		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, controle, grupoControle, quadro, scanner);
		}

	}
	
	/**
	 * Parte de strings do menu
	 * @param scanner
	 * @return os itens que o menu pode realizar 
	 */
	private static String menu(Scanner scanner) {
		System.out.println(
				"(C)adastrar Aluno\n" +
				"(E)xibir Aluno\n" +
				"(N)ovo Grupo\n" +
				"(A)locar Aluno ou (P)ertinência a Grupo? \n" +
				"(R)egistrar Aluno que Respondeu\n" +
				"(I)mprimir Alunos que Responderam\n" +
				"(O)lhaí quais Grupos o Aluno Tá.\n" +
				"(S)im, quero Fechar o Programa!\n" +
				"\n" + 
				"Opção> ");
		return scanner.next().toUpperCase();
	}
	
	/**
	 * Recebe as opções desejadas pelo usuário 
	 * @param opcao
	 * @param controle
	 * @param scanner
	 */
	private static void comando(String opcao,ControleAlunos controle, ControleGrupos grupoControle, Quadro quadro, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraAluno(controle, scanner);
			break;
		case "E":
			exibirAluno(controle, scanner);
			break;
		case "N":
			novoGrupo(grupoControle, scanner);
			break;
		case "A":
			alocarAlunoGrupo(controle, grupoControle, scanner);
			break;
		case "P":
			verificarPertinenciaAlunoGrupo(controle, grupoControle, scanner);
			break;
		case "R":
			addAlunoRespondeuQuadro(controle, quadro, scanner);
			break;
		case "I":
			imprimeAlunoRespondeuQuadro(quadro, scanner);
			break;
		case "O":
			olhaAlunoGrupo(controle, grupoControle, scanner);
			break;
		case "S":
			sair();
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}

//___________________verifica entrada vazia___________________
	/**
	 * verifica se a entrada é vazia e lança um erro caso for
	 * @param entrada
	 */
	private static void verificaVazio(String entrada) {
		if (entrada.isBlank()) {
			throw new IllegalArgumentException("ENTRADA NÃO PODE SER VAZIA");
		}
	}
	
//___________________________Cadastrar Aluno_____________________________
	
	/**
	 * Recebe as informações dos alunos e manda para o controle cadastrar.
	 * @param controle
	 * @param scanner
	 */
	
	private static void cadastraAluno(ControleAlunos controle, Scanner scanner) {
		scanner.nextLine();
		System.out.println("Matrícula: ");
		String matricula = scanner.nextLine();
		verificaVazio(matricula);
		if (controle.alunoExistente(matricula)==true) {
			return ;
		}
		System.out.println("Nome: ");
		String nome = scanner.nextLine();
		verificaVazio(nome);
		System.out.println("Curso: ");
		String curso = scanner.nextLine();
		verificaVazio(curso);
		controle.cadastraAluno(matricula, nome, curso);
		System.out.println("CADASTRO REALIZADO!\n");
	}
	
//___________________________Exibir Aluno_____________________________
	/**
	 * recebe a matricula do aluno para ser consultado na lista suas informações
	 * @param controle
	 * @param scanner
	 */
	private static void exibirAluno(ControleAlunos controle, Scanner scanner) {
		scanner.nextLine();
		System.out.println("Matrícula: ");
		String matricula = scanner.nextLine();
		verificaVazio(matricula);
		if (controle.verificaExistenciaAluno(matricula)==false) {
			System.out.println("Aluno não cadastrado.\n");
			return ;
		}else {
			System.out.println(controle.consultaAluno(matricula));
		}
	}
	
//_________________________criar grupo____________________________
	/**
	 * recebendo as informações para criar um grupo
	 * @param grupoControle
	 * @param scanner
	 */
	private static void novoGrupo(ControleGrupos grupoControle, Scanner scanner) {
		scanner.nextLine();
		System.out.println("Grupo: ");
		String nomeGrupo = scanner.nextLine();
		verificaVazio(nomeGrupo);
		if (grupoControle.grupoExiste(nomeGrupo.toUpperCase())==true) {
			System.out.println("GRUPO JÁ CADASTRADO!\n");
			return ;
		}
		System.out.println("Tamanho: ");
		String tamanhoString = scanner.nextLine();
		Integer tamanho;
		if (tamanhoString.isBlank()) {
			tamanho = null;
		}else {
			tamanho = Integer.parseInt(tamanhoString);
		}  
		if (tamanho!=null) {
			if (tamanho<1) {
				throw new IllegalArgumentException("TAMANHO INVÁLIDO");
			}
		}
		grupoControle.adicionarGrupo(nomeGrupo, tamanho);
	}
	
//_________________________colocar aluno no grupo_________________________
	/**
	 * recebe a matricula do aluno e o grupo no qual ele vai participar
	 * @param grupoControle
	 * @param scanner
	 */
	private static void alocarAlunoGrupo(ControleAlunos controle, ControleGrupos grupoControle, Scanner scanner) {
		scanner.nextLine();
		System.out.println("Matricula: ");
		String matricula = scanner.nextLine();
		verificaVazio(matricula);
		if (controle.verificaExistenciaAluno(matricula)==false) {
			System.out.println("Aluno não cadastrado.\n");
			return ;
		}
		System.out.println("Grupo: ");
		String nomeGrupo = scanner.nextLine();
		verificaVazio(nomeGrupo);
		if (grupoControle.grupoExiste(nomeGrupo.toUpperCase())==false) {
			System.out.println("Grupo não cadastrado.\n");
			return ;
		}
		if (grupoControle.cabeAlunoGrupo(nomeGrupo.toUpperCase())==false) {
			System.out.println("GRUPO CHEIO\n");
			return ;
		}
		grupoControle.alocarAluno(matricula, nomeGrupo.toUpperCase(), controle);
		System.out.println("ALUNO ALOCADO!\n");
	}
	
//____________________________pertinencia a grupo_______________________________
	/**
	 * reebe os dados do aluno e verifica se ele está no grupo consultado
	 * @param controle
	 * @param grupoControle
	 * @param scanner
	 */
	private static void verificarPertinenciaAlunoGrupo(ControleAlunos controle, ControleGrupos grupoControle, Scanner scanner) {
		scanner.nextLine();
		System.out.println("Grupo: ");
		String nomeGrupo = scanner.nextLine();
		verificaVazio(nomeGrupo);
		if (grupoControle.grupoExiste(nomeGrupo.toUpperCase())==false) {
			System.out.println("Grupo não cadastrado.\n");
			return ;
		}
		System.out.println("Aluno: ");
		String matricula = scanner.nextLine();
		verificaVazio(matricula);
		if (controle.verificaExistenciaAluno(matricula)==false) {
			System.out.println("Aluno não cadastrado.\n");
			return ;
		}
		if (grupoControle.verificaExistenciaAlunoGrupo(matricula, nomeGrupo.toUpperCase(), controle)==true) {
			System.out.println("ALUNO PERTENCE AO GRUPO\n");
		}else {
			System.out.println("ALUNO NÃO PERTENCE AO GRUPO\n");
		}
	}
	
//________________________cadastra aluno no quadro________________________________
	/**
	 * recebe o aluno que respondeu o quadro para ser adicionado na lista
	 * @param controle
	 * @param quadro
	 * @param scanner
	 */
	private static void addAlunoRespondeuQuadro(ControleAlunos controle, Quadro quadro, Scanner scanner) {
		scanner.nextLine();
		System.out.println("Matricula: ");
		String matricula = scanner.nextLine();
		verificaVazio(matricula);
		quadro.addAlunoQuadro(matricula, controle);
		if (controle.verificaExistenciaAluno(matricula)==false) {
			System.out.println("Aluno não cadastrado.\n");
			return ;
		}
		System.out.println("ALUNO REGISTRADO!\n");
	}
	
//_________________________imprime alunos que responderam o quadro_________________________	
	/**
	 * método que imprime os alunos que responderam o quadro
	 * @param quadro
	 * @param scanner
	 */
	private static void imprimeAlunoRespondeuQuadro(Quadro quadro, Scanner scanner) {
		scanner.nextLine();
		System.out.println(quadro.imprimeAlunos());
	}

//_____________________imprime os grupos que o aluno participa____________________________
	/**
	 * recebe a matricula do aluno para verificar em quais grupos ele participa
	 * @param controle
	 * @param grupoControle
	 * @param scanner
	 */
	private static void olhaAlunoGrupo(ControleAlunos controle, ControleGrupos grupoControle, Scanner scanner) {
		scanner.nextLine();
		System.out.println("Aluno: ");
		String matricula = scanner.nextLine();
		verificaVazio(matricula);
		System.out.println(grupoControle.imprimeGruposAluno(matricula, controle));
	}

	
//______________________________Sair____________________________
	/**
	 * sai do programa
	 */
	private static void sair() {
		System.out.println("tchau");
		System.exit(0);
	}
}

