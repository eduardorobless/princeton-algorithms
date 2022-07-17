
import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
    private final int gridSize;
    private int nbOpenSites = 0;
    private final boolean[][] grid;
    private final WeightedQuickUnionUF quicky;
    private final int TOP = 0;
    private final int bottom;
    private int numberOpenSites;
    public Percolation(int n) {
        if ( n <= 0)
        {
            throw new IllegalArgumentException("Incorrect size grid n: " + n);
        }
        gridSize = n;
        bottom = gridSize * gridSize + 1;
        quicky = new WeightedQuickUnionUF( gridSize * gridSize + 2 ); // last two nodes are virtual
        grid = new boolean[n][n];
        numberOpenSites = 0;
    }


    // to get the number of node from row, col use row * n  + col
        public void open ( int row, int col)
        {
            validateIndex(row, col);

            if (grid[row-1][col -1]) {return;}

            grid[row - 1][col -1] = true;
            numberOpenSites++;

            if ( row == 1)
            {
                quicky.union(getIndex(row, col), TOP);
            }

            if (row == gridSize)
            {
                quicky.union(getIndex(row, col), bottom);
            }

            // check left
            if (col > 1  && isOpen(row, col -1))
            {
                quicky.union(getIndex(row, col), getIndex(row, col - 1));
            }
            // check right
            if (col < gridSize && isOpen(row, col + 1))
            {
                quicky.union(getIndex(row, col), getIndex(row, col + 1));
            }
            // check up
            if (row > 1 && isOpen(row - 1, col))
            {
                quicky.union(getIndex(row, col), getIndex(row - 1, col));
            }
            // check bottom
            if (row < gridSize && isOpen(row + 1, col))
            {
                quicky.union(getIndex(row, col), getIndex(row + 1, col));
            }
        }
        // is the site (row, col) open?
        public boolean isOpen ( int row, int col)
        {
            validateIndex(row, col);
            return this.grid[row-1][col-1] == true;
        }
        // is the site (row, col) full?
        public boolean isFull ( int row, int col)             // check if given node is connected to virtual parent node
        {
            validateIndex(row, col);
            if (!isOpen(row, col)){
                return false;
            }
            return this.quicky.find(getIndex(row, col)) == this.quicky.find(TOP);
        }
        private int getIndex(int row, int col)
        {
            validateIndex(row, col);
            // getting real values row -1 , col -1
            // map to values starting from 0 remember row * n + col, mapping to nodes, add + 1 , so...
            return (row -1) * gridSize + col;
        }
        public int numberOfOpenSites ()
        {
            return this.numberOpenSites;
        }
        // does the system percolates?
        public boolean percolates ()
        {
            return this.quicky.find(TOP)
                    == this.quicky.find(bottom);
        }
    private void validateIndex(int row, int col) {
        if (!isValid(row, col)) {
            throw new IllegalArgumentException(String.format("Invalid site (%d, %d)", row, col));
        }
    }

    private boolean isValid(int row, int col)
    {
        return (col >= 1 && col <= gridSize && row >= 1 && row <= gridSize);
    }
}
