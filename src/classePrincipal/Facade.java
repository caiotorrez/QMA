package classePrincipal;

import controladoresIO.ControllerAjuda;
import controladoresIO.ControllerAluno;
import controladoresIO.ControllerHorarioLocal;
import controladoresIO.ControllerTutor;
import servicos.ServiceAjuda;
import servicos.ServiceAluno;
import servicos.ServiceHorarioLocais;
import servicos.ServiceTutor;

public class Facade {
	
	private ServiceAluno serviceAluno = new ServiceAluno();
	private ServiceTutor serviceTutor = new ServiceTutor(this.serviceAluno, this.serviceAjuda);
	private ServiceHorarioLocais serviceHL = new ServiceHorarioLocais(this.serviceTutor);
	private ServiceAjuda serviceAjuda = new ServiceAjuda(this.serviceTutor, this.serviceHL, this.serviceAluno);
	private ControllerAluno alunoController = new ControllerAluno(this.serviceAluno);
	private ControllerTutor tutorController = new ControllerTutor(this.serviceTutor);
	private ControllerHorarioLocal horarioLocalController = new ControllerHorarioLocal(this.serviceHL);
	private ControllerAjuda ajudaController = new ControllerAjuda(this.serviceAjuda);
	
	
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		this.alunoController.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
	}
	
	public String recuperaAluno(String matricula) {
		return this.alunoController.recuperaAluno(matricula);
	}
	
	public String listarAlunos() {
		return this.alunoController.listarAlunos();
	}
	
	public String getInfoAluno(String matricula, String atributo) {
		return this.alunoController.getInfoAluno(matricula, atributo);
	}
	
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		this.tutorController.tornarTutor(matricula, disciplina, proficiencia);
	}
	
	public String recuperaTutor(String matricula) {
		return this.tutorController.recuperaTutor(matricula);
	}
	
	public String listarTutores() {
		return this.tutorController.listarTutores();
	}
	
	public void cadastrarHorario(String email, String horario, String dia) {
		horarioLocalController.cadastrarHorario(email, horario, dia);
	}
	
	public void cadastrarLocalDeAtendimento(String email, String local) {
		horarioLocalController.cadastrarLocalDeAtendimento(email, local);
	}
	
	public boolean consultaHorario(String email, String horario, String dia) {
		return horarioLocalController.consultaHorario(email, horario, dia);
	}
	
	public boolean consultaLocal(String email, String local) {
		return horarioLocalController.consultaLocal(email, local);
	}
	
	public int pedirAjudaPresencial (String matrAluno, String disciplina, String horario, String dia, String localInteresse) {
		return this.ajudaController.pedirAjudaPresencial(matrAluno, disciplina, horario, dia, localInteresse);
	}
	
	public int pedirAjudaOnline (String matrAluno, String disciplina) {
		return this.ajudaController.pedirAjudaOnline(matrAluno, disciplina);
	}
	
	public String pegarTutor(int idAjuda) {
		return this.ajudaController.pegarTutor(idAjuda);
	}
	
	public String getInfoAjuda(int idAjuda, String atributo) {
		return this.ajudaController.getInfoAjuda(idAjuda, atributo);
	}

}
