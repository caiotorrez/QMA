/**
 * UFCG - Universidade Federal de Campina Grande
 * LP2 - Laboratorio de Programacao 2 - Projeto Final
 * Caio Vitor Brasileiro Torres - 116111245
 * Francivaldo Cabral de Andrade - 116111544
 * Luan Carlos da Silva Bezerra - 116110100
 */
package modelos.ajuda;
/**
 * Classe {@link AjudaOnline}Online, herda caracteristicas de {@link Ajuda}
 * @author Caio
 * @version 1.2
 */
@SuppressWarnings("serial")
public class AjudaOnline extends Ajuda {
    /**
     * Construtor de AjudaOnline
     * @param matricula, String
     * @param disciplina, String
     */
    public AjudaOnline(String matricula, String disciplina) {
        super(matricula, disciplina);
    }
    
}