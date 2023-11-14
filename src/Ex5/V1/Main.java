package Ex5.V1;

import Ex5.V1.TicTacThread;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        int n = 4;

        Semaphore ticSemaphore = new Semaphore(1);
        Semaphore tacSemaphore = new Semaphore(0);

        TicTacThread ticThread = new TicTacThread("TIC", n, ticSemaphore, tacSemaphore);
        TicTacThread tacThread = new TicTacThread("TAC", n, tacSemaphore, ticSemaphore);

        ticThread.start();
        tacThread.start();

        try {
            ticThread.join();
            tacThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Programa finalitzat");
    }
}














