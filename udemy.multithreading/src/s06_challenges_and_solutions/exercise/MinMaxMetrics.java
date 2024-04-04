package s06_challenges_and_solutions.exercise;

@SuppressWarnings("unused")
public class MinMaxMetrics {

    // Add all necessary member variables
    private volatile long max;
    private volatile long min;

    private final Object lockMin = new Object();
    private final Object lockMax = new Object();

    /**
     * Initializes all member variables
     */
    public MinMaxMetrics() {
        this.max = Long.MIN_VALUE;
        this.min = Long.MAX_VALUE;
    }

    /**
     * Adds a new sample to our metrics.
     */
    public void addSample(long newSample) {
        synchronized (this.lockMin){
            if (newSample<this.min)
                this.min = newSample;
        }
        synchronized (this.lockMax){
            if (newSample>this.max)
                this.max = newSample;
        }
    }

    /**
     * Returns the smallest sample we've seen so far.
     */
    public long getMin() {
        return this.min;
    }

    /**
     * Returns the biggest sample we've seen so far.
     */
    public long getMax() {
        return this.max;
    }
}
