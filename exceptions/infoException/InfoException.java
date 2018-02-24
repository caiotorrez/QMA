package infoException;

public class InfoException extends RuntimeException {

	public InfoException(String tipo) {
		super("Erro na obtencao de informacao de " + tipo.toLowerCase() + ": " + tipo + " nao encontrado");
	}

	public InfoException(String tipo, String causa) {
		super("Erro na obtencao de informacao de " + tipo.toLowerCase() + ": " + causa);
	}

}
