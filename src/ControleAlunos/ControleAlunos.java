package ControleAlunos;

import java.util.HashMap;

/**
 * Classe que tem o controle dos alunos para cadastrar 
 * @author vanderson
 *
 */
public class ControleAlunos {
	
	/**
	 * HashMap que armazena os alunos
	 */
	private HashMap<String, Aluno> mapaMatriculaAlunos;
	
	/**
	 * Construtor para inicializar o controle de alunos
	 */
	public ControleAlunos() {
		this.mapaMatriculaAlunos = new HashMap<>();
	}

	
//_____________________cadastrar aluno_____________________________
	/**
	 * Método que recebe os valores do main e cadastra os alunos
	 * @param matricula
	 * @param nome
	 * @param curso
	 */
	public void cadastraAluno(String matricula, String nome, String curso) {
		Aluno aluno = new Aluno(matricula, nome, curso);
	    this.mapaMatriculaAlunos.put(matricula, aluno);
	}
	
//___________________pega aluno______________________
	/**
	 * metodo que pega um aluno pela sua matricula
	 * @param matricula
	 * @return um aluno
	 */
	public Aluno pegaAluno(String matricula) {
	    return this.mapaMatriculaAlunos.get(matricula);
	}
	
//____________________verifica se o aluno existe para o cadastro____________________________
	
	/**
	 * Verifica se tem aluno cadastrado com a matricula inserida e caso tenha, retorna o aluno que existe e cancela o cadastro
	 * @param matricula
	 */
	public boolean alunoExistente(String matricula){
		boolean jaCadastrado = false;
		if(this.mapaMatriculaAlunos.containsKey(matricula)==true) {
			System.out.println("\n"+pegaAluno(matricula).toString()+"\nMATRÍCULA JÁ CADASTRADA!\n");
			jaCadastrado = true;
		}return jaCadastrado;
	}

//___________________verifica existencia do aluno_______________________________
	/**
	 * Verifica se o aluno com determinada matricula existe
	 * @param matricula
	 * @return true se existir e false o contrário
	 */
	public boolean verificaExistenciaAluno(String matricula) {
		if (this.mapaMatriculaAlunos.containsKey(matricula)==true) {
			return true;
		}return false;
	}

//__________________consulta aluno ______________________________
	/**
	 * Método que realiza a consulta do usuário pela matricula
	 * @param matricula
	 * @return o aluno com a matricula exigida pelo usuário
	 */
	
	public String consultaAluno(String matricula) {
		return this.mapaMatriculaAlunos.get(matricula).toStringConsulta();
	}
	
//__________________acessar o mapa matricula_______________
	/**
	 * metodo acessor 
	 * @return o mapa de alunos
	 */
	public HashMap<String, Aluno> getMapaMatriculaAlunos() {
		return this.mapaMatriculaAlunos;
	}

}
