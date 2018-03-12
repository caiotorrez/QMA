package niveisTeste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelos.tutor.Doacao;
import modelos.tutor.NivelTutor;

public class NivelTutorTeste {

private Doacao nivel = new NivelTutor();
	
	
	@Test
	public void test() {
		assertEquals("0.8", String.valueOf(nivel.getTaxa(5)));
	}
	
}
