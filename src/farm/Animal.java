package farm;

public abstract class Animal implements Volume<Double> {
    private int power;
    private int maxPower;
    private Dimension dimension;

    public Animal(double height, double width, double length, int maxPower) {
        this.maxPower = maxPower;
        this.dimension = new Dimension(height, width, length);
    }

    abstract void eat();

    public boolean fed(){
        return false;
    }

    protected void setPower(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }

    public int getMaxPower() {
        return maxPower;
    }

    @Override
    public Double calculate() {
        return this.dimension.getHeight() * this.dimension.getLength() * this.dimension.getWidth();
    }
}
