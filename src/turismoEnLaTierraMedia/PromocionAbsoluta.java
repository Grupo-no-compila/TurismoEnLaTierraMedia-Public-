package turismoEnLaTierraMedia;

import java.util.List;

public class PromocionAbsoluta extends Promocion {
	private int precioFinal;
	private double tiempoTotal;
	
	public PromocionAbsoluta(List<Atraccion> atracciones, 
			TipoDeAtraccion tipo, int precioFinal) {
		super(atracciones, tipo);
		this.precioFinal = precioFinal;
		
	}

	
	@Override
	public int getCosto() {
		return this.precioFinal;
	}

	
	@Override
	protected void tiempoTotal() {
		for (int i=0; i<super.atracciones.size();i++) {
			tiempoTotal += super.atracciones.get(i).getTiempo();
		}
	}


	@Override
	public double getTiempo() {
		return tiempoTotal;
	}


	@Override
	protected void precioFinal() {
		
	}
	
}
