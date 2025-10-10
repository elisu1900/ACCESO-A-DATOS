package models;


import java.io.BufferedReader;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class util {

	static ArrayList<Empleado> listaEmpleados = new ArrayList<>();

	/**
	 * ESTE METODO LEE UN ARCHIVO Y CREA EMPLEADOS CON LOS DATOS DE LOS ARCHIVOS
	 * 
	 * @param file
	 */
	public static void toArrayList(File file) {

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String linea;
			while ((linea = reader.readLine()) != null) {
				String[] datos = linea.replaceAll("\"", "").split(",");
				Empleado e = new Empleado(datos[0], Integer.parseInt(datos[1]), Integer.parseInt(datos[2]));

				listaEmpleados.add(e);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ESTE METODO MUESTRA EL ARRAY
	 */
	public static void mostrarArray() {
		for (Empleado empleados : listaEmpleados) {
			System.out.println(empleados.toString());
		}
	}

	/**
	 * ALMACENA LOS EMPLEADOS DE UN ARRAY EN UN ARCHIVO DE TEXTO
	 * 
	 * @param file
	 * @param empleados
	 */
	public static void toArchivoTexto(File file, List<Empleado> empleados) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
			for (Empleado empleado : empleados) {
				writer.println("\"" + empleado.getEmpresa() + "\", \"" + empleado.getEdad() + "\", \""
						+ empleado.getNumeroEmpleado() + "\n");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * LEE EMPLEADOS DE UN ARCHIVO DE TEXTOS Y LOS IMPRIME POR PANTALLA
	 * 
	 * @param file
	 */
	public static void leerEmpleados(File file) {
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String linea;
			while ((linea = reader.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ESTE METODO PASA DE UN ARRAY A UN ARCHIVO BINARIO EN ORDEN INVERSO
	 * 
	 * @param empleados
	 * @param file
	 */
	public static void toArchivoBinarioInverso(ArrayList<Empleado> empleados, File file) {
		try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(file))) {
			
			for (int i = empleados.size() - 1; i >= 0; i--) {
				escritor.writeObject(empleados.get(i));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ESTE METODO LEE LOS EMPLEADOS BINARIOS
	 * 
	 * @param file
	 */
	public static void leer_Empleados_B(File file) {
		try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(file))) {
			while (true) {
				try {
					Empleado empleado = (Empleado) lector.readObject();

					System.out.println(empleado);
					System.out.println("--------------------------");
				} catch (EOFException e) {
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
