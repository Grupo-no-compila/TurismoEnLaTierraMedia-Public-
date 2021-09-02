package turismoEnLaTierraMedia;

import java.util.List;

public class Usuario {
	private String nombre;
	private int presupuesto;
	private double tiempoDisponible;
	private TipoDeAtraccion atraccionFavorita;
	private List <Atraccion> atraccionComprada;
	
	
	public Usuario(String nombre, int presupuesto, double tiempoDisponible, TipoDeAtraccion atraccionFavorita) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.atraccionFavorita = atraccionFavorita;
	}

	public void comprarAtraccion(Atraccion atraccion) {
		this.tiempoDisponible -= atraccion.getTiempo();
		this.presupuesto -= atraccion.getCosto();
	}
	
	public void comprarPromocion(Promocion promocion) {
		this.tiempoDisponible -= promocion.getTiempo();
		this.presupuesto -= promocion.getCosto();
	}
	
	public boolean yaCompro(Atraccion atraccion) {
		return atraccionComprada.contains(atraccion); 		 		
	}
	
	public boolean tieneTiempo(Atraccion atraccion) {
		return (atraccion.getTiempo()<= this.tiempoDisponible); 
	}
	
	public boolean puedeCostear(Atraccion atraccion) {
		return (atraccion.getCosto()<= this.presupuesto);
	}
	
	public TipoDeAtraccion getTipoFavorito() {
	return this.atraccionFavorita;
	}
}
