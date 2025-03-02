package az.turingacademy.family.human;

import az.turingacademy.family.pet.Pet;

import java.util.Map;

public final class Woman extends Human {
    public Woman(String name, String surname, String birthDate,Integer iq){
        super(name, surname, birthDate,iq);
    }
    public Woman(String name, String surname, String birthDate){
        super(name, surname, birthDate);
    }

    @Override
    public void greetPet() {
        System.out.println("Hi,my sweety!");
    }

    public void makeup() {
        System.out.println("Woman doing makeup");
    }
}
