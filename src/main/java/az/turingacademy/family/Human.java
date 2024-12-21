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
    private String[][] schedule;
    private Family family;
    private int constant;

    public Human(String name, String surname, int year, byte iq, Pet pet,Family family, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.pet = pet;
        this.schedule = schedule;
        this.family=family;
        constant = 1;
    }

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        constant = 2;
    }

    public Human(String name, String surname, int year, Family family) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.family=family;
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


    public String[][] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return year == human.year && iq == human.iq && Objects.equals(name, human.name) && Objects.equals(surname, human.surname) &&
                Objects.equals(pet, human.pet) && Objects.equals(family,human.family) &&
                Objects.deepEquals(schedule, human.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, year, iq, pet,family, Arrays.deepHashCode(schedule));
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
                    ", family(mother,father)=" + family +
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
                    ", family(mother,father)=" + family +
                    "}";
        } else {
            return "Constructor is empty..";
        }
    }
}
