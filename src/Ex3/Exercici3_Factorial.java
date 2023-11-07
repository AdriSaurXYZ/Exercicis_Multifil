package Ex3;

public class Exercici3_Factorial extends Thread {
    private int num;
    private String nom;

    public Exercici3_Factorial(String nom, int num, int prioritat) {
        this.nom = nom;
        this.num = num;
        setPriority(prioritat);
    }

    @Override
    public void run() {
        long resultat = calcularFactorial(num);
        System.out.println(nom + " - Prioritat " + getPriority() + ": " + resultat);
    }

    private long calcularFactorial(int n) {
        if (n <= 1)  {
            return 1;
        } else {
            return n * calcularFactorial(n - 1);
        }
    }
}



