package Ex10;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore ticSemaphore = new Semaphore(1);
        Semaphore tacSemaphore = new Semaphore(0);
        Semaphore tocSemaphore = new Semaphore(0);

        int numSecuencias = 2; // Cambia esto para ajustar el número de secuencias

        for (int i = 0; i < numSecuencias; i++) {
            new TicThread(ticSemaphore, tacSemaphore).start();
            new TacThread(tacSemaphore, tocSemaphore).start();
            new TocThread(tocSemaphore, ticSemaphore).start();

            try {
                Thread.sleep(1000); // Espera para la siguiente secuencia (4 segundos)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
