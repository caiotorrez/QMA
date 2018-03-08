package modelos.tempo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
public class Local implements Serializable {
	
	private Set<String> locais;
	
	public Local(String local) {
		this.locais = new HashSet<>();
		this.addLocal(local);
	}
	
	public void addLocal(String local) {
		this.locais.add(local);
	}
	
	public void removeLocal(String local) {
		this.locais.remove(local);
	}
	
	public boolean contemLocal(String local) {
		return this.locais.contains(local);
	}

}
