/**
 * UFCG - Universidade Federal de Campina Grande
 * LP2 - Laboratorio de Programacao 2 - Projeto Final
 * Caio Vitor Brasileiro Torres – 116111245
 * Francivaldo Cabral de Andrade – 116111544
 * Luan Carlos da Silva Bezerra - 116110100
 */
package modelos.caixaSistema;
import java.io.Serializable;
/**
 * Classe CaixaSistema, armazena as informacoes do Caixa do sistema
 * @author Luan Carlos
 * @version 1.4
 */
@SuppressWarnings("serial")
public class CaixaSistema implements Serializable {
    private int caixaSistema;
    
    /**
     * Construtor do CaixaSistema
     * @param valorInicial, Integer
     */
    public CaixaSistema(int valorInicial) {
        this.caixaSistema = valorInicial;
    }
    /**
     * Retorna o valor atual do caixa
     * @return Integer
     */
    public int getCaixa() {
        return this.caixaSistema;
    }
    
    /**
     * Adiciona valor ao caixa 
     * @param valor, Integer
     */
    public void addValor(int valor) {
        this.caixaSistema += valor;
    }
    
}