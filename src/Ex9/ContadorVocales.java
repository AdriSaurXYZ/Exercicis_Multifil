package Ex9;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.Semaphore;

class ContadorVocales {
    private static final Object lock = new Object();
    private static final Semaphore semaphore = new Semaphore(1);

    public static void contarVocales(String texto, char vocal, String rutaArchivo) {
        int contador = 0;
        for (char c : texto.toCharArray()) {
            if (Character.toLowerCase(c) == Character.toLowerCase(vocal)) {
                contador++;
            }
        }

        try {
            semaphore.acquire(); // Adquiere el semáforo para escribir en el archivo
            FileWriter writer = new FileWriter(rutaArchivo, true);
            writer.write("vocal " + vocal + ": " + contador + "\n");
            writer.close();
            semaphore.release(); // Libera el semáforo
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}