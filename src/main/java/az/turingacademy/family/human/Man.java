package az.turingacademy.family.human;

import az.turingacademy.family.pet.Pet;

import java.util.Map;

public final class Man extends Human {

    public Man(String name, String surname, String birthDate,Integer iq) {
        super(name, surname, birthDate,iq);
    }

    public Man(String name, String surname, String birthDate) {
        super(name, surname, birthDate);
    }


    @Override
    public void greetPet() {
        System.out.println("Hey,man!");
    }

    public void repairCar() {
        System.out.println("Man repair the car");
    }
}
