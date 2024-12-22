package az.turingacademy.family;

public class Main {
    public static void main(String[] args) {


        Dog dog = new Dog("Lessi");
        System.out.println(dog.toString());

        Pet fish=new Fish("Ballom",1,(byte)20,new String[]{"eat","swim"});
        System.out.println(fish.toString());

        RoboCat roboCat=new RoboCat("gptCat");
        System.out.println("species:"+roboCat.getSpecies()+", name:"+roboCat.getNickname());

        fish.eat();
        dog.respond();

        Human mother = new Human("Lale", "Quliyeva", 1980);
        Human father = new Human("Nihat", "Quliyev", 1978);
        Human human=new Human();
        human.bornChild(mother,father,2000);

    }
}
