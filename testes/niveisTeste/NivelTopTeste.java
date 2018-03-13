package niveisTeste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelos.tutor.Doacao;
import modelos.tutor.NivelTop;

public class NivelTopTeste {

private Doacao nivel = new NivelTop();
	
	
	@Test(expected = NumberFormatException.class)
	public void testTaxaInvalidaNegativa() {
		assertEquals("", String.valueOf(nivel.getTaxa(-2)));
	}
	
	@Test(expected = NumberFormatException.class)
	public void testTaxaInvalidaPiso() {
		assertEquals("", String.valueOf(nivel.getTaxa(4.5)));
	}
	
	@Test(expected = NumberFormatException.class)
	public void testTaxaInvalidaTeto() {
		assertEquals("", String.valueOf(nivel.getTaxa(5.1)));
	}
	
	@Test
	public void testTaxa() {
		assertEquals("0.9", String.valueOf(nivel.getTaxa(4.54555520131)));
	}
	
	@Test
	public void testTaxa2() {
		assertEquals("0.94", String.valueOf(nivel.getTaxa(4.9)));
	}
	
	@Test
	public void testTaxa3() {
		assertEquals("0.95", String.valueOf(nivel.getTaxa(5)));
	}
	
	
}