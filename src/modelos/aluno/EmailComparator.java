package modelos.aluno;

import java.util.Comparator;


public class EmailComparator implements Comparator<Aluno> {

	@Override
	public int compare(Aluno aluno, Aluno outroAluno) {
		int indice = aluno.getEmail().compareTo(outroAluno.getEmail());
		if (indice == 0) {
			return aluno.getMatricula().compareTo(outroAluno.getMatricula());
		}
		return indice;
	}

}
