/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - UFCG
 * LABORATORIO DE PROGRAMACAO 2
 * ALUNOS - CAIO TORRES - FRANCIVALDO CABRAL - LUAN CARLOS
 * MATRICULAS -  -  - 116.110.100
 * PROJETO FINAL - QUEM ME AJUDA
 */
package controllerTeste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import controller.Controller;

/**
 * Classe de testes referente ao Controller do Sistema
 * @author 
 * @version 1.0
 */
public class ControllerTeste {
	private Controller controllerTeste = new Controller();


	/**
	 * Testa a recuperacao textual do Aluno
	 * @throws Exception
	 */
	@Test
	public void recuperaAlunoTeste() throws Exception {
		controllerTeste.cadastrarAluno("Francis", "111222333", 55, "999-999", "francis@andrade.com");
		assertEquals("111222333 - Francis - 55 - 999-999 - francis@andrade.com",
				controllerTeste.recuperaAluno("111222333"));
	}

	/**
	 * Testa quando nao ha alunos cadastrados ainda
	 */
	@Test
	public void listarAlunosVazioTeste() {
		assertEquals("Nao ha alunos cadastrados", controllerTeste.listarAlunos());
	}

	/**
	 * Testa a listagem de todos os alunos cadastrados
	 * @throws Exception
	 */
	@Test
	public void listarAlunosTeste() throws Exception {
		controllerTeste.cadastrarAluno("Francis", "111222333", 55, "999-999", "francis@andrade.com");
		controllerTeste.cadastrarAluno("Andrade", "333222111", 40, "999-999", "andrade@francis.com");
		assertEquals(
				"333222111 - Andrade - 40 - 999-999 - andrade@francis.com" + System.lineSeparator()
						+ "111222333 - Francis - 55 - 999-999 - francis@andrade.com" + System.lineSeparator(),
				controllerTeste.listarAlunos());
	}

}