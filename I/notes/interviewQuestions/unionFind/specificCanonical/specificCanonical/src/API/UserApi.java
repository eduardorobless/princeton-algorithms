package API;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserApi {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("/home/eduardo/Computer Science/courses/algorithms_princenton/notes/weightedQuickUnionWPathCompression/weightedQuickUnionWPathCompression/src/sites_10_unions_10.txt"));
        int line_number = 1;
        String line;
        SpecificCanonical quicky = null;
        String [] lineElems;
        while((line = br.readLine()) != null) {
            line = line.trim();
            if (line_number == 1) {
                quicky = new SpecificCanonical(Integer.parseInt(line));
                System.out.println("The number of sites is " + line);
            } else {
                if (quicky.count() == 1) {
                    System.out.println("The time taken for all nodes to be connected are: "+  Integer.toString(line_number -1));
                    break; } // all nodes are connected
                else{
                    lineElems = line.split(" ");
                    quicky.union(Integer.parseInt(lineElems[0]), Integer.parseInt(lineElems[1]));
                    System.out.printf("p: " + lineElems[0] + " q: " + lineElems[1] + "\n");
                }
            }
            line_number++;
        }

        quicky.get_array();
        System.out.printf("Largest element is: " + Integer.toString(quicky.find(6) )  );
    }
}