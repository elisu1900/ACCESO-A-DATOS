package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class UtilContenido {

	/**
	 * ESTE METODO ESCRIBE TODO LO LEIDO EN CVS EN EL ARCHIVO .DAT EN BINARIO
	 * @param nombreFicheroCSV
	 */
	public static void fichero_CSV_To_Binario(String nombreFicheroCSV) {
		File archivo = new File(nombreFicheroCSV);
		
		if(archivo.exists()) {
			String nombreDat = nombreFicheroCSV.replace(".csv", ".dat");
			try(BufferedReader lector = new BufferedReader(new FileReader(nombreFicheroCSV));
				ObjectOutputStream write =  new ObjectOutputStream(new FileOutputStream(nombreDat))) {
						
				String linea;
				while ((linea = lector.readLine()) != null) {
					write.writeObject(linea);
				}
				
				System.out.println("Archivo convertido");

			} catch (Exception e) {
				System.err.println("Algo ha salido mal y no se ha podido convertir el archivo");
			}
		}
		else {
			System.err.println("El archivo dado no existe");
		}
		
	}
	/**
	 * ESTE METODO A PARTIR DE UN FICHERO .DAT TE CREA UN FICHERO CSV Y ESCRIBE LOS DATOS DENTRO DE ESTE FICHERO
	 * @param nombreFicheroDAT
	 */
	public static void fichero_Binario_To_CSV(String nombreFicheroDAT){
		
		
		
	        String nombreCSV = nombreFicheroDAT.replace(".dat", ".csv");
	        
			try (ObjectInputStream read = new ObjectInputStream(new FileInputStream(nombreFicheroDAT));
					BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreCSV))){
				
				String linea;
				while(read.available() > 0 ) {
					linea = (String) read.readObject();
					escritor.write(linea);
					escritor.newLine();
				}
				System.out.println("Archivo creado correctamente");
			} catch(Exception e) {
				e.printStackTrace();
			}
	}
	/**
	 * ESTE METODO CREA  UN ARVICO NUEVO CON _ORD Y ORDENA LAS LINEAS MENOS LA CABECERA
	 * @param nombreFicheroCSV
	 */
	public static void ordenar_Archivo_CSV(String nombreFicheroCSV) {
		int punto = nombreFicheroCSV.indexOf(".");
		String nombreOrdenado = nombreFicheroCSV.substring(0,punto) + "_ord.csv"; 

		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(nombreFicheroCSV)));
				BufferedWriter bw = new BufferedWriter(new FileWriter(nombreOrdenado))){
			
			List<String> datos = new ArrayList<>();
			String linea;
			
			linea = br.readLine();
			bw.write(linea);
			bw.newLine();
			
			
			while ((linea = br.readLine()) != null) {
				datos.add(linea);
			}
			
			datos.sort(String.CASE_INSENSITIVE_ORDER);
			for (String dato : datos) {
				bw.write(dato);
				bw.newLine();
			}
			System.out.println("archivo creado y ordenado correctamente");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Algo ha salido mal, comprueba que se haya escrito bien el nombre del archivo .CSV");
		}
		
	}
	/**
	 * ESTE METODO COPIA EL ARCHIVO DADO PERO ORDENADO EN OTRO ARCHIVO CON EL SUFIJO _ORD
	 * @param nombreArchivoDAT
	 */
	public static void ordenar_Archivo_Binario(String nombreArchivoDAT) {
		int punto = nombreArchivoDAT.indexOf(".");
		String nombreOrdenado = nombreArchivoDAT.substring(0,punto) + "_ord.dat";
		
		try (ObjectInputStream read1 = new ObjectInputStream(new FileInputStream(nombreArchivoDAT));
				ObjectOutputStream write1 = new ObjectOutputStream(new FileOutputStream(nombreOrdenado))){
			
			List<String> datos = new ArrayList<>();
			String linea;
			
			linea = (String) read1.readObject();
			write1.writeObject(linea);
			
			
			while (read1.available() > 0) {
				linea = (String) read1.readObject();
				datos.add(linea);
			}
			
			datos.sort(String.CASE_INSENSITIVE_ORDER);
			for (String dato : datos) {
				write1.writeObject(dato);
				System.out.println( ((ObjectInput) write1).readObject());
			}	
			System.out.println("archivo creado y ordenado correctamente");

			
		} catch (Exception e) {
			System.err.println("Algo ha salido mal, comprueba que se haya escrito bien el nombre del archivo .dat");
		}
	}
	
	/**
	 * ESTE METODO CONVIERTE UN ARCHIVO .DAT A .CSV Y LO ORDENA CON EL SUFIJO _ORD
	 * @param nombreFicheroDAT
	 */
	public static void fichero_Binario_To_CSV_Ordenado(String nombreFicheroDAT) {
	    int punto = nombreFicheroDAT.indexOf(".");
	    String nombreOrdenado = nombreFicheroDAT.substring(0, punto) + "_ord.csv";
	    
	    try (ObjectInputStream read = new ObjectInputStream(new FileInputStream(nombreFicheroDAT));
	         BufferedWriter bw = new BufferedWriter(new FileWriter(nombreOrdenado))) {
	        
	        List<String> datos = new ArrayList<>();
	        String linea;
	        
            linea = (String) read.readObject();
            bw.write(linea + "\n");

	        while (read.available() > 0) {
	            linea = (String) read.readObject();
	            datos.add(linea);
	        }
	        
	        datos.sort(String.CASE_INSENSITIVE_ORDER);
	        
	        for (String dato : datos) {
	            bw.write(dato);
	            bw.newLine();
	        }
			System.out.println("archivo convertido y ordenado correctamente");

	    } catch (Exception e) {
	        System.err.println("Algo ha salido mal, comprueba que se haya escrito bien el nombre del archivo .dat");
	    }
	}
	
}
