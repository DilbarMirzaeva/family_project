package az.turingacademy.family;

public class Main {
    public static void main(String[] args) {

        Pet pet1 = new Pet("dog", "Lessi");
        Pet pet2 = new Pet("cat", "Miki", 3, (byte) 20, new String[]{"sleep", "jump", "drink"});

        Human mother = new Human("Lale", "Quliyeva", 40);
        Human father = new Human("Murad", "Quliyev", 45);
        Human child1 = new Human("Nigar", "Quliyev", 2004, mother, father);
        Human child2 = new Human("Murad", "Quliyev", 2006, (byte) 90, pet2, mother, father,
                new String[][]{{"Friday", "go to course"}, {"Sunday", "go to gym"}});


        child1.greetPet();

        child2.greetPet();
        child2.describePet();
        System.out.println("\nPet fed?");
        System.out.println(child1.feedPet(false));
        System.out.println();

        pet1.eat();
        pet1.respond();
        pet1.foul();

        System.out.println("\nPETS toString:");
        System.out.println("1)" + pet1.toString());
        System.out.println("2)" + pet2.toString());

        System.out.println("\nHUMAN toString");
        System.out.println("1)" + child1.toString());
        System.out.println("2)" + child2.toString());

    }
}
