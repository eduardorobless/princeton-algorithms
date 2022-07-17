package API;

public class QuickFind {
    private final int[] id;
    private int count;
    public QuickFind(int N)
    {
        count = N;
        id = new int[N];
        for(int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return this.count;
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public int [ ] getArray(){
            return id;
    }
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for(int i=0; i < id.length; i++){
            if(id[i] == pid) {
                id[i] = qid;
            }
        }
        count--;
    }
}





