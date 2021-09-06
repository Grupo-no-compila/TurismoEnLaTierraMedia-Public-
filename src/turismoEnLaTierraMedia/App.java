package turismoEnLaTierraMedia;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class App {
	
	private static List<Atraccion> atracciones;
	private static List<Usuario> usuarios;
	private static List<Promocion> promociones;

	public static void main(String[] args) {
		
		atracciones = new LinkedList<Atraccion>();
		usuarios = new LinkedList<Usuario>();
		promociones = new LinkedList<Promocion>();
		
		System.out.println("Leer los archivos y crear las atracciones\n");
		atracciones = AdministradorDeArchivos.leerAtracciones(); //Lee el archivo, crea las atracciones y las guarda en una lista
		usuarios = AdministradorDeArchivos.leerUsuarios();		//Lee el archivo, crea a los usuarios y los guarda en una lista
		promociones = AdministradorDeArchivos.leerPromociones(); //Lee el archivo, crea las promociones y las guarda en una lista
		for(Atraccion a : atracciones) System.out.println(a); //Recorre cada atraccion de la lista y las imprime en consola
		System.out.println("------------------------------------------------------------------\n");
		System.out.println("Leer los archivos y crear a los usuarios\n");
		for (Usuario u : usuarios) System.out.println(u); 	//Recorre cada usuario de la lista y los imprime en consola
			
			
		System.out.println("------------------------------------------------------------------\n");
		
  		System.out.println("Atracciones ordenadas por preferencia, presupuesto y tiempo de los usuarios\n");
  		
  		for (Usuario u : usuarios) { 
  			System.out.println(u.getNombre() + ":\n");
  			atracciones.sort(new ComparadorDeSugeribles(u)); //Ordena las atracciones segun preferencia del usuario
  			for(Atraccion a : atracciones) {
  				if(u.puedeCostear(a) && u.tieneTiempo(a) && !u.yaCompro(a)) System.out.println(a); //Recorre cada atraccion(ya odenadas) e imprime la que el usuario puede pagar, si tiene tiempo y si NO compro esa atraccion anteriormente 
  			}
  		System.out.println("\n");
//  		JOptionPane.showInputDialog("Elegir una atraccion");
  		}
  		for(Promocion p : promociones) System.out.println(p); //Recorre cada promocion y la imprime en la consola
	}

}
