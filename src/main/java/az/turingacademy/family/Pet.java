package az.turingacademy.family;

import java.util.Arrays;
import java.util.Objects;

public class Pet {

    private String species;
    private String nickname;
    private int age;
    private byte trickLevel;
    private String[] habits;
    String constant;

    public Pet(String species, String nickname, int age, byte trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
        constant = "first";
    }

    public Pet(String species, String nickname) {
        this.species = species;
        this.nickname = nickname;
        constant = "second";
    }

    public Pet() {

    }


    public void eat() {
        System.out.println("I am eating");
    }

    public void respond() {
        System.out.println("Hello owner.I am " + nickname + ".I miss you!");
    }

    public void foul() {
        System.out.println("I need to cover it up");
    }


    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public byte getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(byte trickLevel) {
        this.trickLevel = trickLevel;
    }

    public String[] getHabits() {
        return habits;
    }

    public void setHabits(String[] habits) {
        this.habits = habits;
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, nickname, age, trickLevel, Arrays.hashCode(habits));
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pet pet = (Pet) obj;
        return age == pet.age && trickLevel == pet.trickLevel && Objects.equals(species, pet.species) &&
                Objects.equals(nickname, pet.nickname) && Objects.deepEquals(habits, pet.habits);
    }

    @Override
    public String toString() {
        if (constant.equals("first")) {
            return "Pet{" +
                    "species='" + species + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", age=" + age +
                    ", trickLevel=" + trickLevel +
                    ", habits=" + Arrays.toString(habits) +
                    '}';
        } else if (constant.equals("second")) {
            return "Pet{" +
                    "species='" + species + '\'' +
                    ", nickname='" + nickname
                    ;
        } else {
            return "constructor is empty..";
        }
    }
}
