package ControleAlunos;

import java.util.ArrayList;

/**
 * representa a lista com os alunos que responde o quadro
 * @author vanderson
 *
 */
public class Quadro {
	/**
	 * lista com os alunos que responde o quadro
	 */
	private ArrayList<Aluno> alunos;
	
	/**
	 * construtor do quadro
	 */
	public Quadro() {
		this.alunos = new ArrayList<Aluno>();
	}
	
	/**
	 * metodo que adiciona o aluno no arrayList  
	 * @param matricula
	 * @param controle
	 */
	public void addAlunoQuadro(String matricula, ControleAlunos controle) {
		Aluno aluno = (Aluno) controle.pegaAluno(matricula);
		alunos.add(aluno);
	}
	
//_____________________imprime alunos que respondeu o quadro_____________________
	/**
	 * representa os nomes em string dos alunos que responderam o quadro em ordem
	 * @return os dados dos alunos, na ordem que responderam no quadro
	 */
	public String imprimeAlunos() {
		String saida = "Alunos:\n";
		int index = 0;
		for (int i=0; i<alunos.size(); i++) {
			Aluno aluno = (Aluno) alunos.get(i);
			index = i+1;
			saida += Integer.toString(index)+aluno.toStringQuadro()+"\n";
		}return saida;
	}
	
}
