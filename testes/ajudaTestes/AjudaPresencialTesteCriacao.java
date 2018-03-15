/**
 * UFCG - Universidade Federal de Campina Grande
 * LP2 - Laboratorio de Programacao 2 - Projeto Final
 * Caio Vitor Brasileiro Torres - 116111245
 * Francivaldo Cabral de Andrade - 116111544
 * Luan Carlos da Silva Bezerra - 116110100
 */
package ajudaTestes;

import org.junit.Test;

import modelos.ajuda.Ajuda;
import modelos.ajuda.AjudaException;
import modelos.ajuda.AjudaPresencial;

/**
 * Classe referente aos testes de {@link AjudaPresencial}
 * @author Caio Torres
 * @version 1.0
 */
public class AjudaPresencialTesteCriacao {

	@SuppressWarnings("unused")
	private Ajuda ajuda;
	
	/**
	 * Testa criacao valida
	 */
	@Test
	public void criacaoValida() {
		this.ajuda = new AjudaPresencial("111", "LP1", "10:30", "Seg", "LCC2");
	}
	
	/**
	 * Testa criacao com horario null
	 */
	@Test(expected = AjudaException.class)
	public void testeHorarioNull() {
		this.ajuda = new AjudaPresencial("111", "LP1", null, "seg", "LCC2");
	}
	
	/**
	 * Testa criacao com horario em branco com espacos
	 */
	@Test(expected = AjudaException.class)
	public void testeHorarioEmBranco() {
		this.ajuda = new AjudaPresencial("111", "LP1", "  ", "seg", "LCC2");
	}
	
	/**
	 * Testa criacao com horario em branco
	 */
	@Test(expected = AjudaException.class)
	public void testeHorarioEmBranco2() {
		this.ajuda = new AjudaPresencial("111", "LP1", "", "seg", "LCC2");
	}
	
	/**
	 * Testa criacao com dia null
	 */
	@Test(expected = AjudaException.class)
	public void testeDiaNull() {
		this.ajuda = new AjudaPresencial("111", "LP1", "10:30", null, "LCC2");
	}
	
	/**
	 * Testa criacao com dia em branco
	 */
	@Test(expected = AjudaException.class)
	public void testeDiaEmBranco() {
		this.ajuda = new AjudaPresencial("111", "LP1", "10:30", "", "LCC2");
	}
	
	/**
	 * Testa criacao com dia em branco com espacos
	 */
	@Test(expected = AjudaException.class)
	public void testeDiaEmBranco2() {
		this.ajuda = new AjudaPresencial("111", "LP1", "10:30", "  ", "LCC2");
	}
	
	/**
	 * Testa criacao com local null
	 */
	@Test(expected = AjudaException.class)
	public void testeLocalNull() {
		this.ajuda = new AjudaPresencial("111", "LP1", "10:30", "Seg" , null);
	}
	
	/**
	 * Testa criacao com local em branco
	 */
	@Test(expected = AjudaException.class)
	public void testeLocalEmBranco() {
		this.ajuda = new AjudaPresencial("111", "LP1", "10:30", "Seg" , "");
	}
	
	/**
	 * Testa criacao com local em branco com espacos
	 */
	@Test(expected = AjudaException.class)
	public void testeLocalEmBranco2() {
		this.ajuda = new AjudaPresencial("111", "LP1", "10:30", "Seg" , "  ");
	}
}
