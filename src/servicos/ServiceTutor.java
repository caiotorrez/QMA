/**
 * UFCG - Universidade Federal de Campina Grande
 * LP2 - Laboratorio de Programacao 2 - Projeto Final
 * Caio Vitor Brasileiro Torres – 116111245
 * Francivaldo Cabral de Andrade – 116111544
 * Luan Carlos da Silva Bezerra - 116110100
 */
package servicos;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import modelos.tutor.Disciplina;
import modelos.tutor.Tutor;
/**
 * Classe ServiceCaixaSistema, realiza as operacoes no ambito do Caixa do Sistema
 * @author Caio Torres
 * @version 1.5
 */
@SuppressWarnings("serial")
public class ServiceTutor implements Serializable {
    private ServiceAluno serviceAluno;
    private Map<String, Tutor> tutores;
    /**
     * Construtor de ServiceTutor
     * @param serviceAluno, ServiceAluno
     */
    public ServiceTutor(ServiceAluno serviceAluno) {
        this.serviceAluno = serviceAluno;
        this.tutores = new HashMap<>();
    }
    /**
     * Adiciona um tutor na colecao de tutores
     * @param matricula, String
     * @param disciplina, String
     * @param proficiencia, Integer
     */
    public void addTutor(String matricula, String disciplina, int proficiencia) {
        if (!this.serviceAluno.containsAluno(matricula)) {
            throw new NullPointerException("Erro na definicao de papel: Tutor nao encontrado");
        } else if (this.tutores.containsKey(matricula)) {
            this.tutores.get(matricula).addDisciplina(new Disciplina(disciplina, proficiencia));
        } else {
            this.tutores.put(matricula, new Tutor(matricula, this.serviceAluno.getInfoAluno(matricula, "Email"),
            new Disciplina(disciplina, proficiencia), this.tutores.size()));
        }
    }
    /**
     * Retorna um Tutor cadastrado por meio da sua matricula
     * @param matricula, String
     * @return Tutor
     */
    public Tutor getTutor(String matricula) {
        if (this.tutores.containsKey(matricula)) {
            return this.tutores.get(matricula);
        }
        return null;
    }
    
    /**
     * Retorna a representacao textual de um Tutor cadastrado por meio da sua matricula
     * @param matricula, String
     * @return String
     */
    public String getToStringTutor(String matricula) {
        if (this.tutores.containsKey(matricula)) {
            return this.serviceAluno.toStringAluno(matricula);
        }
        return null;
    }
    /**
     * Retorna a lista de tutores cadastrados, ordenados de uma maneira predefinida
     * @return String
     */
    public String getAllTutores() {
        return this.serviceAluno.ordenacaoPersonalizada(this.tutores.keySet());
    }
    /**
     * Verifica se existe um tutor cadastrado por meio da sua matricula
     * @param matricula, String
     * @return boolean
     */
    public boolean containsTutor(String matricula) {
        return this.tutores.containsKey(matricula);
    }
    
    /**
     * Retorna todas as matriculas dos tutores cadastrados
     * @param disciplina, String
     * @return String
     */
    public String searchTutor(String disciplina) {
        String output = "";
        for (Tutor tutor : this.tutores.values()) {
            if (tutor.exibeDisciplinas().contains(disciplina))
                output += tutor.getMatricula() + ",";
        }
        return output;
    }
    
    /**
     * Retorna a matricula de um tutor por meio do seu email
     * @param email, String
     * @return String
     */
    public String getMatricula(String email) {
        return this.serviceAluno.getMatricula(email);
    }
    /**
     * Retorna a matricula do melhor tutor avaliado
     * @param matriculas, String[] matriculas
     * @return String
     */
    public String melhorTutorAvaliado(String[] matriculas) {
        List<Tutor> tutores = new ArrayList<>();
        for (String matricula : matriculas) {
            tutores.add(this.tutores.get(matricula));
        }
        Collections.sort(tutores);
        return tutores.get(0).getMatricula();
    }
    /**
     * Avalia um tutor
     * @param nota, Integer
     * @param matricula, String
     */
    public void avaliarTutor(int nota, String matricula) {
        if (matricula == null) {
            throw new NullPointerException("Erro na avaliacao de tutor: Ajuda nao atribuida a tutor");
        } else {
            this.tutores.get(matricula).addAvaliacao(nota);
        }
    }
    /**
     * Retorna a nota atual de um tutor
     * @param matricula, String
     * @return String
     */
    public String getNota(String matricula) {
        String saida = "";
        DecimalFormat formato = new DecimalFormat("0.00");
        saida = formato.format(this.tutores.get(matricula).getAvaliacao());
        saida = saida.replace(".", ",");
        return saida;
    }
    /**
     * Retorna o nivel atual do tutor, com base na sua nota atual
     * @param matricula, String
     * @return String
     */
    public String getNivel(String matricula) {
        return this.tutores.get(matricula).getNivel();
    }
    
    /**
     * Retorna a taxa que sera cobrada sobre doacoes recebidas
     * @param matricula, String
     * @return double
     */
    public double getTaxaAvaliacao(String matricula) {
        return this.tutores.get(matricula).getTaxaAvaliacao();
    }
    
    /**
     * Realiza uma doacao para um tutor especifico
     * @param matricula, String
     * @param valor, Integer
     */
    public void doar(String matricula, int valor) {
        this.tutores.get(matricula).addDoacao(valor);
    }
}