package Ex6;

import java.util.Random;

class NumberGeneratorThread extends Thread {
    private int totalNumbers;
    private Random random = new Random();
    private volatile boolean isStopped = false;

    public NumberGeneratorThread(int totalNumbers) {
        this.totalNumbers = totalNumbers;
    }

    @Override
    public void run() {
        for (int i = 0; i < totalNumbers; i++) {
            if (isStopped) {
                System.out.println(getName() + " interrumpido.");
                return;
            }
            int randomNumber = random.nextInt(100);
            System.out.println(getName() + ": " + randomNumber);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(getName() + " interrumpido durante la espera.");
                return;
            }
        }
    }

    public void stopThread() {
        isStopped = true;
    }
}