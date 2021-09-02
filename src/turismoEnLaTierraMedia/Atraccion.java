package turismoEnLaTierraMedia;

import java.util.Objects;

public class Atraccion implements Comparable <Atraccion>{
	private int costo;
	private String nombre;
	private TipoDeAtraccion tipo;
	private double tiempo;
	private int cupo;
	
	
	@Override
	public int compareTo(Atraccion o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public boolean hayCupo() {
		return true;
	}
	
	public void restarCupo() {
		
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
		return costo == other.costo && cupo == other.cupo && Objects.equals(nombre, other.nombre)
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
	
}
