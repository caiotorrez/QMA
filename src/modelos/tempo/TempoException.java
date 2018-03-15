/**
 * UFCG - Universidade Federal de Campina Grande
 * LP2 - Laboratorio de Programacao 2 - Projeto Final
 * Caio Vitor Brasileiro Torres – 116111245
 * Francivaldo Cabral de Andrade – 116111544
 * Luan Carlos da Silva Bezerra - 116110100
 */
package modelos.tempo;
/**
 * Classe TempoException, contem Excecoes usadas no ambito de Horario
 * @author Caio Torres
 * @version 1.4
 *
 */
@SuppressWarnings("serial")
public class TempoException extends RuntimeException {
    
    public TempoException() {
        super();
    }
    
    public TempoException(String msg) {
        super(msg);
    }
    
    public TempoException(RuntimeException erro) {
        super(erro);
    }
}