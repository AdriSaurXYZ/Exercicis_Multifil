package Ex4;

import java.util.Scanner;
class FilCalculFibonacci extends Thread {
    @Override
    public void run() {
        System.out.println("Fil executant-se:");
        System.out.println("Escriu algo en la consola per interrompre el fil");
        int n1 = 1;
        int n2 = 1;

        while (!isInterrupted()) {
            System.out.println(n1);
            int temp = n1;
            n1 = n2;
            n2 = temp + n2;

            // Pausa de 2 segundos
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Fil interromput.");
                break;
            }
        }
    }
}

class UserInputThread extends Thread {
    private Thread targetThread;

    public UserInputThread(Thread targetThread) {
        this.targetThread = targetThread;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        targetThread.interrupt();
    }
}
