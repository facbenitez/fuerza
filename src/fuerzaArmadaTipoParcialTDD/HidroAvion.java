package fuerzaArmadaTipoParcialTDD;

public class HidroAvion extends Vehiculo implements Acuatico, Volador {

	private Double altura;
	private Double profundidad;

	public HidroAvion(Integer id, String nombre,String patente) {
		super(id, nombre,patente);
		this.altura=0.0;
		this.profundidad=0.0;
		
	}

	@Override
	public Double getAltura() {
		// TODO Auto-generated method stub
		return altura;
	}

	@Override
	public Double getProfundidad() {
		// TODO Auto-generated method stub
		return profundidad;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public void setProfundidad(Double profundidad) {
		this.profundidad = profundidad;
	}
	
}
