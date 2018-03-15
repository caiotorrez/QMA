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
import modelos.tutor.NivelTop;

/**
 * Classe de Testes, referentes ao {@link NivelTop}
 * 
 * @author Caio Torres
 * @version 1.0
 */
public class NivelTopTeste {

private Doacao nivel = new NivelTop();
	
	/**
	 * Testa taxa negativa
	 */
	@Test(expected = NumberFormatException.class)
	public void testTaxaInvalidaNegativa() {
		assertEquals("", String.valueOf(nivel.getTaxa(-2)));
	}
	
	/**
	 * Testa taxa no abaixo do limite inferior
	 */
	@Test(expected = NumberFormatException.class)
	public void testTaxaInvalidaPiso() {
		assertEquals("", String.valueOf(nivel.getTaxa(4.5)));
	}
	
	/**
	 * Testa taxa acima do limite superior
	 */
	@Test(expected = NumberFormatException.class)
	public void testTaxaInvalidaTeto() {
		assertEquals("", String.valueOf(nivel.getTaxa(5.1)));
	}
	
	/**
	 * Testa taxa valida e arredondamento
	 */
	@Test
	public void testTaxa() {
		assertEquals("0.9", String.valueOf(nivel.getTaxa(4.54555520131)));
	}
	
	/**
	 * Testa taxa valida
	 */
	@Test
	public void testTaxa2() {
		assertEquals("0.94", String.valueOf(nivel.getTaxa(4.9)));
	}
	
	/**
	 * Testa taxa valida no limite superior
	 */
	@Test
	public void testTaxa3() {
		assertEquals("0.95", String.valueOf(nivel.getTaxa(5)));
	}
	
	
}