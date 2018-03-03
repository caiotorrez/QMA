package servicos;

import java.util.ArrayList;
import java.util.List;

import ajuda.Ajuda;
import ajuda.AjudaOnline;
import ajuda.AjudaPresencial;

public class ServiceAjuda {

	private ServiceTutor serviceTutor;
	private ServiceHorarioLocais serviceHL;
	private ServiceAluno serviceAluno;
	private List<Ajuda> ajudas;
	
	public ServiceAjuda(ServiceTutor serviceTutor, ServiceHorarioLocais serviceHL, ServiceAluno serviceAluno) {
		this.ajudas= new ArrayList<>();
		this.serviceTutor = serviceTutor;
		this.serviceHL = serviceHL;
		this.serviceAluno = serviceAluno;
	}
	
	private String setTutorAjuda(String disciplina, String horario, String dia, String local) {
		List<String> matriculas = new ArrayList<>();
		for (String matricula : this.serviceTutor.searchTutor(disciplina).split(",")) {
			String email = serviceAluno.getInfoAluno(matricula, "Email");
			if (serviceHL.contemHorario(email, horario, dia) && serviceHL.contemLocal(email, local)) {
				matriculas.add(matricula);
			}
		}
		String[] input = matriculas.toArray(new String[matriculas.size()]);
		return this.serviceTutor.melhorTutorAvaliado(input);
	}
	
	public int cadastrarAjudaPresencial(String matrAluno, String disciplina, String horario, String dia, String localInteresse) {
		this.ajudas.add(new AjudaPresencial(matrAluno, disciplina, horario, dia, localInteresse));
		int id = this.ajudas.size();
		this.ajudas.get(id - 1).setMatriculaTutor(this.setTutorAjuda(disciplina, horario, dia, localInteresse));
		return this.ajudas.size();
	}
	
	private String setTutorAjuda(String disciplina) {
		List<String> matriculas = new ArrayList<>();
		for (String matricula : this.serviceTutor.searchTutor(disciplina).split(",")) {
			matriculas.add(matricula);
		}
		String[] input = matriculas.toArray(new String[matriculas.size()]);
		return this.serviceTutor.melhorTutorAvaliado(input);
	}
	
	public int cadastrarAjudaOnline (String matrAluno, String disciplina) {
		this.ajudas.add(new AjudaOnline(matrAluno, disciplina));
		int id = this.ajudas.size();
		this.ajudas.get(id - 1).setMatriculaTutor(this.setTutorAjuda(disciplina));
		return id;
	}
	
	
	public String getTutorAjuda(int id) {
		if (id > this.ajudas.size()) {
			throw new NullPointerException("Erro ao tentar recuperar tutor : id nao encontrado ");
		} else {
			return this.ajudas.get(id - 1).toString();
		}
		
	}

	public String getInfoAjuda(int id, String atributo) {
		if (id > this.ajudas.size()) {
			throw new NullPointerException("Erro ao tentar recuperar info da ajuda : id nao encontrado ");
		}
		switch(atributo.toLowerCase()) {
		
		case "disciplina":
			return this.ajudas.get(id - 1).getDisciplina();
		case "horario":
			return ((AjudaPresencial) this.ajudas.get(id - 1)).getHorario();
		case "dia":
			return ((AjudaPresencial) this.ajudas.get(id - 1)).getDia();
		case "localinteresse": 
			return ((AjudaPresencial) this.ajudas.get(id - 1)).getLocalInteresse();
		default :
			throw new NullPointerException("Erro ao tentar recuperar info da ajuda : atributo nao encontrado");
		}
	}
}