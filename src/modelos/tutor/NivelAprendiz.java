package modelos.tutor;

import java.io.Serializable;

@SuppressWarnings("serial")
public class NivelAprendiz implements Doacao, Serializable {

	public double getTaxa(double avaliacao) {
		if (avaliacao <= 0 || avaliacao > 3) {
			throw new NumberFormatException("Nota de avaliacao fora do limite.");
		}
		String saida =  String.valueOf(0.4 + ((avaliacao - 3) / 10));
		if (saida.length() > 3) {
			return Double.valueOf(saida.substring(0, 4).replace(',', '.'));
		}
		return Double.valueOf(saida.substring(0, 3).replace(',', '.'));
	}
	
	@Override
	public String toString() {
		return "Aprendiz";
	}
}
