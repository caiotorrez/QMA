package modelos.tutor;

import java.text.DecimalFormat;

public class NivelTop implements Doacao {

	@Override
	public double getTaxa(double avaliacao) {
		return Double.valueOf(new DecimalFormat("0.00").format(0.90 + ((avaliacao - 4.5) / 10)).replace(',', '.'));
	}
	
	@Override
	public String toString() {
		return "TOP";
	}

}
