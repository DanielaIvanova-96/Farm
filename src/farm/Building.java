package farm;

public class Building implements Volume<Double> {

    private Dimension dimension;

    public Building(double height, double width, double length) {
        this.dimension = new Dimension(height, width, length);
    }

    public double getHeight(){
        return this.dimension.getHeight();
    }

    public double getWidth(){
        return this.dimension.getWidth();
    }

    public double getLength(){
        return this.dimension.getLength();
    }

    @Override
    public Double calculate() {
        return this.getHeight() * this.getWidth() * this.getLength();
    }
}
