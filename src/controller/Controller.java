package controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import InfoException.BuscaChaveException;
import InfoException.InfoException;
import alunos.Aluno;
import cadastroExceptions.EmailInvalidoException;
import definicaoException.DefinicaoException;
import tutor.Disciplina;
import tutor.Tutor;

public class Controller {

	private Map<String, Aluno> alunos = new TreeMap<>(Collections.reverseOrder());
	private Map<String, Tutor> tutores = new TreeMap<>(Collections.reverseOrder());

	private void validaEmail(String email) {
		// checa o primeiro e o ultimo char se tem '@' se nao tiver checa se tem '@' em algum lugar do email.
		if (email.charAt(0) == '@' || email.charAt(email.length() - 1) == '@' || !email.contains("@")) {
			throw new EmailInvalidoException("aluno");
		}
	}

	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		this.validaEmail(email);
		if (alunos.containsKey(matricula)) {
			throw new NullPointerException("Erro no cadastro de aluno: Aluno de mesma matricula ja cadastrado");
		}
		this.alunos.put(matricula, new Aluno(nome, matricula, codigoCurso, telefone, email));
	}

	public String recuperaAluno(String matricula) {
		try {
			return this.alunos.get(matricula).toString();
		} catch (NullPointerException npe) {
			throw new BuscaChaveException("Aluno");
		}
	}

	public String listarAlunos() {
		String saida = Arrays.toString(this.alunos.values().toArray());
		return saida.equals("") ? "Nao ha alunos cadastrados" : saida.substring(1, saida.length() - 1);
	}

	public String getInfoAluno(String matricula, String atributo) {
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

	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		if (!this.alunos.containsKey(matricula)) {
			throw new DefinicaoException("papel", "Tutor nao encontrado");
		}
		
		if (this.tutores.containsKey(matricula)) {
			this.tutores.get(matricula).addDisciplina(new Disciplina(disciplina, proficiencia));
		} else {
			this.tutores.put(matricula, new Tutor(this.alunos.get(matricula), new Disciplina(disciplina, proficiencia)));
		}
			
	}

	public String recuperaTutor(String matricula) {
		if (!this.tutores.containsKey(matricula)) {
			throw new BuscaChaveException("Tutor");
		} else { 
			return this.tutores.get(matricula).toString();
		}
	}

	public String listarTutores() {
		String saida = Arrays.toString(this.tutores.values().toArray());
		return saida.equals("") ? "Nao ha tutores cadastrados" : saida.substring(1, saida.length() - 1);
	}
}
