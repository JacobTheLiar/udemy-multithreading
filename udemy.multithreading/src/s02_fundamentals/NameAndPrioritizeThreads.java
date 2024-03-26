package s02_fundamentals;

public class NameAndPrioritizeThreads {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("in thread: "+Thread.currentThread().getName());
            System.out.println("priority: "+Thread.currentThread().getPriority());
        });

        thread.setName("New Thread");
        thread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("Before - in thread: "+Thread.currentThread().getName());
        thread.start();
        System.out.println("After - in thread: "+Thread.currentThread().getName());
    }
}
