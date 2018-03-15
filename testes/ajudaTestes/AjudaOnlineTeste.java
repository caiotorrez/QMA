/**
 * UFCG - Universidade Federal de Campina Grande
 * LP2 - Laboratorio de Programacao 2 - Projeto Final
 * Caio Vitor Brasileiro Torres - 116111245
 * Francivaldo Cabral de Andrade - 116111544
 * Luan Carlos da Silva Bezerra - 116110100
 */
package ajudaTestes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelos.ajuda.Ajuda;
import modelos.ajuda.AjudaOnline;

/**
 * Classe referente aos testes de {@link AjudaOnline}
 * @author Caio Torres
 * @version 1.0
 */
public class AjudaOnlineTeste {

	private Ajuda ajuda = new AjudaOnline("111", "Historia");
	
	/**
	 * Testa se a ajuda se encontra nao concluida
	 */
	@Test
	public void getConclusaoFalse() {
		assertEquals(false, this.ajuda.getConclusaoAjuda());
	}
	

	/**
	 * Testa se a ajuda se encontra concluida
	 */
	@Test
	public void getConclusaoTrue() {
		this.ajuda.setConcluirAjuda();
		assertEquals(true, this.ajuda.getConclusaoAjuda());
	}
	

	/**
	 * Testa se retorna null a matricula n cadastrada
	 */
	@Test
	public void getMatriculaTutorNaoCadastrado() {
		assertEquals(null, this.ajuda.getMatriculaTutor());
	}
	
	/**
	 * Testa se retorna a matricula do tutor cadastrada
	 */
	@Test
	public void getMatriculaTutorCadastrado() {
		this.ajuda.setMatriculaTutor("101010");
		assertEquals("101010", this.ajuda.getMatriculaTutor());
	}
	
	
}
