package Ex8;

import java.util.concurrent.Semaphore;


public class Main {
    public static void main(String[] args) {
        int N = 10; // Número de hilos sumadores
        Contador contador = new Contador();
        Semaphore semaforo = new Semaphore(1); // Inicializar semáforo con 1 permiso

        Sumador[] sumadores = new Sumador[N];
        for (int i = 0; i < N; i++) {
            sumadores[i] = new Sumador(i, contador, semaforo);
            sumadores[i].start();
        }

        for (int i = 0; i < N; i++) {
            try {
                sumadores[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
