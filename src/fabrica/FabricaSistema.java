/**
 * UFCG - Universidade Federal de Campina Grande
 * LP2 - Laboratorio de Programacao 2 - Projeto Final
 * Caio Vitor Brasileiro Torres – 116111245
 * Francivaldo Cabral de Andrade – 116111544
 * Luan Carlos da Silva Bezerra - 116110100
 */
package fabrica;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import controladores.ControllerAjuda;
import controladores.ControllerAluno;
import controladores.ControllerCaixa;
import controladores.ControllerHorarioLocal;
import controladores.ControllerTutor;
import servicos.ServiceAjuda;
import servicos.ServiceAluno;
import servicos.ServiceCaixaSistema;
import servicos.ServiceHorarioLocais;
import servicos.ServiceTutor;
/**
 * Classe FabricaSistema, inializa os Controladores e Services do Sistema
 * @author Francivaldo
 * @version 1.3
 * @author Caio Torres
 * @version 1.5
 */
@SuppressWarnings("serial")
public final class FabricaSistema implements Serializable {
    private ObjectOutputStream saveAluno;
    private ObjectOutputStream saveTutor;
    private ObjectOutputStream saveHL;
    private ObjectOutputStream saveAjuda;
    private ObjectOutputStream saveCaixa;
    private ObjectInputStream leitor;
    private ServiceAluno serviceAluno;
    private ServiceTutor serviceTutor;
    private ServiceHorarioLocais serviceHL;
    private ServiceAjuda serviceAjuda;
    private ServiceCaixaSistema serviceCaixa;
    private ControllerAluno alunoController;
    private ControllerTutor tutorController;
    private ControllerHorarioLocal horarioLocalController;
    private ControllerAjuda ajudaController;
    private ControllerCaixa caixaController;
    /**
     * Armazena as informacoes do sistema em um arquivo
     */
    public void salvarSistema() {
        try {
            this.saveAluno.writeObject(this.serviceAluno);
            this.saveTutor.writeObject(this.serviceTutor);
            this.saveHL.writeObject(this.serviceHL);
            this.saveAjuda.writeObject(this.serviceAjuda);
            this.saveCaixa.writeObject(this.serviceCaixa);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Carrega um arquivo que contem informacoes passadas do sistema
     */
    public void carregarSistema() {
        try {
            this.alunoController = new ControllerAluno((ServiceAluno) leitura("serviceAluno.ser"));
            this.tutorController = new ControllerTutor((ServiceTutor) leitura("serviceTutor.ser"));
            this.horarioLocalController = new ControllerHorarioLocal((ServiceHorarioLocais) leitura("serviceHL.ser"));
            this.ajudaController = new ControllerAjuda((ServiceAjuda) leitura("serviceAjuda.ser"));
            this.caixaController = new ControllerCaixa((ServiceCaixaSistema) leitura("serviceCaixa.ser"));
        } catch (Exception e) {
            System.err.println("Erro ao carregar sistema, nao ha sistema salvo.");
        }
    }
    
    /**
     * Cria um novo documento e branco que sera utilizado para armazenas novas informacoes
     */
    public void limparSistema() {
        this.create();
    }
    
    /**
     * Ira ler o arquivo que contem as informacoes
     * @param arquivo, String
     * @return Object
     */
    private Object leitura(String arquivo) {
        try {
            this.leitor = new ObjectInputStream(new FileInputStream(arquivo));
            try {
                return this.leitor.readObject();
            } catch (ClassNotFoundException e) {
                System.err.println("Erro ao ler arquivo, " + e.getMessage());
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo, " + e.getMessage());
        }
        return null;
    }
    
    /**
     * Cria arquivos em branco que armazenara novas informacoes
     */
    public FabricaSistema() {
        this.create();
    }
    /**
     * Inicializa os arquivos armazenadores
     */
    public void create() {
        try {
            this.saveAluno = new ObjectOutputStream(new FileOutputStream("serviceAluno.ser"));
            this.saveTutor = new ObjectOutputStream(new FileOutputStream("serviceTutor.ser"));
            this.saveHL = new ObjectOutputStream(new FileOutputStream("serviceHL.ser"));
            this.saveAjuda = new ObjectOutputStream(new FileOutputStream("serviceAjuda.ser"));
            this.saveCaixa = new ObjectOutputStream(new FileOutputStream("serviceCaixa.ser"));
            this.serviceAluno = new ServiceAluno();
            this.serviceTutor = new ServiceTutor(this.serviceAluno);
            this.serviceHL = new ServiceHorarioLocais(this.serviceTutor);
            this.serviceAjuda = new ServiceAjuda(this.serviceTutor, this.serviceHL, this.serviceAluno);
            this.serviceCaixa = new ServiceCaixaSistema(this.serviceTutor);
            this.alunoController = new ControllerAluno(this.serviceAluno);
            this.tutorController = new ControllerTutor(this.serviceTutor);
            this.horarioLocalController = new ControllerHorarioLocal(this.serviceHL);
            this.ajudaController = new ControllerAjuda(this.serviceAjuda);
            this.caixaController = new ControllerCaixa(this.serviceCaixa);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Retorna o Controlador de Aluno
     * @return ControllerAluno
     */
    public ControllerAluno getAlunoController() {
        return this.alunoController;
    }
    /**
     * Retorna o Controlador de Tutor
     * @return ControllerTutor
     */
    public ControllerTutor getTutorController() {
        return this.tutorController;
    }
    
    /**
     * Retorna o Controlador de Horario e Local
     * @return ControllerHorarioLocal
     */
    public ControllerHorarioLocal getHorarioLocalController() {
        return this.horarioLocalController;
    }
    
    /**
     * Retorna o Controlador de Ajuda
     * @return ControllerAjuda
     */
    public ControllerAjuda getAjudaController() {
        return this.ajudaController;
    }
    
    /**
     * Retorna o Controlador de Caixa
     * @return ControllerCaixa
     */
    public ControllerCaixa getCaixaController() {
        return this.caixaController;
    }
}