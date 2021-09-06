package turismoEnLaTierraMedia;

import java.util.List;

public abstract class Promocion implements Sugerible {
	protected List <Atraccion> atracciones; 
	protected TipoDeAtraccion tipo;
	protected double tiempoTotal;
	protected String nombreDeLaPromo;
	
	public Promocion(String nombreDeLaPromo, List<Atraccion> atraccion, TipoDeAtraccion tipo) {
		this.nombreDeLaPromo = nombreDeLaPromo;
		this.atracciones = atraccion;
		this.tipo = tipo;
	} 
	
	
	public boolean esPromocion() {
		return true;
	}
	
	public boolean hayCupo() {
		for(Atraccion a: this.atracciones) {
			if(!a.hayCupo()) return false;
		}
		return true;
	}
	
	public double getTiempo() {
		for (int i=0; i<this.atracciones.size();i++) {
		tiempoTotal += this.atracciones.get(i).getTiempo();
	   }
	 return tiempoTotal;	
	}
	
	public TipoDeAtraccion getTipo() {
		return this.tipo;
	}
	
}
