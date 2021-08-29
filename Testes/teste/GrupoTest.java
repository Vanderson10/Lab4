package teste;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import ControleAlunos.Aluno;
import ControleAlunos.Grupo;


/**
 * 
 * @author vanderson
 *
 */
class GrupoTest {
	
	@Test
	void testHashCode() {
		Grupo grupo = new Grupo("Teste", 5);
		assertEquals(grupo.hashCode(), "Teste".hashCode());
	}

	@Test
	void testAddAlunoGrupo() {
		Grupo grupo = new Grupo("Teste", 5);
		Aluno aluno = new Aluno("2", "Van", "CC");
		grupo.addAlunoGrupo(aluno);
		boolean teste = false;
		if (grupo.pertenceAlunoGrupo(aluno)) {
			teste = true;
		}
		assertTrue(teste);
	}

	@Test
	void testPertenceAlunoGrupo() {
		Grupo grupo = new Grupo("Teste", 5);
		Aluno aluno = new Aluno("2", "Van", "CC");
		grupo.addAlunoGrupo(aluno);
		assertTrue(grupo.pertenceAlunoGrupo(aluno));
	}

	@Test
	void testGetTamanho() {
		Grupo grupo = new Grupo("Teste", 5);
		assertEquals(grupo.getTamanho(),5);
	}

	@Test
	void testQuantAlunosZero() {
		Grupo grupo = new Grupo("Teste", 5);
		assertEquals(grupo.quantAlunos(),0);
	}
	
	@Test
	void testQuantAlunos() {
		Grupo grupo = new Grupo("Teste", 5);
		Aluno aluno = new Aluno("2", "Van", "CC");
		grupo.addAlunoGrupo(aluno);
		assertEquals(grupo.quantAlunos(),1);
	}

	@Test
	void testGetNome() {
		Grupo grupo = new Grupo("Teste", 5);
		assertEquals(grupo.getNome(),"Teste");
	}

}
