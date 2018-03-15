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
     * Checa se o atributo local passado eh valido.
     * @param local
     */
    private void checkLocal(String local) {
    	if (local == null || local.trim().equals("")) {
    		throw new LocalException(new NullPointerException("Local nao pode ser null ou em branco"));
    	}
    }
    
    /**
     * Construtor de Local
     * @param local, String
     */
    public Local(String local) {
    	this.checkLocal(local);
        this.locais = new HashSet<>();
        this.addLocal(local);
    }
    
    /**
     * Adiciona um novo local ao banco de dados de locais
     * @param local, String
     */
    public void addLocal(String local) {
    	this.checkLocal(local);
    	if (this.contemLocal(local)) {
    		throw new LocalException("Esse local ja esta adcionado.");
    	} else {
    		this.locais.add(local);    		
    	}
    }
    
    
    /**
     * Verifica a existencia de um local, por meio do seu nome
     * @param local, String
     * @return boolean
     */
    public boolean contemLocal(String local) {
    	this.checkLocal(local);
        return this.locais.contains(local);
    }
}