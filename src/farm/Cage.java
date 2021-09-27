package farm;

public class Cage extends Building {
    private Animal animal;

    public Cage(double height, double width, double length) {
        super(height, width, length);
    }

    //метод, проверчващ дали животното се събира в клетката
    private boolean validateAccommodation() {
        return animal.calculate() <= this.calculate();
    }

    //метод, проверяващ дали клетката е празна
    public boolean Accommodation (Animal animal){
        if(animal.calculate() <= this.calculate() && this.animal == null) {
            this.animal = animal;
            return true;
        }

        return false;
    }

    public boolean release() {
        animal = null;
        return true;
    }

    public Animal getAnimal() {
        return animal;
    }
}
