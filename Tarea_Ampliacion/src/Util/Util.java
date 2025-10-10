package Util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Util {

	
	
	public static void buscar(File carpeta) {
		
		File[] archivos = carpeta.listFiles();
		
		if (archivos != null) {
			for (int i = 0; i < archivos.length; i++) {
				System.out.println(archivos[i].getName());
				
				
			}
		}
	}
	
	public static void crearArchivo() {
		File file = new File("archivo.csv");
		try {
			
			if (file.createNewFile()) {
				
				System.out.println("Archivo CSV creado con exito");
			}
			
		} catch (Exception e) {
			
		}
		
	}
}
