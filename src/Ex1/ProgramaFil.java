package Ex1;
public class ProgramaFil {
    public static void main(String[] args) {
        int N = 5; // Nombre de fils que vols crear
        for (int i = 1; i <= N; i++) {
            Thread fil = new Fil("Ex1.Fil " + i);
            fil.start();
        }
    }
}



