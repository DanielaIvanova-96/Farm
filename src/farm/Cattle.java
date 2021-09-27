package farm;

public class Cattle extends Milking implements Freight {


    public Cattle(double height, double width, double length, int maxPower, double maxQuantity) {
        super(height, width, length, maxPower, maxQuantity);
    }

    public String moo(){
        return "Мучене";
    }

    @Override
    void eat() {
        //Увеличаваме силата
        int currentPower = getPower();
        int maxPower = getMaxPower();

        if(currentPower < maxPower){
            currentPower = (int) (currentPower * 0.05 + currentPower);
            setPower(currentPower);

            if(currentPower == maxPower){
                setPower(currentPower);
            }
        }

        //Увеличаваме количеството
        double currentQuantity = getQuantity();
        double maxQuantity = getMaxQuantity();

        if(currentQuantity < maxQuantity){
            currentQuantity = currentQuantity*0.05 + currentQuantity;
            setQuantity(currentQuantity);

            if(currentQuantity == maxQuantity){
                setQuantity(currentQuantity);
            }
        }
    }

    @Override
    public void work() {
       this.setPower((int) (this.getPower()*0.5));
    }
}
