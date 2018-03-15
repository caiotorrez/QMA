/**
 * UFCG - Universidade Federal de Campina Grande
 * LP2 - Laboratorio de Programacao 2 - Projeto Final
 * Caio Vitor Brasileiro Torres - 116111245
 * Francivaldo Cabral de Andrade - 116111544
 * Luan Carlos da Silva Bezerra - 116110100
 */
package caixaSistemaTeste;

import org.junit.Test;

import modelos.caixaSistema.CaixaException;
import modelos.caixaSistema.CaixaSistema;

/**
 * Classe de Testes, referentes ao {@link CaixaSistema}
 * 
 * @author Caio Torres
 * @version 1.0
 */
public class CaixaSistemaTeste {

	private CaixaSistema caixa = new CaixaSistema(0);
	
	/**
	 * Testa a criacao do caixa com valor negativo
	 */
	@Test(expected = CaixaException.class)
	public void criarCaixaInvalidoTeste() {
		this.caixa = new CaixaSistema(-1);
	}
	
	/**
	 * Testa a criacao do caixa com valor valido
	 */
	public void criarCaixaValidoTeste() {
		this.caixa = new CaixaSistema(0);
	}
	
	/**
	 * Testa a adicao de valor negativo ao caixa
	 */
	@Test(expected = CaixaException.class)
	public void adicionaValorAoCaixaNegativoTest() {
		this.caixa.addValor(-1);
	}
	
	/**
	 * Testa a adicao de valor valido ao caixa
	 */
	@Test
	public void adicionaValorAoCaixaValidoTest() {
		this.caixa.addValor(1);
	}
}