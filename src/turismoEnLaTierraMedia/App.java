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
			System.out.println("   " + p); // Recorre cada usuario de la lista y los imprime en consola
		System.out.println("------------------------------------------------------------------\n");

		for (Usuario u : usuarios) {
			System.out.println("Usuario: " + u.getNombre());
			System.out.println("\n");
			System.out.println("Promociones sugeridas:\n");

			sugeribles.sort(new ComparadorDeSugeribles(u));
			for (Sugerible s1 : sugeribles) {

				if (u.tieneTiempo(s1) && u.puedeCostear(s1) && !u.yaCompro(s1) && s1.hayCupo()) {
					sugeriblesUsuario.add(s1);
					System.out.println(sugeriblesUsuario.lastIndexOf(s1) + 1 + ") " + s1);
				}
			}

			for (Sugerible ss : sugeriblesUsuario) {
				int w = 1;
				while (u.getPresupuesto() >= ss.getCosto() && u.getTiempoDisponible() >= ss.getTiempo()
						&& !u.yaCompro(ss) && ss.hayCupo()) {

					System.out.println("\n");

					System.out.println(
							"Por favor elija número de Sugerencia que desea comprar, para salir escriba '0' (cero): ");

					String opcion = "";

					Scanner entradaEscanerOpcion = new Scanner(System.in); // Creación de un objeto Scanner;

					opcion = entradaEscanerOpcion.nextLine(); // Invocamos un método sobre un objeto Scanner;

					if (opcion.equals("0")) {
						System.out.println("Tiempo disponible de " + u.getNombre() + ": " + u.getTiempoDisponible() + " horas");
						System.out.println("Presupuesto restante: " + u.getPresupuesto() + " monedas de oro");
						sugeriblesUsuario = new LinkedList<Sugerible>();
						System.out.println("\n");
						w = 0;
						break;
					}

					if (Integer.parseInt(opcion) < 0 || Integer.parseInt(opcion) >= sugeriblesUsuario.size() + 1) {
						System.out.println("Sugerencia no encontrada");
						break;
					}

					for (Sugerible s2 : sugeribles) {

						if (Integer.parseInt(opcion) == sugeriblesUsuario.lastIndexOf(s2) + 1 && u.tieneTiempo(s2)
								&& u.puedeCostear(s2) && !u.yaCompro(s2) && s2.hayCupo())
							u.comprarSugerible(s2);
					}

					System.out.println("Tiempo disponible de " + u.getNombre() + ": " + u.getTiempoDisponible() + " horas");
					System.out.println("Presupuesto restante: " + u.getPresupuesto() + " monedas de oro");
					System.out.println("\n");

					sugeriblesUsuario = new LinkedList<Sugerible>();
					sugeribles.sort(new ComparadorDeSugeribles(u));

					for (Sugerible s3 : sugeribles) {

						if (u.tieneTiempo(s3) && u.puedeCostear(s3) && !u.yaCompro(s3) && s3.hayCupo()) {
							sugeriblesUsuario.add(s3);
							System.out.println(sugeriblesUsuario.indexOf(s3) + 1 + "-" + s3);
						}
						AdministradorDeArchivos.escribirItinerarioDeLosUsuarios(usuarios);
					}
				}
				if (w == 0) {
					break;
				}
			}

		}
		System.out.println("No hay más usuarios");
	}
}