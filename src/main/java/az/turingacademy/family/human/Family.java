package az.turingacademy.family.human;

import az.turingacademy.family.pet.Pet;
import specialException.FamilyOverflowException;

import java.util.*;

public class Family implements HumanCreator {

     static final int maxSize=5;
    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pets = new HashSet<>();


    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
    }

    public Family(Human father, Human mother, List<Human> children, Set<Pet> pet) {
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>(children);
        this.pets = pet != null ? new HashSet<>(pet) : new HashSet<>();
    }

    public boolean deleteChild(int index) {
        if (index >= 0 && index < children.size()) {
            Human removeChild = children.remove(index);
            removeChild.setFamily(null);
            return true;
        }
        return false;
    }

    public boolean deleteChild(Human child) {
        if (children.remove(child)) {
            child.setFamily(null);
            return true;
        }
        return false;
    }

    public int countFamily() {
        return children.size() + 2;
    }

    public void addChild(Human child) {
        if(countFamily()+1>maxSize){
            throw new FamilyOverflowException("Can't add child.Family size exceeds limit of "+maxSize);
        }
        if (child == null) {
            System.out.println("Child could not be 'null'");
            return;
        }
        children.add(child);
        child.setFamily(this);
    }

    @Override
    public void bornChild() {
        String[] manNames = {"Anar", "Ali", "Mahir", "Jamal", "Murad"};
        String[] womanNames = {"Nigar", "Dilbar", "Lala", "Zahra", "Ayan"};
        boolean genderMan = new Random().nextBoolean();
        String name = genderMan ? manNames[new Random().nextInt(4)] : womanNames[new Random().nextInt(4)];
        Human child = genderMan ? new Man(name, getFather().getSurname(), "20/12/2003") : new Woman(name, getFather().getSurname(), "20/12/2003");
        child.setIq((mother.getIq() + father.getIq()) / 2);
        addChild(child);
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public void removePet(Pet pet) {
        pets.remove(pet);
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public void prettyFormat() {
        System.out.println("Family :");
        System.out.println("\tmother: " + mother );
        System.out.println("\tfather: " + father );
        if(!children.isEmpty()){
            System.out.println("\tchildren: ");
            for (Human child : children) {
                if (child instanceof Man) {
                    System.out.println("\t\tboy: "+child);
                }else {
                    System.out.println("\t\tgirl: "+child);
                }
            }
        }
        System.out.println("\tpets: "+pets);
        System.out.println("---------------------------");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) && Objects.equals(father, family.father) && Objects.equals(children, family.children) && Objects.equals(pets, family.pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father, children, pets);
    }

    @Override
    public String toString() {
        return (mother != null ? "mother: " + mother + ", " : "") +
                (father != null ? "father: " + father + ", " : "") +
                (children.isEmpty() ? "" : "children: " + children + ", ") +
                (pets.isEmpty() ? "" : "pet(s)=" + pets) + '}';
    }

}
