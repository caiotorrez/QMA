package servicos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import modelos.aluno.Aluno;
import modelos.aluno.EmailComparator;
import modelos.aluno.MatriculaComparator;

public class ServiceAluno {
	
	private Map<String, Aluno> alunos;
	private String atributoDeOrdenacao;
	
	
	public ServiceAluno() {
		this.alunos = new HashMap<>();
		this.atributoDeOrdenacao = "nome";
	}
	
	public void addAluno(Aluno aluno) {
		this.alunos.put(aluno.getMatricula(), aluno);
	}

	public String toStringAluno(String matricula) {
		return this.alunos.get(matricula).toString();
	}

	public String getAllAlunos() {
		List<Aluno> alunos = new ArrayList<>(this.alunos.values());
		Collections.sort(alunos);
		String saida = Arrays.toString(alunos.toArray());
		return saida.equals("") ? "Nao ha alunos cadastrados" : saida.substring(1, saida.length() - 1);
	}
	
	public String getInfoAluno(String matricula, String atributo) {
		switch(atributo.toLowerCase()) {
		case "nome" :
			return this.alunos.get(matricula).getNome();
		case "matricula" :
			return this.alunos.get(matricula).getMatricula();
		case "codigoCurso" :
			return String.valueOf(this.alunos.get(matricula).getCodigoDoCurso());
		case "telefone" :
			return this.alunos.get(matricula).getTelefone();
		case "email" :
			return this.alunos.get(matricula).getEmail();
		default:
			return "Nao existe essa informacao.";
		}
	}
	
	public boolean containsAluno(String matricula) {
		return this.alunos.containsKey(matricula);
	}
	
	public String getMatricula(String email) {
		for (String matricula : this.alunos.keySet()) {
			if (this.alunos.get(matricula).getEmail().equals(email)) {
				return matricula;
			}
		} return null;
	}
	
	public String ordenacaoPersonalizada(Set<String> matriculas) {
		
		List<Aluno> lista = new ArrayList<>();
		for (String matricula : matriculas) {
			lista.add(this.alunos.get(matricula));
		}
		
		if (this.atributoDeOrdenacao.equals("nome")) {
			Collections.sort(lista);
		}
		else if (this.atributoDeOrdenacao.equals("email")) {
			Collections.sort(lista, new EmailComparator());
		}
		else if (this.atributoDeOrdenacao.equals("matricula")) {
			Collections.sort(lista, new MatriculaComparator());
		}
		String saida = Arrays.toString(lista.toArray());
		return saida.substring(1, saida.length() - 1);
	}
	
	public void setOrdem(String atributo) {
		this.atributoDeOrdenacao = atributo;
	}
}
