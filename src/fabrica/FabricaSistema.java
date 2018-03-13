package fabrica;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import controladores.ControllerAjuda;
import controladores.ControllerAluno;
import controladores.ControllerCaixa;
import controladores.ControllerHorarioLocal;
import controladores.ControllerTutor;
import servicos.ServiceAjuda;
import servicos.ServiceAluno;
import servicos.ServiceCaixaSistema;
import servicos.ServiceHorarioLocais;
import servicos.ServiceTutor;

@SuppressWarnings("serial")
public final class FabricaSistema implements Serializable {

	private ObjectOutputStream saveAluno;
	private ObjectOutputStream saveTutor;
	private ObjectOutputStream saveHL;
	private ObjectOutputStream saveAjuda;
	private ObjectOutputStream saveCaixa;
	private ObjectInputStream leitor;
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


	public void salvarSistema() {
		try {
			this.saveAluno.writeObject(this.serviceAluno);
			this.saveTutor.writeObject(this.serviceTutor);
			this.saveHL.writeObject(this.serviceHL);
			this.saveAjuda.writeObject(this.serviceAjuda);
			this.saveCaixa.writeObject(this.serviceCaixa);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void carregarSistema() {
		this.alunoController = new ControllerAluno((ServiceAluno) leitura("serviceAluno.ser"));
		this.tutorController = new ControllerTutor((ServiceTutor) leitura("serviceTutor.ser"));
		this.horarioLocalController = new ControllerHorarioLocal((ServiceHorarioLocais) leitura("serviceHL.ser"));
		this.ajudaController = new ControllerAjuda((ServiceAjuda) leitura("serviceAjuda.ser"));
		this.caixaController = new ControllerCaixa((ServiceCaixaSistema) leitura("serviceCaixa.ser"));
	}
	
	public void limparSistema() {
		this.create();
	}
	
	private Object leitura(String arquivo) {
		try {
			this.leitor = new ObjectInputStream(new FileInputStream(arquivo));
			try {
				return this.leitor.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public FabricaSistema() {
		this.create();
	}

	public void create() {
		try {
			this.saveAluno = new ObjectOutputStream(new FileOutputStream("serviceAluno.ser"));
			this.saveTutor = new ObjectOutputStream(new FileOutputStream("serviceTutor.ser"));
			this.saveHL = new ObjectOutputStream(new FileOutputStream("serviceHL.ser"));
			this.saveAjuda = new ObjectOutputStream(new FileOutputStream("serviceAjuda.ser"));
			this.saveCaixa = new ObjectOutputStream(new FileOutputStream("serviceCaixa.ser"));
			this.serviceAluno = new ServiceAluno();
			this.serviceTutor = new ServiceTutor(this.serviceAluno);
			this.serviceHL = new ServiceHorarioLocais(this.serviceTutor);
			this.serviceAjuda = new ServiceAjuda(this.serviceTutor, this.serviceHL, this.serviceAluno);
			this.serviceCaixa = new ServiceCaixaSistema(this.serviceTutor);
			this.alunoController = new ControllerAluno(this.serviceAluno);
			this.tutorController = new ControllerTutor(this.serviceTutor);
			this.horarioLocalController = new ControllerHorarioLocal(this.serviceHL);
			this.ajudaController = new ControllerAjuda(this.serviceAjuda);
			this.caixaController = new ControllerCaixa(this.serviceCaixa);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ControllerAluno getAlunoController() {
		return this.alunoController;
	}

	public ControllerTutor getTutorController() {
		return this.tutorController;
	}
	
	public ControllerHorarioLocal getHorarioLocalController() {
		return this.horarioLocalController;
	}
	
	public ControllerAjuda getAjudaController() {
		return this.ajudaController;
	}
	
	public ControllerCaixa getCaixaController() {
		return this.caixaController;
	}
}
