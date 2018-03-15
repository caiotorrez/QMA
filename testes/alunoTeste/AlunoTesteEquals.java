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

/**
 * Classe de Testes, referentes a Aluno
 * @author Francis Cabral
 * @version 1.0
 * @author Luan Carlos
 * @version 1.1
 */
public class AlunoTesteEquals {
	
	private Aluno alunoTeste;
	private Aluno alunoTeste2;

	/**
	 * Teste do equals com Alunos de matriculas iguais.
	 */
	@Test
	public void equalsMatriculasIguaisTeste() {
		this.alunoTeste = new Aluno("Francis", "111222333", 45, "9999-9999", "francis@andrade.com");
		this.alunoTeste2 = new Aluno("Andrade", "111222333", 45, "8888-8888", "andrade@andrade.com");
		assertEquals(true, alunoTeste.equals(alunoTeste2));
	}

	/**
	 * Teste do equals com Alunos com matriculas diferentes.
	 */
	@Test
	public void equalsMatriculasDiferentesTeste() {
		this.alunoTeste = new Aluno("Francis", "111222333", 45, "9999-9999", "francis@andrade.com");
		this.alunoTeste2 = new Aluno("Francis", "444555666", 45, "9999-9999", "francis@andrade.com");
		assertEquals(false, alunoTeste.equals(alunoTeste2));
	}
	
	@Test
	public void ComparandoAlunos() {
		this.alunoTeste = new Aluno("Francis", "111222333", 45, "9999-9999", "francis@andrade.com");
		this.alunoTeste2 = new Aluno("Chico", "444555666", 45, "9999-9999", "francis@andrade.com");
		System.out.println(this.alunoTeste.compareTo(this.alunoTeste2));
	}
}
