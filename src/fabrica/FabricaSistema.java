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

	private ObjectOutputStream gravador;
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
			this.gravador = new ObjectOutputStream(new FileOutputStream("serviceTutor.ser"));
			this.gravador.writeObject(this.serviceAluno);
			
			this.gravador = new ObjectOutputStream(new FileOutputStream("serviceTutor.ser"));
			this.gravador.writeObject(this.serviceTutor);
			
			this.gravador = new ObjectOutputStream(new FileOutputStream("serviceHL.ser"));
			this.gravador.writeObject(this.serviceHL);
			
			this.gravador = new ObjectOutputStream(new FileOutputStream("serviceAjuda.ser"));
			this.gravador.writeObject(this.serviceAjuda);
			
			this.gravador = new ObjectOutputStream(new FileOutputStream("serviceCaixa.ser"));
			this.gravador.writeObject(this.serviceCaixa);
			
			System.out.println("Deu certo");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void carregarSistema() {
		this.serviceTutor = (ServiceTutor) leitura("serviceAluno.ser");
		this.serviceTutor = (ServiceTutor) leitura("serviceTutor.ser");
		this.serviceHL = (ServiceHorarioLocais) leitura("serviceHL.ser");
		this.serviceAjuda = (ServiceAjuda) leitura("serviceAjuda.ser");
		this.serviceCaixa = (ServiceCaixaSistema) leitura("serviceCaixa.ser");
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
			this.gravador = new ObjectOutputStream(new FileOutputStream("Sistema.ser"));
		} catch (IOException e) {
			e.printStackTrace();
		}
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
