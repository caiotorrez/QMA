package niveisTeste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelos.tutor.Doacao;
import modelos.tutor.NivelTutor;

public class NivelTutorTeste {

private Doacao nivel = new NivelTutor();
	

	@Test(expected = NumberFormatException.class)
	public void testTaxaInvalida() {
		assertEquals("", String.valueOf(nivel.getTaxa(3)));
	}
	
	@Test(expected = NumberFormatException.class)
	public void testTaxaInvalida2() {
		assertEquals("", String.valueOf(nivel.getTaxa(4.6)));
	}
	
	@Test
	public void testTaxa() {
		assertEquals("0.8", String.valueOf(nivel.getTaxa(3.1)));
	}
	
	@Test
	public void testTaxa2() {
		assertEquals("0.8", String.valueOf(nivel.getTaxa(4.5)));
	}
	
}
