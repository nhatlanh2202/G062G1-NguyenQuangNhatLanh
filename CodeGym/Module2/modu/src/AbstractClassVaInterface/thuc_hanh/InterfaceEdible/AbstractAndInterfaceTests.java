package AbstractClassVaInterface.thuc_hanh.InterfaceEdible;

import AbstractClassVaInterface.thuc_hanh.InterfaceEdible.Animal.Animal;
import AbstractClassVaInterface.thuc_hanh.InterfaceEdible.Animal.Tiger;
import AbstractClassVaInterface.thuc_hanh.InterfaceEdible.Animal.Chicken;
import AbstractClassVaInterface.thuc_hanh.InterfaceEdible.Edible.Edible;
import AbstractClassVaInterface.thuc_hanh.InterfaceEdible.Fruit.Fruit;
import AbstractClassVaInterface.thuc_hanh.InterfaceEdible.Fruit.Apple;
import AbstractClassVaInterface.thuc_hanh.InterfaceEdible.Fruit.Orange;

public class AbstractAndInterfaceTests {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());
            ;

            if (animal instanceof Chicken) {
                Edible edibler = (Chicken) animal;
                System.out.println(edibler.howToEat());
            }
        }

        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
    }
}
