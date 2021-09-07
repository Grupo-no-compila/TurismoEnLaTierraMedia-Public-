package turismoEnLaTierraMedia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AdministradorDeArchivos {
	
	public static List<Atraccion> leerAtracciones(){
		File f = new File("atracciones.txt"); 	
		Scanner sc;
		String[] line;
		List<Atraccion> atracciones = new LinkedList<Atraccion>(); 
		
		try {
			sc = new Scanner(f);
			
			while(sc.hasNextLine()) {
				line = sc.nextLine().split(",");
				
				atracciones.add(
						new Atraccion(
								line[0],//nombre
								Integer.valueOf(line[1]), //costo
								Double.parseDouble(line[2]), //tiempo
								Integer.valueOf(line[3]), //cupo
								TipoDeAtraccion.valueOf(line[4]) //tipo
								)
							);
				line = null;
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (InputMismatchException e) {
			System.err.println(e.getMessage());
		}
		
		return atracciones;
	}
	
	public static List<Usuario> leerUsuarios(){
		File f = new File("usuarios.txt");
		Scanner sc;
		String[] line;
		List<Usuario> usuarios = new LinkedList<Usuario>();
		
		try {
			sc = new Scanner(f);
			
			while(sc.hasNextLine()) {
				line = sc.nextLine().split(",");
				
				usuarios.add(
						new Usuario(
								line[0],//nombre
								Integer.valueOf(line[1]), //costo
								Double.parseDouble(line[2]), //tiempo
								TipoDeAtraccion.valueOf(line[3]) //tipo
								)
							);
				line = null;
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (InputMismatchException e) {
			System.err.println(e.getMessage());
		}
		
		return usuarios;
	}
	
	public static List<Promocion> leerPromociones() {
		File f = new File("promociones.txt");
		Scanner sc;
		String[] line;
		List<Promocion> promociones = new LinkedList<Promocion>();
		List<Atraccion> atraccionesPromo = new LinkedList<Atraccion>();
		List<Atraccion> listaDeAtracciones = leerAtracciones();

		try {
			sc = new Scanner(f);

			while (sc.hasNextLine()) {
				line = sc.nextLine().split(",");

				for (Atraccion a : listaDeAtracciones) {
					for (int i = 3; i < line.length; i++) {
						if (a.getNombre().equals(line[i])) {
							atraccionesPromo.add(a);
						}
					}
				}

				if (line[0].equals("Porcentual")) {
					promociones.add(new PromocionPorcentual(line[1], // nombre
							atraccionesPromo, // atracciones
							TipoDeAtraccion.valueOf(line[2]), // tipo de atraccion
							Integer.valueOf(line[3])// porcentaje de descuento
					));
				}
				if (line[0].equals("Absoluta")) {
					promociones.add(new PromocionAbsoluta(line[1], // nombre
							atraccionesPromo, // atracciones
							TipoDeAtraccion.valueOf(line[2]), // tipo de atraccion
							Integer.valueOf(line[3])// precio final
					));
				}
				if (line[0].equals("AxB")) {
					promociones.add(new PromocionAxB(line[1], // nombre
							atraccionesPromo, // atracciones
							TipoDeAtraccion.valueOf(line[2]) // tipo de atraccion
					));
				}

				line = null;
				atraccionesPromo = new LinkedList<Atraccion>();
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (InputMismatchException e) {
			System.err.println(e.getMessage());
		}

		return promociones;
	}

	public static void escribirItinerarioDeLosUsuarios(List<Usuario> usuarios) {
		for(Usuario a : usuarios) {
		File f = new File(a.getNombre() + "Itinerario.txt");
		PrintWriter pw;
		
		try {
			pw = new PrintWriter(f);
			
			pw.write(a.toString()+"\n"+ a.atraccionComprada);
			
			pw.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}	
		}
	}


}
	
