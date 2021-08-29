package ControleAlunos;

/**
 * Classe que representa o aluno
 * @author vanderson
 *
 */

public class Aluno {
	/**
	 * representa a matrícula do aluno
	 */
	private String matricula;
	/**
	 * representa o nome do aluno
	 */
	private String nome;
	/**
	 * representa o curso que um aluno participa
	 */
	private String curso;
	
	/**
	 * Construtor do aluno
	 * @param matricula
	 * @param nome
	 * @param curso
	 */
	public Aluno(String matricula, String nome, String curso) {
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}
	
	/**
	 * Método para outras classes acessarem a matricula do aluno
	 * @return matricula
	 */
	public String getMatricula() {
		return this.matricula;
	}
	
	/**
	 * método hashCode do aluno
	 */
	public int hashCode() {
		return this.matricula.hashCode();
	}
	
	/**
	 * Método que retorna a parte de texto de um objeto com sua matricula, nome e curso
	 */
	public String toString() {
		return "Matrícula: "+this.matricula+"\n"+"Nome: "+this.nome+"\n"+"Curso: "+this.curso;
	}
	
	/**
	 * toString para a consulta	
	 * @return o usuário que será consultado pela matricula, com suas informações em uma linha
	 */
	public String toStringConsulta() {
		return "Aluno:"+" "+this.matricula+" - "+this.nome+" - "+this.curso+"\n";
	}
	
	/**
	 * toStrig para o quadro
	 * @return uma string com matricula, nome, curso.
	 */
	public String toStringQuadro() {
		return ". "+this.matricula+" - "+this.nome+" - "+this.curso;
	}
	
}
