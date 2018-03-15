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
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import modelos.aluno.Aluno;
import modelos.aluno.EmailComparator;
import modelos.aluno.MatriculaComparator;
/**
 * Classe ServiceAluno, contem as operacoes realizadas sobre a Aluno
 * @author Caio Torres
 * @version 1.5
 */
@SuppressWarnings("serial")
public class ServiceAluno implements Serializable {
    
    private Map<String, Aluno> alunos;
    private transient String atributoDeOrdenacao;
    
    /**
     * Construtor de ServiceAluno
     */
    public ServiceAluno() {
        this.alunos = new HashMap<>();
        this.atributoDeOrdenacao = "nome";
    }
    
    /**
     * Adiciona um novo aluno a colecao de alunos
     * @param aluno, Aluno
     */
    public void addAluno(Aluno aluno) {
        this.alunos.put(aluno.getMatricula(), aluno);
    }
    /**
     * Retorna a representacao textual de um aluno especifico, por meio da sua matricula
     * @param matricula, String
     * @return String
     */
    public String toStringAluno(String matricula) {
        return this.alunos.get(matricula).toString();
    }
    /**
     * Lista todos os alunos cadastrados
     * @return String
     */
    public String getAllAlunos() {
        List<Aluno> alunos = new ArrayList<>(this.alunos.values());
        Collections.sort(alunos);
        String saida = Arrays.toString(alunos.toArray());
        return saida.equals("") ? "Nao ha alunos cadastrados" : saida.substring(1, saida.length() - 1);
    }
    
    /**
     * Retorna uma Informacao especifica de um aluno cadastrado por meio de sua matricula
     * @param matricula, String
     * @param atributo, String
     * @return String
     */
    public String getInfoAluno(String matricula, String atributo) {
        switch(atributo.toLowerCase()) {
        case "nome" :
            return this.alunos.get(matricula).getNome();
        case "matricula" :
            return this.alunos.get(matricula).getMatricula();
        case "codigoCurso" :
            return String.valueOf(this.alunos.get(matricula).getCodigoDoCurso());
        case "telefone" :
            return this.alunos.get(matricula).getTelefone();
        case "email" :
            return this.alunos.get(matricula).getEmail();
        default:
            return "Nao existe essa informacao.";
        }
    }
    
    /**
     * Verifica se o aluno esta cadastrado, por meio da sua matricula
     * @param matricula, String
     * @return boolean
     */
    public boolean containsAluno(String matricula) {
        return this.alunos.containsKey(matricula);
    }
    
    /**
     * Retorna a matricula de um Aluno com base no seu email
     * @param email, String
     * @return String
     */
    public String getMatricula(String email) {
        for (String matricula : this.alunos.keySet()) {
            if (this.alunos.get(matricula).getEmail().equals(email)) {
                return matricula;
            }
        } return null;
    }
    
    /**
     * Atribui uma nova forma de ordenacao a colecao de Alunos e retorna a mesma
     * @param matriculas, Set<String>
     * @return String
     */
    public String ordenacaoPersonalizada(Set<String> matriculas) {
        if (this.atributoDeOrdenacao == null) {
            this.atributoDeOrdenacao = "nome";
        }
        List<Aluno> lista = new ArrayList<>();
        for (String matricula : matriculas) {
            lista.add(this.alunos.get(matricula));
        }
        
        if (this.atributoDeOrdenacao.equals("nome")) {
            Collections.sort(lista);
        }
        else if (this.atributoDeOrdenacao.equals("email")) {
            Collections.sort(lista, new EmailComparator());
        }
        else if (this.atributoDeOrdenacao.equals("matricula")) {
            Collections.sort(lista, new MatriculaComparator());
        }
        String saida = Arrays.toString(lista.toArray());
        return saida.substring(1, saida.length() - 1);
    }
    
    /**
     * Altera a forma de ordenacao da colecao de Alunos
     * @param atributo
     */
    public void setOrdem(String atributo) {
        this.atributoDeOrdenacao = atributo;
    }
}