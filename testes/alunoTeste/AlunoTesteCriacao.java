/**
 * UFCG - Universidade Federal de Campina Grande
 * LP2 - Laboratorio de Programacao 2 - Projeto Final
 * Caio Vitor Brasileiro Torres - 116111245
 * Francivaldo Cabral de Andrade - 116111544
 * Luan Carlos da Silva Bezerra - 116110100
 */
package alunoTeste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelos.aluno.Aluno;
import modelos.aluno.AlunoException;

/**
 * Classe de Testes, referentes a Aluno
 * @author Francis Cabral
 * @version 1.0
 * @author Luan Carlos
 * @version 1.1
 */
public class AlunoTesteCriacao {
	
	private Aluno alunoTeste;

	/**
	 * Testa a criacao de um Aluno com o nome nulo.
	 */
	@Test(expected = AlunoException.class)
	public void nomeNuloTeste() {
		this.alunoTeste = new Aluno(null, "112233", 50, "000-000", "francis@andrade.com");
	}

	/**
	 * Testa a criacao de um Aluno com o nome vazio.
	 */
	@Test(expected = AlunoException.class)
	public void nomeVazioTeste() {
		this.alunoTeste = new Aluno(" ", "112233", 50, "000-000", "francis@andrade.com");
	}
	
	/**
	 * Testa a criacao de um Aluno com o nome vazio.
	 */
	@Test(expected = AlunoException.class)
	public void nomeVazioTeste2() {
		this.alunoTeste = new Aluno("", "112233", 50, "000-000", "francis@andrade.com");
	}

	/**
	 * Testa a criacao de um Aluno com o matricua nulo.
	 */
	@Test(expected = AlunoException.class)
	public void matriculaNuloTeste() {
		this.alunoTeste = new Aluno("Ricardo", null, 50, "000-000", "francis@andrade.com");
	}

	/**
	 * Testa a criacao de um Aluno com o matricula vazio.
	 */
	@Test(expected = AlunoException.class)
	public void matriculaVazioTeste() {
		this.alunoTeste = new Aluno("Ricardo", "   ", 50, "000-000", "francis@andrade.com");
	}
	
	/**
	 * Testa a criacao de um Aluno com o matricula vazio.
	 */
	@Test(expected = AlunoException.class)
	public void matriculaVazioTeste2() {
		this.alunoTeste = new Aluno("Ricardo", "", 50, "000-000", "francis@andrade.com");
	}

	/**
	 * Testa a criacao de um Aluno com o email nulo.
	 */
	@Test(expected = AlunoException.class)
	public void emailNuloTeste() {
		this.alunoTeste = new Aluno("Breno", "112233", 50, "000-000", null);
	}

	/**
	 * Testa a criacao de um Aluno com o email vazio.
	 * 
	 */
	@Test(expected = AlunoException.class)
	public void emailVazioTeste() {
		this.alunoTeste = new Aluno("Breno", "112233", 50, "000-000", "    ");
	}
	
	/**
	 * Testa a criacao de um Aluno com o email vazio.
	 * 
	 */
	@Test(expected = AlunoException.class)
	public void emailVazioTeste2() {
		this.alunoTeste = new Aluno("Breno", "112233", 50, "000-000", "");
	}


	/**
	 * Testa a Criacao do aluno com um telefone.
	 */
	@Test
	public void toStringComTelefoneTest() {
		this.alunoTeste = new Aluno("Francis", "111222333", 45, "9999-9999", "francis@andrade.com");
		assertEquals("111222333 - Francis - 45 - 9999-9999 - francis@andrade.com", alunoTeste.toString());
	}
}
