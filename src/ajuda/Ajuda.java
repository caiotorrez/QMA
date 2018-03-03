package ajuda;

public abstract class Ajuda {
	
	
	private String disciplina;
	private String matriculaAluno;
	private String matriculaTutor;
	
	
	public Ajuda(String matrAluno, String disciplina) {
		this.matriculaAluno = matrAluno;
		this.disciplina = disciplina;
	}
	
	public void setMatriculaTutor(String matriculaTutor) {
		this.matriculaTutor = matriculaTutor;
	}

	public String getMatriculaTutor() {
		return this.matriculaTutor;
		
	}
	
	public String getDisciplina() {
		return this.disciplina;
	}
	
	public String getMatriculaAluno() {
		return this.matriculaAluno;
	}
	
	@Override
	public String toString() {
		return "Tutor - " + this.matriculaTutor +", disciplina- " + this.disciplina;
	}
}
