/**
 * UFCG - Universidade Federal de Campina Grande
 * LP2 - Laboratorio de Programacao 2 - Projeto Final
 * Caio Vitor Brasileiro Torres – 116111245
 * Francivaldo Cabral de Andrade – 116111544
 * Luan Carlos da Silva Bezerra - 116110100
 */
package classePrincipal;
import fabrica.FabricaSistema;
/**
 * Classe Fachada, contem todas as chamadas de metodos necessarias para o sistema
 * @author Caio Torres
 * @version 1.1
 * @author Luan Carlos
 * @version 1.2
 * @author Francivaldo
 * @version 1.3
 */
public class Facade {
    private FabricaSistema fabricaSistema;
    
    /**
     * Este metodo ira inicializar os Controladores e Services do sistema
     */
    public Facade() {
        this.fabricaSistema = new FabricaSistema();
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
        this.fabricaSistema.getAlunoController().cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
    }
    
    /**
     * Retorna um aluno cadastrado com base na sua matricula
     * @param matricula, String
     * @return, Aluno
     */
    public String recuperaAluno(String matricula) {
        return this.fabricaSistema.getAlunoController().recuperaAluno(matricula);
    }
    
    /**
     * Lista todos os alunos cadastrados
     * @return String
     */
    public String listarAlunos() {
        return this.fabricaSistema.getAlunoController().listarAlunos();
    }
    
    /**
     * Retorna uma Informacao especifica de um aluno cadastrado por meio de sua matricula
     * @param matricula, String
     * @param atributo, String
     * @return String
     */
    public String getInfoAluno(String matricula, String atributo) {
        return this.fabricaSistema.getAlunoController().getInfoAluno(matricula, atributo);
    }
    
    /**
     * Promove um aluno cadastrado para um Tutor
     * @param matricula, String
     * @param disciplina, String
     * @param proficiencia, Integer
     */
    public void tornarTutor(String matricula, String disciplina, int proficiencia) {
        this.fabricaSistema.getTutorController().tornarTutor(matricula, disciplina, proficiencia);
    }
    
    /**
     * Retorna um Tutor cadastrado por meio da sua matricula
     * @param matricula, String
     * @return String
     */
    public String recuperaTutor(String matricula) {
        return this.fabricaSistema.getTutorController().recuperaTutor(matricula);
    }
    
    /**
     * Retorna a lista de tutores cadastrados
     * @return String
     */
    public String listarTutores() {
        return this.fabricaSistema.getTutorController().listarTutores();
    }
    
    /**
     * Cadastra um novo Horario livre para atendimento de um tutor cadastrado
     * @param email, String
     * @param horario, String
     * @param dia, String
     */
    public void cadastrarHorario(String email, String horario, String dia) {
        this.fabricaSistema.getHorarioLocalController().cadastrarHorario(email, horario, dia);
    }
    
    /**
     * Cadastra um novo local para atendimento de um tutor cadastrado
     * @param email, String 
     * @param local, String
     */
    public void cadastrarLocalDeAtendimento(String email, String local) {
        this.fabricaSistema.getHorarioLocalController().cadastrarLocalDeAtendimento(email, local);
    }
    
    /**
     * Retorna por meio de boolean se existe disponibilidade de horario de atendimento de um tutor cadastrado
     * @param email, String
     * @param horario, String
     * @param dia, String
     * @return boolean
     */
    public boolean consultaHorario(String email, String horario, String dia) {
        return this.fabricaSistema.getHorarioLocalController().consultaHorario(email, horario, dia);
    }
    
    /**
     * Retorna se um local cadastrado esta disponivel para atendimento por meio de um boolean
     * @param email, String
     * @param local, String
     * @return boolean
     */
    public boolean consultaLocal(String email, String local) {
        return this.fabricaSistema.getHorarioLocalController().consultaLocal(email, local);
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
        return this.fabricaSistema.getAjudaController().pedirAjudaPresencial(matrAluno, disciplina, horario, dia, localInteresse);
    }
    
    /**
     * Cria um pedido de ajuda online, retornando o numero id referente ao pedido de juda
     * @param matrAluno, String
     * @param disciplina, String
     * @return Integer
     */
    public int pedirAjudaOnline (String matrAluno, String disciplina) {
        return this.fabricaSistema.getAjudaController().pedirAjudaOnline(matrAluno, disciplina);
    }
    
    /**
     * Retorna o monitor responsavel pelo atendimento da ajuda solicitada 
     * @param idAjuda, Integer
     * @return String
     */
    public String pegarTutor(int idAjuda) {
        return this.fabricaSistema.getAjudaController().pegarTutor(idAjuda);
    }
    
    /**
     * Retorna uma informacao associada a uma solicitacao de ajuda
     * @param idAjuda, Integer
     * @param atributo, String
     * @return String
     */
    public String getInfoAjuda(int idAjuda, String atributo) {
        return this.fabricaSistema.getAjudaController().getInfoAjuda(idAjuda, atributo);
    }
    
    /**
     * Atribui uma nota a ajuda realizada pelo tutor
     * @param idAjuda, Integer
     * @param nota, Integer
     */
    public void avaliarTutor(int idAjuda, int nota) {
        this.fabricaSistema.getAjudaController().avaliarTutor(idAjuda, nota);
    }
    
    /**
     * Retorna a nota de um tutor cadastrado especifico por meio da sua matricula
     * @param matriculaTutor, String
     * @return String
     */
    public String pegarNota(String matriculaTutor) {
        return this.fabricaSistema.getTutorController().pegarNota(matriculaTutor);
    }
    
    /**
     * Retorna o nivel de um tutor cadastrado especifico por meio da sua matricula
     * @param matriculaTutor, String
     * @return String
     */
    public String pegarNivel(String matriculaTutor) {
        return this.fabricaSistema.getTutorController().pegarNivel(matriculaTutor);
    }
    /**
     * Realiza uma doacao para um tutor cadastrado especifico por meio da sua matricula
     * @param matriculaTutor, String
     * @param totalCentavos, Integer
     */
    public void doar(String matriculaTutor, int totalCentavos) {
        this.fabricaSistema.getCaixaController().doar(matriculaTutor, totalCentavos);
    }
    
    /**
     * Retorna o valor da carteira virtual de um tutor cadastrado por meio da sua matricula
     * @param emailTutor, String
     * @return Integer
     */
    public int totalDinheiroTutor(String emailTutor) {
        return this.fabricaSistema.getCaixaController().totalDinheiroTutor(emailTutor);
    }
    
    /**
     * Retorna o valor que o caixa do sistema retem no momento
     * @return Integer
     */
    public int totalDinheiroSistema() {
        return this.fabricaSistema.getCaixaController().totalDinheiroSistema();
    }
    
    /**
     * Configura a ordem de ordenacao dos alunos
     * @param atributo, String
     */
    public void configurarOrdem(String atributo) {
        this.fabricaSistema.getAlunoController().configuraOrdem(atributo);
    }
    
    /**
     * Salva as informacoes do sistema
     */
    public void salvar()  {
        this.fabricaSistema.salvarSistema();
    }
    
    /**
     * Carrega um arquivos que contem informacoes passadas do sistema
     */
    public void carregar() {
        this.fabricaSistema.carregarSistema();
    }
    
    /**
     * Limpa os dados salvos do sistema iniciando um novo arquivo em branco
     */
    public void limpar() {
        this.fabricaSistema.limparSistema();
    }
    
}
