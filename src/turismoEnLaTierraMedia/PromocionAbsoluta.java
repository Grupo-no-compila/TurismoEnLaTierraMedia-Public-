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
}
