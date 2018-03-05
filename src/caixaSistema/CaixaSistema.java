package caixaSistema;

public class CaixaSistema {

	private int valorTotalCaixa;
	
	public CaixaSistema() {
		this.valorTotalCaixa = 0;
	}

	public int getCaixa() {
		return this.valorTotalCaixa;
	}
	
	public void setCaixa(int valor) {
		this.valorTotalCaixa += valor;
	}
}
