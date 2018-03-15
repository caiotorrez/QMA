/**
 * UFCG - Universidade Federal de Campina Grande
 * LP2 - Laboratorio de Programacao 2 - Projeto Final
 * Caio Vitor Brasileiro Torres – 116111245
 * Francivaldo Cabral de Andrade – 116111544
 * Luan Carlos da Silva Bezerra - 116110100
 */
package servicos;
import java.io.Serializable;
import modelos.caixaSistema.CaixaSistema;
import servicos.ServiceTutor;
/**
 * Classe ServiceCaixaSistema, realiza as operacoes no ambito do Caixa do Sistema
 * @author Luan Carlos
 * @version 1.5
 */
@SuppressWarnings("serial")
public class ServiceCaixaSistema implements Serializable {
    
    private CaixaSistema caixa;
    private ServiceTutor serviceTutor;
    
    /**
     * Construtor de ServiceCaixaSistema
     * @param serviceTutor, ServiceTutor
     */
    public ServiceCaixaSistema(ServiceTutor serviceTutor) {
        this.caixa = new CaixaSistema(0);
        this.serviceTutor = serviceTutor;
    }   
    
    /**
     * Adiciona Valor ao caixa do sistema
     * @param valor, Integer
     */
    public void addValorCaixa(int valor) {
        this.caixa.addValor(valor);
    }
    /**
     * Retorna o valor contido no caixa do sistema
     * @return Integer
     */
    public int getValorCaixa() {
        return this.caixa.getCaixa();
    }
    
    /**
     * Realiza uma doacao para um tutor cadastrado especifico por meio da sua matricula
     * @param matriculaTutor, String
     * @param totalCentavos, Integer
     */
    public void doar(String matriculaTutor, int totalCentavos) {
        if (!this.serviceTutor.containsTutor(matriculaTutor)) {
            throw new NullPointerException("Erro na doacao para tutor: Tutor nao encontrado");
        }
        int valorDoacao = (int) (totalCentavos * this.serviceTutor.getTaxaAvaliacao(matriculaTutor));
        this.serviceTutor.doar(matriculaTutor, valorDoacao);
        this.caixa.addValor(totalCentavos - valorDoacao);
    }
    /**
     * Retorna o valor da carteira virtual de um tutor cadastrado por meio da sua matricula
     * @param emailTutor, String
     * @return Integer
     */
    public int totalDinheiroTutor(String emailTutor) {
        String matricula = this.serviceTutor.getMatricula(emailTutor);
        if (matricula == null) {
            throw new NullPointerException("Erro na consulta de total de dinheiro do tutor: Tutor nao encontrado");
        }
        else {
            return this.serviceTutor.getTutor(matricula).getCarteira();
        }
    }
}