package s02_fundamentals.hakers;

import java.util.stream.IntStream;

import static s02_fundamentals.hakers.HackerVsPolice.MAX_PASSWORD;

public class DescendingHackerThread extends HackerThread{
    public DescendingHackerThread(Vault vault) {
        super(vault);
    }

    @Override
    public void run() {
        IntStream.rangeClosed(0,MAX_PASSWORD)
                .map(i -> MAX_PASSWORD - i - 1)
                .filter(vault::isCorrectPassword)
                .findAny()
                .ifPresent(guessed -> System.out.println(getName()+ ": I've found password: "+guessed));
        System.exit(0);
    }
}
