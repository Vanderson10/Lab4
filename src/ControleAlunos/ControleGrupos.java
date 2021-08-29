package ControleAlunos;

import java.util.HashMap;
/**
 * A classe que controla as operações do grupo
 * @author vanderson
 *
 */
public class ControleGrupos {
	
	private HashMap<String, Grupo> mapaNomeGrupos;

//_____________construtor_________________
	/**
	 * construtor do controle de grupo
	 */
	public ControleGrupos() {
		this.mapaNomeGrupos = new HashMap<>();
	}
	
//___________metodo que add os grupos______________________
	/**
	 * metodo que criar e adiciona os grupos no hashmap
	 * @param nome
	 * @param tamanho
	 */
	public void adicionarGrupo(String nome, Integer tamanho) {
		Grupo grupo = new Grupo(nome, tamanho);
	    this.mapaNomeGrupos.put(nome.toUpperCase(), grupo);
		System.out.println("CADASTRO REALIZADO!\n");
	}	
	
//____________verifica existencia do grupo_____________
	/**
	 * verifica se ja existe o grupo 
	 * @param nome
	 */
	public boolean grupoExiste(String nome){
		if(this.mapaNomeGrupos.containsKey(nome)==true) {
			return true;
		}return false;
	}
	
//________________colocar aluno no grupo__________________________
	/**
	 * aloca aluno no conjunto do grupo
	 * @param matricula
	 * @param nomeGrupo
	 */
	public void alocarAluno(String matricula, String nomeGrupo, ControleAlunos Controle) {
		Grupo grupo = this.mapaNomeGrupos.get(nomeGrupo);
		Aluno aluno = Controle.pegaAluno(matricula); 
		grupo.addAlunoGrupo(aluno);
	}
	
//_______________verifica se cabe mais aluno no grupo__________________
	/**
	 * verifica se pode adicionar mais aluno
	 * @param nomeGrupo
	 * @return true caso tenha espaço e false o contrario
	 */
	public boolean cabeAlunoGrupo(String nomeGrupo) {
		Grupo grupo = this.mapaNomeGrupos.get(nomeGrupo);
		if (grupo.getTamanho()==null) {
			return true;
		}
		if (grupo.getTamanho() > grupo.quantAlunos()) {
			return true;
		}return false;
	}
	
//______________verifica se o aluno pertence a um grupo____________
	/**
	 * verifica se um determinado aluno está no grupo
	 * @param matricula
	 * @param nomegrupo
	 * @param controle
	 * @return true se o aluno esta no grupo e false o contrário
	 */
	public boolean verificaExistenciaAlunoGrupo(String matricula, String nomegrupo, ControleAlunos controle) {
		Grupo grupo = this.mapaNomeGrupos.get(nomegrupo);
		Aluno aluno = controle.pegaAluno(matricula);
		if (grupo.pertenceAlunoGrupo(aluno)==true) {
			return true;
		}return false;
	}
	
//_____________________imprime grupos que um aluno participa_____________________________
	/**
	 * verifica quais grupos um aluno participa
	 * @param matricula
	 * @param controle
	 * @return uma lista em string com os nomes do grupo que um aluno participa
	 */
	public String imprimeGruposAluno(String matricula, ControleAlunos controle){
		Aluno aluno = (Aluno) controle.pegaAluno(matricula);
		String saida = "Grupos: \n"; 
		for (Grupo grupo: this.mapaNomeGrupos.values()){
			if (grupo.pertenceAlunoGrupo(aluno)==true) {
				saida += "- "+grupo.getNome()+"\n";
			}
		}return saida;
	}
	
//______________________metodo para acessar o grupo________________
	/**
	 * metodo acessor
	 * @return o mapa de grupos
	 */
	public HashMap<String, Grupo> getMapaNomeGrupos() {
		return this.mapaNomeGrupos;
	}
	
}
