/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - UFCG
 * LABORATORIO DE PROGRAMACAO 2
 * ALUNOS - CAIO TORRES - FRANCIVALDO CABRAL - LUAN CARLOS
 * MATRICULAS -  -  - 116.110.100
 * PROJETO FINAL - QUEM ME AJUDA
 */
package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import alunos.Aluno;
import cadastroExceptions.CadastroNaoEncontradoException;
import cadastroExceptions.EmailInvalidoException;
import cadastroExceptions.NullOuEmBrancoException;
import definicaoException.DefinicaoException;
import horarios.Horario;
import infoException.BuscaChaveException;
import infoException.InfoException;
import tutor.Disciplina;
import tutor.Tutor;

/**
 * Classe Controller, realiza as operacoes do Sistema
 * @author 
 * @version 1.0
 */
public class Controller {

	private Map<String, Aluno> alunos = new HashMap<>();
	private Map<String, Tutor> tutores = new HashMap<>();

	/**
	 * Ira validar o Email que sera passado como parametro pra criacao do Aluno
	 * @param email, String com o email que sera verificado
	 * @exception Sera lancada quando o Email passado nao for valido
	 * @throws EmailInvalidoException
	 */
	private void validaEmail(String email) throws Exception{
		// checa o primeiro e o ultimo char se tem '@' se nao tiver checa se tem '@' em algum lugar do email.
		if (email.charAt(0) == '@' || email.charAt(email.length() - 1) == '@' || !email.contains("@")) {
			throw new EmailInvalidoException("aluno");
		}
	}

	
// Alunos
	
	/**
	 * Cadastra um novo aluno
	 * @param nome, String com o nome do aluno
	 * @param matricula, String com a matricula do aluno
	 * @param codigoDoCurso, Inteiro com o codigo unico referente ao curso
	 * @param telefone, String com o numero de telefone do aluno
	 * @param email, String com o email do aluno
	 * @exception Sera lancado quando algum parametro for passado incorretamente 
	 * @throws NullPointerException
	 * @throws EmailInvalidoException
	 */
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) throws Exception {
		this.validaEmail(email);
		if (alunos.containsKey(matricula)) {
			throw new NullPointerException("Erro no cadastro de aluno: Aluno de mesma matricula ja cadastrado");
		}
		this.alunos.put(matricula, new Aluno(nome, matricula, codigoCurso, telefone, email));
	}

	/**
	 * Retorna a representacao textual de um Aluno
	 * @param matricula, String que sera usada para busca o Aluno
	 * @return String
	 * @exception Sera lancada quando o aluno pesquisado nao estiver cadastrado
	 * @throws BuscaChaveException
	 */
	public String recuperaAluno(String matricula)throws BuscaChaveException {
		try {
			return this.alunos.get(matricula).toString();
		} catch (NullPointerException npe) {
			throw new BuscaChaveException("Aluno");
		}
	}

	/**
	 * Retorna todos os alunos cadastrados
	 * @return String
	 */
	public String listarAlunos() {
		List<Aluno> alunos = new ArrayList<>(this.alunos.values());
		Collections.sort(alunos);
		String saida = Arrays.toString(alunos.toArray());
		return saida.equals("") ? "Nao ha alunos cadastrados" : saida.substring(1, saida.length() - 1);
	}

	/**
	 * Retorna um atributo especifico do Aluno
	 * @param matricula, String com a matricula que identifica o Aluno
	 * @param atributo, String com o atributo do Aluno pesquisado
	 * @return String
	 * @exception Sera lancada quando o Aluno pesquisado nao estiver matriculado
	 * @throws InfoException
	 */
	public String getInfoAluno(String matricula, String atributo)throws InfoException {
		if (!this.alunos.containsKey(matricula)) {
			throw new InfoException("Aluno");
		}
		// Isso aqui ta um cabare, precisamos de um monitor
		if (atributo.equalsIgnoreCase("nome")) {
			return this.alunos.get(matricula).getNome();
		} else if (atributo.equalsIgnoreCase("matricula")) {
			return this.alunos.get(matricula).getMatricula();
		} else if (atributo.equalsIgnoreCase("codigoCurso")) {
			return String.valueOf(this.alunos.get(matricula).getCodigoDoCurso());
		} else if (atributo.equalsIgnoreCase("telefone")) {
			return this.alunos.get(matricula).getTelefone();
		} else if (atributo.equalsIgnoreCase("email")) {
			return this.alunos.get(matricula).getEmail();
		} else {
			return null;
		}
	}

