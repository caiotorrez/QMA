package controladores;
import servicos.ServiceTutor;
/**
 * Classe ControllerTutor, efetua a checagem dos parametros e faz a ligacao entre a fachada e os serviceTutor
 * @author Caio Torres
 * @version 1.3
 */
public class ControllerTutor {
    
    private ServiceTutor serviceTutor;
    
    /**
     * Inicializa o serviceTutor
     * @param serviceTutor, ServiceTutor
     */
    public ControllerTutor(ServiceTutor serviceTutor) {
        this.serviceTutor = serviceTutor;   
    }
    
    /**
     * Promove um aluno cadastrado para um Tutor
     * @param matricula, String
     * @param disciplina, String
     * @param proficiencia, Integer
     */
    public void tornarTutor(String matricula, String disciplina, int proficiencia) {
        if (matricula == null || matricula.trim().equals("")) {
            throw new NullPointerException("Erro na definicao de papel: Matricula invalida");
        }
        else if (disciplina == null || disciplina.trim().equals("")) {
            throw new NullPointerException("Erro na definicao de papel: Disciplina invalida");
        }
        else if (proficiencia < 1) {
            throw new NullPointerException("Erro na definicao de papel: Proficiencia invalida");
        }
        this.serviceTutor.addTutor(matricula, disciplina, proficiencia);
    }
    
    /**
     * Retorna um Tutor cadastrado por meio da sua matricula
     * @param matricula, String
     * @return String
     */
    public String recuperaTutor(String matricula) {
        if (!this.serviceTutor.containsTutor(matricula)) {
            throw new NullPointerException("Erro na busca por tutor: Tutor nao encontrado");
        }
        return this.serviceTutor.getToStringTutor(matricula);
    }
    
    /**
     * Retorna a lista de tutores cadastrados
     * @return String
     */
    public String listarTutores() {
        return this.serviceTutor.getAllTutores();
    }
    
    /**
     * Retorna a nota de um tutor cadastrado especifico por meio da sua matricula
     * @param matriculaTutor, String
     * @return String
     */
    public String pegarNota(String matriculaTutor) {
        if (matriculaTutor == null || matriculaTutor.trim().equals("")) {
            throw new NullPointerException();
        } else {
            return this.serviceTutor.getNota(matriculaTutor);   
        }
    }
    /**
     * Retorna o nivel de um tutor cadastrado especifico por meio da sua matricula
     * @param matriculaTutor, String
     * @return String
     */
    public String pegarNivel(String matriculaTutor) {
        if (matriculaTutor == null || matriculaTutor.trim().equals("")) {
            throw new NullPointerException();
        } else {
            return this.serviceTutor.getNivel(matriculaTutor);
        }
    }   
}