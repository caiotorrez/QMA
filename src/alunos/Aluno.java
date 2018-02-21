package alunos;

public class Aluno {
	
	private String nome;
	private String matricula;
	private int codigoCurso;
	private String telefone;
	private String email;
	

	
	public Aluno(String nome, String matricula, int codigoDoCurso, String telefone, String email) {
		this.nome = nome;
		this.matricula = matricula;
		this.codigoCurso = codigoDoCurso;
		this.telefone = telefone;
		this.email = email;
	}
	
	public Aluno(String nome, String matricula, int codigoDoCurso, String email) {
		this.nome = nome;
		this.matricula = matricula;
		this.codigoCurso = codigoDoCurso;
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}


	public String getMatricula() {
		return this.matricula;
	}


	public int getCodigoDoCurso() {
		return this.codigoCurso;
	}


	public String getTelefone() {
		return this.telefone;
	}


	public String getEmail() {
		return this.email;
	}

	
	@Override
	public String toString() {
		return this.telefone == null ? 
				this.matricula + " - " + this.nome + " - " + this.codigoCurso + " - " + this.email :
					this.matricula + " - " + this.nome + " - " + this.codigoCurso + " - " + this.telefone + " - " + this.email;
	}
	
	

}
