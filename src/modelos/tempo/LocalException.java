/**
 * UFCG - Universidade Federal de Campina Grande
 * LP2 - Laboratorio de Programacao 2 - Projeto Final
 * Caio Vitor Brasileiro Torres – 116111245
 * Francivaldo Cabral de Andrade – 116111544
 * Luan Carlos da Silva Bezerra - 116110100
 */
package modelos.tempo;

/**
 * Classe LocalException, contem Excecoes usadas no ambito de {@link Tempo}
 * @author Caio Torres
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class LocalException extends RuntimeException {
	
	public LocalException() {
		super();
	}
	
	public LocalException(RuntimeException re) {
		super(re);
	}
	
	public LocalException(String msg) {
		super(msg);
	}
}
