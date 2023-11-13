package Ex7;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

class AlertThread extends Thread {
    private AtomicBoolean quarterFlag;
    private AtomicBoolean halfFlag;
    private AtomicBoolean threeQuarterFlag;
    private AtomicBoolean countdownFlag;

    public AlertThread(AtomicBoolean quarterFlag, AtomicBoolean halfFlag, AtomicBoolean threeQuarterFlag, AtomicBoolean countdownFlag) {
        this.quarterFlag = quarterFlag;
        this.halfFlag = halfFlag;
        this.threeQuarterFlag = threeQuarterFlag;
        this.countdownFlag = countdownFlag;
    }

    @Override
    public void run() {
        while (true) {
            if (quarterFlag.get()) {
                System.out.println("Quedan 1/4 del tiempo.");
                quarterFlag.set(false);
            }
            if (halfFlag.get()) {
                System.out.println("Queda la mitad del tiempo.");
                halfFlag.set(false);
            }
            if (threeQuarterFlag.get()) {
                System.out.println("Quedan 3/4 del tiempo.");
                threeQuarterFlag.set(false);
            }
            if (countdownFlag.get()) {
                System.out.println("Cuenta atrás finalizada.");
                break;
            }
        }
    }
}