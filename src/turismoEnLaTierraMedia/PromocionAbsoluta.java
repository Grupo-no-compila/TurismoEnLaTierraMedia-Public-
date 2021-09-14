package turismoEnLaTierraMedia;

import java.util.List;

public class PromocionAbsoluta extends Promocion {
	private int precioFinal;
	
	public PromocionAbsoluta(String nombreDeLaPromo, List<Atraccion> atracciones, 
			TipoDeAtraccion tipo, int precioFinal) {
		super(nombreDeLaPromo, atracciones, tipo);
		this.precioFinal = precioFinal;		
	}
	
	@Override
	public int getCosto() {
		return this.precioFinal;
	}

	@Override
	public String toString() {
		String nombreDeLasAtracciones = ""; 
		for(Atraccion a:atracciones) {
			nombreDeLasAtracciones += a.getNombre() + ", ";			
		}
		return "PromocionAbsoluta: " + nombreDeLaPromo + ", Tipo: " + tipo + "\n" 
				+ "   Atracciones Incluidas: " + nombreDeLasAtracciones + "\n" 
				+ "   Tiempo Total: " + this.getTiempo() + ", Precio Total: " + this.getCosto() + "\n" ;
	}
	
	
}
