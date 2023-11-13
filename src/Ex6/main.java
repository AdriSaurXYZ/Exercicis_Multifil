package Ex6;

import java.util.Random;


public class main {
    public static void main(String[] args) {
        NumberGeneratorThread thread1 = new NumberGeneratorThread(5);
        NumberGeneratorThread thread2 = new NumberGeneratorThread(Integer.MAX_VALUE); // Ejecutará indefinidamente

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            while (thread2.isAlive()) {
                // El hilo principal sigue esperando mientras el hilo 2 esté vivo.
            }
            thread2.stopThread(); // Detener el hilo 2 cuando el hilo 1 haya terminado.
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Programa finalitzat");
    }
}


