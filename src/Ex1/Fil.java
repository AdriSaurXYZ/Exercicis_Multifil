package Ex1;

class Fil extends Thread {
    public Fil(String nom) {
        super(nom);
    }

    @Override
    public void run() {
        System.out.println(getName() + ": iniciat");

        // Genera i mostra un número aleatori entre 1 i 100
        int numeroAleatori = (int) (Math.random() * 100) + 1;
        System.out.println(getName() + ": valor " + numeroAleatori);

        System.out.println(getName() + ": finalitzat");
    }
}