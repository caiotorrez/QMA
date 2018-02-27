package tutorTestes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import alunos.Aluno;
import cadastroExceptions.NullOuEmBrancoException;
import definicaoException.DefinicaoException;
import horarios.Horario;
import tutor.Disciplina;
import tutor.Tutor;

public class TutorTest {
	private Tutor tutorTeste;
	private Aluno alunoTeste;
	private Disciplina disciplinaTeste;
	private Disciplina disciplinaTeste2;
	private Horario horarioTeste;

	@Before
	public void setUp() throws Exception {
		alunoTeste = new Aluno("Francis", "111222333", 55, "999-999", "francis@andrade.com");
		disciplinaTeste = new Disciplina("Programação 2", 4);
		disciplinaTeste2 = new Disciplina("Lab. de Prog. 2", 3);
		tutorTeste = new Tutor(alunoTeste, disciplinaTeste);
		horarioTeste = new Horario("francis@andrade.com", "16:00", "segunda");
	}

	@Test
	public void addDisciplinaTeste() {
		tutorTeste.addDisciplina(disciplinaTeste2);
	}

	@Test(expected = DefinicaoException.class)
	public void addDisciplinaJaAdicionadaTeste() {
		tutorTeste.addDisciplina(disciplinaTeste);
	}

	@Test
	public void exibeDisciplinasTeste() {
		tutorTeste.addDisciplina(disciplinaTeste2);
		assertEquals("Programação 2 - 4" + System.lineSeparator() + "Lab. de Prog. 2 - 3" + System.lineSeparator(),
				tutorTeste.exibeDisciplina());
	}

	@Test
	public void addLocalTeste() {
		tutorTeste.addLocal("francis@andrade.com", "Cantinho Universitário");
	}

	@Test(expected = NullOuEmBrancoException.class)
	public void addLocalEmailInvalidoTeste() {
		tutorTeste.addLocal(null, "bar da cabrita");
	}

	@Test(expected = NullOuEmBrancoException.class)
	public void addLocalEmailVazioTeste() {
		tutorTeste.addLocal(" ", "bar da cabrita");
	}

	@Test(expected = NullOuEmBrancoException.class)
	public void addLocalLocalNullTeste() {
		tutorTeste.addLocal("francis@andrade.com", null);
	}

	@Test(expected = NullOuEmBrancoException.class)
	public void addLocalLocalVazioTeste() {
		tutorTeste.addLocal("francis@andrade.com", " ");
	}

	@Test
	public void addHorarioTeste() {
		tutorTeste.addHorario(horarioTeste);
	}

	@Test
	public void contemHorarioFalseTeste() {
		assertEquals(false, tutorTeste.contemHorario(horarioTeste));
	}

	@Test
	public void contemHorarioTrueTeste() {
		tutorTeste.addHorario(horarioTeste);
		assertEquals(true, tutorTeste.contemHorario(horarioTeste));
	}

	@Test
	public void contemLocalFalseTeste() {
		assertEquals(false, tutorTeste.contemLocal("bar da cabrita"));
	}

	@Test
	public void contemLocalTrueTeste() {
		tutorTeste.addLocal("francis@andrade.com", "bar da cabrita");
		assertEquals(true, tutorTeste.contemLocal("bar da cabrita"));
	}

	@Test
	public void contemEmailFalseTeste() {
		assertEquals(false, tutorTeste.contemEmail("andrade@francis.com"));
	}

	@Test
	public void contemEmailTrueTeste() {
		assertEquals(true, tutorTeste.contemEmail("francis@andrade.com"));
	}

	@Test
	public void toStringTeste() {
		assertEquals("111222333 - Francis - 55 - 999-999 - francis@andrade.com", tutorTeste.toString());
	}

}
