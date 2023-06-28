package fuerzaArmadaTipoParcialTDD;

public class Portaviones extends Vehiculo implements Acuatico {

	private Double profundidad;

	public Portaviones(Integer id, String nombre,String patente) {
		super(id, nombre,patente);
		this.profundidad=0.0;
	}

	@Override
	public Double getProfundidad() {
		// TODO Auto-generated method stub
		return profundidad;
	}

	public void setProfundidad(Double profundidad) {
		this.profundidad = profundidad;
	}
	
}
