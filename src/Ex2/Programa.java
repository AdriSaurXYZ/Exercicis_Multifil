package Ex2;

public class Programa {
    public static void main(String[] args) {
        int[] compte = { 1000 }; // Valor compartit

        FilSuma sumaFil = new FilSuma(compte);
        FilResta restaFil = new FilResta(compte);

        sumaFil.start();
        restaFil.start();

        try {
            sumaFil.join();
            restaFil.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Fil principal: " + compte[0]);
    }
}

class FilSuma extends Thread {
    private int[] compte;

    public FilSuma(int[] compte) {
        this.compte = compte;
    }

    @Override
    public void run() {
        int registre = compte[0];
        System.out.println("Fil suma => compte: " + registre);

        // Realitza la suma
        registre += 10;

        System.out.println("Fil suma => registre: " + registre);

        // Assigna el valor del registre a compte
        compte[0] = registre;

        System.out.println("Fil suma => compte: " + compte[0]);
    }
}

class FilResta extends Thread {
    private int[] compte;

    public FilResta(int[] compte) {
        this.compte = compte;
    }

    @Override
    public void run () {
        int registre = compte[0];
        System.out.println("Fil resta => compte: " + registre);

        // Realitza la resta
        registre -= 10;

        System.out.println("Fil resta => registre: " + registre);

        // Assigna el valor del registre a compte
        compte[0] = registre;

        System.out.println("Fil resta  => compte: " + compte[0]);
    }
}