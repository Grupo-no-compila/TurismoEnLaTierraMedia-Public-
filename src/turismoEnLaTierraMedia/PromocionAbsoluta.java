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

	@Override
	public String toString() {
		String nombreDeLasAtracciones = ""; 
		for(Atraccion a:atracciones) {
			nombreDeLasAtracciones += a.getNombre() + ", ";			
		}
		return "PromocionAbsoluta: " + nombreDeLaPromo + ", Tipo: " + tipo + "\n" 
				+ "   Atracciones Incluidas: " + nombreDeLasAtracciones + "\n" 
				+ "   Tiempo Total: " + this.getTiempo()+ " horas " + ", Precio Total: " + 
				this.getCosto() + " monedas" + "\n" + "   Ahorro Comprando La Promo: " + 
				this.getAhorro()+ " monedas" + "\n" ;
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
		return  precioReal - this.precioFinal; 
	}
	
}
