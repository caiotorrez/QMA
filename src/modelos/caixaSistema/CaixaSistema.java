package modelos.caixaSistema;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CaixaSistema implements Serializable {

	private int caixaSistema;
	
	public CaixaSistema(int valorInicial) {
		this.caixaSistema = valorInicial;
	}

	public int getCaixa() {
		return this.caixaSistema;
	}
	
	public void addValor(int valor) {
		this.caixaSistema += valor;
	}
	
}
