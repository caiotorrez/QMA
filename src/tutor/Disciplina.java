/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - UFCG
 * LABORATORIO DE PROGRAMACAO 2
 * ALUNOS - CAIO TORRES - FRANCIVALDO CABRAL - LUAN CARLOS
 * MATRICULAS -  -  - 116.110.100
 * PROJETO FINAL - QUEM ME AJUDA
 */
package tutor;

public class Disciplina {

	private String disciplina;
	private int proficiencia;

	
	public Disciplina(String nomeDisciplina, int proficiencia) {
		if (nomeDisciplina == null || nomeDisciplina.trim().equals("")) {
			throw new NullPointerException();
		}
		else if (proficiencia < 1 || proficiencia > 5) {
			throw new TutorException(new NumeroForaDosLimitesException("eh"));
		}
		this.disciplina = nomeDisciplina;
		this.proficiencia = proficiencia;
	}

	
	public String getID() {
		return this.disciplina;
	}

	
	public int getProficiencia() {
		return this.proficiencia;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disciplina == null) ? 0 : disciplina.hashCode());
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
		Disciplina other = (Disciplina) obj;
		if (disciplina == null) {
			if (other.disciplina != null)
				return false;
		} else if (!disciplina.equals(other.disciplina))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return this.disciplina + " - " + this.proficiencia;
	}

}
