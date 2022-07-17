package API;

public class WeightedQuickUnion {
    private int[] id;
    private int[] sz;
    private int count;

    public WeightedQuickUnion(int N) {
        this.count = N;
        this.id = new int[N];
        sz = new int[N];
        for(int i = 0; i < N; i++) { id[i] = i; }
        for(int i = 0; i < N; i++) { sz[i] = 1; }

    }

    public int count() {
        return this.count;
    }

    public boolean connected(int p, int q) {
        return this.find(p) == this.find(q);
    }

    private int find(int p) {
        while(p != this.id[p]) {
            p = this.id[p];
        }

        return p;
    }

    public void union(int p, int q) {
        int i = this.find(p);
        int j = this.find(q);
        if (i == j ) return;
        if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i];}
        else { id[j] = i; sz[i] += sz[j]; }
        this.count--;
    }

    public void get_array() {
        System.out.printf("%nThe array have the following elements: ");

        for(int i = 0; i < this.id.length; ++i) {
            System.out.printf(" %d ", this.id[i]);
        }

    }

    public void are_connected(int p, int q) {
        if (this.connected(p, q)) {
            System.out.printf("%s and %s are connected%n", p, q);
        } else {
            System.out.printf("%s and %s are not connected%n", p, q);
        }

    }
}
