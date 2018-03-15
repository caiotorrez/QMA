/**
 * UFCG - Universidade Federal de Campina Grande
 * LP2 - Laboratorio de Programacao 2 - Projeto Final
 * Caio Vitor Brasileiro Torres – 116111245
 * Francivaldo Cabral de Andrade – 116111544
 * Luan Carlos da Silva Bezerra - 116110100
 */
package modelos.aluno;
import java.io.Serializable;
/**
 * Classe Aluno, armazena os seus respctivos atributos
 * @author Caio Torres
 * @version 1.0
 * @author Luan
 * @version 1.1
 */
@SuppressWarnings("serial")
public class Aluno implements Comparable<Aluno>, Serializable {
    private String nome;
    private String matricula;
    private int codigoCurso;
    private String telefone;
    private String email;
    /**
     * Checa os parametros que serao usados na criacao de Aluno
     * @param nome, String
     * @param matricula, String
     * @param email, String
     * @param condigoDoCurso, Integer
     */
    private void checkCadastro(String nome, String matricula, String email, int condigoDoCurso) {
        if (nome == null || nome.trim().equals(""))
            throw new AlunoException(new NullPointerException("Erro no cadastro do Aluno: Nome nao pode ser null ou em branco."));
        else if (matricula == null || matricula.trim().equals(""))
            throw new AlunoException(new NullPointerException("Erro no cadastro do Aluno: Matricula nao pode ser null ou em branco."));
        else if (email == null || email.trim().equals(""))
            throw new AlunoException(new NullPointerException("Erro no cadastro do Aluno: Email nao pode ser null ou em branco."));
        else if (codigoCurso < 0)
            throw new AlunoException(new NumberFormatException("Erro no cadastro do Aluno: Codigo do curso nao pode ser negativo"));
    }
    /**
     * Construtor de Aluno
     * @param nome, String
     * @param matricula, String
     * @param codigoDoCurso, Integer
     * @param telefone, String
     * @param email, String
     */
    public Aluno(String nome, String matricula, int codigoDoCurso, String telefone, String email) {
        this.checkCadastro(nome, matricula, email, codigoDoCurso);
        this.nome = nome;
        this.matricula = matricula;
        this.codigoCurso = codigoDoCurso;
        this.telefone = telefone;
        this.email = email;
    }
    /**
     * Retorna o nome do Aluno
     * @return String
     */
    public String getNome() {
        return this.nome;
    }
    /**
     * Retorna a Matricula do Aluno
     * @return String
     */
    public String getMatricula() {
        return this.matricula;
    }
    /**
     * Retorna o codigo do Curso que o Aluno esta Atrelado
     * @return Integer
     */
    public int getCodigoDoCurso() {
        return this.codigoCurso;
    }
    /**
     * Retorna o numero de telefone do aluno
     * @return String
     */
    public String getTelefone() {
        return this.telefone;
    }
    /**
     * Retorna o email do aluno
     * @return String
     */
    public String getEmail() {
        return this.email;
    }
    /**
     * HashCode :)
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
        return result;
    }
    /**
     * Equals :P
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Aluno other = (Aluno) obj;
        if (matricula == null) {
            if (other.matricula != null)
                return false;
        } else if (!matricula.equals(other.matricula))
            return false;
        return true;
    }
    /**
     * Forma de comparacao entre os alunos
     */
    @Override
    public int compareTo(Aluno outroAluno) {
        int indice = this.nome.compareTo(outroAluno.nome);
        if (indice == 0) {
            return this.matricula.compareTo(outroAluno.matricula);
        } return indice;
    }
    /**
     * Retorna a representacao textual de Aluno
     */
    @Override
    public String toString() {
        return this.telefone.equals("")
                ? this.matricula + " - " + this.nome + " - " + this.codigoCurso + " - " + this.email
                : this.matricula + " - " + this.nome + " - " + this.codigoCurso + " - " + this.telefone + " - "
                        + this.email;
    }
}