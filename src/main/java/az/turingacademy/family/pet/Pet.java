package az.turingacademy.family.pet;

import az.turingacademy.family.human.Family;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pet {

    private Species species;
    private String nickname;
    private Integer age;
    private Integer trickLevel;
    private Set<String> habits = new HashSet<>();
    private Family family;

    public Pet(String nickname, int age, Integer trickLevel, Set<String> habits) {
        this.species = Species.UNKNOWN;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits != null ? new HashSet<>(habits) : new HashSet<>();
    }

    public Pet(String nickname) {
        this.species = Species.UNKNOWN;
        this.nickname = nickname;
    }

    public Pet() {

    }


    public void eat() {
        System.out.println("I am eating");
    }

    public abstract void respond();

    public void setSpecies(Species species) {
        this.species = (species != null) ? species : Species.UNKNOWN;
    }

    public Species getSpecies() {
        return species;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(Integer trickLevel) {
        this.trickLevel = trickLevel;
    }

    public Set<String> getHabits() {
        return new HashSet<>(habits);
    }

    public void setHabits(Set<String> habits) {
        this.habits = habits != null ? new HashSet<>(habits) : new HashSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return species == pet.species && Objects.equals(nickname, pet.nickname) && Objects.equals(age, pet.age) && Objects.equals(trickLevel, pet.trickLevel) && Objects.equals(habits, pet.habits) && Objects.equals(family, pet.family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, nickname, age, trickLevel, habits, family);
    }

    @Override
    public String toString() {
        return "Pet{" +
                (species != null ? "Species=" + species : "") + '\'' +
                (nickname != null ? ", nickname='" + nickname : "") + '\'' +
                (age != null ? ", age=" + age : "") +
                (trickLevel != null ? ", trickLevel=" + trickLevel : "") +
                (habits.isEmpty() ? "" : ", habits=" + habits) +
                '}';

    }
}
