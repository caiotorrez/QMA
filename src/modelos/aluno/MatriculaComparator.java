package modelos.aluno;

import java.util.Comparator;


public class MatriculaComparator implements Comparator<Aluno> {
	
	@Override
	public int compare(Aluno aluno, Aluno outroAluno) {
		return aluno.getMatricula().compareTo(outroAluno.getMatricula());
	}
}
	