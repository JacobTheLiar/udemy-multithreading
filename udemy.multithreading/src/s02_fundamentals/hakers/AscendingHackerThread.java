package s02_fundamentals.hakers;

import java.util.stream.IntStream;

import static s02_fundamentals.hakers.HackerVsPolice.MAX_PASSWORD;

public class AscendingHackerThread extends HackerThread{
    public AscendingHackerThread(Vault vault) {
        super(vault);
    }

    @Override
    public void run() {
        IntStream.rangeClosed(0,MAX_PASSWORD)
                .filter(vault::isCorrectPassword)
                .findAny()
                .ifPresent(guessed -> System.out.println(getName()+ ": I've found password: "+guessed));
        System.exit(0);
    }
}
