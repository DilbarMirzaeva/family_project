package az.turingacademy.family;

import java.util.Arrays;
import java.util.Objects;

public class Family {

    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;


    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new Human[0];
    }

    public void addChild(Human child) {
        Human[] newChildren = new Human[children.length + 1];
        System.arraycopy(children,0,newChildren,0,children.length);
        newChildren[children.length] = child;
        children = newChildren;
        child.setFamily(this);
    }

    public void deleteChild(int index) {
        if (index < 0 || index >= children.length) {
            System.out.println("INVALID INDEX..");
        } else {
            Human[] newChildren = new Human[children.length - 1];
            System.arraycopy(children, 0, newChildren, 0, index);
            System.arraycopy(children, index + 1, newChildren, index, children.length - index - 1);

            children = newChildren;
        }
    }

    public void deleteChild(Human child){
        int i=0;
        for (; i < children.length; i++) {
            if(child.equals(children[i])){
                System.out.println(i);
                break;
            }
        }

        int index=i;
        Human[] newChildren=new Human[children.length-1];
        System.arraycopy(children,0,newChildren,0,index);
        System.arraycopy(children,index+1,newChildren,index,children.length-index-1);

        children=newChildren;

    }


    public int countFamily() {
        int count = 2 + children.length;
        return count;
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

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
        this.children = children;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) && Objects.equals(father, family.father) && Objects.deepEquals(children, family.children) && Objects.equals(pet, family.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father, Arrays.hashCode(children), pet);
    }

    @Override
    public String toString() {
        return (mother != null ? "mother=" + mother + ", " : "") +
                (father != null ? "father=" + father + ", " : "") +
                (children != null ? "children=" + Arrays.toString(children) + ", " : "") +
                (pet != null ? "pet=" + pet : "");
    }

}
