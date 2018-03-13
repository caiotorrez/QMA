package modelos.tutor;

import java.io.Serializable;

@SuppressWarnings("serial")
public class NivelTop implements Doacao, Serializable {

	@Override
	public double getTaxa(double avaliacao) {
		if (avaliacao > 5 || avaliacao <= 4.5) {
			throw new NumberFormatException("Nota de avaliacao fora do limite.");
		}
		
		String saida = String.valueOf(0.90 + ((avaliacao - 4.5) / 10));
		if (saida.length() > 3) {
			return Double.valueOf(saida.substring(0, 4).replace(',', '.'));
		}
		return Double.valueOf(saida.substring(0, 3).replace(',', '.'));
	}
	
	@Override
	public String toString() {
		return "TOP";
	}

}
