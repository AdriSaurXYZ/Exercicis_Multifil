package Ex8;

import java.util.concurrent.Semaphore;

class Sumador extends Thread {
    private int numSumador;
    private Contador contador;
    private Semaphore semaforo;

    public Sumador(int numSumador, Contador contador, Semaphore semaforo) {
        this.numSumador = numSumador;
        this.contador = contador;
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        try {
            semaforo.acquire(); // Adquirir el semáforo para acceso exclusivo al contador
            int valorActual = contador.getValor();
            contador.incrementar();
            semaforo.release(); // Liberar el semáforo

            System.out.println("Fil " + numSumador + ": el valor del comptador és " + valorActual);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}