// Tutores
	
	/**
	 * Modifica o status de um Aluno especifico, para Tutor em alguma disciplina
	 * @param matricula, String com a matricula que identifica o Aluno
	 * @param disciplina, String com a disciplina que o Aluno sera tutor
	 * @param proficiencia, Inteiro valor atribuido para a habilidade do Aluno da disciplina
	 * @throws Exception 
	 * @exception Sera lancada quando o Aluno pesquisado nao estiver cadastrado
	 */
	public void tornarTutor(String matricula, String disciplina, int proficiencia)throws Exception {
		if (!this.alunos.containsKey(matricula)) {
			throw new DefinicaoException("papel", "Tutor nao encontrado");
		}
		
		if (this.tutores.containsKey(matricula)) {
			this.tutores.get(matricula).addDisciplina(new Disciplina(disciplina, proficiencia));
		} else {
			this.tutores.put(matricula, new Tutor(this.alunos.get(matricula), new Disciplina(disciplina, proficiencia)));
		}
	}

	/**
	 * Retorna a representacao textual de um Tutor
	 * @param matricula, String com o identificador unico do Tutor
	 * @return String
	 * @exception Sera lancada caso o aluno/Tutor nao esteja cadastrado
	 * @throws BuscaChaveException
	 */
	public String recuperaTutor(String matricula)throws BuscaChaveException {
		if (!this.tutores.containsKey(matricula)) {
			throw new BuscaChaveException("Tutor");
		} else { 
			return this.tutores.get(matricula).toString();
		}
	}

	/**
	 * Retorna a representacao textual dos Tutores cadastrados
	 * @return String
	 */
	public String listarTutores() {
		List<Tutor> tutores = new ArrayList<>(this.tutores.values());
		Collections.sort(tutores);
		String saida = Arrays.toString(tutores.toArray());
		return saida.equals("") ? "Nao ha tutores cadastrados" : saida.substring(1, saida.length() - 1);
	}
	

// Horarios e Locais
	
	/**
	 * Verifica se o email do Tutor ja foi cadastrado
	 * @param email, String com o email pesquisado
	 * @return String
	 */
	private String checkContemEmailTutor(String email) {
		for (String key : this.tutores.keySet()) {
			if (this.tutores.get(key).contemEmail(email)) {
				return key;
			}
		} return null;
	}
	
	/**
	 * Cadastra um novo horario de atendimento
	 * @param email, String com o email do Tutor
	 * @param horario, String com o horario disponivel
	 * @param dia, String com o dia do atendimento
	 * @exception Sera lancada caso o Tutor nao esteja cadastrado
	 * @throws CadastroNaoEncontradoException
	 */
	public void cadastrarHorario(String email, String horario, String dia)throws CadastroNaoEncontradoException {
		try {
			this.tutores.get(this.checkContemEmailTutor(email)).addHorario(new Horario(email, horario, dia));
		}
		catch (NullPointerException npe) {
			throw new CadastroNaoEncontradoException("Erro no cadastrar horario: tutor nao cadastrado");
		}
	}
	
	/**
	 * Cadastra o Local que sera realizado o atendimento
	 * @param email, String com o email do Tutor 
	 * @param local, String com o local do atendimento
	 * @exception Sera lancada se o tutor nao estiver cadastrado, ou algum parametro nao for passado corretamente
	 * @throws NullOuEmBrancoException
	 * @throws CadastroNaoEncontradoException
	 */
	public void cadastrarLocalDeAtendimento(String email, String local)throws Exception {
		try {
			this.tutores.get(this.checkContemEmailTutor(email)).addLocal(email, local);
		}
		catch (NullPointerException npe) {
			if (email == null || email.trim().equals("")) {
				throw new NullOuEmBrancoException("Erro no cadastrar local de atendimento: email nao pode ser vazio ou em branco");
			}
			throw new CadastroNaoEncontradoException("Erro no cadastrar local de atendimento: tutor nao cadastrado");
		}
	}
	
	/**
	 * Verifica se o horario/dia requerido para um novo atendimento esta disponivel
	 * @param email, String com o email do Tutor
	 * @param horario, String com o horario requerido para o novo atendimento
	 * @param dia, String com o dia requerido para o novo atendimento
	 * @return boolean
	 */
	public boolean consultaHorario(String email, String horario, String dia) {
		try {
			return this.tutores.get(checkContemEmailTutor(email)).contemHorario(new Horario(email, horario, dia));
		} catch (NullPointerException npe) {
			return false;
		}
	}

	/**
	 * Verifica se o local requerido para um novo atendimento esta disponivel
	 * @param email, String com o email do Tutor
	 * @param local, String com o local requerido para o novo atendimento
	 * @return boolean
	 */
	public boolean consultaLocal(String email, String local) {
		try {
			return this.tutores.get(checkContemEmailTutor(email)).contemLocal(local);
		} catch (NullPointerException npe) {
			return false;
		}
	}
}
