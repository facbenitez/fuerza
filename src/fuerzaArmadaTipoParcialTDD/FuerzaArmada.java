package fuerzaArmadaTipoParcialTDD;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class FuerzaArmada {
	private Set<Vehiculo> convoy;
	private Map<String, Batalla> batallas;
	
	public FuerzaArmada() {	
		this.convoy =new HashSet<>();	
		this.batallas =new HashMap<>();
	}

	public Set<Vehiculo> getConvoy() {
		return convoy;
	}

	public void setConvoy(Set<Vehiculo> convoy) {
		this.convoy = convoy;
	}

	public Map<String, Batalla> getBatallas() {
		return batallas;
	}

	public void setBatallas(Map<String, Batalla> batallas) {
		this.batallas = batallas;
	}

	//agregar un vehiculo a la fuerza(convoy)
	public void agregarVehiculo(Vehiculo nuevoVehiculo) {
		this.convoy.add(nuevoVehiculo);
	}

	//muestro la cantidad de vehiculos que hay dentro del convoy de la fuerza
	public Integer getCapacidadDeDefensa() {	
		return this.convoy.size();
	}
	
	//busco si el vehiculo existe en la fuerza(convoy),si esta lo muestro .
	public Vehiculo buscarVehiculo(Integer idVehiculo)throws VehiculoInexistente{
		for (Vehiculo vehiculoActual : convoy) {
			if(vehiculoActual.getId().equals(idVehiculo)) {
				return vehiculoActual;
			}
		}
		throw new VehiculoInexistente();
	}

	//muestro la info de la batalla
	public String presentarBatalla() {
		return "FuerzaArmada [convoy=" + convoy + ", batallas=" + batallas + "]";
	}
	
	//creo una batalla
	public void crearBatalla(String nombreBatalla, TipoDeBatalla tipo, Double latitud, Double longitud) {
		this.batallas.put(nombreBatalla,new Batalla(nombreBatalla,tipo,latitud,longitud));	
	}
	
	//busco la batalla dentro del mapa
	public Batalla getBatalla(String nombreBatalla) {
		return batallas.get(nombreBatalla);
	}
	
	//envio un tipo de vehiculo a una batalla del mismo tipo
	public Boolean enviarALaBatalla(String nombreDeLaBatalla, Integer idVehiculo) throws VehiculoInexistente, VehiculoIncompatible {
	    Vehiculo enviarALaBatalla=buscarVehiculo(idVehiculo);
	    Batalla aCombatir=getBatalla(nombreDeLaBatalla);

       return aCombatir.ingregarVehiculoEnLaBatalla(enviarALaBatalla);
	}

	public TreeSet<Vehiculo> obtenerConvoyOrdenadosPorId() {
		TreeSet<Vehiculo>ordenPorId=new TreeSet<>();
		ordenPorId.addAll(convoy);
		return ordenPorId;
	}

	public TreeSet<Vehiculo> obtenerConvoyOrdenadosPorPatente() {
		TreeSet<Vehiculo>ordenPorPatente=new TreeSet<>(new OrdenarPorPatente());
		ordenPorPatente.addAll(convoy);
		return ordenPorPatente;
	}
	
	
}
