package az.turingacademy.family;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Human {

    private String name;
    private String surname;
    private int year;
    private byte iq;
    private Pet pet;
    private Human mother;
    private Human father;
    private String[][] schedule;
    int constant;

    public Human(String name, String surname, int year, byte iq, Pet pet, Human mother, Human father, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.pet = pet;
        this.mother = mother;
        this.father = father;
        this.schedule = schedule;
        constant = 1;
    }

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        constant = 2;
    }

    public Human(String name, String surname, int year, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.mother = mother;
        this.father = father;
        constant = 3;
    }

    public Human() {

    }


    public void greetPet() {
        if (pet != null) {
            System.out.println("Hello," + pet);
        } else {
            System.out.println("I don't have a pet");
        }
    }

    public void describePet() {
        if (pet != null) {
            String slyness = (pet.getTrickLevel() > 50) ? "very sly" : "almost not sly";
            System.out.println("I have an " + pet.getSpecies() + ",it is " + pet.getAge() + " years old,it is " + slyness);
        } else {
            System.out.println("I don't have a pet");
        }
    }

    public boolean feedPet(boolean timeForEating) {
        if (pet != null) {
            if (timeForEating) {
                System.out.println("Hm... I will feed Jack's " + pet.getNickname());
                return true;
            } else {
                Random random = new Random();
                int randomnum = random.nextInt(101);
                if (pet.getTrickLevel() > randomnum) {
                    System.out.println("Hm... I will feed Jack's " + pet.getNickname());
                    return true;
                } else {
                    System.out.println("Hm... I think Jack's " + pet.getNickname() + " is not hungry");
                    return false;
                }
            }
        } else {
            System.out.println("I don't have a pet");
            return false;
        }
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public byte getIq() {
        return iq;
    }

    public void setIq(byte iq) {
        this.iq = iq;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public String[][] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return year == human.year && iq == human.iq && Objects.equals(name, human.name) && Objects.equals(surname, human.surname) &&
                Objects.equals(pet, human.pet) && Objects.equals(mother, human.mother) && Objects.equals(father, human.father) &&
                Objects.deepEquals(schedule, human.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, year, iq, pet, mother, father, Arrays.deepHashCode(schedule));
    }

    @Override
    public String toString() {
        if (constant == 1) {
            return "Human{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", year=" + year +
                    ", iq=" + iq +
                    ", pet=" + pet +
                    ", mother=" + mother +
                    ", father=" + father +
                    ", schedule=" + Arrays.toString(schedule) +
                    '}';
        } else if (constant == 2) {
            return "Human{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", year=" + year +
                    "}";
        } else if (constant == 3) {
            return "Human{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", year=" + year +
                    ", mother=" + mother +
                    ", father=" + father +
                    "}";
        } else {
            return "Constructor is empty..";
        }
    }
}
