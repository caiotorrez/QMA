package horariosTeste;

import org.junit.Test;

import cadastroExceptions.NullOuEmBrancoException;
import horarios.Horario;

public class HorarioTeste {
	private Horario horarioTeste;

	@Test(expected = NullOuEmBrancoException.class)
	public void horarioEmailNuloTeste() {
		horarioTeste = new Horario(null, "15:00", "segunda");
	}

	@Test(expected = NullOuEmBrancoException.class)
	public void horarioEmailVazioTeste() {
		horarioTeste = new Horario(" ", "15:00", "segunda");
	}

	@Test(expected = NullOuEmBrancoException.class)
	public void horarioHoraNuloTeste() {
		horarioTeste = new Horario("francis@andrade.com", null, "segunda");
	}

	@Test(expected = NullOuEmBrancoException.class)
	public void horarioHoraVaziaTeste() {
		horarioTeste = new Horario("francis@andrade.com", "  ", "segunda");
	}

	@Test(expected = NullOuEmBrancoException.class)
	public void horarioDiaNuloTeste() {
		horarioTeste = new Horario("francis@andrade.com", "15:00", null);
	}

	@Test(expected = NullOuEmBrancoException.class)
	public void horarioDiaVazioTeste() {
		horarioTeste = new Horario("francis@andrade.com", "15:00", " ");
	}

}
