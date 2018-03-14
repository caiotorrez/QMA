/**
 * UFCG - Universidade Federal de Campina Grande
 * LP2 - Laboratorio de Programacao 2 - Projeto Final
 * Caio Vitor Brasileiro Torres – 116111245
 * Francivaldo Cabral de Andrade – 116111544
 * Luan Carlos da Silva Bezerra - 116110100
 */
package controladores;
import servicos.ServiceAjuda;
/**
 * ControllerAjuda, efetua a checagem dos parametros e faz a ligacao entre a fachada e os serviceAjuda
 * @author Caio Torres
 * @version 1.3
 */
public class ControllerAjuda {
    
    private ServiceAjuda serviceAjuda;
    
    /**
     * Inicia o ServiceAjuda
     * @param serviceAjuda, ServiceAjuda
     */
    public ControllerAjuda(ServiceAjuda serviceAjuda) {
        this.serviceAjuda = serviceAjuda;
    }
    
    /**
     * Cria um pedido de ajuda presencial, retornando o numero id referente ao pedido de ajuda
     * @param matrAluno, String
     * @param disciplina, String
     * @param horario, String
     * @param dia, String
     * @param localInteresse, String
     * @return Integer
     */
    public int pedirAjudaPresencial (String matrAluno, String disciplina, String horario, String dia, String localInteresse) {
        if (matrAluno == null || matrAluno.trim().equals("")) {
            throw new NullPointerException("Erro no pedido de ajuda presencial: matricula de aluno nao pode ser vazio ou em branco");
        }
        else if (disciplina == null || disciplina.trim().equals("")) {
            throw new NullPointerException("Erro no pedido de ajuda presencial: disciplina nao pode ser vazio ou em branco");
        }
        else if (horario == null || horario.trim().equals("")) {
            throw new NullPointerException("Erro no pedido de ajuda presencial: horario nao pode ser vazio ou em branco");
        }
        else if (dia == null || dia.trim().equals("")) {
            throw new NullPointerException("Erro no pedido de ajuda presencial: dia nao pode ser vazio ou em branco");
        }
        else if (localInteresse == null || localInteresse.trim().equals("")) {
            throw new NullPointerException("Erro no pedido de ajuda presencial: local de interesse nao pode ser vazio ou em branco");
        }
        return this.serviceAjuda.cadastrarAjudaPresencial(matrAluno, disciplina, horario, dia, localInteresse);
    }
    
    /**
     * Cria um pedido de ajuda online, retornando o numero id referente ao pedido de ajuda
     * @param matrAluno, String
     * @param disciplina, String
     * @return Integer
     */
    public int pedirAjudaOnline (String matrAluno, String disciplina) {
        if (matrAluno == null || matrAluno.trim().equals("")) {
            throw new NullPointerException("Erro no pedido de ajuda online: matricula de aluno nao pode ser vazio ou em branco");
        }
        if (disciplina == null || disciplina.trim().equals("")) {
            throw new NullPointerException("Erro no pedido de ajuda online: disciplina nao pode ser vazio ou em branco");
        }
        return this.serviceAjuda.cadastrarAjudaOnline(matrAluno, disciplina);
    }
    
    /**
     * Retorna o monitor responsavel pelo atendimento da ajuda solicitada 
     * @param idAjuda, Integer
     * @return String
     */
    public String pegarTutor(int idAjuda) {
        if (idAjuda < 0) {
            throw new NullPointerException("Erro ao tentar recuperar tutor : id nao pode menor que zero ");
        }
        return this.serviceAjuda.getTutorAjuda(idAjuda);
    }
    
    /**
     * Retorna uma informacao associada a uma solicitacao de ajuda
     * @param idAjuda, Integer
     * @param atributo, String
     * @return String
     */
    public String getInfoAjuda(int idAjuda, String atributo) {
        if (idAjuda < 0) {
            throw new NullPointerException("Erro ao tentar recuperar info da ajuda : id nao pode menor que zero ");
        }
        if (atributo == null || atributo.trim().equals("")) {
            throw new NullPointerException("Erro ao tentar recuperar info da ajuda : atributo nao pode ser vazio ou em branco");
        }
        else {
            return this.serviceAjuda.getInfoAjuda(idAjuda, atributo);
        }
    }
    
    /**
     * Atribui uma nota a ajuda realizada pelo tutor
     * @param idAjuda, Integer
     * @param nota, Integer
     */
    public void avaliarTutor(int id, int nota) {
        this.serviceAjuda.concluirAjuda(id, nota);
    }
}