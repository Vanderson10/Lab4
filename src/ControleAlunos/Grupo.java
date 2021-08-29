package ControleAlunos;

import java.util.HashSet;
/**
 * classe que representa o grupo
 * @author vanderson
 *
 */
public class Grupo {
	
	/**
	 * representa o nome de um grupo
	 */
	private String nome;
	
	/**
	 *representa a quantidade de pessoas que um grupo pode ter
	 */
	private Integer tamanho;
	
	/**
	 * representa um conjunto que contem alunos
	 */
	private HashSet<Aluno> grupo;

	
	/**
	 * Construtor do grupo
	 * @param nome
	 * @param tema
	 */
	public Grupo(String nome, Integer tamanho) {
		this.nome = nome;
		this.tamanho = tamanho;
		this.grupo = new HashSet<>();
	}
	
	/**
	 * método hashCode do grupo
	 */
	public int hashCode() {
		return this.nome.hashCode();
	}
	
	/**
	 * pega o aluno do controle e adiciona no grupo
	 * @param aluno
	 */
	public void addAlunoGrupo(Aluno aluno) { 
		this.grupo.add(aluno);
	}
	
	/**
	 * método que recebe uma matricula e informa se o aluno está dentro do grupo
	 * @param matricula
	 * @return true para pertinencia e false o contrário.
	 */
	public boolean pertenceAlunoGrupo(Aluno aluno) {
		return this.grupo.contains(aluno);
	}
	
	/**
	 * método para acessar o tamanho
	 * @return tamanho
	 */
	public Integer getTamanho() {
		return this.tamanho;
	}
	
	/**
	 * metodo que representa a quantidade de alunos de um grupo
	 * @return a quantidade de alunos do conjunto grupo
	 */
	public int quantAlunos() {
		return this.grupo.size();
	}
	
	/**
	 * metodo que representa o nome do grupo
	 * @return o nome do grupo
	 */
	public String getNome() {
		return this.nome;
	}
}
