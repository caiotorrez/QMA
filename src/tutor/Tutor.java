/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - UFCG
 * LABORATORIO DE PROGRAMACAO 2
 * ALUNOS - CAIO TORRES - FRANCIVALDO CABRAL - LUAN CARLOS
 * MATRICULAS -  -  - 116.110.100
 * PROJETO FINAL - QUEM ME AJUDA
 */
package tutor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import alunos.Aluno;
import cadastroExceptions.NullOuEmBrancoException;
import definicaoException.DefinicaoException;
import horarios.Horario;

/**
 * Classe Tutor
 * @author Caio Torres
 * @version 1.0
 */
public class Tutor implements Comparable<Tutor> {
	
	
	private int notaAvaliacao;
	private int qtAvaliacoes;
	private double carteira;
	private Map<String, Horario> horarios;
	private Map<String, Disciplina> disciplinas;
	private List<String> locais;
	private Aluno aluno;
	
	/**
	 * Construtor do Tutor
	 * @param aluno, String com o nome do Tutor
	 * @param disciplina, Disciplina referente a disciplina que o Tutor e responsavel
	 */
	public Tutor(Aluno aluno, Disciplina disciplina) {
		this.horarios = new HashMap<>();
		this.disciplinas = new HashMap<>();
		this.locais = new ArrayList<>();
		this.aluno = aluno;
		this.disciplinas.put(disciplina.getID(), disciplina);
	}
	
	/**
	 * Adiciona uma disciplina ao leque de responsabilidade do Tutor
	 * @param disciplina, Disciplina que sera adicionada a Colecao de Disciplinas do Tutor
	 * @exception Sera lancada quando a nova disciplina ja estiver na colecao de Disciplinas do Tutor
	 * @throws DefinicaoException
	 */
	public void addDisciplina(Disciplina disciplina)throws DefinicaoException {
		if (this.disciplinas.containsKey(disciplina.getID())) {
			throw new DefinicaoException("papel", "Ja eh tutor dessa disciplina");
		} else {
			this.disciplinas.put(disciplina.getID(), disciplina);
		}
	}
	
	/**
	 * Retorna a reprensacao textutal da colecao de Disciplinas do Tutor
	 * @return String
	 */
	public String exibeDisciplina() {
		String saida = "";
		for(String matricula : this.disciplinas.keySet()) {
			saida += this.disciplinas.get(matricula).toString() + System.lineSeparator();
			
		} return saida;
	}
	
	/**
	 * Verifica se o Local para atendimento e valido e esta disponivel
	 * @param email, String com o email do tutor responsavel
	 * @param local, String com o local para o Atendimento
	 * @exception Sera lancada quando o nome do local for invalido ou o local estiver indisponivel
	 * @throws NullOuEmBrancoException
	 */
	private void checkCadastroLocal(String email, String local)throws NullOuEmBrancoException {
		if (email == null || email.trim().equals("")) {
			throw new NullOuEmBrancoException("Erro no cadastrar local de atendimento: email nao pode ser vazio ou em branco");			
		}
		else if (local == null || local.trim().equals("")) {
			throw new NullOuEmBrancoException("Erro no cadastrar local de atendimento: local nao pode ser vazio ou em branco");
		}
	}
	
	/**
	 * Adiciona um local de atendimento a colecao referente aos locais do Tutor
	 * @param email, String com o email do tutor responsavel
	 * @param local, String com o nome do local
	 */
	public void addLocal(String email, String local) {
		this.checkCadastroLocal(email, local);
		this.locais.add(local);
	}
	
	/**
	 * Adiciona um horario de atendimento a colecao de atendimentos do Tutor
	 * @param horario, Horario para atendimento
	 */
	public void addHorario(Horario horario) {
		this.horarios.put(horario.getDia(), horario);
	}
	
	/**
	 * Verifica se o local esta cadastrado a colecao de locais do Tutor
	 * @param local, String com o nome do local pesquisado
	 * @return boolean
	 */
	public boolean contemLocal(String local) {
		return this.locais.contains(local);
	}
	
	/**
	 * Verifica se o horario esta cadastrado a colecao de horarios do Tutor
	 * @param horario, Horario que esta sendo pesquisado
	 * @return boolean
	 */
	public boolean contemHorario(Horario horario) {
		return this.horarios.containsValue(horario);
	}
	
	/**
	 * Verifica se o Email do tutor esta cadastrado na colecao de alunos cadastrados
	 * @param email, String com o email do tutor pesquisado
	 * @return boolean
	 */
	public boolean contemEmail(String email) {
		return this.aluno.getEmail().equals(email);
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
	
	/**
	 * Representacao Textual do Tutor
	 * @return String
	 */
	public String toString() {
		return aluno.toString();
	}

	/**
	 * Forma de comparacao entre tutores
	 * @return Inteiro
	 */
	@Override
	public int compareTo(Tutor outroTutor) {
		return this.aluno.compareTo(outroTutor.aluno);
	}
}
