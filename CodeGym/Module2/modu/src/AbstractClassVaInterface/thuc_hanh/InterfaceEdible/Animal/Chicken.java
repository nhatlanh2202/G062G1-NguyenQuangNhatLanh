package AbstractClassVaInterface.thuc_hanh.InterfaceEdible.Animal;

import AbstractClassVaInterface.thuc_hanh.InterfaceEdible.Edible.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String howToEat() {
        return "Chicken: cluck-cluck!";
    }

    @Override
    public String makeSound() {
        return  "could be fried";
    }
}

