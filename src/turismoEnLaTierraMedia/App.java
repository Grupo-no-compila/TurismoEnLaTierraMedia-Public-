package turismoEnLaTierraMedia;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class App {

	private static List<Atraccion> atracciones;
	private static List<Usuario> usuarios;
	private static List<Promocion> promociones;
	private static List<Sugerible> sugeribles;

	public static void main(String[] args) {

		atracciones = new LinkedList<Atraccion>();
		usuarios = new LinkedList<Usuario>();
		promociones = new LinkedList<Promocion>();
		sugeribles = new LinkedList<Sugerible>();

		atracciones = AdministradorDeArchivos.leerAtracciones(); // Lee el archivo, crea las atracciones y las guarda en
																	// una lista
		sugeribles.addAll(atracciones);
		usuarios = AdministradorDeArchivos.leerUsuarios(); // Lee el archivo, crea a los usuarios y los guarda en una
															// lista
		promociones = AdministradorDeArchivos.leerPromociones(); // Lee el archivo, crea las promociones y las guarda en
																	// una lista
		sugeribles.addAll(promociones);

		System.out.println("Leer los archivos y crear las atracciones\n");
		for (Atraccion a : atracciones)
			System.out.println(a); // Recorre cada atraccion de la lista y las imprime en consola
		System.out.println("------------------------------------------------------------------\n");

		System.out.println("Leer los archivos y crear a los usuarios\n");
		for (Usuario u : usuarios)
			System.out.println(u); // Recorre cada usuario de la lista y los imprime en consola
		System.out.println("------------------------------------------------------------------\n");

		System.out.println("Leer los archivos y crear las promociones\n");
		for (Promocion p : promociones)
			System.out.println(p); // Recorre cada usuario de la lista y los imprime en consola
		System.out.println("------------------------------------------------------------------\n");

		// System.out.println("Atracciones compradas por cada usuario\n");

		for (Usuario u : usuarios) {
			System.out.println(u.getNombre() + ":\n");
			sugeribles.sort(new ComparadorDeSugeribles(u)); // Ordena las atracciones segun preferencia del usuario

			for (Sugerible s : sugeribles) {
				if (u.puedeCostear(s) && u.tieneTiempo(s) && !u.yaCompro(s) && s.hayCupo()) {

					System.out.println(s); // Recorre cada atraccion(ya odenadas) e imprime la que el usuario puede
											// pagar, si tiene tiempo y si NO compro esa atraccion anteriormente
					u.comprarSugerible(s);
					
				}

			}
			System.out.println("------------------------------------------------------------------\n");
			
//  		JOptionPane.showInputDialog("Elegir una atraccion");
		}
		// for(Promocion p : promociones) System.out.println(p); //Recorre cada
		// promocion y la imprime en la consola
		AdministradorDeArchivos.escribirItinerarioDeLosUsuarios(usuarios);
	}

}
