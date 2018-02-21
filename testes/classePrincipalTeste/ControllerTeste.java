package classePrincipalTeste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import classePrincipal.Controller;

public class ControllerTeste {
	private Controller controllerTeste = new Controller();

	@Before
	public void setUp() {
		controllerTeste.inicializar();
	}

	@Test
	public void recuperaAlunoTeste() {
		controllerTeste.cadastrarAluno("Francis", "111222333", 55, "999-999", "francis@andrade.com");
		assertEquals("111222333 - Francis - 55 - 999-999 - francis@andrade.com",
				controllerTeste.recuperaAluno("111222333"));
	}

	@Test
	public void listarAlunosVazioTeste() {
		assertEquals("Nao ha alunos cadastrados", controllerTeste.listarAlunos());
	}

	@Test
	public void listarAlunosTeste() {
		controllerTeste.cadastrarAluno("Francis", "111222333", 55, "999-999", "francis@andrade.com");
		controllerTeste.cadastrarAluno("Andrade", "333222111", 40, "999-999", "andrade@francis.com");
		assertEquals("333222111 - Andrade - 40 - 999-999 - andrade@francis.com" + System.lineSeparator()
				+ "111222333 - Francis - 55 - 999-999 - francis@andrade.com" + System.lineSeparator(), controllerTeste.listarAlunos());
	}

}