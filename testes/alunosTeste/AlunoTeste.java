/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - UFCG
 * LABORATORIO DE PROGRAMACAO 2
 * ALUNOS - CAIO TORRES - FRANCIVALDO CABRAL - LUAN CARLOS
 * MATRICULAS -  -  - 116.110.100
 * PROJETO FINAL - QUEM ME AJUDA
 */
package alunosTeste;

import static org.junit.Assert.*;
import org.junit.Test;

import alunos.Aluno;
import cadastroExceptions.NullOuEmBrancoException;

/**
 * Classe de Testes, referentes a Aluno
 * 
 * @author
 * @version 1.1
 */
public class AlunoTeste {
	private Aluno alunoTeste;

	/**
	 * Testa a criacao de um Aluno com o nome nulo.
	 * 
	 * @throws Exception
	 * @version 1.0
	 * @author 
	 */
	@Test(expected = NullOuEmBrancoException.class)
	public void nomeNuloTeste() throws Exception {
		alunoTeste = new Aluno(null, "112233", 50, "000-000", "francis@andrade.com");
	}

	/**
	 * Testa a criacao de um Aluno com o nome vazio.
	 * 
	 * @throws Exception
	 * @version 1.0
	 * @author 
	 */
	@Test(expected = NullOuEmBrancoException.class)
	public void nomeVazioTeste() throws Exception {
		alunoTeste = new Aluno(" ", "112233", 50, "000-000", "francis@andrade.com");
	}

	/**
	 * Testa a criacao de um Aluno com o matricua nulo.
	 * 
	 * @throws Exception
	 * @version 1.1
	 * @author Luan Carlos
	 */
	@Test(expected = NullOuEmBrancoException.class)
	public void matriculaNuloTeste() throws Exception {
		alunoTeste = new Aluno("Ricardo", null, 50, "000-000", "francis@andrade.com");
	}

	/**
	 * Testa a criacao de um Aluno com o matricula vazio.
	 * 
	 * @throws Exception
	 * @version 1.1
	 * @author Luan Carlos
	 */
	@Test(expected = NullOuEmBrancoException.class)
	public void matriculaVazioTeste() throws Exception {
		alunoTeste = new Aluno("Ricardo", " ", 50, "000-000", "francis@andrade.com");
	}
	/**
	 * Testa a criacao de um Aluno com o email nulo.
	 * 
	 * @throws Exception
	 * @version 1.1
	 * @author Luan Carlos
	 */
	@Test(expected = NullOuEmBrancoException.class)
	public void emailNuloTeste() throws Exception {
		alunoTeste = new Aluno("Breno", "112233", 50, "000-000", null);
	}

	/**
	 * Testa a criacao de um Aluno com o email vazio.
	 * 
	 * @throws Exception
	 * @version 1.1
	 * @author Luan Carlos
	 */
	@Test(expected = NullOuEmBrancoException.class)
	public void emailVazioTeste() throws Exception {
		alunoTeste = new Aluno("Breno", "112233", 50, "000-000", " ");
	}
	/**
	 * Testa a Criacao do aluno com um telefone.
	 * 
	 * @throws Exception
	 * @version 1.0
	 * @author 
	 */
	@Test
	public void toStringComTelefoneTest() throws Exception {
		alunoTeste = new Aluno("Francis", "111222333", 45, "9999-9999", "francis@andrade.com");
		assertEquals("111222333 - Francis - 45 - 9999-9999 - francis@andrade.com", alunoTeste.toString());
	}

}
