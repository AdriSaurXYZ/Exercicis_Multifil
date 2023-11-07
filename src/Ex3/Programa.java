package Ex3;

public class Programa {
    public static void main(String[] args) {
        prova1();
        prova2();
    }

    public static void prova1() {
        Exercici3_Factorial fil1 = new Exercici3_Factorial("Fil 1", 5, Thread.MIN_PRIORITY);
        Exercici3_Factorial fil2 = new Exercici3_Factorial("Fil 2", 5, Thread.MAX_PRIORITY);

        fil1.start();
        fil2.start();
    }

    public static void prova2() {
        int numFils = 10;
        Thread[] fils = new Thread[numFils];

        for (int i = 0; i < numFils; i++) {
            String nom = "Fil " + (i + 1);
            int prioritat = (i < numFils / 2) ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
            Exercici3_Factorial fil = new Exercici3_Factorial(nom, 5, prioritat);
            fils[i] = fil;
        }

        for (Thread fil : fils) {
            fil.start();
        }
    }
}