package turismoEnLaTierraMedia;

import java.util.List;

public class PromocionPorcentual extends Promocion {
	
	private double porcentajeDescuento;
	private int precioFinal;
	
	public PromocionPorcentual(String nombreDeLaPromo, List<Atraccion> atracciones, TipoDeAtraccion tipo, 
			double porcentajeDescuento) {
		super(nombreDeLaPromo, atracciones, tipo);
		this.porcentajeDescuento = porcentajeDescuento;
	}


	@Override
	public int getCosto() {
		double precioARedondear = 0;
		for (int i = 0; i < super.atracciones.size(); i++) {
			precioFinal += super.atracciones.get(i).getCosto();
			precioARedondear = precioFinal*(1-porcentajeDescuento);
			
		}
		return  (int) Math.round(precioARedondear);
	}
}
