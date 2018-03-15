/**
 * UFCG - Universidade Federal de Campina Grande
 * LP2 - Laboratorio de Programacao 2 - Projeto Final
 * Caio Vitor Brasileiro Torres - 116111245
 * Francivaldo Cabral de Andrade - 116111544
 * Luan Carlos da Silva Bezerra - 116110100
 */
package modelos.aluno;
/**
 * Classe AlunoException, contem Excecoes usadas no ambito de Aluno
 * @author Caio Torres
 * @version 1.1
 */
@SuppressWarnings("serial")
public class AlunoException extends RuntimeException {
    
    public AlunoException() {
        super();
    }
    
    public AlunoException(String msg) {
        super(msg);
    }
    
    public AlunoException(RuntimeException erro) {
        super(erro);
    }
}
