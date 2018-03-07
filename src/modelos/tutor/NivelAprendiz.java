package modelos.tutor;

import java.text.DecimalFormat;

public class NivelAprendiz implements Doacao {

	public double getTaxa(double avaliacao) {
		return Double.valueOf(new DecimalFormat("0.000").format(0.4 + ((avaliacao - 3) / 10)).replace(',', '.'));
	}
	
	@Override
	public String toString() {
		return "Aprendiz";
	}
}
