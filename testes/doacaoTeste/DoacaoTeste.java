package doacaoTeste;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import modelos.aluno.Aluno;
import servicos.ServiceAluno;
import servicos.ServiceCaixaSistema;
import servicos.ServiceTutor;

public class DoacaoTeste {

	private Aluno aluno;
	private ServiceTutor tutorService;
	private ServiceAluno serviceAluno;
	private ServiceCaixaSistema caixaService;
	
	
	@Before
	public void setUp() {
		aluno = new Aluno("Luan", "116110100", 1, "93654789", "luan.bezerra@ccc.ufcg");
		serviceAluno = new ServiceAluno();
		serviceAluno.addAluno(aluno);
		tutorService = new ServiceTutor(serviceAluno);
		caixaService = new ServiceCaixaSistema(tutorService);
		tutorService.addTutor("116110100", "Programacao", 4);
	}

	@Test
	public void doarTeste() {
		caixaService.doar("116110100", 1000);
		assertEquals(800, tutorService.getTutor("116110100").getCarteira());
		assertEquals(200, caixaService.getValorCaixa());
	}
	
}
