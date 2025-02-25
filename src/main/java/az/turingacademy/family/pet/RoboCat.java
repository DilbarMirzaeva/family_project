package az.turingacademy.family.pet;

import java.util.Set;

public class RoboCat extends Pet {
    public RoboCat(String nickname) {
        super(nickname);
        setSpecies(Species.ROBOCAT);
    }

    public RoboCat(String nickname, int age, Integer trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        setSpecies(Species.ROBOCAT);

    }

    @Override
    public void respond() {
        System.out.println("Smart,Agile");
    }

    @Override
    public void eat() {
        System.out.println("Robo cat eat");
    }
}
