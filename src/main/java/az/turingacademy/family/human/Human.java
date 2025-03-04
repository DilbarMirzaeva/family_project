package az.turingacademy.family.human;

import az.turingacademy.family.pet.Pet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Human {

    private String name;
    private String surname;
    private LocalDate birthDate;
    private Integer iq;
    private Pet pet;
    private Map<DayOfWeek, String> schedule = new HashMap<>();
    private Family family;

    public Human(String name, String surname, String  birthDate, Integer iq, Pet pet, Family family, Map<DayOfWeek, String> schedule) {
        this.name = name;
        this.surname = surname;
        this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.iq = iq;
        this.schedule = schedule != null ? new HashMap<>(schedule) : new HashMap<>();
        this.family = family;
    }

    public Human(String name, String surname, String birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public Human(String name, String surname, String birthDate, Integer iq) {
        this.name = name;
        this.surname = surname;
        this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.iq = iq;
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
                System.out.println("Hm... I will feed " + name + "'s " + pet.getNickname());
                return true;
            } else {
                Random random = new Random();
                int randomNum = random.nextInt(101);
                if (pet.getTrickLevel() > randomNum) {
                    System.out.println("Hm... I will feed " + name + "'s " + pet.getNickname());
                    return true;
                } else {
                    System.out.println("Hm... I think " + name + "'s " + pet.getNickname() + " is not hungry");
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getIq() {
        return iq;
    }

    public void setIq(Integer iq) {
        this.iq = iq;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }


    public Map<DayOfWeek, String> getSchedule() {
        return new HashMap<>(schedule);
    }

    public void setSchedule(Map<DayOfWeek, String> schedule) {
        this.schedule = schedule != null ? new HashMap<>(schedule) : new HashMap<>();
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
        return Objects.equals(name, human.name) && Objects.equals(surname, human.surname) && Objects.equals(birthDate, human.birthDate) && Objects.equals(iq, human.iq) && Objects.equals(pet, human.pet) && Objects.equals(schedule, human.schedule) && Objects.equals(family, human.family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthDate, iq, pet, schedule, family);
    }


    @Override
    public String toString() {
        return "{" +
                (name != null ? "name='" + name : "") + '\'' +
                (surname != null ? ", surname='" + surname : "") + '\'' +
                (birthDate != null ? ", year=" + birthDate : "") +
                (iq != null ? ", iq=" + iq : "") +
                (pet != null ? ", pet=" + pet : "") +
                (schedule.isEmpty() ? "" : ", schedule=" + schedule) +
                '}';

    }
}
