package horarios;

import cadastroExceptions.NullOuEmBrancoException;

public class Horario {
	
	private String email;
	private String dia;
	private String horario;
	
	public void checkCadastro(String email, String horario, String dia) {
		if (email == null || email.trim().equals("")) {
			throw new NullOuEmBrancoException("Erro no cadastrar horario: email nao pode ser vazio ou em branco");
		}
		else if (dia == null || dia.trim().equals("")) {
			throw new NullOuEmBrancoException("Erro no cadastrar horario: dia nao pode ser vazio ou em branco");
		}
		
		else if (horario == null || horario.trim().equals("")) {
			throw new NullOuEmBrancoException("Erro no cadastrar horario: horario nao pode ser vazio ou em branco");
		}
	}
	
	public Horario(String email, String horario, String dia) {
		this.checkCadastro(email, horario, dia);
		this.email = email;
		this.dia = dia;
		this.horario = horario;
	}
	
	public String getEmail() {
		return email;
	}

	public String getDia() {
		return dia;
	}

	public String getHorario() {
		return horario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dia == null) ? 0 : dia.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((horario == null) ? 0 : horario.hashCode());
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
		Horario other = (Horario) obj;
		if (dia == null) {
			if (other.dia != null)
				return false;
		} else if (!dia.equals(other.dia))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (horario == null) {
			if (other.horario != null)
				return false;
		} else if (!horario.equals(other.horario))
			return false;
		return true;
	}


}
