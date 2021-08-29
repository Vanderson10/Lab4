package teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ControleAlunos.Aluno;

/**
 * @author vanderson
 *
 */
class AlunoTest {
	
	@Test
	void testHashCode() {
		Aluno aluno = new Aluno("1", "vanderson", "CC");
		assertEquals(aluno.hashCode(),"1".hashCode());
	}

	@Test
	void testGetMatricula() {
		Aluno aluno = new Aluno("1", "vanderson", "CC");
		assertEquals(aluno.getMatricula(),"1");
	}

	@Test
	void testToString() {
		Aluno aluno = new Aluno("1", "vanderson", "CC");
		assertEquals(aluno.toString(),"Matrícula: 1\nNome: vanderson\nCurso: CC");
	}

	@Test
	void testToStringConsulta() {
		Aluno aluno = new Aluno("1", "vanderson", "CC");
		assertEquals(aluno.toStringConsulta(),"Aluno: 1 - vanderson - CC\n");
	}

	@Test
	void testToStringQuadro() {
		Aluno aluno = new Aluno("1", "vanderson", "CC");
		assertEquals(aluno.toStringQuadro(),". 1 - vanderson - CC");
	}

}
