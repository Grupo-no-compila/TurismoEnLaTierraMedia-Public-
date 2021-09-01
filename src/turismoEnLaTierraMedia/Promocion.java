package turismoEnLaTierraMedia;

import java.util.List;

public abstract class Promocion {
	protected List <Atraccion> atracciones; 
	private TipoDeAtraccion tipo;
	
	
	public Promocion(List<Atraccion> atraccion, TipoDeAtraccion tipo) {
		this.atracciones = atraccion;
		this.tipo = tipo;
	}

	protected abstract void precioFinal(); 

	protected abstract void tiempoTotal();

	protected abstract double getTiempo();

	protected abstract int getCosto();

}
