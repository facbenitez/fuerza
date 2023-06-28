package fuerzaArmadaTipoParcialTDD;

public class Camion extends Vehiculo implements Terrestre{

	private Double velocidad;

	public Camion(Integer id, String nombre,String patente) {
		super(id, nombre,patente);
		this.velocidad=0.0;
	}

	@Override
	public Double getVelocidad() {
		// TODO Auto-generated method stub
		return velocidad;
	}

	public void setVelocidad(Double velocidad) {
		this.velocidad = velocidad;
	}
	
	

}
