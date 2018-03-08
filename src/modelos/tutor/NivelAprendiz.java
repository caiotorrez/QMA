package modelos.tutor;

import java.io.Serializable;

@SuppressWarnings("serial")
public class NivelAprendiz implements Doacao, Serializable {

	public double getTaxa(double avaliacao) {
		return Double.valueOf(String.valueOf(0.4 + ((avaliacao - 3) / 10)).substring(0, 4).replace(',', '.'));
	}
	
	@Override
	public String toString() {
		return "Aprendiz";
	}
}
