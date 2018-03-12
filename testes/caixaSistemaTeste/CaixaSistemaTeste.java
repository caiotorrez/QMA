package caixaSistemaTeste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelos.caixaSistema.CaixaSistema;

public class CaixaSistemaTeste {

	private CaixaSistema caixa;
	private CaixaSistema caixa2;
	
	@Test
	public void adicionaValorAoCaixaTest() {
		caixa = new CaixaSistema(0);
		caixa2 = new CaixaSistema(100);
		assertEquals(0, caixa.getCaixa());
		caixa.addValor(100);
		assertEquals(100, caixa.getCaixa());
		assertEquals(100, caixa2.getCaixa());
		caixa2.addValor(100);
		assertEquals(200, caixa2.getCaixa());
	}
}