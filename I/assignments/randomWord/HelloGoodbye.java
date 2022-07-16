public class HelloGoodbye {
    public static void main(String[] args) {
        try {
            String firstArg = args[0];
            String secondArg = args[1];
            System.out.println("Hello " + firstArg + " and " + secondArg);
            System.out.print("Goodbye " + secondArg + " and " + firstArg);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Check your parameters!");
        }

    }
}
