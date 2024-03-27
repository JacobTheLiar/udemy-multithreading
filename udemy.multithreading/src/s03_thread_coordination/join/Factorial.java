package s03_thread_coordination.join;

import java.math.BigInteger;
import java.util.stream.Stream;

public class Factorial {

    public static void main(String[] args) {
        Stream.of(0L, 3453L, 35483L, 258758855L, 4565L, 25L, 8889L)
                .map(FactorialThread::new)
                .peek(thread -> thread.setDaemon(true))
                .peek(Thread::start)
                .peek(thread -> {
                    try {
                        thread.join(2000);
                    } catch (InterruptedException ignore) {
                    }
                })
                .forEach(thread -> {
                    if (thread.isFinished()) {
                        System.out.println("Factorial of " + thread.getInputNumber() + " is " + thread.getResult());
                    } else {
                        System.out.println("The calculation for " + thread.getInputNumber() + " is still in progress");
                    }
                });
    }

    private static class FactorialThread extends Thread {
        private final long inputNumber;
        private BigInteger result = BigInteger.ZERO;
        private boolean isFinished;

        private FactorialThread(long inputNumber) {
            this.inputNumber = inputNumber;
        }

        @Override
        public void run() {
            this.result = factorial(inputNumber);
            this.isFinished = true;
        }

        private BigInteger factorial(long n) {
            return Stream
                    .iterate(BigInteger.ONE, i -> i.compareTo(new BigInteger(Long.toString(n+1)))<0, i -> i.add(BigInteger.ONE))
                    .reduce(BigInteger.ONE, BigInteger::multiply);
        }

        public BigInteger getResult() {
            return result;
        }

        public boolean isFinished() {
            return isFinished;
        }

        public long getInputNumber() {
            return inputNumber;
        }
    }
}
