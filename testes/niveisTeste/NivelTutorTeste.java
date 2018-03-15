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
import modelos.tutor.NivelTutor;


/**
 * Classe de Testes, referentes ao {@link NivelTutor}
 * 
 * @author Caio Torres
 * @version 1.0
 */
public class NivelTutorTeste {

private Doacao nivel = new NivelTutor();
	
	/**
	 * Testa taxa abaixo do limite inferior
	 */
	@Test(expected = NumberFormatException.class)
	public void testTaxaInvalida() {
		assertEquals("", String.valueOf(nivel.getTaxa(3)));
	}
	
	/**
	 * testa Taxa acima do limite superior
	 */
	@Test(expected = NumberFormatException.class)
	public void testTaxaInvalida2() {
		assertEquals("", String.valueOf(nivel.getTaxa(4.6)));
	}
	
	/**
	 * Testa taxa valida no limite inferior
	 */
	@Test
	public void testTaxa() {
		assertEquals("0.8", String.valueOf(nivel.getTaxa(3.1)));
	}
	
	/**
	 * Testa taxa valida no limite superior
	 */
	@Test
	public void testTaxa2() {
		assertEquals("0.8", String.valueOf(nivel.getTaxa(4.5)));
	}
}
