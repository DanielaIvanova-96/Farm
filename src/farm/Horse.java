package farm;

public class Horse extends Animal implements Freight {

    public Horse(double height, double width, double length, int maxPower) {
        super(height, width, length, maxPower);
    }

    public String neigh(){
        return "Цвилене";
    }

    @Override
    public void work() {
        this.setPower((int) (this.getPower()*0.5));
    }

    @Override
    void eat() {
        int currentPower = getPower();
        int maxPower = getMaxPower();

        if(currentPower < maxPower){
            currentPower += currentPower * 0.05;
            setPower(currentPower);

            if(currentPower == maxPower){
                setPower(currentPower);
            }
        }
    }
}
