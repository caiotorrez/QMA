package cadastroExceptions;

public class EmailInvalidoException extends CadastroException {
	
	public EmailInvalidoException(String tipo) {
		super(tipo, "Email invalido");
	}

}
