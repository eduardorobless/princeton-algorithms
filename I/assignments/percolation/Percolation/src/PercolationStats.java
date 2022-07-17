import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdOut;

public class PercolationStats {
    private final double [] rate;
    private final int trials;
    private int gridSize;
    public PercolationStats(int gridSize, int trials)
    {
        if (gridSize <= 0)
        {
            throw new IllegalArgumentException("Incorrect size grid n: " + gridSize);
        } else if (trials <= 0) {
            throw new IllegalArgumentException("Trial number must be positive: " + trials);
        }

        this.trials = trials;
        this.rate = new double[trials];
        this.gridSize = gridSize;
        run();
    }

    private void run()
    {
        for (int trial = 0; trial < trials ; trial++)
        {
            Percolation percolation = new Percolation(gridSize);
            // choosing a site uniformly amon blocked sites
            while (!percolation.percolates()) // keep opening sites till it percolates
            {
                int randomSite = StdRandom.uniform(gridSize * gridSize);
                int row = randomSite / gridSize;
                int col = randomSite % gridSize ;

                if (percolation.isOpen(row + 1, col + 1)) { continue;}

                percolation.open(row + 1, col + 1);
            }
            rate[trial] =  percolation.numberOfOpenSites() / (double) (gridSize * gridSize);
        }
    }

    // sample mean of percolation threshold
    public double mean()
    {
        return StdStats.mean(rate);
    }

    public double stddev()
    {
        return StdStats.stddev(rate);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo()
    {
        return mean() - 1.96 * this.stddev() / Math.sqrt(trials);
    }
    // high endpoint of 95% confidence interval
    public double confidenceHi()
    {
        return mean() + 1.96 * this.stddev() / Math.sqrt(trials);
    }
    private void percolation_results(double mean, double stddev, double lo, double hi)
    {
        System.out.printf("mean\t\t\t= %s\nstddev\t\t\t= %s\n95%% confidence interval = [%s, %s]", mean, stddev, lo, hi);
    }

    // test client
    public static void main(String [] args) {
        int gridSize = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        PercolationStats stats = new PercolationStats(gridSize, trials);

        stats.percolation_results(stats.mean(), stats.stddev(), stats.confidenceLo(), stats.confidenceHi());
    }
}
