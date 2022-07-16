
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
public class RandomWord {
    public static void main(String[] args) {
        double probability;
        String mode;
        int count = 1;
        boolean champion;
        String championName = "";
            while (!StdIn.isEmpty()) {
                mode = StdIn.readString();
                probability = 1.0/count;
                champion = StdRandom.bernoulli(probability);
                if (champion) {
                    championName = mode;
                }
                count = count + 1;
            }

            System.out.println("Champion: " + championName);
    }
}
