package fabrica;

import classePrincipal.ControllerCaixa;
import controladoresIO.ControllerAjuda;
import controladoresIO.ControllerAluno;
import controladoresIO.ControllerHorarioLocal;
import controladoresIO.ControllerTutor;
import servicos.ServiceAjuda;
import servicos.ServiceAluno;
import servicos.ServiceCaixaSistema;
import servicos.ServiceHorarioLocais;
import servicos.ServiceTutor;

public class FabricaSistema implements Fabrica<FabricaSistema> {
	private ServiceAluno serviceAluno;
	private ServiceTutor serviceTutor;
	private ServiceHorarioLocais serviceHL;
	private ServiceAjuda serviceAjuda;
	private ServiceCaixaSistema serviceCaixa;
	private ControllerAluno alunoController;
	private ControllerTutor tutorController;
	private ControllerHorarioLocal horarioLocalController;
	private ControllerAjuda ajudaController;
	private ControllerCaixa caixaController;

	@Override
	public void create() {
		this.serviceAluno = new ServiceAluno();
		this.serviceTutor = new ServiceTutor(this.serviceAluno);
		this.serviceHL = new ServiceHorarioLocais(this.serviceTutor);
		this.serviceAjuda = new ServiceAjuda(this.serviceTutor, this.serviceHL, this.serviceAluno);
		this.serviceCaixa = new ServiceCaixaSistema();
		this.alunoController = new ControllerAluno(this.serviceAluno);
		this.tutorController = new ControllerTutor(this.serviceTutor);
		this.horarioLocalController = new ControllerHorarioLocal(this.serviceHL);
		this.ajudaController = new ControllerAjuda(this.serviceAjuda);
		this.caixaController = new ControllerCaixa(this.serviceCaixa);
	}

}
