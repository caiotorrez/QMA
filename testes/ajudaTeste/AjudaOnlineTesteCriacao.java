/**
 * UFCG - Universidade Federal de Campina Grande
 * LP2 - Laboratorio de Programacao 2 - Projeto Final
 * Caio Vitor Brasileiro Torres - 116111245
 * Francivaldo Cabral de Andrade - 116111544
 * Luan Carlos da Silva Bezerra - 116110100
 */
package ajudaTeste;

import org.junit.Test;

import modelos.ajuda.Ajuda;
import modelos.ajuda.AjudaException;
import modelos.ajuda.AjudaOnline;

/**
 * Classe referente aos testes de {@link AjudaOnline}
 * @author Caio Torres
 * @version 1.0
 */
public class AjudaOnlineTesteCriacao {

	private Ajuda ajuda = new AjudaOnline("111", "Historia");
	
	/**
	 * Criacao com matricula em branco
	 */
	@Test(expected = AjudaException.class)
	public void testMatriculaEmBranco() {
		this.ajuda = new AjudaOnline("", "Geografia");
	}
	
	/**
	 * Criacao com matricula em branco com espacos
	 */
	@Test(expected = AjudaException.class)
	public void testMatriculaEmBranco2() {
		this.ajuda = new AjudaOnline("   ", "Geografia");
	}
	
	/**
	 * Criacao com matricula null
	 */
	@Test(expected = AjudaException.class)
	public void testMatriculaNull() {
		this.ajuda = new AjudaOnline(null, "Geografia");
	}
	
	/**
	 * Criacao com disciplina null
	 */
	@Test(expected = AjudaException.class)
	public void testDisciplinaNull() {
		this.ajuda = new AjudaOnline("110", null);
	}
	
	/**
	 * Criacao com disciplina em branco com espacos
	 */
	@Test(expected = AjudaException.class)
	public void testDisciplinaEmBranco() {
		this.ajuda = new AjudaOnline("110", "    ");
	}
	
	/**
	 * Criacao com disciplina em branco
	 */
	@Test(expected = AjudaException.class)
	public void testDisciplinaEmBranco2() {
		this.ajuda = new AjudaOnline("110", "");
	}
	
	/**
	 * Setando um tutor null para a ajuda solicitada
	 */
	@Test(expected = AjudaException.class)
	public void setMatriculaTutorNull() {
		this.ajuda.setMatriculaTutor(null);
	}
	
	/**
	 * Setando um tutor em branco com espacos para a ajuda solicitada
	 */
	@Test(expected = AjudaException.class)
	public void setMatriculaTutorEmBranco() {
		this.ajuda.setMatriculaTutor("   ");
	}
	
	/**
	 * Setando um tutor em branco para a ajuda solicitada
	 */
	@Test(expected = AjudaException.class)
	public void setMatriculaTutorEmBranco2() {
		this.ajuda.setMatriculaTutor("");
	}
}
