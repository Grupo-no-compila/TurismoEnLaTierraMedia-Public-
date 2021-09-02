package turismoEnLaTierraMedia;

import java.util.Comparator;

public class ComparadorDeAtracciones implements Comparator<Atraccion>{
	private TipoDeAtraccion preferencia;
	
	public ComparadorDeAtracciones(TipoDeAtraccion preferencia) {
		this.preferencia = preferencia;
	}

	
	@Override
	public int compare(Atraccion A1, Atraccion A2) {		
		if(this.preferencia == A1.getTipo() //v1AUTO && v2MOTO
				&& this.preferencia != A2.getTipo()) 
			return -1;
		else if(this.preferencia != A1.getTipo() //v2AUTO && v1MOTO
				&& this.preferencia == A2.getTipo()) 
			return 1;
		else { //v1AUTO && v2AUTO || v1MOTO && v2CAMION
			return -1*Double.compare(A1.getCosto(), A2.getCosto());

			/*if(v1.getPrecio() > v2.getPrecio()) 
				return -1;
			else if(v1.getPrecio() < v2.getPrecio()) 
				return 1;
			else 
				return 0;*/
		}
	}
}

