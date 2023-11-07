package Ex2;

public class Programa{

        public static void main(String[] args) {
            int[] compte = { 1000 }; // Inicialitzem "compte" amb el valor 1000

            Thread filSuma = new Thread(new Runnable() {
                @Override
                public void run() {
                    int valor_compte = compte[0];
                    System.out.println("Fil suma => compte: " + valor_compte);
                    valor_compte += 10;
                    System.out.println("Fil suma => registre: " + valor_compte);
                    compte[0] = valor_compte;
                    System.out.println("Fil suma => compte: " + compte[0]);
                }
            });

            Thread filResta = new Thread(new Runnable() {
                @Override
                public void run() {
                    int valor_compte = compte[0];
                    System.out.println("Fil resta => compte: " + valor_compte);
                    valor_compte -= 10;
                    System.out.println("Fil resta => registre: " + valor_compte);
                    compte[0] = valor_compte;
                    System.out.println("Fil resta => compte: " + compte[0]);
                }
            });

            filSuma.start();
            filResta.start();

            try {
                filSuma.join();
                filResta.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Fil principal: " + compte[0]);
        }
    }