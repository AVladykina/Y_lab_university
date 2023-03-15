package statsaccumulator;

public class StatsAccumulatorImpl
implements StatsAccumulator{

    private int count;
    private int min;
    private int max;
    private double sum;

    @Override
    public void add(int value) {
        count++;
        sum += value;
        if (count == 1) {
            min = value;
            max = value;
        } else {
            min = Math.min(min, value);
            max = Math.max(max, value);
        }
    }

    @Override
    public int getMin() {
        if (count == 0) {
            throw new IllegalStateException("StatsAccumulator is empty");
        }
        return min;
    }

    @Override
    public int getMax() {
        if (count == 0) {
            throw new IllegalStateException("StatsAccumulator is empty");
        }
        return max;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Double getAvg() {
        if (count == 0) {
            throw new IllegalStateException("StatsAccumulator is empty");
        }
        return sum / count;
    }
}
