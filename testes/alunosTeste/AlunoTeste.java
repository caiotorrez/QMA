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
 * @version 1.0
 */
public class AlunoTeste {
	private Aluno alunoTeste;

	/**
	 * Testa a criação de um Aluno com o nome nulo.
	 * 
	 * @throws Exception
	 */
	@Test(expected = NullOuEmBrancoException.class)
	public void nomeNuloTeste() throws Exception {
		alunoTeste = new Aluno(null, "112233", 50, "000-000", "francis@andrade.com");
	}

	/**
	 * Testa a criação de um Aluno com o nome vazio.
	 * 
	 * @throws Exception
	 */
	@Test(expected = NullOuEmBrancoException.class)
	public void nomeVazioTeste() throws Exception {
		alunoTeste = new Aluno(" ", "112233", 50, "000-000", "francis@andrade.com");
	}

	/**
	 * Testa a Criacao do aluno com um telefone.
	 * 
	 * @throws Exception
	 */
	@Test
	public void toStringComTelefoneTest() throws Exception {
		alunoTeste = new Aluno("Francis", "111222333", 45, "9999-9999", "francis@andrade.com");
		assertEquals("111222333 - Francis - 45 - 9999-9999 - francis@andrade.com", alunoTeste.toString());
	}

}
