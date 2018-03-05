package classePrincipal;

import servicos.ServiceCaixaSistema;

public class ControllerCaixa {
	
	private ServiceCaixaSistema serviceCaixa;

	public ControllerCaixa(ServiceCaixaSistema serviceCaixa) {
		this.serviceCaixa = serviceCaixa;
	}

	public void adicionaValorAoCaixa(int total_sistema) {
		serviceCaixa.adicionaValorAoCaixa(total_sistema);
	}

	public int retornaValorCaixa() {
		return serviceCaixa.retornaValorCaixa();
	}
}
