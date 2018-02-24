package cadastroExceptions;

public class NullOuEmBrancoException extends CadastroException {
	
	public NullOuEmBrancoException(String tipo) {
		super(tipo, "Nome nao pode ser vazio ou nulo");
	}
	
	public NullOuEmBrancoException(String tipo, String tipo2) {
		super(tipo, tipo2 + " nao pode ser vazio ou nulo");
	}

}
