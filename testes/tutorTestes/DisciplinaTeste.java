package tutorTestes;

import static org.junit.Assert.*;

import org.junit.Test;

import definicaoException.NumeroForaDosLimitesException;
import tutor.Disciplina;

public class DisciplinaTeste {
	private Disciplina disciplinaTeste;

	@Test(expected = NullPointerException.class)
	public void disciplinaNomeNuloTeste() throws Exception {
		disciplinaTeste = new Disciplina(null, 5);
	}

	@Test(expected = NullPointerException.class)
	public void disciplinaNomeVazioTeste() throws Exception {
		disciplinaTeste = new Disciplina(" ", 5);
	}

	@Test(expected = NumeroForaDosLimitesException.class)
	public void disciplinaProficienciaInvalidaTeste() throws Exception {
		disciplinaTeste = new Disciplina("Programacao", 6);
	}

	@Test(expected = NumeroForaDosLimitesException.class)
	public void disciplinaProficienciaZeroTeste() throws Exception {
		disciplinaTeste = new Disciplina("Programacao", 0);
	}

	@Test(expected = NumeroForaDosLimitesException.class)
	public void disciplinaProficienciaNegativaTeste() throws Exception {
		disciplinaTeste = new Disciplina("Programacao", -1);
	}
	
	@Test
	public void toStringTeste() throws Exception {
		disciplinaTeste = new Disciplina("Programação 2", 4);
		assertEquals("Programação 2 - 4", disciplinaTeste.toString());
	}

}
