package fuerzaArmadaTipoParcialTDD;

import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.Test;

public class TestFuerzasArmadaArg {
	
	@Test
	public void queSePuedaCrearUnObjetoVolador() {
		//Vehiculo avion1 = new Volador();
		Volador avion = new Avion(1, "A-10","abc123");

		assertEquals(0.0, avion.getAltura(), 0.01);
	}

	@Test
	public void queSePuedaCrearUnObjetoTerrestre() {
		//Vehiculo tanque = new Terrestre();
		Terrestre tanque = new Tanque(5, "Renault FT","cde231");

		assertEquals(0.0, tanque.getVelocidad(), 0.1);
	}

	@Test
	public void queSePuedaCrearUnObjetoAcuatico() {
		//Vehiculo submarino = new Acuatico();
		Acuatico submarino = new Submarino(8, "ARA - San Juan","efg321");

		assertEquals(0.0, submarino.getProfundidad(), 0.01);
	}

	@Test
	public void queSePuedaCrearUnObjetoAnfibio() {
		//Vehiculo var = new Anfibio();
		Anfibio var = new Anfibio(12, "LARC-5","ghi123");

		assertEquals(0.0, var.getVelocidad(), 0.01);
		assertEquals(0.0, var.getProfundidad(), 0.01);
	}

	@Test
	public void queSePuedaCrearUnHidroavion() {
		//Vehiculo ag600 = new HidroAvion();
		HidroAvion ag600 = new HidroAvion(12, "AG600","ijk213");

		assertEquals(0.0, ag600.getAltura(), 0.01);
		assertEquals(0.0, ag600.getProfundidad(), 0.01);
	}

	@Test
	public void queSePuedaArmarElConvoy() {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.agregarVehiculo(new Avion(1, "A-10","abc123"));
		argentina.agregarVehiculo(new Avion(2, "A-10","vbj132"));
		argentina.agregarVehiculo(new Avion(3, "F-102","bcd231"));
		argentina.agregarVehiculo(new Avion(4, "F-15","bcd123"));
		argentina.agregarVehiculo(new Tanque(5, "Renault FT","cde456"));
		argentina.agregarVehiculo(new Camion(6, "T-72","cde235"));
		argentina.agregarVehiculo(new Camion(7, "T-72","edf145"));
		argentina.agregarVehiculo(new Submarino(8, "ARA - San Juan","bcd456"));
		argentina.agregarVehiculo(new Portaviones(9, "A-10","jkl123"));
		argentina.agregarVehiculo(new Destructor(10, "A-10","lmo456"));
		argentina.agregarVehiculo(new Destructor(11, "A-10","lmo123"));
		argentina.agregarVehiculo(new HidroAvion(12, "Mitsubishi F1M","jkl345"));
		argentina.agregarVehiculo(new Anfibio(12, "LARC-5","rty123"));

		assertEquals((Integer)12, argentina.getCapacidadDeDefensa());
		
	}

	@Test
	public void queSePuedaCrearUnaBatalla() {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);
	
