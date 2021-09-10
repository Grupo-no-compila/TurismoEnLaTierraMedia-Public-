package turismoEnLaTierraMedia;

import java.util.LinkedList;
import java.util.List;

public interface Sugerible {
	
	List <Atraccion> atraccionComprada = new LinkedList<Atraccion>();

	public int getCosto();
	
	public TipoDeAtraccion getTipo();
	
	public double getTiempo();
	
	public boolean hayCupo();
	
	public boolean esPromocion();

	public boolean esOContiene(Sugerible atraccion);

	public void restarCupo();



}
