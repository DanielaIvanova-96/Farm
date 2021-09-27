package farm;

public class Goat extends Milking {


    public Goat(double height, double width, double length, int maxPower, double maxQuantity) {
        super(height, width, length, maxPower, maxQuantity);
    }

    public String bleat(){
        return "Блеене";
    }

    @Override
    void eat() {
        //Увеличаваме силата
        int currentPower = getPower();
        int maxPower = getMaxPower();

        if(currentPower < maxPower){
            currentPower += currentPower * 0.05;
            setPower(currentPower);

            if(currentPower == maxPower){
                setPower(currentPower);
            }
        }

        //Увеличаваме количеството
        double currentQuantity = getQuantity();
        double maxQuantity = getMaxQuantity();

        if(currentQuantity < maxQuantity){
            currentQuantity += currentQuantity * 0.05;
            setQuantity(currentQuantity);

            if(currentQuantity == maxQuantity || currentQuantity > maxQuantity){
                setQuantity(maxQuantity);
            }
        }
    }
}