		assertEquals((Double)100.5, argentina.getBatalla("San Lorenzo").getLatitud(),0.01);
		assertEquals((Double)20.3, argentina.getBatalla("San Lorenzo").getLongitud(),0.01);

	}

	@Test
	public void queSePuedaPresentarBatallaTerrestre() throws VehiculoInexistente, VehiculoIncompatible {
		FuerzaArmada argentina = new FuerzaArmada();
		
		argentina.agregarVehiculo(new Avion(1, "A-10","abc123"));
		argentina.agregarVehiculo(new Avion(2, "A-10","vbj132"));
		argentina.agregarVehiculo(new Avion(3, "F-102","bcd231"));
		argentina.agregarVehiculo(new Avion(4, "F-15","bcd123"));
		argentina.agregarVehiculo(new Submarino(8, "A-10","cde456"));
		argentina.agregarVehiculo(new Portaviones(9, "A-10","cde235"));
		argentina.agregarVehiculo(new Destructor(10, "A-10","edf145"));
		argentina.agregarVehiculo(new Destructor(11, "A-10","bcd456"));
		argentina.agregarVehiculo(new HidroAvion(12, "A-10","jkl123"));
		argentina.agregarVehiculo(new Anfibio(13, "A-10","lmo456"));	
		argentina.agregarVehiculo(new Tanque(5, "Renault FT","lmo123"));
		argentina.agregarVehiculo(new Camion(6, "T-72","jkl345"));
		argentina.agregarVehiculo(new Camion(7, "T-72","rty123"));
		
		assertEquals((Integer)13, argentina.getCapacidadDeDefensa());
		
		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);
		argentina.presentarBatalla();
		
		assertTrue(argentina.enviarALaBatalla("San Lorenzo", 5));
		assertTrue(argentina.enviarALaBatalla("San Lorenzo", 6));
		assertTrue(argentina.enviarALaBatalla("San Lorenzo", 7));
		
	}
	
	@Test
	public void queSePuedaPresentarBatallaNaval() throws VehiculoInexistente, VehiculoIncompatible {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.agregarVehiculo(new Submarino(8, "A-10","abc123"));
		argentina.agregarVehiculo(new Portaviones(9, "A-10","abc234"));
		argentina.agregarVehiculo(new Destructor(10, "A-10","abc124"));
		argentina.agregarVehiculo(new Destructor(11, "A-10","bcd234"));
		argentina.agregarVehiculo(new HidroAvion(12,"A-10","bcd123"));
		argentina.agregarVehiculo(new Anfibio(13, "A-10","jkl456"));

		assertEquals((Integer)6, argentina.getCapacidadDeDefensa());
		
		argentina.crearBatalla("Pacifico", TipoDeBatalla.NAVAL, 200.5, 45.8);
        argentina.presentarBatalla();
		
		assertTrue(argentina.enviarALaBatalla("Pacifico", 8));
		assertTrue(argentina.enviarALaBatalla("Pacifico", 9));
		assertTrue(argentina.enviarALaBatalla("Pacifico", 10));		
		assertTrue(argentina.enviarALaBatalla("Pacifico", 11));		
		assertTrue(argentina.enviarALaBatalla("Pacifico", 12));		
		assertTrue(argentina.enviarALaBatalla("Pacifico", 13));	
			
	}
			
	@Test (expected = VehiculoIncompatible.class)
	public void queSeNoSePuedaEnviarAUnaBatallaEnTierraUnBarco() throws VehiculoInexistente, VehiculoIncompatible {
		FuerzaArmada argentina = new FuerzaArmada();
		
		argentina.agregarVehiculo(new Tanque(5, "Renault FT","abc123"));
		argentina.agregarVehiculo(new Camion(6, "T-72","abc234"));
		argentina.agregarVehiculo(new Camion(7, "T-72","abc124"));
		argentina.agregarVehiculo(new Destructor(11, "A-10","jkl214"));
		
		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);
		
		assertFalse(argentina.enviarALaBatalla("San Lorenzo", 11));
		
	}
	
	@Test (expected = VehiculoIncompatible.class)
	public void queSeNoSePuedaEnviarAUnaBatallaNavalUnCamion() throws VehiculoInexistente, VehiculoIncompatible {
		FuerzaArmada argentina = new FuerzaArmada();
		
		argentina.agregarVehiculo(new Submarino(8, "A-10","abc123"));
		argentina.agregarVehiculo(new Portaviones(9, "A-10","abc234"));
		argentina.agregarVehiculo(new Destructor(10, "A-10","abc124"));
		argentina.agregarVehiculo(new Camion(7, "T-72","abc124"));
		
		argentina.crearBatalla("Pacifico", TipoDeBatalla.NAVAL, 100.5, 20.3);
		
		assertFalse(argentina.enviarALaBatalla("Pacifico", 7));
		
	}
	
	@Test (expected = VehiculoInexistente.class)
	public void queSeNoSePuedaEnviarAUnaBatallaUnVehiculoQueNoExista() throws VehiculoInexistente, VehiculoIncompatible {
		FuerzaArmada argentina = new FuerzaArmada();
		
		argentina.agregarVehiculo(new Tanque(5, "Renault FT","asd123"));
		argentina.agregarVehiculo(new Camion(6, "T-72","acb125"));
		argentina.agregarVehiculo(new Camion(7, "T-72","fbn456"));
		argentina.agregarVehiculo(new Destructor(11, "A-10","iou123"));
		
		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);
		
		assertFalse(argentina.enviarALaBatalla("San Lorenzo", 4));
	}
	
	@Test
	public void queSePuedaOrdenarPorIDElConvoyDeLaFuerzasArmadasUsandoComparable() {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.agregarVehiculo(new Avion(1, "A-10","abc123"));
		argentina.agregarVehiculo(new Avion(2, "A-10","vbj132"));
		argentina.agregarVehiculo(new Avion(3, "F-102","bcd231"));
		argentina.agregarVehiculo(new Avion(4, "F-15","bcd123"));
		argentina.agregarVehiculo(new Tanque(5, "Renault FT","cde456"));
		argentina.agregarVehiculo(new Camion(6, "T-72","cde235"));

		System.out.println("-------------VehiculosOrdenadosPorId-------------");
		TreeSet<Vehiculo>todosLosVehiculosOrdenados=argentina.obtenerConvoyOrdenadosPorId();
		for (Vehiculo vehiculo : todosLosVehiculosOrdenados) {
			System.out.println(""+vehiculo.toString());
		}
			
	}
	
	@Test
	public void queSePuedaOrdenarPorPatenteElConvoyDeLaFuerzasArmadasUsandoComparator() {
		FuerzaArmada argentina = new FuerzaArmada();

		argentina.agregarVehiculo(new Avion(1, "A-10","abc123"));
		argentina.agregarVehiculo(new Avion(2, "A-10","vbj132"));
		argentina.agregarVehiculo(new Avion(3, "F-102","bcd231"));
		argentina.agregarVehiculo(new Avion(4, "F-15","bcd123"));
		argentina.agregarVehiculo(new Tanque(5, "Renault FT","cde456"));
		argentina.agregarVehiculo(new Camion(6, "T-72","cde235"));
		
		System.out.println("-------------VehiculosOrdenadosPorPatente-------------");
		TreeSet<Vehiculo>todosLosVehiculosOrdenadosPorPatente=argentina.obtenerConvoyOrdenadosPorPatente();
		for (Vehiculo vehiculo : todosLosVehiculosOrdenadosPorPatente) {
			System.out.println(""+vehiculo.toString());
		}
		
	}
	
}
