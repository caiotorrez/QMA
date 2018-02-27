/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - UFCG
 * LABORATORIO DE PROGRAMACAO 2
 * ALUNOS - CAIO TORRES - FRANCIVALDO CABRAL - LUAN CARLOS
 * MATRICULAS -  -  - 116.110.100
 * PROJETO FINAL - QUEM ME AJUDA
 */
package horarios;

import cadastroExceptions.NullOuEmBrancoException;

/**
 * Classe horario
 * @author Caio Torres
 * @version 1.0
 */
public class Horario {

	private String email;
	private String dia;
	private String horario;

	/**
	 * Verifica os parametros de criacao do Objeto Horario
	 * 
	 * @param email,
	 *            String com o email do tutor responsavel
	 * @param horario,
	 *            String com o horario para o atendimento
	 * @param dia,
	 *            String com dia para o atendimento
	 * @exception Sera
	 *                lancada quando algum parametro for passado como nulo ou vazio
	 * @throws NullOuEmBrancoException
	 */
	public void checkCadastro(String email, String horario, String dia) throws NullOuEmBrancoException {
		if (email == null || email.trim().equals("")) {
			throw new NullOuEmBrancoException("Erro no cadastrar horario: email nao pode ser vazio ou em branco");
		} else if (dia == null || dia.trim().equals("")) {
			throw new NullOuEmBrancoException("Erro no cadastrar horario: dia nao pode ser vazio ou em branco");
		} else if (horario == null || horario.trim().equals("")) {
			throw new NullOuEmBrancoException("Erro no cadastrar horario: horario nao pode ser vazio ou em branco");
		}
	}

	/**
	 * Construtor de Horario
	 * 
	 * @param email,
	 *            String com o email do tutor responsavel
	 * @param horario,
	 *            String com o horario para o atendimento
	 * @param dia,
	 *            String com dia para o atendimento
	 */
	public Horario(String email, String horario, String dia) {
		this.checkCadastro(email, horario, dia);
		this.email = email;
		this.dia = dia;
		this.horario = horario;
	}

	/**
	 * Retorna o email do Tutor responsavel pelo horario
	 * 
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Retorna o dia do Atendimento
	 * 
	 * @return String
	 */
	public String getDia() {
		return dia;
	}

	/**
	 * Retorna o horario do Atendimento
	 * 
	 * @return String
	 */
	public String getHorario() {
		return horario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dia == null) ? 0 : dia.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((horario == null) ? 0 : horario.hashCode());
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
		Horario other = (Horario) obj;
		if (dia == null) {
			if (other.dia != null)
				return false;
		} else if (!dia.equals(other.dia))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (horario == null) {
			if (other.horario != null)
				return false;
		} else if (!horario.equals(other.horario))
			return false;
		return true;
	}

	/**
	 * Retorna a representacao textual de Horario
	 * @version 1.0
	 * @author Luan Carlos
	 */
	public String toString(){
		return "Responsavel - "+this.email+" - Dia: "+this.dia+" - Hora: "+this.horario;
	}
}
