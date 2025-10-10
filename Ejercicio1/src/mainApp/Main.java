package mainApp;

import java.io.File;
import java.util.ArrayList;

import models.Empleado;
import models.util;

public class Main {

	public static void main(String[] args) {
		
		File file = new File("src/archivo");
		File fileBinario =new  File("src/archivo2");

		util.toArrayList(file);
		util.mostrarArray();
		
		
		ArrayList<Empleado> empleados = new ArrayList<>();
		empleados.add(new Empleado("Mercadona", 26, 2000));
		empleados.add(new Empleado("Carrefour", 36, 2500));
		empleados.add(new Empleado("Mercadona", 32, 3500));
		empleados.add(new Empleado("Mercadona", 45, 4000));
		
		util.toArchivoTexto(file, empleados);
		
		System.out.println("Contenido: ");
		util.leerEmpleados(file);
		util.toArchivoBinarioInverso(empleados, fileBinario);
		util.leer_Empleados_B(fileBinario);
	}
}
