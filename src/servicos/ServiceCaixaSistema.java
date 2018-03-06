package servicos;

import modelos.caixaSistema.CaixaSistema;

public class ServiceCaixaSistema {

	private CaixaSistema caixa;
	
	public ServiceCaixaSistema() {
		caixa =  new CaixaSistema();
	}	
	
	public void adicionaValorAoCaixa(int total_sistema) {
		caixa.setCaixa(total_sistema);
	}

	public int retornaValorCaixa() {
		return caixa.getCaixa();
	}

}
