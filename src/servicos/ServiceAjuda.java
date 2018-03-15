/**
 * UFCG - Universidade Federal de Campina Grande
 * LP2 - Laboratorio de Programacao 2 - Projeto Final
 * Caio Vitor Brasileiro Torres – 116111245
 * Francivaldo Cabral de Andrade – 116111544
 * Luan Carlos da Silva Bezerra - 116110100
 */
package servicos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import modelos.ajuda.Ajuda;
import modelos.ajuda.AjudaOnline;
import modelos.ajuda.AjudaPresencial;
/**
 * Classe ServiceAjuda, contem as operacoes realizadas sobre a Ajuda
 * @author Caio Torres
 * @version 1.5
 */
@SuppressWarnings("serial")
public class ServiceAjuda implements Serializable {
    private ServiceTutor serviceTutor;
    private ServiceHorarioLocais serviceHL;
    private ServiceAluno serviceAluno;
    private List<Ajuda> ajudas;
    
    /**
     * Construtor de ServiceAjuda
     * @param serviceTutor, ServiceTutor
     * @param serviceHL, ServiceHorarioLocais
     * @param serviceAluno, ServiceAluno
     */
    public ServiceAjuda(ServiceTutor serviceTutor, ServiceHorarioLocais serviceHL, ServiceAluno serviceAluno) {
        this.ajudas = new ArrayList<>();
        this.serviceTutor = serviceTutor;
        this.serviceHL = serviceHL;
        this.serviceAluno = serviceAluno;
    }
    
    /**
     * Altera o Tutor que sera responsavel por atender a Ajuda
     * @param disciplina, String
     * @param horario, String
     * @param dia, String
     * @param local, String
     * @return String
     */
    private String setTutorAjuda(String disciplina, String horario, String dia, String local) {
        List<String> matriculas = new ArrayList<>();
        for (String matricula : this.serviceTutor.searchTutor(disciplina).split(",")) {
            String email = serviceAluno.getInfoAluno(matricula, "Email");
            if (serviceHL.contemHorario(email, horario, dia) && serviceHL.contemLocal(email, local)) {
                matriculas.add(matricula);
            }
        }
        String[] input = matriculas.toArray(new String[matriculas.size()]);
        return this.serviceTutor.melhorTutorAvaliado(input);
    }
    
    /**
     * Cadastra um pedido de ajuda presencial, retornando o numero id referente ao pedido de ajuda
     * @param matrAluno, String
     * @param disciplina, String
     * @param horario, String
     * @param dia, String
     * @param localInteresse, String
     * @return Integer
     */
    public int cadastrarAjudaPresencial(String matrAluno, String disciplina, String horario, String dia, String localInteresse) {
        this.ajudas.add(new AjudaPresencial(matrAluno, disciplina, horario, dia, localInteresse));
        int id = this.ajudas.size();
        this.ajudas.get(id - 1).setMatriculaTutor(this.setTutorAjuda(disciplina, horario, dia, localInteresse));
        return this.ajudas.size();
    }
    
    /**
     * Altera o Tutor que sera responsavel por atender a Ajuda
     * @param disciplina, String
     * @return String
     */
    private String setTutorAjuda(String disciplina) {
        List<String> matriculas = new ArrayList<>();
        for (String matricula : this.serviceTutor.searchTutor(disciplina).split(",")) {
            matriculas.add(matricula);
        }
        String[] input = matriculas.toArray(new String[matriculas.size()]);
        return this.serviceTutor.melhorTutorAvaliado(input);
    }
    
    /**
     * Cadastra um pedido de ajuda online, retornando o numero id referente ao pedido de ajuda
     * @param matrAluno, String
     * @param disciplina, String
     * @return Integer
     */
    public int cadastrarAjudaOnline (String matrAluno, String disciplina) {
        this.ajudas.add(new AjudaOnline(matrAluno, disciplina));
        int id = this.ajudas.size();
        this.ajudas.get(id - 1).setMatriculaTutor(this.setTutorAjuda(disciplina));
        return id;
    }
    
    /**
     * Retorna o monitor responsavel pelo atendimento da ajuda solicitada 
     * @param id, Integer
     * @return String
     */
    public String getTutorAjuda(int id) {
        if (id > this.ajudas.size()) {
            throw new NullPointerException("Erro ao tentar recuperar tutor : id nao encontrado ");
        } else {
            return this.ajudas.get(id - 1).toString();
        }
        
    }
    /**
     * Retorna uma informacao associada a uma solicitacao de ajuda
     * @param id, Integer
     * @param atributo, String
     * @return String
     */
    public String getInfoAjuda(int id, String atributo) {
        if (id > this.ajudas.size()) {
            throw new NullPointerException("Erro ao tentar recuperar info da ajuda : id nao encontrado ");
        }
        switch(atributo.toLowerCase()) {
        
        case "disciplina":
            return this.ajudas.get(id - 1).getDisciplina();
        case "horario":
            return ((AjudaPresencial) this.ajudas.get(id - 1)).getHorario();
        case "dia":
            return ((AjudaPresencial) this.ajudas.get(id - 1)).getDia();
        case "localinteresse": 
            return ((AjudaPresencial) this.ajudas.get(id - 1)).getLocalInteresse();
        default :
            throw new NullPointerException("Erro ao tentar recuperar info da ajuda : atributo nao encontrado");
        }
    }
    
    /**
     * Atribui uma nota a ajuda realizada pelo tutor
     * @param id, Integer
     * @param nota, Integer
     */
    public void concluirAjuda(int id, int nota) {
        if (this.ajudas.size() == 12) { 
            this.ajudas.get(11);
        }
        if (nota < 0) {
            throw new NumberFormatException("Erro na avaliacao de tutor: nota nao pode ser menor que 0");
        }
        else if (nota > 5) {
            throw new NumberFormatException("Erro na avaliacao de tutor: nota nao pode ser maior que 5");
        }
        else if (id > this.ajudas.size()) {
            throw new NullPointerException("Erro na avaliacao de tutor: id nao encontrado ");
        }
        else if (this.ajudas.get(id - 1).getMatriculaTutor() == null) {
            throw new NullPointerException("Erro na avaliacao de tutor: Ajuda nao atribuida a tutor");
        }
        else if (this.ajudas.get(id - 1).getConclusaoAjuda()) {
            throw new NullPointerException("Erro na avaliacao de tutor: Ajuda ja avaliada");
        }
        else {
            this.ajudas.get(id - 1).setConcluirAjuda();
            this.serviceTutor.avaliarTutor(nota, this.ajudas.get(id - 1).getMatriculaTutor());
        }
    }
}