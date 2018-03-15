/**
 * UFCG - Universidade Federal de Campina Grande
 * LP2 - Laboratorio de Programacao 2 - Projeto Final
 * Caio Vitor Brasileiro Torres - 116111245
 * Francivaldo Cabral de Andrade - 116111544
 * Luan Carlos da Silva Bezerra - 116110100
 */
package modelos.ajuda;

/**
 * Classe {@link AjudaException}, contem Excecoes usadas no ambito de {@link Ajuda}
 * @author Caio Torres
 * @version 1.1
 *
 */
@SuppressWarnings("serial")
public class AjudaException extends RuntimeException {
    
    public AjudaException() {
        super();
    }
    public AjudaException(String msg) {
        super(msg);
    }
    
    public AjudaException(RuntimeException erro) {
        super(erro);
    }
}