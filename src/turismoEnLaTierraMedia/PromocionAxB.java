package turismoEnLaTierraMedia;

import java.util.List;

public class PromocionAxB extends Promocion {
	// la atraccion gratis la pasamos por archivo (la ultima atraccion)

	private int precioFinal;
	
	private Atraccion atraccionGratis;

	public PromocionAxB(String nombreDeLaPromo, Atraccion atraccionGratis, List<Atraccion> atracciones,
			TipoDeAtraccion tipo) {
		super(nombreDeLaPromo, atracciones, tipo);
		
		
		this.atraccionGratis = atraccionGratis;
		
	}

	@Override
	public int getCosto() {
		precioFinal = 0;
		
		for (int i = 0; i < super.atracciones.size(); i++) {
			if (super.atracciones.get(i).getNombre() != atraccionGratis.getNombre())
				precioFinal += super.atracciones.get(i).getCosto();
		}
		return this.precioFinal;
	}

	@Override
	public String toString() {
		String nombreDeLasAtracciones = "";
		for (Atraccion a : atracciones) {
			nombreDeLasAtracciones += a.getNombre() + ", ";
		}
		return "PromocionAxB: " + nombreDeLaPromo + ", Tipo : " + tipo + "\n " + "  Atracciones Incluidas: " + atraccionGratis.getNombre()
				+ ", " + nombreDeLasAtracciones + "\n " + "  Tiempo Total: " + this.getTiempo() + ", Precio Total: "
				+ this.getCosto() + "\n";
	}
	
	@Override
	public double getTiempo() {
		tiempoTotal = 0;
		for (int i = 0; i < this.atracciones.size(); i++) {
			tiempoTotal += this.atracciones.get(i).getTiempo();
		}
		tiempoTotal += atraccionGratis.getTiempo();
		return tiempoTotal;
	}
	
	public Atraccion getAtraccionGratis() {
		return this.atraccionGratis;
	}
	
	@Override
	public boolean esOContiene(Sugerible s) {
		if(this.atraccionGratis.equals(s)) {
			return true;
		}
		else for (Atraccion a : super.atracciones) {
			if (a.equals(s))
				return true;
		}
		return false;
	}


}
