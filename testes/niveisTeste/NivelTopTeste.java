package niveisTeste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelos.tutor.Doacao;
import modelos.tutor.NivelTop;

public class NivelTopTeste {

private Doacao nivel = new NivelTop();
	
	
	@Test
	public void test1() {
		assertEquals("0.9", String.valueOf(nivel.getTaxa(4.54555520131)));
	}
	
	@Test
	public void test2() {
		assertEquals("0.94", String.valueOf(nivel.getTaxa(4.9)));
	}
}