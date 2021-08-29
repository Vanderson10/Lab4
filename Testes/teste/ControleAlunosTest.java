package teste;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ControleAlunos.Aluno;
import ControleAlunos.ControleAlunos;

/**
 * @author vanderson
 *
 */
class ControleAlunosTest {

	private ControleAlunos controle;
	
	@BeforeEach
	void iniciaAluno() {
		this.controle = new ControleAlunos();
	}
	
	@Test
	void testCadastraAluno() {
		controle.cadastraAluno("250", "Gabriel Reyes", "Computação");
		HashMap<String, Aluno> mapa = controle.getMapaMatriculaAlunos();
		Aluno aluno = (Aluno) mapa.get("250");
		assertEquals(aluno.getMatricula(), "250");	
	}

	@Test
	void testPegaAluno() {
		controle.cadastraAluno("250", "Gabriel Reyes", "Computação");
		HashMap<String, Aluno> mapa = controle.getMapaMatriculaAlunos();
		Aluno aluno = (Aluno) controle.pegaAluno("250");
		assertEquals(aluno,mapa.get("250"));
	}

	@Test
	void testAlunoNãoExistente() {
		assertFalse(controle.alunoExistente("1"));
	}
	
	@Test
	void testAlunoExistente() {
		controle.cadastraAluno("1", "Gabriel Reyes", "Computação");
		assertTrue(controle.alunoExistente("1"));
	}

	@Test
	void testVerificaExistenciaAlunoFalse() {
		assertFalse(controle.verificaExistenciaAluno("1"));
	}
	
	@Test
	void testVerificaExistenciaAlunoTrue() {
		controle.cadastraAluno("1", "Gabriel Reyes", "Computação");
		assertTrue(controle.alunoExistente("1"));
	}

}
