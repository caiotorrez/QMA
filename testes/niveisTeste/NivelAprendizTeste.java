package niveisTeste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelos.tutor.Doacao;
import modelos.tutor.NivelAprendiz;

public class NivelAprendizTeste {

	private Doacao nivel = new NivelAprendiz();


	@Test(expected = NumberFormatException.class)
	public void testTaxaInvalidaNegativa() {
		assertEquals("", String.valueOf(nivel.getTaxa(-2)));
	}
	
	@Test(expected = NumberFormatException.class)
	public void testTaxaInvalidaPiso() {
		assertEquals("", String.valueOf(nivel.getTaxa(0)));
	}
	
	@Test(expected = NumberFormatException.class)
	public void testTaxaInvalidaTeto() {
		assertEquals("", String.valueOf(nivel.getTaxa(3.1)));
	}
	
	@Test
	public void testTaxa() {
		assertEquals("0.11", String.valueOf(nivel.getTaxa(0.1)));
	}
	
	@Test
	public void testTaxa2() {
		assertEquals("0.37", String.valueOf(nivel.getTaxa(2.7777777778)));
	}
	
	@Test
	public void testTaxa3() {
		assertEquals("0.4", String.valueOf(nivel.getTaxa(3)));
	}

}
