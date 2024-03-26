package s02_fundamentals.hakers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HackerVsPolice {

    static final int MAX_PASSWORD = 9999;
    public static void main(String[] args) {
        Random random = new Random();
        Vault vault = new Vault(random.nextInt(MAX_PASSWORD));

        List<Thread> threads = new ArrayList<>();
        threads.add(new AscendingHackerThread(vault));
        threads.add(new DescendingHackerThread(vault));
        threads.add(new Police());

        threads.forEach(Thread::start);

    }
}
