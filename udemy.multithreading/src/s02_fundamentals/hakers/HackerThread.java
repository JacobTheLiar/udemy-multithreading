package s02_fundamentals.hakers;

public abstract class HackerThread extends Thread{

    protected final Vault vault;

    public HackerThread(Vault vault) {
        this.vault = vault;
        this.setName(this.getClass().getSimpleName());
        this.setPriority(MAX_PRIORITY);
    }

    @Override
    public void start() {
        System.out.println("Starting hacking by: "+this.getName());
        super.start();
    }
}
