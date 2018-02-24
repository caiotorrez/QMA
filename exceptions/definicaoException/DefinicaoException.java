package definicaoException;

public class DefinicaoException extends RuntimeException {
	
	
	public DefinicaoException(String tipo, String causa) {
		super("Erro na definicao de " + tipo + ": " + causa);
	}

}
