package az.turingacademy.family.human;

import az.turingacademy.family.pet.Pet;

import java.util.Map;

public final class Woman extends Human {
    public Woman(String name, String surname, String year,Integer iq){
        super(name, surname, year,iq);
    }
    public Woman(String name, String surname, String year){
        super(name, surname, year);
    }

    @Override
    public void greetPet() {
        System.out.println("Hi,my sweety!");
    }

    public void makeup() {
        System.out.println("Woman doing makeup");
    }
}
