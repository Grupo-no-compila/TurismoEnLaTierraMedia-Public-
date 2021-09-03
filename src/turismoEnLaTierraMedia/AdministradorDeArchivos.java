package turismoEnLaTierraMedia;

import java.io.File;
import java.io.FileNotFoundException;
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
}
	
