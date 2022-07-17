package API;

public class UserApi {
    public static void main(String[] args) {
        QuickUnion quickunion = new QuickUnion(7);
        int p;
        int q;
        p = 0;
        q = 1;
        quickunion.union(p, q);  // when it found a 0 in id array put the parent of second
        areConnected(quickunion, p, q);

        q = 6;
        quickunion.union(p,q); // when it found a 0 in id array put the parent of second in all coincidences
        areConnected(quickunion, p, q);

        int [ ] myArray = quickunion.getArray();
        showArray(myArray);
        System.out.printf("%nI have %d component(s)%n", quickunion.count());
    }


    public static void showArray(int[] array){
        System.out.print("The array have the following elements: ");
        for (int j : array) {
            System.out.print(j);
        }
    }
    public static void areConnected(QuickUnion quickunion, int p, int q){
        if (quickunion.connected(p, q)) {
            System.out.printf("%s and %s are connected%n", p, q);
        }else {
            System.out.printf("%s and %s are not connected%n", p, q);
        }
    }
}


