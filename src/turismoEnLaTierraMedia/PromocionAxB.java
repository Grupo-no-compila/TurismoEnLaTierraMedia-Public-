package turismoEnLaTierraMedia;

import java.util.List;

public class PromocionAxB extends Promocion {
	//la atraccion gratis la pasamos por archivo (la ultima atraccion)
	
	private double tiempoTotal;
	private int precioFinal;
	
	public PromocionAxB(List<Atraccion> atracciones, TipoDeAtraccion tipo) {
		super(atracciones, tipo);
	}


	@Override
	public int getCosto() {
		return this.precioFinal;
	}

	@Override
	protected void tiempoTotal() {
		for (int i = 0; i < super.atracciones.size(); i++) {
			tiempoTotal += super.atracciones.get(i).getTiempo();
		}
	}

	@Override
	public double getTiempo() {
		return tiempoTotal;
	}

	@Override
	protected void precioFinal() {
		for (int i = 0; i < super.atracciones.size()-1; i++) {
			precioFinal += super.atracciones.get(i).getCosto();
		}
	}

}
