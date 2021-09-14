package turismoEnLaTierraMedia;

import java.util.Comparator;

public class ComparadorDePrecio implements Comparator<Sugerible> {
	


	@Override
	public int compare(Sugerible s1, Sugerible s2) {

	 if (s1.getCosto() > s2.getCosto()) // Por precio
			return -1;

	 else if (s1.getCosto() < s2.getCosto())
			return 1;
	 
	 else
		 return Double.compare(s2.getTiempo(), s1.getTiempo());
	
	 
     }
}	