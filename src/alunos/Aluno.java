/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - UFCG
 * LABORATORIO DE PROGRAMACAO 2
 * ALUNOS - CAIO TORRES - FRANCIVALDO CABRAL - LUAN CARLOS
 * MATRICULAS -  -  - 116.110.100
 * PROJETO FINAL - QUEM ME AJUDA
 */
package alunos;

import cadastroExceptions.NullOuEmBrancoException;

/**
 * CLASSE ALUNO, COMPORTA O OBJETO ALUNO
 * @author 
 * @version 1.0
 */
public class Aluno implements Comparable<Aluno> {

	private String nome;
	private String matricula;
	private int codigoCurso;
	private String telefone;
	private String email;

	/**
	 * checkCadastro
	 * Verifica os parametros que seram usados para a criacao do objeto Aluno
	 * @param nome, String com o nome do aluno
	 * @param matricula, String com a matricula do aluno
	 * @param codigoDoCurso, Inteiro com o codigo unico referente ao curso
	 * @param telefone, String com o numero de telefone do aluno
	 * @param email, String com o email do aluno
	 * @exception Sera lancado quando algum parametro for passado incorretamente 
	 * @throws NullOuEmBrancoException
	 */
	private void checkCadastro(String nome, String matricula, int codigoDoCurso, String telefone, String email) throws Exception {
		if (nome == null || nome.trim().equals("")) {
			throw new NullOuEmBrancoException("Erro no cadastro de aluno: Nome nao pode ser vazio ou nulo");
		}
	}
	
	/**
	 * Construtor do Objeto Aluno
	 * @param nome, String com o nome do aluno
	 * @param matricula, String com a matricula do aluno
	 * @param codigoDoCurso, Inteiro com o codigo unico referente ao curso
	 * @param telefone, String com o numero de telefone do aluno
	 * @param email, String com o email do aluno
	 * @exception Sera lancado quando algum parametro for passado incorretamente 
	 * @throws NullOuEmBrancoException
	 */
	public Aluno(String nome, String matricula, int codigoDoCurso, String telefone, String email) throws Exception {
		this.checkCadastro(nome, matricula, codigoDoCurso, telefone, email);
		this.nome = nome;
		this.matricula = matricula;
		this.codigoCurso = codigoDoCurso;
		this.telefone = telefone;
		this.email = email;
	}

	/**
	 * Retorna o nome do Aluno
	 * @return String
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Retorna a matricula do Aluno
	 * @return String
	 */
	public String getMatricula() {
		return this.matricula;
	}

	/**
	 * Retorna o codigo do curso que o Aluno esta cadastrado
	 * @return Inteiro
	 */
	public int getCodigoDoCurso() {
		return this.codigoCurso;
	}

	/**
	 * Retorna o Telefone do Aluno
	 * @return String
	 */
	public String getTelefone() {
		return this.telefone;
	}

	/**
	 * Retorna o Email do Aluno
	 * @return String
	 */
	public String getEmail() {
		return this.email;
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
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
	
	/**
	 * Implementa a forma de comparacao entre Alunos
	 * @return Inteiro
	 */
	@Override
	public int compareTo(Aluno outroAluno) {
		return this.nome.compareTo(outroAluno.nome);
	}
	
	/**
	 * Retorna a representacao textual do Aluno
	 * @return String
	 */
	@Override
	public String toString() {
		return this.telefone.equals("") ? 
				this.matricula + " - " + this.nome + " - " + this.codigoCurso + " - " + this.email : 
					this.matricula + " - " + this.nome + " - " + this.codigoCurso + " - " + this.telefone + " - " + this.email;
	}

}
