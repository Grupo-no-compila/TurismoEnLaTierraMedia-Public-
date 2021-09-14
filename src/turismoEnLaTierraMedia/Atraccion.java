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
	
	public Atraccion(String nombre) {
		this.nombre = nombre;
		
	}

	//public int getCupo() {
	//	return cupo;
	//}

	@Override
	public boolean hayCupo() {
		return this.cupo > 0;
	}

	@Override
	public void restarCupo() {
		this.cupo--;
	}

	@Override
	public double getTiempo() {
		return this.tiempo;
	}

	@Override
	public int getCosto() {
		return this.costo;
	}

	public String getNombre() {
		return this.nombre;
	}

	@Override
	public TipoDeAtraccion getTipo() {
		return this.tipo;
	}

	@Override
	public boolean esPromocion() {
		return false;
	}

	@Override
	public String toString() {
		return "Atraccion " + nombre + ", Tiempo: " + tiempo + ", Costo: " + costo + ", Tipo: " + tipo + "\n";
	}

	@Override
	public boolean esOContiene(Sugerible sugerencia) {
		return this.equals(sugerencia);
	}

	@Override
	public int hashCode() {
		return Objects.hash(costo, nombre, tiempo, tipo);
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

}
