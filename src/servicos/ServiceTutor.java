package servicos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import tutor.Disciplina;
import tutor.Tutor;

public class ServiceTutor {
	
	private ServiceAluno serviceAluno;
	private Map<String, Tutor> tutores;
	
	
	public ServiceTutor(ServiceAluno serviceAluno) {
		this.serviceAluno = serviceAluno;
		this.tutores = new HashMap<>();
	}
		
	public void addTutor(String matricula, String disciplina, int proficiencia) {
		if (!this.serviceAluno.containsAluno(matricula)) {
			throw new NullPointerException("Erro na definicao de papel: Tutor nao encontrado");
		}
		else if (this.tutores.containsKey(matricula)) {
			this.tutores.get(matricula).addDisciplina(new Disciplina(disciplina, proficiencia));
		} else {
			this.tutores.put(matricula, new Tutor(matricula, this.serviceAluno.getInfoAluno(matricula, "Email"), new Disciplina(disciplina, proficiencia),this.tutores.size()));
		}
	}
	
	
	public String getTutor(String matricula) {
		if (this.tutores.containsKey(matricula)) {
			return this.serviceAluno.toStringAluno(matricula);
		}
		return null;
	}
	
	public String getAllTutores() {
		String saida = "";
		Map<String, String> tutores = new TreeMap<>();
		for (String matricula : this.tutores.keySet()) {
			tutores.put(this.serviceAluno.getInfoAluno(matricula, "nome"), this.serviceAluno.toStringAluno(matricula));
		}
		for (String toString : tutores.values()) {
			saida += toString + ", ";
		}
		return saida.equals("") ? "Nao ha tutores cadastrados" : saida.substring(0, saida.length() - 2);
	}

	public boolean containsTutor(String matricula) {
		return this.tutores.containsKey(matricula);
	}
	
	public String searchTutor(String disciplina) {
		String output = "";
		for (Tutor tutor : this.tutores.values()) {
			if (tutor.exibeDisciplinas().contains(disciplina))
				output += tutor.getMatricula() + ",";
			}
		return output;
	}
	
	public double getAvalicaoTutor(String matricula) {
		return this.tutores.get(matricula).getAvaliacao();
	}
	
	public String melhorTutorAvaliado(String[] matriculas) {
		List<Tutor> tutores = new ArrayList<>();
		for (String matricula : matriculas) {
			tutores.add(this.tutores.get(matricula));
		}
		Collections.sort(tutores);
		return tutores.get(0).getMatricula();
	}

}