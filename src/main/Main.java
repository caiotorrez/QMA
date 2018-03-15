/**
 * UFCG - Universidade Federal de Campina Grande
 * LP2 - Laboratorio de Programacao 2 - Projeto Final
 * Caio Vitor Brasileiro Torres - 116111245
 * Francivaldo Cabral de Andrade - 116111544
 * Luan Carlos da Silva Bezerra - 116110100
 */
package main;
import easyaccept.EasyAccept;
/**
 * Classe Main, ira inicializar o Sistema
 * @author Caio Torres
 * @version 1.0
 * @author Luan Carlos
 * @version 1.1
 */
public class Main {
    /**
     * Roda os testes do Easy Accept
     * @param args, String com o que o main ira rodar
     */
    public static void main(String[] args) throws ClassNotFoundException {
        args = new String[] { "classePrincipal.Facade", "testesAceitacao/us1_test.txt", "testesAceitacao/us2_test.txt",
                                "testesAceitacao/us3_test.txt", "testesAceitacao/us4_test.txt", "testesAceitacao/us5_test.txt",
                                    "testesAceitacao/us6_test.txt"};
        EasyAccept.main(args);
    }
}