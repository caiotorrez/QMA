/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - UFCG
 * LABORATORIO DE PROGRAMACAO 2
 * ALUNOS - CAIO TORRES - FRANCIVALDO CABRAL - LUAN CARLOS
 * MATRICULAS -  -  - 116.110.100
 * PROJETO FINAL - QUEM ME AJUDA
 */
package tutor;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe Tutor
 * 
 * @author Caio Torres
 * @version 1.0
 */
public class Tutor implements Comparable<Tutor> {
	
	private Map<String, Disciplina> disciplinas;
	private String matricula;
	private String email;
	private float avaliacao;
	private int id;

	public Tutor(String matricula, String email, Disciplina disciplina, int id) {
		if(disciplina == null) {
			throw new TutorException(new NullPointerException("Erro na criacao do Tutor: Disciplina nao pode ser nula"));
		}
		else if (matricula == null || matricula.trim().equals("")) {
			throw new TutorException(new NullPointerException("Erro na criacao do Tutor: Matricula nao pode ser nulo ou em branco"));
		}
		else if (email == null || email.trim().equals("")) {
			throw new TutorException(new NullPointerException("Erro na criacao do Tutor: Email nao pode ser nulo ou em branco"));
		}
		
		this.disciplinas = new HashMap<>();
		this.matricula = matricula;
		this.email = email;
		this.disciplinas.put(disciplina.getID(), disciplina);
		this.avaliacao = 4;
		this.id = id;
	}


	public void addDisciplina(Disciplina disciplina) {
		if(disciplina == null)
			throw new TutorException(new NullPointerException("Erro na adicao de disciplinas ao Tuto: Disciplina nao pode ser nula"));
		else if (this.disciplinas.containsKey(disciplina.getID())) {
			throw new TutorException("Erro na definicao de papel: Ja eh tutor dessa disciplina");
		} else {
			this.disciplinas.put(disciplina.getID(), disciplina);
		}
	}
	
	public String exibeDisciplinas() {
		String saida = "";
		for (String matricula : this.disciplinas.keySet()) {
			saida += this.disciplinas.get(matricula).toString() + System.lineSeparator();
		}
		return saida;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getMatricula() {
		return this.matricula;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void addAvaliacao(int avaliacao) {
		this.avaliacao = (this.avaliacao * 5 + avaliacao) / 6;
	}
	
	public double getAvaliacao() {
		return this.avaliacao;		
	}

	public String getNivel() {
		if (this.avaliacao > 4.5) {
			return "TOP";
		} else if (this.avaliacao > 3) {
			return "Tutor";
		} else {
			return "Aprendiz";
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	@Override
	public int compareTo(Tutor outroTutor) {
		if (this.avaliacao > outroTutor.getAvaliacao()) {
			return -1;
		} else if (this.avaliacao > outroTutor.avaliacao) {
			return 1;
		}
		else if (this.id < outroTutor.id) {
			return -1;
		} else if (this.id > outroTutor.id) {
			return 1;
		}
		return 0;
	}
	
	@Override
	public String toString() {
		return this.matricula + " - " + this.email;
	}
}
