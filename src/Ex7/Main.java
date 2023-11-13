package Ex7;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el número de segundos: ");
        int totalTime = scanner.nextInt();

        AtomicBoolean quarterFlag = new AtomicBoolean(false);
        AtomicBoolean halfFlag = new AtomicBoolean(false);
        AtomicBoolean threeQuarterFlag = new AtomicBoolean(false);
        AtomicBoolean countdownFlag = new AtomicBoolean(false);

        CountdownThread countdownThread = new CountdownThread(totalTime, quarterFlag, halfFlag, threeQuarterFlag, countdownFlag);
        AlertThread alertThread = new AlertThread(quarterFlag, halfFlag, threeQuarterFlag, countdownFlag);

        countdownThread.start();
        alertThread.start();

        try {
            countdownThread.join();
            alertThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Programa finalitzat");
    }
}