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
	
	public void doar(String matriculaTutor, int totalCentavos) {
		if (totalCentavos <= 0) 
			throw new NullPointerException("Erro na doacao para tutor: totalCentavos nao pode ser menor que zero");
		else
			serviceCaixa.doar(matriculaTutor, totalCentavos);
	}
	
	public int totalDinheiroTutor(String emailTutor) {
		if(emailTutor == null || emailTutor.trim().equals(""))
			throw new NullPointerException("Erro na consulta de total de dinheiro do tutor: emailTutor nao pode ser vazio ou nulo");
		else
			return serviceCaixa.totalDinheiroTutor(emailTutor);
	}
}
