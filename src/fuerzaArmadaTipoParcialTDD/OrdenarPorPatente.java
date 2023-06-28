package fuerzaArmadaTipoParcialTDD;

import java.util.Comparator;

public class OrdenarPorPatente implements Comparator<Vehiculo> {

	@Override
	public int compare(Vehiculo o1, Vehiculo o2) {
		
		return o1.getPatente().compareTo(o2.getPatente());
	}

}
