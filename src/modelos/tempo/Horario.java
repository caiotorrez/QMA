/**
 * UFCG - Universidade Federal de Campina Grande
 * LP2 - Laboratorio de Programacao 2 - Projeto Final
 * Caio Vitor Brasileiro Torres – 116111245
 * Francivaldo Cabral de Andrade – 116111544
 * Luan Carlos da Silva Bezerra - 116110100
 */
package modelos.tempo;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
/**
 * Classe Horario, armazena as informacoes de Horario
 * @author Caio Torres
 * @version 1.4
 */
@SuppressWarnings("serial")
public class Horario implements Serializable {
    
    private Map<String, String> database;
    
    /**
     * Construtor de Horario
     * @param horario, String
     * @param dia, String
     */
    public Horario(String horario, String dia) {
        if (horario == null || horario.trim().equals("")) {
            throw new TempoException(new NullPointerException("Erro na criacao de horario: Horario nao pode ser null ou em branco."));
        }
        else if (dia == null || dia.trim().equals("")) {
            throw new TempoException(new NullPointerException("Erro na criacao de horario: Dia nao pode ser null ou em branco."));
        } else {
            this.database = new HashMap<>();
            this.addHorario(horario, dia);
        }
    }
    
    /**
     * Adiciona um novo horario ao banco de dados
     * @param horario, String
     * @param dia, String
     */
    public void addHorario(String horario, String dia) {
        if (horario == null || horario.trim().equals("")) {
            throw new TempoException(new NullPointerException("Erro ao adcionar horario: Horario nao pode ser null ou em branco."));
        }
        else if (dia == null || dia.trim().equals("")) {
            throw new TempoException(new NullPointerException("Erro ao adcionar horario: Dia nao pode ser null ou em branco."));
        } else {
            this.database.put(dia, horario);
        }
        
    }
    
    public String getHorario(String dia) {
    	if (dia == null || dia.trim().equals("")) {
    		throw new TempoException(new NullPointerException("Erro ao recuperar horario: dia nao pode ser null ou em branco."));
    	}
        if (!this.database.containsKey(dia)) {
            throw new TempoException(new IllegalArgumentException("Erro ao recuperar horario: Dia nao cadastrado."));
        }
        return this.database.get(dia);
    }
    
    /**
     * Retorna todos horarios cadastrados
     * @return String
     */
    public String getAllHorarios() {
        String saida = "";
        for (String dia : this.database.keySet()) {
            saida += dia + System.lineSeparator() +  this.database.get(dia) + "\n";
        }
        return saida;
    } 
    
    /**
     * Retorna todos os dias com horarios cadastrados
     * @return String
     */
    public String getDias() {
        String saida = "";
        for (String dia : this.database.keySet()) {
            saida += dia + System.lineSeparator();
        }
        return saida;
    }
    
    /**
     * Verifica se existe um dia cadastrado por meio de uma String
     * @param dia, String
     * @return boolean
     */
    public boolean contemDia(String dia) {
    	if (dia == null || dia.trim().equals("")) {
    		throw new TempoException(new NullPointerException("Erro ao verificar horario: dia nao pode ser null ou em branco."));
    	}
        return this.database.containsKey(dia);
    }
}