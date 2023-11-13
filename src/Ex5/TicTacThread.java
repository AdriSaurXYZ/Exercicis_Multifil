package Ex5;
import java.util.concurrent.Semaphore;

class TicTacThread extends Thread {
    private String message;
    private int repetitions;
    private Semaphore currentSemaphore;
    private Semaphore nextSemaphore;

    public TicTacThread(String message, int repetitions, Semaphore currentSemaphore, Semaphore nextSemaphore) {
        this.message = message;
        this.repetitions = repetitions;
        this.currentSemaphore = currentSemaphore;
        this.nextSemaphore = nextSemaphore;
    }

    @Override
    public void run() {
        for (int i = 0; i < repetitions; i++) {
            try {
                currentSemaphore.acquire(); // Adquiere el semáforo actual antes de imprimir
                System.out.println(message);
                nextSemaphore.release(); // Libera el semáforo siguiente para permitir al otro hilo imprimir
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}