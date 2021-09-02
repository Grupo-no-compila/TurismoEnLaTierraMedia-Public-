package turismoEnLaTierraMedia;

import java.util.List;

public class PromocionAxB extends Promocion {
	//la atraccion gratis la pasamos por archivo (la ultima atraccion)
	
	private int precioFinal;
	
	public PromocionAxB(List<Atraccion> atracciones, TipoDeAtraccion tipo) {
		super(atracciones, tipo);
	}


	@Override
	public int getCosto() {
		for (int i = 0; i < super.atracciones.size()-1; i++) {
			precioFinal += super.atracciones.get(i).getCosto();
		}
		return this.precioFinal;
	}
}
