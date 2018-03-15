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
 * Classe Nivel, armazena as informacoes de Nivel
 * @author Caio Torres
 * @version 1.4
 */
@SuppressWarnings("serial")
public class Nivel implements Serializable {
    
    private double avaliacao;
    private Doacao nivel;
    
    /**
     * Altera o nivel atribuido ao tutor
     */
    private void setNivel() {
        if (this.avaliacao > 4.5) {
            this.nivel = new NivelTop();
        }
        else if (this.avaliacao > 3) {
            this.nivel = new NivelTutor();
        }
        else {
            this.nivel = new NivelAprendiz();
        }
    }
    
    /**
     * Construtor de Nivel
     * @param avaliacao, double
     */
    public Nivel(double avaliacao) {
        if (avaliacao < 0 || avaliacao > 5) {
            throw new NumberFormatException("Nota de avaliacao fora do limite.");
        }
        this.avaliacao = avaliacao;
        this.setNivel();
    }
    
    /**
     * Retorna a avaliacao atribuida ao tutor
     * @return double
     */
    public double getAvaliacao() {
        return this.avaliacao;
    }
    
    /**
     * Alteva o valor da avaliacao atribuida ao tutor
     * @param avaliacao, Integer
     */
    public void setAvaliacao(int avaliacao) {
        if (avaliacao < 0 || avaliacao > 5) {
            throw new NumberFormatException("Nota de avaliacao fora do limite.");
        }
        this.avaliacao = (this.avaliacao * 5 + avaliacao) / 6;
        this.setNivel();
    }
    
    /**
     * Retorna o valor da taxa em funcao do nivel do tutor
     * @return double
     */
    public double getTaxa() {
        return this.nivel.getTaxa(this.avaliacao);
    }
    
    /**
     * Retorna qual nivel o tutor esta
     * @return String
     */
    public String getNivel() {
        return this.nivel.toString();
    }
}