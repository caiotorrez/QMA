/**
 * UFCG - Universidade Federal de Campina Grande
 * LP2 - Laboratorio de Programacao 2 - Projeto Final
 * Caio Vitor Brasileiro Torres - 116111245
 * Francivaldo Cabral de Andrade - 116111544
 * Luan Carlos da Silva Bezerra - 116110100
 */
package controladores;
import servicos.ServiceHorarioLocais;
/**
 * Classe ControllerHorarioLocal, efetua a checagem dos parametros e faz a ligacao entre a fachada e os serviceHorarioLocais
 * @author Caio Torres
 * @version 1.3
 */
public class ControllerHorarioLocal {
    
    private ServiceHorarioLocais serviceHL;
    
    /**
     * Inicializa o ServiceHorarioLocais
     * @param serviceHL, ServiceHorarioLocais
     */
    public ControllerHorarioLocal(ServiceHorarioLocais serviceHL) {
        this.serviceHL = serviceHL;
    }
    
    /**
     * Cadastra um novo Horario livre para atendimento de um tutor cadastrado
     * @param email, String
     * @param horario, String
     * @param dia, String
     */
    public void cadastrarHorario(String email, String horario, String dia) {
        if (email == null || email.trim().equals("")) {
            throw new NullPointerException("Erro no cadastrar horario: email nao pode ser vazio ou em branco");
        }       
        else if (horario == null || horario.trim().equals("")) {
            throw new NullPointerException("Erro no cadastrar horario: horario nao pode ser vazio ou em branco");
        }
        else if (dia == null || dia.trim().equals("")) {
            throw new NullPointerException("Erro no cadastrar horario: dia nao pode ser vazio ou em branco");
        } else {
            this.serviceHL.cadastrarHorario(email, horario, dia);
        }
    }
    
    /**
     * Retorna por meio de boolean se existe disponibilidade de horario de atendimento de um tutor cadastrado
     * @param email, String
     * @param horario, String
     * @param dia, String
     * @return boolean
     */
    public boolean consultaHorario(String email, String horario, String dia) {
        return this.serviceHL.contemHorario(email, horario, dia);
    }
    
    /**
     * Cadastra um novo local para atendimento de um tutor cadastrado
     * @param email, String 
     * @param local, String
     */
    public void cadastrarLocalDeAtendimento(String email, String local) {
        if (email == null || email.trim().equals("")) {
            throw new NullPointerException("Erro no cadastrar local de atendimento: email nao pode ser vazio ou em branco");
        }       
        else if (local == null || local.trim().equals("")) {
            throw new NullPointerException("Erro no cadastrar local de atendimento: local nao pode ser vazio ou em branco");
        }
        else {
            this.serviceHL.cadastrarLocal(email, local);
        }
    }
    /**
     * Retorna se um local cadastrado esta disponivel para atendimento por meio de um boolean
     * @param email, String
     * @param local, String
     * @return boolean
     */
    public boolean consultaLocal(String email, String local) {
        return this.serviceHL.contemLocal(email, local);
    }
}