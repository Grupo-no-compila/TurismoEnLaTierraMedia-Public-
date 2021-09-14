package turismoEnLaTierraMedia;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class App {

	private static List<Atraccion> atracciones;
	private static List<Usuario> usuarios;
	private static List<Promocion> promociones;
	private static List<Sugerible> sugeribles;
	private static List<Sugerible> sugeriblesUsuario;

	public static void main(String[] args) {

		atracciones = new LinkedList<Atraccion>();
		usuarios = new LinkedList<Usuario>();
		promociones = new LinkedList<Promocion>();
		sugeribles = new LinkedList<Sugerible>();
		sugeriblesUsuario = new LinkedList<Sugerible>();

		atracciones = AdministradorDeArchivos.leerAtracciones(); // Lee el archivo, crea las atracciones y las guarda en
																	// una lista
		sugeribles.addAll(atracciones);
		usuarios = AdministradorDeArchivos.leerUsuarios(); // Lee el archivo, crea a los usuarios y los guarda en una
															// lista
		promociones = AdministradorDeArchivos.leerPromociones(); // Lee el archivo, crea las promociones y las guarda en
																	// una lista
		sugeribles.addAll(promociones);

		System.out.println("USUARIOS\n");
		for (Usuario u : usuarios)
			System.out.println(u); // Recorre cada usuario de la lista y los imprime en consola
		System.out.println("------------------------------------------------------------------\n");

		System.out.println("ATRACCIONES\n");
		for (Atraccion a : atracciones)
			System.out.println(a); // Recorre cada atraccion de la lista y las imprime en consola
		System.out.println("------------------------------------------------------------------\n");

		System.out.println("PROMOCIONES\n");
		for (Promocion p : promociones)
			System.out.println(p); // Recorre cada usuario de la lista y los imprime en consola
		System.out.println("------------------------------------------------------------------\n");

		for (Usuario u : usuarios) {

			System.out.println("********************\n");
			System.out.println("USUARIO: " + u.getNombre());

			sugeribles.sort(new ComparadorDeSugeribles(u));

			for (Sugerible s1 : sugeribles) {

				while (u.tieneTiempo(s1) && u.puedeCostear(s1) && !u.yaCompro(s1) && s1.hayCupo()) {
					sugeriblesUsuario.add(s1);

					System.out.println("=============================================================\n");

					System.out.println("ACTIVIDAD SUGERIDA:");

					System.out.println(s1);

					System.out.println("\n");

					System.out.println("Oprima 'S' para comprar o 'N' para continuar");

					String opcion = "";

					Scanner entradaEscanerOpcion = new Scanner(System.in); // Creación de un objeto Scanner;

					opcion = entradaEscanerOpcion.nextLine(); // Invocamos un método sobre un objeto Scanner;

					if (opcion.equals("n") || opcion.equals("N")) {
						System.out.println("\n");
						AdministradorDeArchivos.escribirItinerarioDeLosUsuarios(usuarios);
						break;
					}
					if (opcion.equals("s") || opcion.equals("S")) {
						u.comprarSugerible(s1);
						System.out.println("SUGERENCIA COMPRADA");
						System.out.println("TIEMPO DISPONIBLE: " + u.getTiempoDisponible());
						System.out.println("PRESUPUESTO RESTANTE: " + u.getPresupuesto());
						AdministradorDeArchivos.escribirItinerarioDeLosUsuarios(usuarios);
						continue;
					}
					if (!opcion.equals("s") || !opcion.equals("n") || opcion.equals("N") || opcion.equals("S")) {
						System.out.println("Entrada incorrecta");
						System.out.println("\n");
						continue;
					}

				}

			}
			System.out.println("\n");

		}
		System.out.println("NO HAY MÁS USUARIOS");
	}
}