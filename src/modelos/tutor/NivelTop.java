/**
 * UFCG - Universidade Federal de Campina Grande
 * LP2 - Laboratorio de Programacao 2 - Projeto Final
 * Caio Vitor Brasileiro Torres – 116111245
 * Francivaldo Cabral de Andrade – 116111544
 * Luan Carlos da Silva Bezerra - 116110100
 */
package modelos.tutor;
import java.io.Serializable;
/**
 * Classe NivelAprendiz, implementa a interface de doacao
 * @author Caio Torres
 * @version 1.5
 */
@SuppressWarnings("serial")
public class NivelTop implements Doacao, Serializable {
    /**
     * Retorna o valor da taxa sobre a doacao para o tutor, em funcao da avaliacao do mesmo
     * @return double
     */
    @Override
    public double getTaxa(double avaliacao) {
        if (avaliacao > 5 || avaliacao <= 4.5) {
            throw new NumberFormatException("Nota de avaliacao fora do limite.");
        }
        
        String saida = String.valueOf(0.90 + ((avaliacao - 4.5) / 10));
        if (saida.length() > 3) {
            return Double.valueOf(saida.substring(0, 4).replace(',', '.'));
        }
        return Double.valueOf(saida.substring(0, 3).replace(',', '.'));
    }
    
    /**
     * Representacao textual do nivel aprendriz
     */
    @Override
    public String toString() {
        return "TOP";
    }
}