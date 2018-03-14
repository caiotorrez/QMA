/**
 * UFCG - Universidade Federal de Campina Grande
 * LP2 - Laboratorio de Programacao 2 - Projeto Final
 * Caio Vitor Brasileiro Torres – 116111245
 * Francivaldo Cabral de Andrade – 116111544
 * Luan Carlos da Silva Bezerra - 116110100
 */
package controladores;
import modelos.aluno.Aluno;
import servicos.ServiceAluno;
/**
 * Classe ControllerAluno, efetua a checagem dos parametros e faz a ligacao entre a fachada e os serviceAluno
 * @author Caio Torres
 * @version 1.0
 * @author Luan Carlos
 * @version 1.2
 */
public class ControllerAluno {
    private ServiceAluno serviceAluno;
    
    /**
     * Inicia o serviceAluno
     * @param serviceAluno, ServiceAluno
     */
    public ControllerAluno(ServiceAluno serviceAluno) {
        this.serviceAluno = serviceAluno;
    }
    /**
     * Cadastra um novo aluno
     * @param nome, String
     * @param matricula, String
     * @param codigoCurso, Integer
     * @param telefone, String
     * @param email, String
     */
    public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
        if (nome == null || nome.trim().equals("")) {
            throw new NullPointerException("Erro no cadastro de aluno: Nome nao pode ser vazio ou nulo");
        }
        if (matricula == null || matricula.trim().equals("")) {
            throw new NullPointerException("Erro no cadastro de matricula: Matricula nao pode ser vazio ou nulo");
        }
        else if (!email.matches("[a-zA-Z0-9_.-]+@{1}[a-zA-Z0-9_.-]*\\.+[a-z]{2,4}")) {
            throw new NullPointerException("Erro no cadastro de aluno: Email invalido");
        }
        else if (this.serviceAluno.containsAluno(matricula)) {
            throw new NullPointerException("Erro no cadastro de aluno: Aluno de mesma matricula ja cadastrado");
        }
        
        this.serviceAluno.addAluno(new Aluno(nome, matricula, codigoCurso, telefone, email));
    }
    /**
     * Retorna um aluno cadastrado com base na sua matricula
     * @param matricula, String
     * @return String
     */
    public String recuperaAluno(String matricula) {
        if (!this.serviceAluno.containsAluno(matricula)) {
            throw new NullPointerException("Erro na busca por aluno: Aluno nao encontrado");
        }
        return this.serviceAluno.toStringAluno(matricula);
    }
    /**
     * Lista todos os alunos cadastrados
     * @return String
     */
    public String listarAlunos() {
        return this.serviceAluno.getAllAlunos();
    }
    /**
     * Retorna uma Informacao especifica de um aluno cadastrado por meio de sua matricula
     * @param matricula, String
     * @param atributo, String
     * @return String
     */
    public String getInfoAluno(String matricula, String atributo) {
        if (!this.serviceAluno.containsAluno(matricula)) {
            throw new NullPointerException("Erro na obtencao de informacao de aluno: Aluno nao encontrado");
        }
        return this.serviceAluno.getInfoAluno(matricula, atributo.toLowerCase());
    }
    
    /**
     * Configura a ordem de ordenacao dos alunos
     * @param atributo, String
     */
    public void configuraOrdem(String atributo) {
        this.serviceAluno.setOrdem(atributo.toLowerCase());
    }
}