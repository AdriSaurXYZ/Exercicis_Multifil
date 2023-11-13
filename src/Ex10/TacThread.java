package Ex10;

import java.util.concurrent.Semaphore;

class TacThread extends Thread {
    private Semaphore mySemaphore;
    private Semaphore nextSemaphore;

    public TacThread(Semaphore mySemaphore, Semaphore nextSemaphore) {
        this.mySemaphore = mySemaphore;
        this.nextSemaphore = nextSemaphore;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1; i++) {
            try {
                mySemaphore.acquire();
                System.out.println("TAC");
                nextSemaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}