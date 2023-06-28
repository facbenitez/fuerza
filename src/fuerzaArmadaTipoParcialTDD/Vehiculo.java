package fuerzaArmadaTipoParcialTDD;

public class Vehiculo implements Comparable<Vehiculo> {

	private Integer id;
	private String nombre;
	private String patente;
	
	public Vehiculo(Integer id, String nombre,String patente) {
		this.id = id;
		this.nombre = nombre;
		this.patente=patente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Vehiculo other = (Vehiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int compareTo(Vehiculo o) {
		return this.getId().compareTo(o.getId());
	}

	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", nombre=" + nombre + ", patente=" + patente + "]";
	}
	
	
	
}
