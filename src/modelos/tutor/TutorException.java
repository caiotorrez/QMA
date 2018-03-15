/**
 * UFCG - Universidade Federal de Campina Grande
 * LP2 - Laboratorio de Programacao 2 - Projeto Final
 * Caio Vitor Brasileiro Torres – 116111245
 * Francivaldo Cabral de Andrade – 116111544
 * Luan Carlos da Silva Bezerra - 116110100
 */
package modelos.tutor;
/**
 * Classe TutorException, contem Excecoes usadas no ambito de Tutor
 * @author Caio Torres
 * @version 1.4
 *
 */
@SuppressWarnings("serial")
public class TutorException extends RuntimeException {
    
    public TutorException() {
        super();
    }
    
    public TutorException(RuntimeException re) {
        super(re);
    }
    
    public TutorException(String msg) {
        super(msg);
    }
}