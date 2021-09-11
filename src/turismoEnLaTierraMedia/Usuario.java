package turismoEnLaTierraMedia;

import java.util.LinkedList;
import java.util.List;

public class Usuario {
	private String nombre;
	private int presupuesto;
	private double tiempoDisponible;
	private TipoDeAtraccion atraccionFavorita;
	protected List<Sugerible> sugerenciaComprada = new LinkedList<Sugerible>();
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
		s.restarCupo();
		sugerenciaComprada.add(s);
		if (s.esPromocion()) {
			Promocion promo = (Promocion) s;
			for (Atraccion a : promo.getAtracciones()) {
				atraccionesCompradas.add(a);
			}
		} else {
			Atraccion atraccion = (Atraccion) s;
			atraccionesCompradas.add(atraccion);
		}

	}

	public boolean yaCompro(Sugerible sugerencia) {

		for (Sugerible s : atraccionesCompradas) {
			if (sugerencia.esOContiene(s)) {
				return true;
			}

		}

		return false;

	}

	// if(atraccion.esPromocion()) {
	// return atraccionComprada.contains(atraccion);
	// }else {
	// for(Sugerible s: atraccionComprada) {
	// return s.esOContiene(atraccion);
	// }
	// }
	// return true;
	// }
//	public boolean yaComproPromo(Promocion promocion) {
//		for(int i = 0; i <promocion.getAtracciones().size(); i++) {
//			if(this.yaCompro(promocion.getAtracciones().get(i)))  {
//			return true;
//			}
//		}
//		return false;
//	}

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
		return "Usuario: " + nombre + ", Presupuesto: " + presupuesto + ", Tiempo Disponible: " + tiempoDisponible
				+ ", Atraccion Favorita: " + atraccionFavorita;
	}

}
