package classePrincipal;

import java.util.HashMap;
import java.util.Map;

import alunos.Aluno;
import alunos.InfoAluno;

public class Controller {
	
	private Map<String, Aluno> alunos;
	
	public void inicializar() {
		this.alunos = new HashMap<>();
	}
	
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		this.alunos.put(matricula, new Aluno(nome, matricula, codigoCurso, telefone,  email));
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
		return this.alunos.get(matricula).
		
	}
	
	
	

}
