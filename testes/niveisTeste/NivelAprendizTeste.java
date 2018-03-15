/**
 * UFCG - Universidade Federal de Campina Grande
 * LP2 - Laboratorio de Programacao 2 - Projeto Final
 * Caio Vitor Brasileiro Torres - 116111245
 * Francivaldo Cabral de Andrade - 116111544
 * Luan Carlos da Silva Bezerra - 116110100
 */
package niveisTeste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelos.tutor.Doacao;
import modelos.tutor.NivelAprendiz;

/**
 * Classe de Testes, referentes ao {@link NivelAprendiz}
 * 
 * @author Caio Torres
 * @version 1.0
 */
public class NivelAprendizTeste {

	private Doacao nivel = new NivelAprendiz();

	/**
	 * Testa taxa negativa
	 */
	@Test(expected = NumberFormatException.class)
	public void testTaxaInvalidaNegativa() {
		assertEquals("", String.valueOf(nivel.getTaxa(-2)));
	}
	
	/**
	 * Testa taxa Nula
	 */
	@Test(expected = NumberFormatException.class)
	public void testTaxaInvalidaPiso() {
		assertEquals("", String.valueOf(nivel.getTaxa(0)));
	}
	
	/**
	 * Testa taxa acima do nivel
	 */
	@Test(expected = NumberFormatException.class)
	public void testTaxaInvalidaTeto() {
		assertEquals("", String.valueOf(nivel.getTaxa(3.1)));
	}
	
	/**
	 * Testa taxa acima do 0
	 */
	@Test
	public void testTaxa() {
		assertEquals("0.11", String.valueOf(nivel.getTaxa(0.1)));
	}
	
	/**
	 * Testa taxa valida
	 */
	@Test
	public void testTaxa2() {
		assertEquals("0.37", String.valueOf(nivel.getTaxa(2.7777777778)));
	}
	
	/**
	 * Testa taxa no limite do nivel
	 */
	@Test
	public void testTaxa3() {
		assertEquals("0.4", String.valueOf(nivel.getTaxa(3)));
	}

}
