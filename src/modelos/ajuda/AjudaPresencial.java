/**
 * UFCG - Universidade Federal de Campina Grande
 * LP2 - Laboratorio de Programacao 2 - Projeto Final
 * Caio Vitor Brasileiro Torres - 116111245
 * Francivaldo Cabral de Andrade - 116111544
 * Luan Carlos da Silva Bezerra - 116110100
 */
package modelos.ajuda;
/**
 * Classe {@link AjudaPresencial}encial, herda caracteristicas de {@link Ajuda}
 * @author Caio Torres
 * @version 1.2
 */
@SuppressWarnings("serial")
public class AjudaPresencial extends Ajuda {
    private String horario;
    private String dia;
    private String localInteresse;
    
    /**
     * Construtor de Ajuda
     * @param matrAluno, String
     * @param disciplina, String
     * @param horario, String
     * @param dia, String
     * @param localInteresse, String
     */
    public AjudaPresencial(String matrAluno, String disciplina, String horario, String dia, String localInteresse) {
        super(matrAluno, disciplina);
        if (localInteresse == null || localInteresse.trim().equals("")) {
            throw new AjudaException(new NullPointerException("Local de interesse nao pode ser null ou em branco."));
        }
        else if (horario == null || horario.trim().equals("")) {
            throw new AjudaException(new NullPointerException("Horario nao pode ser null ou em branco."));
        }
        else if (dia == null || dia.trim().equals("")) {
            throw new AjudaException(new NullPointerException("Dia nao pode ser null ou em branco."));
        } else {
            this.localInteresse = localInteresse;
            this.horario = horario;
            this.dia = dia;
        }
    }
    
    /**
     * retorna o horario da ajuda
     * @return String
     */
    public String getHorario() {
        return this.horario;
    }
    
    /**
     * Retorna o dia da ajuda
     * @return String
     */
    public String getDia() {
        return this.dia;
    }
    
    /**
     * Retorna o local de interesse da ajuda
     * @return String
     */
    public String getLocalInteresse() {
        return this.localInteresse;
    }
    
    /**
     * Retorna a representacao textual da ajuda
     */
    @Override
    public String toString() {
        return "Tutor - " + super.getMatriculaTutor() + ", horario - " + this.horario
                + ", dia - " + this.dia + ", local - " + this.localInteresse + ", disciplina - " + super.getDisciplina();
    }
}