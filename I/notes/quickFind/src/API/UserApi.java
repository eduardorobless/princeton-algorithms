package API;

public class UserApi {
    public static void main(String[] args) {
        QuickFind quickfind = new QuickFind(7); // initialize array from 0 up to 10
        int p;
        int q;
        p = 0;
        q = 1;
        quickfind.union(p, q);  // when it found a 0 in id array put the parent of second
        areConnected(quickfind, p, q);

        q = 6;
        quickfind.union(p,q); // when it found a 0 in id array put the parent of second in all coincidences
        areConnected(quickfind, p, q);

        int [ ] myArray = quickfind.getArray();
        showArray(myArray);
        System.out.printf("%nI have %d component(s)%n", quickfind.count());
    }
    public static void showArray(int[] array){
        System.out.printf("The array have the following elements: ");
        for (int j : array) {
            System.out.print(j);
        }
    }
    public static void areConnected(QuickFind quickfind, int p, int q){
        if (quickfind.connected(p, q)) {
            System.out.printf("%s and %s are connected%n", p, q);
        }else {
            System.out.printf("%s and %s are not connected%n", p, q);
        }
    }
}
