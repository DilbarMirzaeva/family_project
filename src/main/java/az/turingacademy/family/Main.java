package az.turingacademy.family;

public class Main {
    public static void main(String[] args) {

        Pet pet1 = new Pet("dog", "Lessi");
        Pet pet2 = new Pet("cat", "Miki", 3, (byte) 20, new String[]{"sleep", "jump", "drink"});
        Human mother = new Human("Lale", "Quliyeva", 1980);
        Human father = new Human("Murad", "Quliyev", 1978);
        Family family=new Family(mother,father);
        family.setPet(pet1);
        System.out.println(family);
        Human child1 = new Human("Nigar", "Quliyev", 2004);
       Human child2 = new Human("Murad", "Quliyev", 2006);
       family.addChild(child1);
       family.addChild(child2);
       family.deleteChild(child2);
       family.setPet(pet2);
       family.setPet(pet1);
        System.out.println(family);


    }
}
