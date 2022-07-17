package API;

public class QuickUnionWPathCompression {
    private  int[] id;
    private  int count;



    public QuickUnionWPathCompression(int N){
        count = N;
        id = new int[N];
        for (int i = 0 ; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return this.count;
    }

    public int root(int i) {

            while (i != id[i]) {
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

        int pRoot = root(p);
        int qRoot = root(q);
        if (pRoot == qRoot) return;
        id[pRoot] = qRoot; // set parent of first element the second element.; the first element became child of the second.

        // linking every site on the path from q and to their roots to the root of the new tree
        int aux;
        while(p!= qRoot ) {
            aux = id[p]; //store the father of p
            id[p] = qRoot;
            p = aux;
        }

        while(q!= qRoot ) {
            aux = id[q]; //store the father of p
            id[q] = qRoot;
            q = aux;
        }

        count--;
    }

}
