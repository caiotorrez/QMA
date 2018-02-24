package cadastroExceptions;

public class NullOuEmBrancoException extends CadastroException {
	
	public NullOuEmBrancoException(String msg) {
		super(msg);
	}
	
	public NullOuEmBrancoException(String tipo, String tipo2) {
		super(tipo, tipo2 + " nao pode ser vazio ou nulo");
	}

}
