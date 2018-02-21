package alunosTeste;

import static org.junit.Assert.*;

import org.junit.Test;

import alunos.Aluno;

public class AlunoTeste {
	private Aluno alunoTeste = new Aluno("Francis", "111222333", 45, "9999-9999", "francis@andrade.com");
	private Aluno alunoTeste2 = new Aluno("Francis", "111222333", 45, "francis@andrade.com");

	@Test
	public void toStringComTelefoneTest() {
		assertEquals("111222333 - Francis - 45 - 9999-9999 - francis@andrade.com", alunoTeste.toString());
	}

	@Test
	public void toStringSemTelefoneTest() {
		assertEquals("111222333 - Francis - 45 - francis@andrade.com", alunoTeste2.toString());
	}

}
