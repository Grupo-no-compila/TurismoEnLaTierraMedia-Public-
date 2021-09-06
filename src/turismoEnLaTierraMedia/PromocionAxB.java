package turismoEnLaTierraMedia;

import java.util.List;

public class PromocionAxB extends Promocion {
	//la atraccion gratis la pasamos por archivo (la ultima atraccion)
	
	private int precioFinal;

	
	public PromocionAxB(String nombreDeLaPromo, List<Atraccion> atracciones, TipoDeAtraccion tipo) {
		super(nombreDeLaPromo, atracciones, tipo);
	}


	@Override
	public int getCosto() {
		for (int i = 0; i < super.atracciones.size()-1; i++) {
			precioFinal += super.atracciones.get(i).getCosto();
		}
		return this.precioFinal;
	}
	


	@Override
	public String toString() {
		
		return "PromocionAxB [Nombre De La Promo: " + nombreDeLaPromo + ", Atracciones Incluidas: " +
				atracciones + ", tipo : " + tipo
				+ ", tiempoTotal: " + this.getTiempo() + ", Precio Total: " + this.getCosto() + "]";
	}
	
	
}
