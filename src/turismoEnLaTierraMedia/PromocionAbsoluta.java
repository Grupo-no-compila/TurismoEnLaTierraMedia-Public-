package turismoEnLaTierraMedia;

import java.util.List;

public class PromocionAbsoluta extends Promocion {
	private int precioFinal;
	
	public PromocionAbsoluta(List<Atraccion> atracciones, 
			TipoDeAtraccion tipo, int precioFinal) {
		super(atracciones, tipo);
		this.precioFinal = precioFinal;
		
	}

	
	@Override
	public int getCosto() {
		return this.precioFinal;
	}
}
