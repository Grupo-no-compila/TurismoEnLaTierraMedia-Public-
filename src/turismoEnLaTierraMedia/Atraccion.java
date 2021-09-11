package turismoEnLaTierraMedia;

import java.util.Objects;

public class Atraccion implements Sugerible {
	private int costo;
	protected String nombre;
	private TipoDeAtraccion tipo;
	private double tiempo;
	private int cupo;

	public Atraccion(String nombre, int costo, double tiempo, int cupo, TipoDeAtraccion tipo) {
		this.nombre = nombre;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.tipo = tipo;
	}

	public boolean hayCupo() {
		return this.cupo > 0;
	}

	public void restarCupo() {
		this.cupo--;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(costo, cupo, nombre, tiempo, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atraccion other = (Atraccion) obj;
		return costo == other.costo && Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(tiempo) == Double.doubleToLongBits(other.tiempo) && tipo == other.tipo;
	}

	public double getTiempo() {
		return this.tiempo;
	}

	public int getCosto() {
		return this.costo;
	}

	public TipoDeAtraccion getTipo() {
		return this.tipo;
	}

	@Override
	public boolean esPromocion() {

		return false;
	}

	@Override
	public String toString() {
		return "Atraccion " + nombre + ", Costo: " + costo + ", Tiempo: " + tiempo + ", Cupo: " + cupo + ", tipo: "
				+ tipo;
	}

	public String getNombre() {
		return this.nombre;
	}

	@Override
	public boolean esOContiene(Sugerible sugerencia) {
		
		return this.equals(sugerencia);
				
	}

}
