/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - UFCG
 * LABORATORIO DE PROGRAMACAO 2
 * ALUNOS - CAIO TORRES - FRANCIVALDO CABRAL - LUAN CARLOS
 * MATRICULAS -  -  - 116.110.100
 * PROJETO FINAL - QUEM ME AJUDA
 */
package tempoTeste;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import modelos.tempo.Local;
import modelos.tempo.LocalException;



/**
 * Classe de Testes referente a Horario
 * 
 * @author Francis Cabral
 * @version 1.0
 * @author Caio Torres
 * @version 1.1
 */
public class LocalTest {
	private Local localTeste;
	
	@Before
	public void setUp() {
		localTeste = new Local("CAA 404");
	}
	
	/**
	 * Testa a criacao de um local nulo
	 */
	@Test(expected = LocalException.class)
	public void localNull() {
		this.localTeste = new Local(null);
	}
	
	/**
	 * Testa a criacao de um local em branco
	 */
	@Test(expected = LocalException.class)
	public void localEmBranco() {
		this.localTeste = new Local("   ");
	}
	
	/**
	 * Testa a criacao de um local em branco
	 */
	@Test(expected = LocalException.class)
	public void localEmBranco2() {
		this.localTeste = new Local("");
	}
	
	/**
	 * Testa a adcicao de um local nulo
	 */
	@Test(expected = LocalException.class)
	public void addLocalNull() {
		this.localTeste.addLocal(null);
	}
	
	/**
	 * Testa a adcicao de um local em branco
	 */
	@Test(expected = LocalException.class)
	public void addLocalEmBranco() {
		this.localTeste.addLocal("");
	}
	
	/**
	 * Testa a adcicao de um local em branco
	 */
	@Test(expected = LocalException.class)
	public void addLocalEmBranco2() {
		this.localTeste.addLocal("   ");
	}
	
	/**
	 * Testa a adcicao de um local valido
	 */
	@Test
	public void addLocalvalido() {
		this.localTeste.addLocal("CAA 202");
	}
	
	/**
	 * Testa a adcicao de um local valido ja existente
	 */
	@Test(expected = LocalException.class)
	public void addLocalExistente() {
		this.localTeste.addLocal("CAA 404");
	}
	
	/**
	 * Testa se contem um local armazenado valido
	 */
	@Test
	public void contemLocalTeste() {
		assertEquals(true, localTeste.contemLocal("CAA 404"));
	}
	
	/**
	 * Testa se contem um local armazenado invalido
	 */
	@Test
	public void contemLocalFalseTeste() {
		assertEquals(false, localTeste.contemLocal("biblioteca"));
	}

}
