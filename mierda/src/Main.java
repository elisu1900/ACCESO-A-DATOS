import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        int cantidadConductores;
        Scanner teclado = new Scanner(System.in);
        String[] nombre;
        double[][] kms;

        System.out.println("Introduzca la cantidad de conductores que quiere introducir");
        while (true) {
            try {
                cantidadConductores = Integer.parseInt(teclado.nextLine());
                break;
            } catch (Exception e) {
                System.err.println("Introduzca un numero entero");
            }
        }

        nombre = new String[cantidadConductores];
        kms = new double[7][cantidadConductores];
        double total_kms[] = new double[cantidadConductores];

        for (int i = 0; i < cantidadConductores; i++) {
            System.out.println("Introduzca los nombres de los conductores");
            try {
                nombre[i] = teclado.nextLine();
            } catch (Exception e) {
                System.err.println("Asegurese de haber introducido un nombre");
            }
        }

        for (int i = 0; i <= 6; i++) {
            for (int j = 0; j <= cantidadConductores - 1; j++) {
                System.out.println("Introduzca cuantos kms ha realizado el conductor " + nombre[j] + " el dia " + (i + 1));
                kms[i][j] = Double.parseDouble(teclado.nextLine());

            }
        }

        for (int i = 0; i <= cantidadConductores - 1; i++) {
            for (int j = 0; j <= 6; j++) {
                total_kms[i] = total_kms[i] + kms[j][i];
            }
        }

        for (int i = 0; i <= cantidadConductores - 1; i++) {
            System.out.println(nombre[i] + " " + total_kms[i] + "\n");
        }

        teclado.close();
    }
}