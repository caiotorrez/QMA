/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - UFCG
 * LABORATORIO DE PROGRAMACAO 2
 * ALUNOS - CAIO TORRES - FRANCIVALDO CABRAL - LUAN CARLOS
 * MATRICULAS -  -  - 116.110.100
 * PROJETO FINAL - QUEM ME AJUDA
 */
package main;

import easyaccept.EasyAccept;

/**
 * Classe Main, ira inicializar o Sistema
 * @author 
 * @version 1.0
 */
public class Main {

	/**
	 * Roda os testes do Easy Accept
	 * @param args, String com o que o main ira rodar
	 */
	public static void main(String[] args) {
		args = new String[] { "controller.Controller", "testesAceitacao/us1_test.txt",
				"testesAceitacao/us2_test.txt", "testesAceitacao/us3_test.txt" };
		EasyAccept.main(args);
	}

}
