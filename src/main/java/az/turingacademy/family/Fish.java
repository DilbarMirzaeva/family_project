package az.turingacademy.family;

public class Fish extends Pet {
    public Fish(String nickname) {
        super(nickname);
        setSpecies(Species.FISH);
    }

    public Fish(String nickname, int age, byte trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        setSpecies(Species.FISH);
    }

    @Override
    public void eat() {
        System.out.println("Fish eat");
    }

    @Override
    public void respond() {
        System.out.println("Silent,Calm");
    }
}
