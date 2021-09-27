package farm;

import static java.lang.Thread.sleep;

public abstract class Milking extends Animal implements Milky{
    private double quantity;
    private double maxQuantity;

    public Milking(double height, double width, double length, int maxPower, double maxQuantity ) {
        super(height, width, length, maxPower);
        this.maxQuantity=maxQuantity;
    }


    protected void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getMaxQuantity() {
        return maxQuantity;
    }

    @Override
    public boolean start() throws InterruptedException {
        while(progress()) {
            quantity -= quantity * 0.07;        //намаляваме количеството с 7%
            sleep(300);
        }

        return stop();
    }

    @Override
    public boolean progress() {
        return quantity > 0;
    }

    @Override
    public boolean stop() {
        quantity = 0;
        return true;
    }
}
