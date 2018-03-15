/**
 * UFCG - Universidade Federal de Campina Grande
 * LP2 - Laboratorio de Programacao 2 - Projeto Final
 * Caio Vitor Brasileiro Torres – 116111245
 * Francivaldo Cabral de Andrade – 116111544
 * Luan Carlos da Silva Bezerra - 116110100
 */
package servicos;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import modelos.tempo.Horario;
import modelos.tempo.Local;
/**
 * Classe ServiceCaixaSistema, realiza as operacoes no ambito do Caixa do Sistema
 * @author Caio Torres
 * @version 1.5
 */
@SuppressWarnings("serial")
public class ServiceHorarioLocais implements Serializable {
    private ServiceTutor serviceTutor;
    private Map<String, Local> locaisAtendimento;
    private Map<String, Horario> horarios;
    
    /**
     * Construtor de ServiceHorarioLocais
     * @param serviceTutor, ServiceTutor
     */
    public ServiceHorarioLocais(ServiceTutor serviceTutor) {
        this.serviceTutor = serviceTutor;
        this.locaisAtendimento = new HashMap<>();
        this.horarios = new HashMap<>();
    }
    
    /**
     * Cadastra um novo Horario livre para atendimento de um tutor cadastrado
     * @param email, String
     * @param horario, String
     * @param dia, String
     */
    public void cadastrarHorario(String email, String horario, String dia) {
        if (!this.serviceTutor.getAllTutores().contains(email)) {
            throw new NullPointerException("Erro no cadastrar horario: tutor nao cadastrado");
        } 
        else if (this.horarios.containsKey(email)) {
            this.addHorario(email, horario, dia);
        } 
        else {
            this.horarios.put(email, new Horario(horario, dia));
        }
    }
    
    /**
     * Adiciona um novo horario de atendimento a respectiva colecao
     * @param email, String
     * @param horario, String
     * @param dia, String
     */
    public void addHorario(String email, String horario, String dia) {
        this.horarios.get(email).addHorario(horario, dia);
    }
    /**
     * Retorna por meio de boolean se esta cadastrado um horario de atendimento de um tutor cadastrado
     * @param email, String
     * @param horario, String
     * @param dia, String
     * @return boolean
     */
    public boolean contemHorario(String email, String horario, String dia) {
        if (this.horarios.containsKey(email) && this.horarios.get(email).contemDia(dia)) {
            return this.horarios.get(email).getHorario(dia).equals(horario);
        } return false;
        
    }
    /**
     * Cadastra um novo local para atendimento de um tutor cadastrado
     * @param email, String 
     * @param local, String
     */
    public void cadastrarLocal(String email, String local) {
        if (!this.serviceTutor.getAllTutores().contains(email)) {
            throw new NullPointerException("Erro no cadastrar local de atendimento: tutor nao cadastrado");
        }
        else if (this.locaisAtendimento.containsKey(email)) {
            this.locaisAtendimento.get(email).addLocal(local);
        } else {
            this.locaisAtendimento.put(email, new Local(local));
        }
    }
    
    /**
     * Retorna se um local esta cadastrado para atendimento por meio de um boolean
     * @param email, String
     * @param local, String
     * @return boolean
     */
    public boolean contemLocal(String email, String local) {
        if (this.horarios.containsKey(email)) {
            return this.locaisAtendimento.get(email).contemLocal(local);
        } return false;
    }
}
