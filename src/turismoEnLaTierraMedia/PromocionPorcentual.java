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
		precioFinal = 0;
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
		return "PromocionPorcentual: " + nombreDeLaPromo + ", Tipo: " + tipo + 
				", Porcentaje De Descuento: " + porcentajeDescuento + "%"
				+ "\n" +"   Atracciones Incluidas: " + nombreDeLasAtracciones + "\n"
				+ "   Tiempo Total: " + this.getTiempo() + " horas" + 
				", Precio Final: " + this.getCosto() + " monedas" + "\n" + 
				"   Ahorro Comprando La Promo: " + this.getAhorro() +" monedas" + "\n" ;
				
	}


	@Override
	public Atraccion getAtraccionGratis() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getAhorro() {
		int precioReal= 0;
		for(Atraccion a:super.atracciones) {
		precioReal += a.getCosto();
		} 
		return  (precioReal - this.getCosto());
	}

}
