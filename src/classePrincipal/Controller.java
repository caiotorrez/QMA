package classePrincipal;

import java.util.HashMap;
import java.util.Map;

import alunos.Aluno;
import easyaccept.EasyAccept;
import tutor.Disciplina;
import tutor.Tutor;

public class Controller {
	

	private Map<String, Aluno> alunos = new HashMap<>();
	private Map<String, Tutor> tutores = new HashMap<>();

	
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		this.alunos.put(matricula, new Aluno(nome, matricula, codigoCurso, telefone, email));
	}

	public String recuperaAluno(String matricula) {
		return this.alunos.get(matricula).toString();
	}

	public String listarAlunos() {
		String saida = "";
		for (String matricula : this.alunos.keySet()) {
			saida += this.alunos.get(matricula).toString() + System.lineSeparator();
		}
		return saida.equals("") ? "Nao ha alunos cadastrados" : saida;
	}

	public String getInfoAluno(String matricula, String atributo) {
		return null;
	}
	
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		this.tutores.put(matricula, new Tutor(this.alunos.get(matricula), new Disciplina(disciplina, proficiencia)));
	}
	
	public String recuperaTutor(String matricula) {
		return this.tutores.get(matricula).toString();
	}
	
	public String listaTutores() {
		String saida = "";
		for (String matricula : this.tutores.keySet()) {
			saida += this.tutores.get(matricula).toString() + System.lineSeparator();
		}
		return saida.equals("") ? "Nao ha tutores cadastrados" : saida;
	}
	
	public static void main(String[] args) {
		args = new String[] { "classePrincipal.Controller", "testesAceitacao/us1_test.txt", "testesAceitacao/us2_test.txt" };
		EasyAccept.main(args);
	}

}
