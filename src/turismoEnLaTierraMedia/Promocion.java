package turismoEnLaTierraMedia;

import java.util.List;

public abstract class Promocion implements Sugerible {
	protected List<Atraccion> atracciones;
	protected TipoDeAtraccion tipo;
	protected double tiempoTotal;
	protected String nombreDeLaPromo;
	
	

	public Promocion(String nombreDeLaPromo, List<Atraccion> atraccion, TipoDeAtraccion tipo) {
		this.nombreDeLaPromo = nombreDeLaPromo;
		this.atracciones = atraccion;
		this.tipo = tipo;
	}

	
	
	@Override
	public boolean esPromocion() {
		return true;
	}

	@Override
	public boolean hayCupo() {
		for (Atraccion a : this.atracciones) {
			if (!a.hayCupo())
				return false;
		}		
		return true;
	}
	
	@Override
	public void restarCupo() {
		for (Atraccion a : this.atracciones) {
			a.restarCupo();
		}
	}

	@Override
	public double getTiempo() {
		tiempoTotal = 0;
		for (int i = 0; i < this.atracciones.size(); i++) {
			tiempoTotal += this.atracciones.get(i).getTiempo();
		}
		return tiempoTotal;
	}

	@Override
	public TipoDeAtraccion getTipo() {
		return this.tipo;
	}

	@Override
	public boolean esOContiene(Sugerible s) {
		for (Atraccion a : this.atracciones) {
			if (a.equals(s))
				return true;
		}
		return false;
	}

	public List<Atraccion> getAtracciones() {
		return atracciones;
	}

}
