package test;

import static org.junit.Assert.* ;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import turismoEnLaTierraMedia.TipoDeAtraccion;
import turismoEnLaTierraMedia.*;

@SuppressWarnings("unused")
public class PromocionTest {
Promocion p1;
Promocion p2;
Promocion p3;
Promocion p4;
Promocion p5;
List<Atraccion> listaAtracciones;
List<Promocion> listaPromo;

	@Before
	public void setUp() {
	listaAtracciones = AdministradorDeArchivos.leerAtracciones();
	listaPromo = AdministradorDeArchivos.leerPromociones();
	
	p1 = listaPromo.get(0);
	p2 = listaPromo.get(1);
	p3 = listaPromo.get(2);
	p4 = listaPromo.get(3);
	p5 = listaPromo.get(4);
	}
	
	
	/*
	@Test
	public void testCompila() {
		System.out.println(listaAtracciones);
		System.out.println(listaPromo);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);
		System.out.println(p5);
	}*/
	
	@Test
	public void testCosto() {
		assertEquals(22, p1.getCosto());
		assertEquals(36, p2.getCosto());
		assertEquals(10, p3.getCosto());
		assertEquals(26, p4.getCosto());
		assertEquals(10, p5.getCosto());
	}
		
	
	@Test
	public void testTiempo() {
		assertEquals(7, p1.getTiempo(),0);
		assertEquals(7.5, p2.getTiempo(),0);
		assertEquals(7.5, p3.getTiempo(),0);
		assertEquals(1, p4.getTiempo(),0);
		assertEquals(7.5, p5.getTiempo(),0);
		
	}
	
	@Test
	public void testTipo() {
		assertEquals(TipoDeAtraccion.AVENTURA, p1.getTipo());
		assertEquals(TipoDeAtraccion.DEGUSTACION, p2.getTipo());
		assertEquals(TipoDeAtraccion.PAISAJE, p3.getTipo());
		assertEquals(TipoDeAtraccion.DEGUSTACION, p4.getTipo());
		assertEquals(TipoDeAtraccion.PAISAJE, p5.getTipo());

	}
	/*
	@Test
	public void testContienAtraccion() {
		fail("Not yet implemented");
	} */

}
