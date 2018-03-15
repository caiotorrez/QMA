/**
 * UFCG - Universidade Federal de Campina Grande
 * LP2 - Laboratorio de Programacao 2 - Projeto Final
 * Caio Vitor Brasileiro Torres – 116111245
 * Francivaldo Cabral de Andrade – 116111544
 * Luan Carlos da Silva Bezerra - 116110100
 */
package modelos.tutor;
import java.io.Serializable;
/**
 * Classe Disciplina, armazena informacoes de Disciplina
 * @author Caio Torres
 * @version 1.1
 */
@SuppressWarnings("serial")
public class Disciplina implements Serializable {
    private String disciplina;
    private int proficiencia;
    /**
     * Construtor de Disciplina
     * @param nomeDisciplina, String
     * @param proficiencia, Integer
     */
    public Disciplina(String nomeDisciplina, int proficiencia) {
        if (nomeDisciplina == null || nomeDisciplina.trim().equals("")) {
            throw new TutorException(new NullPointerException("Nome da disciplina nao pode ser null ou em branco."));
        } else if (proficiencia <= 0 || proficiencia > 5) {
            throw new TutorException(
                    new NumberFormatException("Proficiencia invalida, nao pode ser negativo nem acima de 5"));
        }
        this.disciplina = nomeDisciplina;
        this.proficiencia = proficiencia;
    }
    /**
     * Retorna o identificador da disciplina
     * @return String
     */
    public String getID() {
        return this.disciplina;
    }
    /**
     * Retorna o valor da proficiencia do tutor na referida disciplina
     * @return Integer
     */
    public int getProficiencia() {
        return this.proficiencia;
    }
    /**
     * hashCode XD
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((disciplina == null) ? 0 : disciplina.hashCode());
        return result;
    }
    /**
     * Equals :D
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Disciplina other = (Disciplina) obj;
        if (disciplina == null) {
            if (other.disciplina != null)
                return false;
        } else if (!disciplina.equals(other.disciplina))
            return false;
        return true;
    }
    /**
     * Retorna a representacao textual de disciplina
     * @return String
     */
    @Override
    public String toString() {
        return this.disciplina + " - " + this.proficiencia;
    }
}