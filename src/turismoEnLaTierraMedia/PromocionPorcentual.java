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
			precioARedondear = -((precioFinal*(porcentajeDescuento/100))-precioFinal);
			
		}
		return  (int) Math.round(precioARedondear);
	}


	@Override
	public String toString() {
		String nombreDeLasAtracciones = ""; 
		for(Atraccion a:atracciones) {
			nombreDeLasAtracciones += a.getNombre() + ", ";
		}
		return "PromocionPorcentual: " + nombreDeLaPromo + ", Atracciones: " + nombreDeLasAtracciones
				+ "Precio Final: " + this.getCosto() + ", Tipo: " + tipo + ", Tiempo Total: " + this.getTiempo()
				+ ", Porcentaje De Descuento: " + porcentajeDescuento;
	}
	
	@Override
	public void restarCupo() {
		for (Atraccion a : super.atracciones) {
			a.restarCupo();
		}
	}
	
}
