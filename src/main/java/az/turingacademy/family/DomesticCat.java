package az.turingacademy.family;

public class DomesticCat extends Pet implements Foul {

    public DomesticCat(String nickname) {
        super(nickname);
        setSpecies(Species.DOMESTICCAT);
    }

    public DomesticCat(String nickname, int age, byte trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        setSpecies(Species.DOMESTICCAT);
    }

    @Override
    public void respond() {
        System.out.println("Cozy,Affectionate");
    }

    @Override
    public void eat() {
        System.out.println("Domestic Cat eat");
    }

    @Override
    public void foul() {
        System.out.println("Cat is naughty");
    }
}
