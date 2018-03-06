package controladores;

import servicos.ServiceCaixaSistema;

public class ControllerCaixaSistema {
	
private ServiceCaixaSistema serviceCaixaSistema;
	
	public ControllerCaixaSistema(ServiceCaixaSistema serviceCaixaSistema) {
		this.serviceCaixaSistema = serviceCaixaSistema;	
	}

	public void doar(String matriculaTutor, int totalCentavos) {
		if (totalCentavos <= 0) 
			throw new NullPointerException("Erro na doacao para tutor: totalCentavos nao pode ser menor que zero");
		else
			serviceCaixaSistema.doar(matriculaTutor, totalCentavos);
	}
	
	public int totalDinheiroTutor(String emailTutor) {
		if(emailTutor == null || emailTutor.trim().equals(""))
			throw new NullPointerException("Erro na consulta de total de dinheiro do tutor: emailTutor nao pode ser vazio ou nulo");
		else
			return serviceCaixaSistema.totalDinheiroTutor(emailTutor);
	}
}
