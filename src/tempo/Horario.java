package tempo;

import java.util.HashMap;
import java.util.Map;

public class Horario {
	
	private Map<String, String> database;
	
	public Horario(String horario, String dia) {
		this.database = new HashMap<>();
		this.addHorario(horario, dia);
	}
	
	public void addHorario(String horario, String dia) {
		this.database.put(dia, horario);
	}
	
	public String getHorario(String dia) {
		return this.database.get(dia);
	}
	
	public String getAllHorarios() {
		String saida = "";
		for (String dia : this.database.keySet()) {
			saida += dia + System.lineSeparator() +  this.database.get(dia) + "\n";
		}
		return saida;
	} 
	
	public String getDias() {
		String saida = "";
		for (String dia : this.database.keySet()) {
			saida += dia + System.lineSeparator();
		}
		return saida;
	}
	
	public boolean contemDia(String dia) {
		return this.database.containsKey(dia);
	}
}
