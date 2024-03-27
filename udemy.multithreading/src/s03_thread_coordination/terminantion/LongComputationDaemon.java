package s03_thread_coordination.terminantion;

import java.math.BigInteger;

public class LongComputationDaemon {

    public static void main(String[] args) {
        Thread thread = new Thread(new LongComputationTask(new BigInteger("2000"), new BigInteger("300000")));
        thread.setDaemon(true);
        thread.start();
    }

    private record LongComputationTask(BigInteger base, BigInteger power) implements Runnable {

        @Override
            public void run() {
                System.out.println(base + "^" + power + " = " + pow(base, power));
            }

            private BigInteger pow(BigInteger base, BigInteger power) {
                BigInteger result = BigInteger.ONE;
                for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                    result = result.multiply(base);
                }
                return result;
            }
        }
}
