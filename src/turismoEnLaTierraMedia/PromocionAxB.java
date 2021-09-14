package turismoEnLaTierraMedia;

import java.util.List;

public class PromocionAxB extends Promocion {
	// la atraccion gratis la pasamos por archivo (la ultima atraccion)

	private int precioFinal;

	public PromocionAxB(String nombreDeLaPromo, List<Atraccion> atracciones, TipoDeAtraccion tipo) {
		super(nombreDeLaPromo, atracciones, tipo);
	}

	@Override
	public int getCosto() {
		precioFinal = 0;
		//super.atracciones.sort(new ComparadorDePrecio()); 
		for (int i = 0; i < super.atracciones.size()-1; i++) {
			precioFinal += super.atracciones.get(i).getCosto();
		}
		return this.precioFinal;
	}

	@Override
	public String toString() {
		String nombreDeLasAtracciones = ""; 
		for(Atraccion a:atracciones) {
			nombreDeLasAtracciones += a.getNombre() + ", ";
		}
		return "PromocionAxB: " + nombreDeLaPromo + ", Tipo : " + tipo + "\n " + 
				"   Atracciones Incluidas: " + nombreDeLasAtracciones + "\n " 
				+ "   Tiempo Total: " + this.getTiempo() + ", Precio Total: " + this.getCosto() + "\n" ;
	}

	

}
