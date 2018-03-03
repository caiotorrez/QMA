/**
 * UNIVERSIDADE FEDERAL DE CAMPINA GRANDE - UFCG
 * LABORATORIO DE PROGRAMACAO 2
 * ALUNOS - CAIO TORRES - FRANCIVALDO CABRAL - LUAN CARLOS
 * MATRICULAS -  -  - 116.110.100
 * PROJETO FINAL - QUEM ME AJUDA
 */
package tutorTestes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import aluno.Aluno;
import cadastroExceptions.NullOuEmBrancoException;
import definicaoException.DefinicaoException;
import horarios.Horario;
import tutor.Disciplina;
import tutor.Tutor;

/**
 * Classe de Testes referente a Tutor
 * 
 * @version 1.1
 * @author
 *
 */
public class TutorTest {
	private Tutor tutorTeste;
	private Aluno alunoTeste;
	private Disciplina disciplinaTeste;
	private Disciplina disciplinaTeste2;
	private Horario horarioTeste;

	/**
	 * Inicializa objetos testes
	 * @author 
	 * @version 1.0
	 * @throws Exception
	 * 
	 */
	@Before
	public void setUp() throws Exception {
		alunoTeste = new Aluno("Francis", "111222333", 55, "999-999", "francis@andrade.com");
		disciplinaTeste = new Disciplina("Programação 2", 4);
		disciplinaTeste2 = new Disciplina("Lab. de Prog. 2", 3);
		tutorTeste = new Tutor(alunoTeste, disciplinaTeste);
		horarioTeste = new Horario("francis@andrade.com", "16:00", "segunda");
	}

	/**
	 * Testa a criacao de um Tutor com o Aluno nulo
	 * @author Luan Carlos
	 * @version 1.1
	 * @throws NullPointerException
	 */
	@Test(expected = NullPointerException.class)
	public void criaTutorAlunoNuloTeste() throws Exception {
		tutorTeste = new Tutor(null, disciplinaTeste);
	}

	/**
	 * Testa a criacao de um Tutor com a Disciplina Nula
	 * @author Luan Carlos
	 * @version 1.1
	 * @throws Exception
	 */
	@Test(expected = NullPointerException.class)
	public void criaTutorDisciplinaNulaTeste() throws Exception {
		tutorTeste = new Tutor(alunoTeste, null);
	}

	/**
	 * Testa a adicao de uma nova disciplina valida a colecao de disciplinas do
	 * Tutor
	 * @author 
	 * @version 1.0
	 * @throws Exception
	 */
	@Test
	public void addDisciplinaTeste() throws Exception {
		tutorTeste.addDisciplina(disciplinaTeste2);
	}

	/**
	 * Testa a adicao de uma nova disciplina nula a colecao de disciplinas do
	 * Tutor
	 * @author Luan Carlos
	 * @version 1.1
	 * @throws Exception
	 */
	@Test(expected = NullPointerException.class)
	public void addDisciplinaNulaTeste() throws Exception {
		tutorTeste.addDisciplina(null);
	}

	/**
	 * Testa a adicao de uma nova disciplina valida mas ja adicionada a colecao
	 * de disciplinas do Tutor
	 * @author 
	 * @version 1.0
	 * @throws Exception
	 */
	@Test(expected = DefinicaoException.class)
	public void addDisciplinaJaAdicionadaTeste() throws Exception {
		tutorTeste.addDisciplina(disciplinaTeste);
	}

	/**
	 * Testa a exibicao todas disciplinas cadastradas na colecao de disciplinas
	 * do Tutor
	 * @author 
	 * @version 1.0
	 * @throws Exception
	 */
	@Test
	public void exibeDisciplinasTeste() throws Exception {
		tutorTeste.addDisciplina(disciplinaTeste2);
		assertEquals("Programação 2 - 4" + System.lineSeparator() + "Lab. de Prog. 2 - 3" + System.lineSeparator(),
				tutorTeste.exibeDisciplina());
	}

