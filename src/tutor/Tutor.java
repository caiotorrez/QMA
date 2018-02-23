package tutor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import alunos.Aluno;

public class Tutor {
	
	
	private int notaAvaliacao;
	private int qtAvaliacoes;
	private double carteira;
	private Map<String, String> horarios;
	private Map<String, Disciplina> disciplinas;
	private List<String> locais;
	private Aluno aluno;
	
	
	public Tutor(Aluno aluno, Disciplina disciplina) {
		this.horarios = new HashMap<>();
		this.disciplinas = new HashMap<>();
		this.locais = new ArrayList<>();
		this.aluno = aluno;
		this.disciplinas.put(disciplina.getID(), disciplina);
	}
	
	public void addDisciplina(Disciplina disciplina) {
		this.disciplinas.put(disciplina.getID(), disciplina);
	}
	
	public String exibeDisciplina() {
		String saida = "";
		for(String matricula : this.disciplinas.keySet()) {
			saida += this.disciplinas.get(matricula).toString() + System.lineSeparator();
			
		} return saida;
	}
	
	public void addLocal(String local) {
		this.locais.add(local);
	}
	
	public void addHorario(String horario, String dia) {
		this.horarios.put(horario, dia);
	}
	
	public boolean contemLocal(String local) {
		return this.locais.contains(local);
	}
	
	public boolean contemHorario(String horario, String dia) {
		return this.horarios.containsValue(dia);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tutor other = (Tutor) obj;
		if (aluno == null) {
			if (other.aluno != null)
				return false;
		} else if (!aluno.equals(other.aluno))
			return false;
		return true;
	}
	
	public String toString() {
		return this.aluno.getMatricula() + " - " + this.aluno.getNome() + " - " + this.notaAvaliacao;
	}
}
