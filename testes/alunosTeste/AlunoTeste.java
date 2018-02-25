/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - UFCG
 * LABORATORIO DE PROGRAMACAO 2
 * ALUNOS - CAIO TORRES - FRANCIVALDO CABRAL - LUAN CARLOS
 * MATRICULAS -  -  - 116.110.100
 * PROJETO FINAL - QUEM ME AJUDA
 */
package alunosTeste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import alunos.Aluno;

/**
 * Classe de Testes, referentes a Aluno
 * @author 
 * @version 1.0
 */
public class AlunoTeste {
	
	private Aluno alunoTeste2;
	private Aluno alunoTeste;
	
	/**
	 * Inicia os alunos para os testes
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.alunoTeste = new Aluno("Francis", "111222333", 45, "9999-9999", "francis@andrade.com");
		this.alunoTeste2 = new Aluno("Francis", "111222333", 45, "", "francis@andrade.com");
	}
	
	/**
	 * Testa a Criacao do aluno com um telefone
	 */
	@Test
	public void toStringComTelefoneTest() {
		assertEquals("111222333 - Francis - 45 - 9999-9999 - francis@andrade.com", alunoTeste.toString());
	}

	/**
	 * Testa a Criacao do aluno com um telefone
	 */
	@Test
	public void toStringSemTelefoneTest() {
		assertEquals("111222333 - Francis - 45 - francis@andrade.com", alunoTeste2.toString());
	}

}
