/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - UFCG
 * LABORATORIO DE PROGRAMACAO 2
 * ALUNOS - CAIO TORRES - FRANCIVALDO CABRAL - LUAN CARLOS
 * MATRICULAS -  -  - 116.110.100
 * PROJETO FINAL - QUEM ME AJUDA
 */
package tutor;

import definicaoException.NumeroForaDosLimitesException;

/**
 * Classe Disciplina
 * @author 
 * @version 1.0
 */
public class Disciplina {

	private String nomeDisciplina;
	private int proficiencia;

	/**
	 * Construtor de Disciplina
	 * @param nomeDisciplina, String com o nome da Disciplina
	 * @param proficiencia, Inteiro com o valor da Habilidade do tutor responsavel pela Disciplina
	 * @exception Sera lancada quando algum parametro invalido for passado para o mesmo
	 * @throws NullPointerException
	 * @throws NumeroForaDosLimitesException
	 */
	public Disciplina(String nomeDisciplina, int proficiencia)throws Exception {
		if (nomeDisciplina == null || nomeDisciplina.trim().equals("")) {
			throw new NullPointerException();
		}
		else if (proficiencia < 1 || proficiencia > 5) {
			throw new NumeroForaDosLimitesException("Proficiencia invalida");
		}
		this.nomeDisciplina = nomeDisciplina;
		this.proficiencia = proficiencia;
	}

	/**
	 * Retorna o nome da Disciplina
	 * @return String
	 */
	public String getID() {
		return nomeDisciplina;
	}

	/**
	 * Retorna o valor da Proficiencia
	 * @return
	 */
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

	/**
	 * Representacao Textual da Disciplina
	 * @return String
	 */
	@Override
	public String toString() {
		return this.nomeDisciplina + " - " + this.proficiencia;
	}

}
