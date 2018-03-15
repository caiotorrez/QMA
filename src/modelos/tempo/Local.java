/**
 * UFCG - Universidade Federal de Campina Grande
 * LP2 - Laboratorio de Programacao 2 - Projeto Final
 * Caio Vitor Brasileiro Torres – 116111245
 * Francivaldo Cabral de Andrade – 116111544
 * Luan Carlos da Silva Bezerra - 116110100
 */
package modelos.tempo;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/**
 * Classe Local, armazena as informacoes de Local
 * @author Caio Torres
 * @version 1.4
 */
@SuppressWarnings("serial")
public class Local implements Serializable {
    
    private Set<String> locais;
    
    /**
     * Construtor de Local
     * @param local, String
     */
    public Local(String local) {
        this.locais = new HashSet<>();
        this.addLocal(local);
    }
    
    /**
     * Adiciona um novo local ao banco de dados de locais
     * @param local, String
     */
    public void addLocal(String local) {
        this.locais.add(local);
    }
    
    /**
     * Remove um local do banco de dados de locais
     * @param local, String
     */
    public void removeLocal(String local) {
        this.locais.remove(local);
    }
    
    /**
     * Verifica a existencia de um local, por meio do seu nome
     * @param local, String
     * @return boolean
     */
    public boolean contemLocal(String local) {
        return this.locais.contains(local);
    }
}