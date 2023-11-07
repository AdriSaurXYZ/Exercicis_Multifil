package Ex4;

public class CalculFibonacci {
    public static void main(String[] args) {
        FilCalculFibonacci calculThread = new FilCalculFibonacci();
        UserInputThread userInputThread = new UserInputThread(calculThread);

        calculThread.start();
        userInputThread.start();
    }
}
