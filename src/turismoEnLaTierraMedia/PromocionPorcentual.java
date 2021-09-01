package turismoEnLaTierraMedia;

import java.util.List;

public class PromocionPorcentual extends Promocion {
	
	private double porcentajeDescuento;
	private double tiempoTotal;
	private int precioFinal;
	
	public PromocionPorcentual(List<Atraccion> atracciones, TipoDeAtraccion tipo, 
			double porcentajeDescuento) {
		super(atracciones, tipo);
		this.porcentajeDescuento = porcentajeDescuento;
	}


	@Override
	public int getCosto() {
		//ver redondeo
		return  (int) (precioFinal*(1-porcentajeDescuento));
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
	//suma de todos los costos de las atracciones
	protected void precioFinal() {
		for (int i = 0; i < super.atracciones.size(); i++) {
			precioFinal += super.atracciones.get(i).getCosto();
		}
	}

}
