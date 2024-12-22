package az.turingacademy.family;

public class Main {
    public static void main(String[] args) {

        Pet pet1 = new Pet(Species.DOG, "Lessi");
        Human mother = new Human("Lale", "Quliyeva", 1980);
        Human father = new Human("Murad", "Quliyev", 1978);
        Family family=new Family(mother,father);
        family.setPet(pet1);
        System.out.println(family);

        Human child1 = new Human("Nigar", "Quliyeva", 2004);
       Human child2 = new Human("Murad", "Quliyev", 2006);

       family.addChild(child1);
       family.addChild(child2);
       family.deleteChild(child1);
       family.setPet(pet1);
        System.out.println(family);

        System.out.println("\nDays of week:");
        for(DayOfWeek days:DayOfWeek.values()){
            System.out.println(days.name());
        }

        Human child3 = new Human("Murad", "Quliyev", 2006);

        System.out.println(child2.equals(child3));
        System.out.println(child2.hashCode());
        System.out.println(child3.hashCode());


    }
}
