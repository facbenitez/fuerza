package fuerzaArmadaTipoParcialTDD;

import java.util.HashSet;
import java.util.Set;

public class Batalla {
	private String nombre;
	private TipoDeBatalla tipo;
	private Double latitud;
	private Double longitud;
	private Set<Vehiculo> vehiculosEnLaBatalla;
	
	public Batalla(String nombre, TipoDeBatalla tipo, Double latitud, Double longitud) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.latitud = latitud;
		this.longitud = longitud;
		this.vehiculosEnLaBatalla=new HashSet<>();
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoDeBatalla getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeBatalla tipo) {
		this.tipo = tipo;
	}

	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
    	this.latitud = latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	public Set<Vehiculo> getVehiculosEnLaBatalla() {
		return vehiculosEnLaBatalla;
	}

	public void setVehiculosEnLaBatalla(Set<Vehiculo> vehiculosEnLaBatalla) {
		this.vehiculosEnLaBatalla = vehiculosEnLaBatalla;
	}

	public Boolean ingregarVehiculoEnLaBatalla(Vehiculo aBatallar)throws VehiculoIncompatible {
		if((this.tipo==TipoDeBatalla.TERRESTRE && !(aBatallar instanceof Terrestre))||
		   (this.tipo==TipoDeBatalla.NAVAL && !(aBatallar instanceof Acuatico))||
		   (this.tipo==TipoDeBatalla.AEREA && !(aBatallar instanceof Volador))) {
			 throw new VehiculoIncompatible();

	       }
		this.vehiculosEnLaBatalla.add(aBatallar);
		return true;
	}
	
	public Integer cantidadDeVehiculoEnBatalla() {
		return this.vehiculosEnLaBatalla.size();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Batalla other = (Batalla) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}	

}
