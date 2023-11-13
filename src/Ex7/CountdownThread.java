package Ex7;

import java.util.concurrent.atomic.AtomicBoolean;
class CountdownThread extends Thread {
    private int totalTime;
    private AtomicBoolean quarterFlag;
    private AtomicBoolean halfFlag;
    private AtomicBoolean threeQuarterFlag;
    private AtomicBoolean countdownFlag;

    public CountdownThread(int totalTime, AtomicBoolean quarterFlag, AtomicBoolean halfFlag, AtomicBoolean threeQuarterFlag, AtomicBoolean countdownFlag) {
        this.totalTime = totalTime;
        this.quarterFlag = quarterFlag;
        this.halfFlag = halfFlag;
        this.threeQuarterFlag = threeQuarterFlag;
        this.countdownFlag = countdownFlag;
    }

    @Override
    public void run() {
        for (int i = totalTime; i >= 0; i--) {
            System.out.println("Tiempo restante: " + i);

            if (i == totalTime / 4) {
                quarterFlag.set(true);
            } else if (i == totalTime / 2) {
                halfFlag.set(true);
            } else if (i == totalTime * 3 / 4) {
                threeQuarterFlag.set(true);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        countdownFlag.set(true);
    }
}
