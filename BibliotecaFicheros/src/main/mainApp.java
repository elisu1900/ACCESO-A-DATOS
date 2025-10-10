package main;

import util.UtilContenido;
import java.io.*;
import java.util.Scanner;

public class mainApp {

	private static final String CSV_NOMBRE = "datos.csv";
	private static final String DAT_NOMBRE = "datos.dat";
	private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int opcion;
		do {
			mostrarMenu();
			System.out.print("Selecciona una opción: ");
			opcion = leerEntero();
			switch (opcion) {
			case 1 -> crearCSVDeEjemplo();
			case 2 -> UtilContenido.fichero_CSV_To_Binario(CSV_NOMBRE);
			case 3 -> UtilContenido.fichero_Binario_To_CSV(DAT_NOMBRE);
			case 4 -> UtilContenido.ordenar_Archivo_CSV(CSV_NOMBRE);
			case 5 -> UtilContenido.ordenar_Archivo_Binario(DAT_NOMBRE);
			case 6 -> UtilContenido.fichero_Binario_To_CSV_Ordenado(DAT_NOMBRE);
			case 0 -> System.out.println("👋 Saliendo del programa...");
			default -> System.out.println("❌ Opción no válida.");
			}

			if (opcion != 0) {
				System.out.println("\nPresiona ENTER para continuar...");
				sc.nextLine();
			}

		} while (opcion != 0);
	}

	private static void mostrarMenu() {
		System.out.println("""
				╔══════════════════════════════════════╗
				║        🧠 MENÚ DE PRUEBA UTILIDAD    ║
				╚══════════════════════════════════════╝
				1. Crear CSV de ejemplo
				2. Convertir CSV → BINARIO (.dat)
				3. Convertir BINARIO → CSV
				4. Ordenar CSV (_ord.csv)
				5. Ordenar BINARIO (_ord.dat)
				6. Convertir y ordenar BINARIO → CSV (_ord.csv)
				0. Salir
				""");
	}

	private static int leerEntero() {
		try {
			return Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	private static void crearCSVDeEjemplo() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(CSV_NOMBRE))) {
			bw.write("Nombre;Edad;Ciudad\n");
			bw.write("Lucía;25;Sevilla\n");
			bw.write("Carlos;31;Málaga\n");
			bw.write("Ana;22;Córdoba\n");
			bw.write("Pedro;29;Granada\n");
			bw.write("Beatriz;27;Cádiz\n");
			System.out.println("✅ Archivo CSV de ejemplo creado: " + CSV_NOMBRE);
		} catch (IOException e) {
			System.err.println("Error creando el archivo CSV de ejemplo: " + e.getMessage());
		}
	}


}
