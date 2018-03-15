/**
 * UFCG - Universidade Federal de Campina Grande
 * LP2 - Laboratorio de Programacao 2 - Projeto Final
 * Caio Vitor Brasileiro Torres – 116111245
 * Francivaldo Cabral de Andrade – 116111544
 * Luan Carlos da Silva Bezerra - 116110100
 */
package modelos.tutor;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
/**
 * Classe Tutor, armazena as informacoes de Tutor
 * 
 * @author Caio Torres
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Tutor implements Comparable<Tutor>, Serializable {
    private Map<String, Disciplina> disciplinas;
    private String matricula;
    private String email;
    private Nivel nivel;
    private int carteira;
    private int id;
    /**
     * Construtor de Tutor
     * @param matricula, String
     * @param email, String
     * @param disciplina, Disciplina
     * @param id, Integer
     */
    public Tutor(String matricula, String email, Disciplina disciplina, int id) {
        if (disciplina == null) {
            throw new TutorException(
                    new NullPointerException("Erro na criacao do Tutor: Disciplina nao pode ser nula"));
        } else if (matricula == null || matricula.trim().equals("")) {
            throw new TutorException(
                    new NullPointerException("Erro na criacao do Tutor: Matricula nao pode ser nulo ou em branco"));
        } else if (email == null || email.trim().equals("")) {
            throw new TutorException(
                    new NullPointerException("Erro na criacao do Tutor: Email nao pode ser nulo ou em branco"));
        }
        this.disciplinas = new HashMap<>();
        this.matricula = matricula;
        this.email = email;
        this.disciplinas.put(disciplina.getID(), disciplina);
        this.nivel = new Nivel(4);
        this.id = id;
        this.carteira = 0;
    }
    /**
     * Adiciona uma disciplina a colecao de discilinas relativas a um monitor
     * @param disciplina, Disciplina
     */
    public void addDisciplina(Disciplina disciplina) {
        if (disciplina == null)
            throw new TutorException(
                    new NullPointerException("Erro na adicao de disciplinas ao Tuto: Disciplina nao pode ser nula"));
        else if (this.disciplinas.containsKey(disciplina.getID())) {
            throw new TutorException("Erro na definicao de papel: Ja eh tutor dessa disciplina");
        } else {
            this.disciplinas.put(disciplina.getID(), disciplina);
        }
    }
    /**
     * Retorna todas as disciplinas que o mesmo e tutor
     * @return String
     */
    public String exibeDisciplinas() {
        String saida = "";
        for (String matricula : this.disciplinas.keySet()) {
            saida += this.disciplinas.get(matricula).toString() + System.lineSeparator();
        }
        return saida;
    }
    /**
     * Retorna o email do tutor
     * @return String
     */
    public String getEmail() {
        return this.email;
    }
    /**
     * Retorna a matricula do tutor
     * @return String
     */
    public String getMatricula() {
        return this.matricula;
    }
    /**
     * Retorna o id do tutor
     * @return Integer
     */
    public int getId() {
        return this.id;
    }
    /**
     * Avalia o tutor
     * @param avaliacao, Integer
     */
    public void addAvaliacao(int avaliacao) {
        this.nivel.setAvaliacao(avaliacao);
    }
    /**
     * Retorna o valor da avaliacao do tutor
     * @return double
     */
    public double getAvaliacao() {
        return this.nivel.getAvaliacao();
    }
    /**
     * Retorna o nivel do tutor
     * @return String
     */
    public String getNivel() {
        return this.nivel.getNivel();
    }
    
    /**
     * Retorna a taxa atual cobrada na doacao em virtude do nivel do tutor
     * @return double
     */
    public double getTaxaAvaliacao() {
        return this.nivel.getTaxa();
    }
    /**
     * Adiciona o valor a carteira virtual do tutor
     * @param valor, Integer
     */
    public void addDoacao(int valor) {
        this.carteira += valor;
    }
    /**
     * Retorna o valor da carteira virtual do tutor
     * @return Integer
     */
    public int getCarteira() {
        return this.carteira;
    }
    /**
     * hashCode :>
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
        return result;
    }
    /**
     * Equals :<
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tutor other = (Tutor) obj;
        if (matricula == null) {
            if (other.matricula != null)
                return false;
        } else if (!matricula.equals(other.matricula))
            return false;
        return true;
    }
    /**
     * Forma de comparacao entre tutores
     */
    @Override
    public int compareTo(Tutor outroTutor) {
        if (this.getAvaliacao() > outroTutor.getAvaliacao()) {
            return -1;
        } else if (this.getAvaliacao() > outroTutor.getAvaliacao()) {
            return 1;
        } else if (this.id < outroTutor.id) {
            return -1;
        } else if (this.id > outroTutor.id) {
            return 1;
        }
        return 0;
    }
    /**
     * Retorna a representacao textual de Tutor
     * @return String
     */
    @Override
    public String toString() {
        return this.matricula + " - " + this.email;
    }
}