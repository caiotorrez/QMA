package tutor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import alunos.Aluno;
import cadastroExceptions.NullOuEmBrancoException;
import definicaoException.DefinicaoException;
import horarios.Horario;

public class Tutor implements Comparable<Tutor> {
	
	
	private int notaAvaliacao;
	private int qtAvaliacoes;
	private double carteira;
	private Map<String, Horario> horarios;
	private Map<String, Disciplina> disciplinas;
	private List<String> locais;
	private Aluno aluno;
	
	
	public Tutor(Aluno aluno, Disciplina disciplina) {
		this.horarios = new HashMap<>();
		this.disciplinas = new HashMap<>();
		this.locais = new ArrayList<>();
		this.aluno = aluno;
		this.disciplinas.put(disciplina.getID(), disciplina);
	}
	
	public void addDisciplina(Disciplina disciplina) {
		if (this.disciplinas.containsKey(disciplina.getID())) {
			throw new DefinicaoException("papel", "Ja eh tutor dessa disciplina");
		} else {
			this.disciplinas.put(disciplina.getID(), disciplina);
		}
	}
	
	public String exibeDisciplina() {
		String saida = "";
		for(String matricula : this.disciplinas.keySet()) {
			saida += this.disciplinas.get(matricula).toString() + System.lineSeparator();
			
		} return saida;
	}
	
	private void checkCadastroLocao(String email, String local) {
		if (email == null || email.trim().equals("")) {
			throw new NullOuEmBrancoException("Erro no cadastrar local de atendimento: email nao pode ser vazio ou em branco");			
		}
		else if (local == null || local.trim().equals("")) {
			throw new NullOuEmBrancoException("Erro no cadastrar local de atendimento: local nao pode ser vazio ou em branco");
		}
	}
	public void addLocal(String email, String local) {
		this.checkCadastroLocao(email, local);
		this.locais.add(local);
	}
	
	public void addHorario(Horario horario) {
		this.horarios.put(horario.getDia(), horario);
	}
	
	public boolean contemLocal(String local) {
		return this.locais.contains(local);
	}
	
	public boolean contemHorario(Horario horario) {
		return this.horarios.containsValue(horario);
	}
	
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
	
	public String toString() {
		return aluno.toString();
	}

	@Override
	public int compareTo(Tutor outroTutor) {
		return this.aluno.compareTo(outroTutor.aluno);
	}
}
