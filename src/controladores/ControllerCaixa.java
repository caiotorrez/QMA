/**
 * UFCG - Universidade Federal de Campina Grande
 * LP2 - Laboratorio de Programacao 2 - Projeto Final
 * Caio Vitor Brasileiro Torres - 116111245
 * Francivaldo Cabral de Andrade - 116111544
 * Luan Carlos da Silva Bezerra - 116110100
 */
package controladores;
import servicos.ServiceCaixaSistema;
/**
 * Classe ControllerCaixa, efetua a checagem dos parametros e faz a ligacao entre a fachada e os serviceCaixaSistema 
 * @author Luan Carlos
 * @version 1.2
 * 
 */
public class ControllerCaixa {
    
    private ServiceCaixaSistema serviceCaixa;
    /**
     * Inicia o ServeciCaixaSistema
     * @param serviceCaixa, ServeciCaixaSistema
     */
    public ControllerCaixa(ServiceCaixaSistema serviceCaixa) {
        this.serviceCaixa = serviceCaixa;
    }
    
    /**
     * Realiza uma doacao para um tutor cadastrado especifico por meio da sua matricula
     * @param matriculaTutor, String
     * @param totalCentavos, Integer
     */
    public void doar(String matriculaTutor, int totalCentavos) {
        if (matriculaTutor == null || matriculaTutor.trim().equals("")) {
            throw new NullPointerException();
        }
        else if (totalCentavos < 0) {
            throw new NumberFormatException("Erro na doacao para tutor: totalCentavos nao pode ser menor que zero");
        }
        else {
            this.serviceCaixa.doar(matriculaTutor, totalCentavos);
        }
    }
    
    /**
     * Retorna o valor da carteira virtual de um tutor cadastrado por meio da sua matricula
     * @param emailTutor, String
     * @return Integer
     */
    public int totalDinheiroTutor(String emailTutor) {
        if (emailTutor == null || emailTutor.trim().equals("")) {
            throw new NullPointerException("Erro na consulta de total de dinheiro do tutor: emailTutor nao pode ser vazio ou nulo");
        }
        return this.serviceCaixa.totalDinheiroTutor(emailTutor);
    }
    
    /**
     * Retorna o valor que o caixa do sistema retem no momento
     * @return Integer
     */
    public int totalDinheiroSistema() {
        return this.serviceCaixa.getValorCaixa();
    }
}