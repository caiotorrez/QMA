package tutor;

import definicaoException.NumeroForaDosLimitesException;

public class Disciplina {

	private String nomeDisciplina;
	private int proficiencia;

	public Disciplina(String nomeDisciplina, int proficiencia) {
		if (nomeDisciplina == null || nomeDisciplina.trim().equals("")) {
			throw new NullPointerException();
		}
		else if (proficiencia < 1 || proficiencia > 5) {
			throw new NumeroForaDosLimitesException("Proficiencia invalida");
		}
		this.nomeDisciplina = nomeDisciplina;
		this.proficiencia = proficiencia;
	}

	public String getID() {
		return nomeDisciplina;
	}

	public int getProficiencia() {
		return proficiencia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeDisciplina == null) ? 0 : nomeDisciplina.hashCode());
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
		if (nomeDisciplina == null) {
			if (other.nomeDisciplina != null)
				return false;
		} else if (!nomeDisciplina.equals(other.nomeDisciplina))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.nomeDisciplina + " - " + this.proficiencia;
	}

}
