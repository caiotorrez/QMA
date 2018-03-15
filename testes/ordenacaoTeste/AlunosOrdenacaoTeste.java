package ordenacaoTeste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import modelos.aluno.Aluno;
import modelos.aluno.EmailComparator;
import modelos.aluno.MatriculaComparator;

public class AlunosOrdenacaoTeste {

	
	
	public List<Aluno> alunos = new ArrayList<>();
	
	@Test
	public void testOrdenacaoNatural() {
		System.out.println("################NOME#####################");
		this.alunos.add(new Aluno("b", "1", 111, "", "bbb@aaaa.com"));
		this.alunos.add(new Aluno("d", "2", 111, "", "ddd@aaaa.com"));
		this.alunos.add(new Aluno("a", "3", 111, "", "aaa@aaaa.com"));
		this.alunos.add(new Aluno("e", "4", 111, "", "eee@aaaa.com"));
		this.alunos.add(new Aluno("c", "5", 111, "", "ccc@aaaa.com"));
		
		Collections.sort(this.alunos);
		for (Aluno aluno : alunos) {
			System.out.println(aluno.toString());
		}

	}
	
	@Test
	public void testOrdenacaoEmail() {
		System.out.println("################EMAIL#####################");
		this.alunos.add(new Aluno("x", "1", 111, "", "bbb@aaaa.com"));
		this.alunos.add(new Aluno("z", "2", 111, "", "ddd@aaaa.com"));
		this.alunos.add(new Aluno("ww", "3", 111, "", "aaa@aaaa.com"));
		this.alunos.add(new Aluno("a", "4", 111, "", "eee@aaaa.com"));
		this.alunos.add(new Aluno("ze", "5", 111, "", "ccc@aaaa.com"));
		
		Collections.sort(this.alunos, new EmailComparator());
		for (Aluno aluno : alunos) {
			System.out.println(aluno.toString());
		}
	}

	@Test
	public void testOrdenacaoMatricula() {
		System.out.println("################MATRICULA#####################");
		this.alunos.add(new Aluno("x", "1", 111, "", "bbb@aaaa.com"));
		this.alunos.add(new Aluno("z", "2", 111, "", "ddd@aaaa.com"));
		this.alunos.add(new Aluno("ww", "3", 111, "", "aaa@aaaa.com"));
		this.alunos.add(new Aluno("a", "4", 111, "", "eee@aaaa.com"));
		this.alunos.add(new Aluno("ze", "5", 111, "", "ccc@aaaa.com"));
		
		Collections.sort(this.alunos, new MatriculaComparator());
		for (Aluno aluno : alunos) {
			System.out.println(aluno.toString());
		}
	}

}
