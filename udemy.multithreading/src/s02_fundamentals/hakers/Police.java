package s02_fundamentals.hakers;

import java.util.stream.IntStream;

public class Police extends Thread{
    @Override
    public void run() {
        System.out.println("Police: I'm counting to 10 and I'll get you!");
        IntStream.rangeClosed(1, 10)
                .peek(i -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ignore) {}
                }).forEach(System.out::println);
        System.out.println("I've caught you! Game Over!");
        System.exit(0);
    }
}
