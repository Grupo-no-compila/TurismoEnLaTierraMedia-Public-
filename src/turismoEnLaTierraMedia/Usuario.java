package turismoEnLaTierraMedia;

public class Usuario {
	private String nombre;
	private int presupuesto;
	private double tiempoDisponible;
	private TipoDeAtraccion atraccionFavorita;
	private Atraccion[] atraccionComprada;
	private int monedasGastadas;
	private int horasGastadas;
	
	public boolean yaCompro(Atraccion atraccion) {
		return false;
		
	}
	
	public boolean tieneTiempo(Atraccion atraccion) {
		return false;
		
	}
	
	public boolean puedeCostear(Atraccion atraccion) {
		return false;
		
	}
}
