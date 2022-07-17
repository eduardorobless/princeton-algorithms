package API;
import java.io.IOException;


public class UserApi {
    public static void main(String[] args) throws IOException {
        SuccesorWithDelete quicky = new SuccesorWithDelete(10);
        quicky.delete(4);
        quicky.delete(5);
        quicky.delete(7);
        quicky.delete(6);

        quicky.get_array();
        System.out.printf("\nSuccesor of 3 is " + Integer.toString(quicky.succesor(3)));
    }
}