	/**
	 * Testa a adicao de um local valido para o atendimento do Tutor
	 * @author 
	 * @version 1.0
	 */
	@Test
	public void addLocalTeste() {
		tutorTeste.addLocal("francis@andrade.com", "Cantinho Universitário");
	}

	/**
	 * Testa a adicao de um email nulo para o atendimento do Tutor
	 * @author 
	 * @version 1.0
	 */
	@Test(expected = NullOuEmBrancoException.class)
	public void addLocalEmailInvalidoTeste() {
		tutorTeste.addLocal(null, "bar da cabrita");
	}

	/**
	 * Testa a adicao de um email vazio para o atendimento do Tutor
	 * @author 
	 * @version 1.0
	 */
	@Test(expected = NullOuEmBrancoException.class)
	public void addLocalEmailVazioTeste() {
		tutorTeste.addLocal(" ", "bar da cabrita");
	}

	/**
	 * Testa a adicao de um local nulo para o atendimento do Tutor
	 * @author 
	 * @version 1.0
	 */
	@Test(expected = NullOuEmBrancoException.class)
	public void addLocalLocalNullTeste() {
		tutorTeste.addLocal("francis@andrade.com", null);
	}

	/**
	 * Testa a adicao de um local vazio para o atendimento do Tutor
	 * @author 
	 * @version 1.0
	 */
	@Test(expected = NullOuEmBrancoException.class)
	public void addLocalLocalVazioTeste() {
		tutorTeste.addLocal("francis@andrade.com", " ");
	}

	/**
	 * Testa a adicao de um horario valido para o atendimento do Tutor
	 * @author 
	 * @version 1.0
	 */
	@Test
	public void addHorarioTeste() {
		tutorTeste.addHorario(horarioTeste);
	}

	/**
	 * Testa o retorno da existencia de um horario quando nao criado
	 * @author 
	 * @version 1.0
	 */
	@Test
	public void contemHorarioFalseTeste() {
		assertEquals(false, tutorTeste.contemHorario(horarioTeste));
	}

	/**
	 * Testa o retorno da existencia de um horario quando criado
	 * @author 
	 * @version 1.0
	 */
	@Test
	public void contemHorarioTrueTeste() {
		tutorTeste.addHorario(horarioTeste);
		assertEquals(true, tutorTeste.contemHorario(horarioTeste));
	}

	/**
	 * Testa o retorno da existencia de atendimento de um local quando nao
	 * existente
	 * @author 
	 * @version 1.0
	 */
	@Test
	public void contemLocalFalseTeste() {
		assertEquals(false, tutorTeste.contemLocal("bar da cabrita"));
	}

	/**
	 * Testa o retorno da existencia de atendimento de um local quando é
	 * existente
	 * @author 
	 * @version 1.0
	 */
	@Test
	public void contemLocalTrueTeste() {
		tutorTeste.addLocal("francis@andrade.com", "bar da cabrita");
		assertEquals(true, tutorTeste.contemLocal("bar da cabrita"));
	}

	/**
	 * Testa o retorno da existencia de tutor quando nao esta cadastrado
	 * @author 
	 * @version 1.0
	 */
	@Test
	public void contemEmailFalseTeste() {
		assertEquals(false, tutorTeste.contemEmail("andrade@francis.com"));
	}

	/**
	 * Testa o retorno da existencia de tutor quando esta cadastrado
	 * 
	 * @author
	 * @version 1.0
	 */
	@Test
	public void contemEmailTrueTeste() {
		assertEquals(true, tutorTeste.contemEmail("francis@andrade.com"));
	}

	/**
	 * Testa a representacao textual do Tutor
	 * 
	 * @author
	 * @version 1.0
	 */
	@Test
	public void toStringTeste() {
		assertEquals("111222333 - Francis - 55 - 999-999 - francis@andrade.com", tutorTeste.toString());
	}

}
