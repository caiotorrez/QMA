package modelos.tutor;

import java.io.Serializable;

@SuppressWarnings("serial")
public class NivelTutor implements Doacao, Serializable {

	@Override
	public double getTaxa(double avaliacao) {
		if (avaliacao > 4.5 || avaliacao <= 3) {
			throw new NumberFormatException("Nota de avaliacao fora do limite.");
		}
		return 0.80;
	}

	@Override
	public String toString() {
		return "Tutor";
	}
}
