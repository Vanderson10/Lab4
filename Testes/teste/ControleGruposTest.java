package teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ControleAlunos.Aluno;
import ControleAlunos.ControleAlunos;
import ControleAlunos.ControleGrupos;
import ControleAlunos.Grupo;

/**
 * 
 * @author vanderson
 *
 */
class ControleGruposTest {
	
	private ControleGrupos controle;
	
	@BeforeEach
	void iniciaGrupo() {
		this.controle = new ControleGrupos();
	}

	@Test
	void testAdicionarGrupo() {
		controle.adicionarGrupo("teste", null);
		HashMap<String, Grupo> mapa = controle.getMapaNomeGrupos();
		Grupo grupo = (Grupo) mapa.get("TESTE");
		assertEquals(grupo.getNome(), "teste");
	}

	@Test
	void testGrupoExisteFalse() {
		assertFalse(controle.grupoExiste("iai"));
	}
	
	@Test
	void testGrupoExisteTrue() {
		controle.adicionarGrupo("iai", 4);
		assertTrue(controle.grupoExiste("IAI"));
	}

	@Test
	void testAlocarAluno() {
		controle.adicionarGrupo("iae", null);
		ControleAlunos controleAluno = new ControleAlunos();
		controleAluno.cadastraAluno("250", "van", "CC");
		controle.alocarAluno("250", "IAE", controleAluno);
		assertTrue(controle.verificaExistenciaAlunoGrupo("250", "IAE", controleAluno));
	}

	@Test
	void testCabeAlunoGrupo() {
		controle.adicionarGrupo("iae", null);
		assertTrue(controle.cabeAlunoGrupo("IAE"));
	}

	@Test
	void testVerificaExistenciaAlunoGrupo() {
		controle.adicionarGrupo("iae", null);
		ControleAlunos controleAluno = new ControleAlunos();
		Aluno aluno = new Aluno("250", "van", "CC");
		controle.alocarAluno("250", "IAE", controleAluno);
		assertTrue(controle.verificaExistenciaAlunoGrupo("250", "IAE", controleAluno));
	}
	
	@Test
	void testVerificaExistenciaAlunoGrupoFa() {
		controle.adicionarGrupo("iae", null);
		ControleAlunos controleAluno = new ControleAlunos();
		assertFalse(controle.verificaExistenciaAlunoGrupo("250", "IAE", controleAluno));
	}

	@Test
	void testImprimeGruposAluno() {
		ControleAlunos controleAluno = new ControleAlunos();
		assertEquals(controle.imprimeGruposAluno("250", controleAluno),"Grupos: \n");
	}

}
