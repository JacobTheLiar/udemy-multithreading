package s02_fundamentals.excercise;

import java.util.List;

@SuppressWarnings("unused")
class MultiExecutor {

    // Add any necessary member variables here
    private final List<Runnable> tasks;

    /*
     * @param tasks to executed concurrently
     */
    public MultiExecutor(List<Runnable> tasks) {
        this.tasks = tasks;
    }

    /**
     * Starts and executes all the tasks concurrently
     */
    public void executeAll() {
        tasks.stream()
                .map(Thread::new)
                .forEach(Thread::start);
    }
}
