package cadastroExceptions;

public class CadastroException extends RuntimeException {
	
	public CadastroException(String tipo) {
		super("Erro no cadastro de " + tipo + ":");
	}

	public CadastroException(String tipo, String causa) {
		super("Erro no cadastro de " + tipo + ": " + causa);
	}
}
