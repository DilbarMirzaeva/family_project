package az.turingacademy.family;

public class Dog extends Pet{

    public Dog(String nickname){
        super(nickname);
        setSpecies(Species.DOG);
    }
    public Dog( String nickname, int age, byte trickLevel, String[] habits) {
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
}
