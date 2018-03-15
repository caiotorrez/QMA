/**
 * UFCG - Universidade Federal de Campina Grande
 * LP2 - Laboratorio de Programacao 2 - Projeto Final
 * Caio Vitor Brasileiro Torres – 116111245
 * Francivaldo Cabral de Andrade – 116111544
 * Luan Carlos da Silva Bezerra - 116110100
 */
package modelos.caixaSistema;

/**
 * Classe {@link CaixaException}, contem excecoes usadas no ambito do {@link CaixaSistema}
 * @author Caio Torres
 * @version 1.1
 *
 */
@SuppressWarnings("serial")
public class CaixaException extends RuntimeException {
	
	public CaixaException() {
		super();
	}
	
	public CaixaException(String msg) {
		super(msg);
	}
	
	public CaixaException(RuntimeException erro) {
		super(erro);
	}
}
