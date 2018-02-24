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

public class Controller {

	private Map<String, Aluno> alunos = new HashMap<>();
	private Map<String, Tutor> tutores = new HashMap<>();

	private void validaEmail(String email) {
		// checa o primeiro e o ultimo char se tem '@' se nao tiver checa se tem '@' em algum lugar do email.
		if (email.charAt(0) == '@' || email.charAt(email.length() - 1) == '@' || !email.contains("@")) {
			throw new EmailInvalidoException("aluno");
		}
	}

	
// Alunos
	
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
		List<Aluno> alunos = new ArrayList<>(this.alunos.values());
		Collections.sort(alunos);
		String saida = Arrays.toString(alunos.toArray());
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

// Tutores
	
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
		List<Tutor> tutores = new ArrayList<>(this.tutores.values());
		Collections.sort(tutores);
		String saida = Arrays.toString(tutores.toArray());
		return saida.equals("") ? "Nao ha tutores cadastrados" : saida.substring(1, saida.length() - 1);
	}
	

// Horarios e Locais
	
	private String checkContemEmailTutor(String email) {
		for (String key : this.tutores.keySet()) {
			if (this.tutores.get(key).contemEmail(email)) {
				return key;
			}
		} return null;
	}
	
	public void cadastrarHorario(String email, String horario, String dia) {
		try {
			this.tutores.get(this.checkContemEmailTutor(email)).addHorario(new Horario(email, horario, dia));
		}
		catch (NullPointerException npe) {
			throw new CadastroNaoEncontradoException("Erro no cadastrar horario: tutor nao cadastrado");
		}
	}
	
	public void cadastrarLocalDeAtendimento(String email, String local) {
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
	
	public boolean consultaHorario(String email, String horario, String dia) {
		try {
			return this.tutores.get(checkContemEmailTutor(email)).contemHorario(new Horario(email, horario, dia));
		} catch (NullPointerException npe) {
			return false;
		}
	}

	public boolean consultaLocal(String email, String local) {
		try {
			return this.tutores.get(checkContemEmailTutor(email)).contemLocal(local);
		} catch (NullPointerException npe) {
			return false;
		}
	}
}
