package farm;

public interface Milky {
    public boolean start() throws InterruptedException;
    public boolean progress();
    public boolean stop();
}
