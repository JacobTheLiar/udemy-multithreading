package s02_fundamentals.hakers;

public class Vault {
    private final int password;

    public Vault(int password) {
        this.password = password;
    }

    public boolean isCorrectPassword(int checkPass){
        try {
            Thread.sleep(5);
        } catch (InterruptedException ignore) {}
        return password == checkPass;
    }
}
