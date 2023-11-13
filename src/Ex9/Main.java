package Ex9;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introdueix un text: ");
        String texto = scanner.nextLine();

        final String rutaArchivo = "resultat.txt"; // Hacer la variable final o efectivamente final

        for (char vocal : "aeiou".toCharArray()) {
            final String finalRutaArchivo = rutaArchivo; // Copia final de rutaArchivo
            char finalVocal = vocal;
            new Thread(() -> ContadorVocales.contarVocales(texto, finalVocal, finalRutaArchivo)).start();
        }

        try {
            // Espera a que todos los hilos terminen
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Processant...");
        System.out.println("Contingut de l'arxiu resultant:");

        try {
            // Lee y muestra el contenido del archivo
            Scanner fileScanner = new Scanner(rutaArchivo);
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
            fileScanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


