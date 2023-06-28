package fuerzaArmadaTipoParcialTDD;

public class Anfibio extends Vehiculo implements Acuatico, Terrestre {

	private Double velocidad;
	private Double profundidad;

	public Anfibio(Integer id, String nombre,String patente) {
		super(id, nombre,patente);
		this.velocidad=0.0;
		this.profundidad=0.0;
	}

	@Override
	public Double getVelocidad() {
		// TODO Auto-generated method stub
		return velocidad;
	}

	@Override
	public Double getProfundidad() {
		// TODO Auto-generated method stub
		return profundidad;
	}

	public void setVelocidad(Double velocidad) {
		this.velocidad = velocidad;
	}

	public void setProfundidad(Double profundidad) {
		this.profundidad = profundidad;
	}	

}
