package modelos.tutor;

import java.io.Serializable;

@SuppressWarnings("serial")
public class NivelTutor implements Doacao, Serializable {

	@Override
	public double getTaxa(double avaliacao) {
		return 0.80;
	}

	@Override
	public String toString() {
		return "Tutor";
	}
}
