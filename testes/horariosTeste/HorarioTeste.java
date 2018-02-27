/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - UFCG
 * LABORATORIO DE PROGRAMACAO 2
 * ALUNOS - CAIO TORRES - FRANCIVALDO CABRAL - LUAN CARLOS
 * MATRICULAS -  -  - 116.110.100
 * PROJETO FINAL - QUEM ME AJUDA
 */
package horariosTeste;

import static org.junit.Assert.*;

import org.junit.Test;

import cadastroExceptions.NullOuEmBrancoException;
import horarios.Horario;

/**
 * Classe de Testes referente a Horario
 * @author 
 * @version 1.0
 *
 */
public class HorarioTeste {
	private Horario horarioTeste;

	/**
	 * Testa a criacao de um horario com o email nulo
	 */
	@Test(expected = NullOuEmBrancoException.class)
	public void horarioEmailNuloTeste() {
		horarioTeste = new Horario(null, "15:00", "segunda");
	}

	/**
	 * Testa a criacao de um horario com o email vazio
	 */
	@Test(expected = NullOuEmBrancoException.class)
	public void horarioEmailVazioTeste() {
		horarioTeste = new Horario(" ", "15:00", "segunda");
	}

	/**
	 * Testa a criacao de um horario com a hora nulo
	 */
	@Test(expected = NullOuEmBrancoException.class)
	public void horarioHoraNuloTeste() {
		horarioTeste = new Horario("francis@andrade.com", null, "segunda");
	}

	/**
	 * Testa a criacao de um horario com a hora vazia
	 */
	@Test(expected = NullOuEmBrancoException.class)
	public void horarioHoraVaziaTeste() {
		horarioTeste = new Horario("francis@andrade.com", "  ", "segunda");
	}

	/**
	 * Testa a criacao de um horario com o dia nulo
	 */
	@Test(expected = NullOuEmBrancoException.class)
	public void horarioDiaNuloTeste() {
		horarioTeste = new Horario("francis@andrade.com", "15:00", null);
	}

	/**
	 * Testa a criacao de um horario com o dia vazio
	 */
	@Test(expected = NullOuEmBrancoException.class)
	public void horarioDiaVazioTeste() {
		horarioTeste = new Horario("francis@andrade.com", "15:00", " ");
	}

	/**
	 * Testa a representacao textual do horario
	 */
	@Test
	public void representacaoTextual(){
		horarioTeste = new Horario("francis@andrade.com", "15:00", "segunda");
		assertEquals("Responsavel - francis@andrade.com - Dia: segunda - Hora: 15:00", horarioTeste.toString());	
	}
}
