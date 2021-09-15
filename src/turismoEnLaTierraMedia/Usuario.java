package turismoEnLaTierraMedia;

import java.util.LinkedList;
import java.util.List;

public class Usuario {
	private String nombre;
	private int presupuesto;
	private double tiempoDisponible;
	private int monedasGastadas;
	private double horasNecesarias;
	private TipoDeAtraccion atraccionFavorita;
	protected List<Sugerible> sugerenciasCompradas = new LinkedList<Sugerible>();
	protected List<Atraccion> atraccionesCompradas = new LinkedList<Atraccion>();

	public Usuario(String nombre, int presupuesto, double tiempoDisponible, TipoDeAtraccion atraccionFavorita) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.atraccionFavorita = atraccionFavorita;
	}
	

	public void comprarSugerible(Sugerible s) {
		this.tiempoDisponible -= s.getTiempo();
		this.presupuesto -= s.getCosto();
		this.monedasGastadas += s.getCosto();
		this.horasNecesarias += s.getTiempo();
		s.restarCupo();
		
		sugerenciasCompradas.add(s);
		if (s.esPromocion()) {
			atraccionesCompradas.add(s.getAtraccionGratis());
			Promocion promo = (Promocion) s;
			for (Atraccion a : promo.getAtracciones()) {
				atraccionesCompradas.add(a);
				
				//System.out.println(a.getNombre() + a.getCupo());
			}
		} else {
			Atraccion atraccion = (Atraccion) s;
			atraccionesCompradas.add(atraccion);
			//System.out.println(atraccion.getNombre() + atraccion.getCupo());
			
		}
	}


	public boolean yaCompro(Sugerible sugerencia) {
		for (Sugerible s : atraccionesCompradas) {
			if (sugerencia.esOContiene(s)) 
				return true;
		}
		return false;
	}

	public boolean tieneTiempo(Sugerible atraccion) {
		return (atraccion.getTiempo() <= this.tiempoDisponible);
	}

	public boolean puedeCostear(Sugerible atraccion) {
		return (atraccion.getCosto() <= this.presupuesto);
	}

	public TipoDeAtraccion getTipoFavorito() {
		return this.atraccionFavorita;
	}

	public String getNombre() {
		return this.nombre;
	}

	@Override
	public String toString() {
		return "Usuario: " + nombre + "\n" + "Tipo de atracci�n preferida: " + atraccionFavorita + "\n"
				+ " Monedas Gastadas: " + monedasGastadas + " monedas de oro" + ",  Tiempo necesario: " + horasNecesarias + " horas" + "\n"
				+ " Presupuesto Disponible: " + presupuesto + " monedas de oro" + ", Tiempo Disponible: " + tiempoDisponible + " horas" + "\n"
				;
	}

	public int getPresupuesto() {
		// TODO Auto-generated method stub
		return this.presupuesto;
	}

	public double getTiempoDisponible() {
		// TODO Auto-generated method stub
		return this.tiempoDisponible;
	}

}
