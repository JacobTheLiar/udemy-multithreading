package s02_fundamentals;

public class CatchingThreadException {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("in thread: "+Thread.currentThread().getName());
            throw new RuntimeException("Some exception raised!");
        });

        thread.setName("Crashing Thread");

        thread.setUncaughtExceptionHandler((Thread t, Throwable e) -> {
            System.out.println("Exception coughed in thread"+t.getName());
            System.out.println("with message: "+e.getMessage());
        });

        thread.start();
    }
}
