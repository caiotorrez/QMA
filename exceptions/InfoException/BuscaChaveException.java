package InfoException;

public class BuscaChaveException extends RuntimeException {
	
	public BuscaChaveException(String tipo) {
		super("Erro na busca por " + tipo.toLowerCase() + ": " + tipo + " nao encontrado" );
	}

}
