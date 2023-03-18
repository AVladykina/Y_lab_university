package ratelimitedprinter;

public class RateLimitedPrinter {
    private final long interval; // интервал в миллисекундах
    private long lastPrintTime; // время последнего вывода

    public RateLimitedPrinter(long interval) {
        this.interval = interval;
        lastPrintTime = 0;
    }

    public void print(String message) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastPrintTime >= interval) {
            System.out.println(message);
            lastPrintTime = currentTime;
        }
    }
}