package cadastroExceptions;

public class CadastroException extends RuntimeException {
	
	public CadastroException(String msg) {
		super(msg);
	}

	public CadastroException(String tipo, String causa) {
		super("Erro no cadastro de " + tipo + ": " + causa);
	}
	

}
