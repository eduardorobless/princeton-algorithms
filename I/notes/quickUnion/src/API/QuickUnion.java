package API;

public class QuickUnion {
    private final int[] id;
    private int count;

    public QuickUnion(int N) {
        count = N;
        id = new int[N];
        for (int i = 0 ; i < N; i++) {
            id[i] = i;
        }
    }
    public int count() {
        return this.count;
    }
    private int root(int i) {
        while(i != id[i]) {
            i = id[i];
        }
        return i;
    }
    public int [ ] getArray(){
        return id;
    }
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j; // set parent of first element the second element.; the first element became child of the second.
        count--;
    }

}
