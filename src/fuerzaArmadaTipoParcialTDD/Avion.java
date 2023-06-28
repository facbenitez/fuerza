package fuerzaArmadaTipoParcialTDD;

public class Avion extends Vehiculo implements Volador {

	private Double altura;

	public Avion(Integer id, String nombre,String patente) {
		super(id, nombre,patente);
		this.altura=0.0;
	}

	@Override
	public Double getAltura() {
		// TODO Auto-generated method stub
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}
	
	

}
