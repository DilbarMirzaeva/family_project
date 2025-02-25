package az.turingacademy.family.pet;

import java.util.Set;

public class Dog extends Pet implements Foul{

    public Dog(String nickname){
        super(nickname);
        setSpecies(Species.DOG);
    }
    public Dog( String nickname, int age, Integer trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        setSpecies(Species.DOG);

    }

    @Override
    public void eat() {
        System.out.println("Dog eat");
    }

    @Override
    public void respond() {
        System.out.println("Loyal,Friendly");
    }

    @Override
    public void foul() {
        System.out.println("I messed up again!");
    }
}
