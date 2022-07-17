package API;

public class WeightedQuickUnionWPathCompression {
    private final int[] id;
    private final int[] sz;
    private int count;

    public WeightedQuickUnionWPathCompression(int N) {
        this.count = N;
        this.id = new int[N];
        this.sz = new int[N];
        for(int i = 0; i < N; i++) { id[i] = i; }
        for(int i = 0; i < N; i++) { sz[i] = 1; }

    }

    public int count() {
        return this.count;
    }

    public boolean connected(int p, int q) {
        return this.root(p) == this.root(q);
    }

    private int root(int p) {
        while(p != this.id[p]) {
            p = this.id[p];
        }

        return p;
    }

    public void union(int p, int q) {
        int  pRoot = this.root(p);
        int qRoot = this.root(q);
        if (pRoot == qRoot ) return;
        int aux;

        if (sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
            // linking every site on the path from q and to their roots to the root of the new tree
            while(p!= qRoot ) {
                aux = id[p]; //store the father of p
                id[p] = qRoot;
                p = aux;
            }
        }
        else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];

            while(q!= pRoot ) {
                aux = id[q]; //store the father of p
                id[q] = pRoot;
                q = aux;
            }


        }




        this.count--;
    }

    public void get_array() {
        System.out.printf("\nThe number of components are: " + count + "\n");
        System.out.printf("%nThe array have the following elements: ");
        for (int j : this.id) {
            System.out.printf(" %d ", j);
        }
        System.out.print("\nThe number of sites rooted in a site: \n");
        for (int j : this.sz) {
            System.out.printf(" %d ", j);
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
