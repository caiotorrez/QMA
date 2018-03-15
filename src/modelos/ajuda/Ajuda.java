/**
 * UFCG - Universidade Federal de Campina Grande
 * LP2 - Laboratorio de Programacao 2 - Projeto Final
 * Caio Vitor Brasileiro Torres - 116111245
 * Francivaldo Cabral de Andrade - 116111544
 * Luan Carlos da Silva Bezerra - 116110100
 */
package modelos.ajuda;
import java.io.Serializable;
/**
 * Classe Ajuda, é uma classe abstrata que assegura uma ajuda a um determinado aluno/tutor.
 * @author Caio Torres
 * @version 1.3
 */
@SuppressWarnings("serial")
public abstract class Ajuda implements Serializable {
    
    
    private String disciplina;
    private String matriculaAluno;
    private String matriculaTutor;
    private boolean concluida;
    
    /**
     * Construtor de Ajuda
     * @param matrAluno, String
     * @param disciplina, String
     */
    public Ajuda(String matrAluno, String disciplina) {
        if (matrAluno == null || matrAluno.trim().equals("")) {
            throw new AjudaException(new NullPointerException("Matricula do Aluno nao pode ser null ou em branco."));
        }
        else if (disciplina == null || disciplina.trim().equals("")) {
            throw new AjudaException(new NullPointerException("Disciplina nao pode ser null ou em branco."));
        } else {
            this.matriculaAluno = matrAluno;
            this.disciplina = disciplina;
            this.concluida = false;
        }
    }
    
    /**
     * Altera a matricula do tutor responsavel
     * @param matriculaTutor, String
     */
    public void setMatriculaTutor(String matriculaTutor) {
    	if (matriculaTutor == null || matriculaTutor.trim().equals("")) {
    		throw new AjudaException(new NullPointerException("Matricula de tutor nao pode ser nula ou vazia."));
    	} else {
    		this.matriculaTutor = matriculaTutor;    		
    	}
    }
    /**
     * Retorna a matricula do Tutor responsavel
     * @return String
     */
    public String getMatriculaTutor() {
        return this.matriculaTutor;
    }
    
    /**
     * Retorna a disciplina solicitada na Ajuda
     * @return String
     */
    public String getDisciplina() {
        return this.disciplina;
    }
    
    /**
     * Retorna a matricula do Aluno solicitante
     * @return String
     */
    public String getMatriculaAluno() {
        return this.matriculaAluno;
    }
    
    /**
     * Altera o Status da Ajuda, para concluida
     */
    public void setConcluirAjuda() {
        this.concluida = true;
    }
    
    /**
     * Retorna o status da ajuda por meio de um boolean
     * @return boolean
     */
    public boolean getConclusaoAjuda() {
        return this.concluida;
    }
    
    /**
     * Retorna a representacao textual de Ajuda
     */
    @Override
    public String toString() {
        return "Tutor - " + this.matriculaTutor +", disciplina - " + this.disciplina;
    }
}