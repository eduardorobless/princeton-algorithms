package API;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserApi {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 1;
        String line;
        WeightedQuickUnion quicky = null;
        String [] lineElems = null;
        while((line = br.readLine()) != null) {
            line = line.trim();
            if (count == 1) {
                quicky = new WeightedQuickUnion(Integer.parseInt(line));
                System.out.println("The number of sites is " + line);
            } else {
                lineElems = line.split(" ");
                quicky.union(Integer.parseInt(lineElems[0]), Integer.parseInt(lineElems[1]));
                System.out.printf("p: " + lineElems[0] + " q: " + lineElems[1] + "\n");
            }
            count++;
        }

        quicky.get_array();
    }
}