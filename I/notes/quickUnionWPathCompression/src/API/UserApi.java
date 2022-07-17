
package API;

public class UserApi {
    public static void main(String[] args) {
        QuickUnionWPathCompression quickunionwpathcompression = new QuickUnionWPathCompression(13);
        int p;
        int q;
        int [ ] myArray = quickunionwpathcompression.getArray();

        /*
        p = 12;
        q = 9;
        quickunionwpathcompression.union(p, q);
        showArray(myArray);*/
        p = 9;
        q = 11;
        quickunionwpathcompression.union(p,q);
        showArray(myArray);

        p = 8;
        q = 10;
        quickunionwpathcompression.union(p, q);
        showArray(myArray);

        quickunionwpathcompression.union(9,8);
        showArray(myArray);

        System.out.printf("%nI have %d component(s)%n", quickunionwpathcompression.count());
    }


    public static void showArray(int[] array){
        System.out.printf("%nThe array have the following elements: ");
        for (int j : array) {
            System.out.printf(" %s ", j);
        }
    }
    public static void areConnected(QuickUnionWPathCompression quickunionwpathcompression, int p, int q){
        if (quickunionwpathcompression.connected(p, q)) {
            System.out.printf("%s and %s are connected%n", p, q);
        }else {
            System.out.printf("%s and %s are not connected%n", p, q);
        }
    }
}