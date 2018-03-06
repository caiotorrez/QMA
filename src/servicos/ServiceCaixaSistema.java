package servicos;

import modelos.caixaSistema.CaixaSistema;
import servicos.ServiceTutor;

public class ServiceCaixaSistema {

	private CaixaSistema caixa;
	private ServiceTutor serviceTutor;
	
	public ServiceCaixaSistema(ServiceTutor serviceTutor) {
		caixa = new CaixaSistema();
		this.serviceTutor = serviceTutor;
	}	
	
	public void adicionaValorAoCaixa(int total_sistema) {
		caixa.setCaixa(total_sistema);
	}

	public int retornaValorCaixa() {
		return caixa.getCaixa();
	}
	
	public void doar(String matriculaTutor, int totalCentavos) {
		if (totalCentavos <= 0) 
			throw new NullPointerException("Erro na doacao para tutor: totalCentavos nao pode ser menor que zero");
		if (serviceTutor.getTutor(matriculaTutor) != null) {
			double taxa = serviceTutor.getTutor(matriculaTutor).getAvaliacao();
			int total_tutor = 0;
			int total_sistema = 0;
			if (serviceTutor.getNivel(matriculaTutor).equalsIgnoreCase("TOP")) {
				taxa = (int) ((taxa - 4.5) + 9)*10;
				total_sistema = (int) (((100 - taxa)/100) * totalCentavos);
			} else if (serviceTutor.getNivel(matriculaTutor).equalsIgnoreCase("Tutor")) {
				total_sistema = 2 * totalCentavos * 10;
			} else if (serviceTutor.getNivel(matriculaTutor).equalsIgnoreCase("Aprendiz")) {
				taxa = ((3.0 - taxa) + 6)*10;
				total_sistema = (int) ((400 - taxa)/100 * totalCentavos);
			}
			serviceTutor.getTutor(matriculaTutor).setCarteira(total_tutor);
			adicionaValorAoCaixa(total_sistema);
		} else
			throw new NullPointerException("Erro na doacao para tutor: Tutor nao encontrado");
	}

	public int totalDinheiroTutor(String emailTutor) {
		if(serviceTutor.getTutor(emailTutor) == null)
			throw new NullPointerException("Erro na consulta de total de dinheiro do tutor: Tutor nao encontrado");
		else
			return serviceTutor.getTutor(emailTutor).getCarteira();			
	}

}
