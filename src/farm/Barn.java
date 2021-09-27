package farm;

import java.util.*;

public class Barn extends Building {
    private Set<Cage> cages;

    public Barn(double height, double width, double length, int cageCount) {
        super(height, width, length);
        cages = new HashSet<>(cageCount);

        Random random = new Random();
        double tempVolume = this.calculate();       //свободно място в клетката

        for (int i = 0; i < cageCount; i++) {
            double randomHeight = random.nextInt((int) (height * 0.9)) + 1;        //умножаваме по 0.9, за да сме сигурни
            double randomLength = random.nextInt((int) (height * 0.9)) + 1;        //че генерираните размери няма да са по-големи
            double randomWidth = random.nextInt((int) (height * 0.9)) + 1;         //от размерите на Barn

            Cage cage = new Cage(randomHeight, randomWidth, randomLength);

            if(tempVolume >= cage.calculate() ) {       // ако свободното място е по-голямо от клетката се добавя
                cages.add(cage);
                tempVolume -= cage.calculate();         // изваждаме размера на клетката, която току що сложихме в Barn
            }
        }
    }

    public boolean addAnimal(Animal animal) {
        if (checkCapacity()) {                      // ако има празни клетки
            for(Cage cage : cages) {
                return cage.Accommodation(animal);
            }
        }

        return false;
    }

    public boolean removeAnimal(Animal animal) {
        for(Cage cage : cages) {
            if(cage.getAnimal().equals(animal)) {
                return cage.release();
            }
        }

        return false;
    }

    // Проверява дали клетката е празна
    public boolean checkCapacity() {
        for(Cage cage : cages) {
            if(cage.getAnimal() == null) {
                return true;
            }
        }

        return false;
    }

    public Set<Cage> getCages() {
        return cages;
    }

    // TODO
    public List<Animal> getAnimals() {
        List<Animal> list = new ArrayList<>();

        for(Cage cage : cages) {
            list.add(cage.getAnimal());
        }

        return list;
    }

    public boolean removeAll(){
        for (Cage cage : cages) {
            cage.release();
        }
        return true;
    }
}
