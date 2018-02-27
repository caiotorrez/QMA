/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - UFCG
 * LABORATORIO DE PROGRAMACAO 2
 * ALUNOS - CAIO TORRES - FRANCIVALDO CABRAL - LUAN CARLOS
 * MATRICULAS -  -  - 116.110.100
 * PROJETO FINAL - QUEM ME AJUDA
 */
package alunos;

import cadastroExceptions.EmailInvalidoException;
import cadastroExceptions.NullOuEmBrancoException;

/**
 * CLASSE ALUNO, COMPORTA O OBJETO ALUNO
 * @author Caio Torres
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
	 * @version 1.0
	 * @author Caio Torres
	 * @version 1.1
	 * @author Luan Carlos
	 */
	private void checkCadastro(String nome, String matricula, int codigoDoCurso, String telefone, String email) throws Exception {
		if (nome == null || nome.trim().equals("")) 
			throw new NullOuEmBrancoException("Erro no cadastro de aluno: Nome nao pode ser vazio ou nulo");		
		if (matricula == null || matricula.trim().equals(""))
			throw new NullOuEmBrancoException("Erro no cadastro de aluno: Nome nao pode ser vazio ou nulo");
		if (email == null || email.trim().equals(""))
			throw new NullOuEmBrancoException("Erro no cadastro de aluno: Nome nao pode ser vazio ou nulo");
		validaEmail(email);
	}
	
	/**
	 * Irá validar o Email que sera passado como parametro pra criacao do Aluno
	 *
	 * @param email,
	 *            String com o email que sera verificado
	 * @throws EmailInvalidoException
	 * @version 1.0
	 * @author Caio Torres
	 * @version 1.1
	 * @author Luan Carlos
	 */
	private void validaEmail(String email) throws Exception {
		// checa o primeiro e o ultimo char se tem '@' se nao tiver checa se tem '@' em
		// algum lugar do email.
		if (email.charAt(0) == '@' || email.charAt(email.length() - 1) == '@' || !email.contains("@")) 
			throw new EmailInvalidoException("aluno");
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
	 * @version 1.0
	 * @author Caio Torres
	 * @version 1.1
	 * @author Luan Carlos
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
