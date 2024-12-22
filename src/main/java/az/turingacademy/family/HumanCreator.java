package az.turingacademy.family;

import java.util.Random;

public interface HumanCreator {

    default void bornChild(Human mother, Human father,int year) {

        String[] ManNames = {"Anar", "Ali", "Mahir", "Jamal", "Murad"};
        String[] WomanNames = {"Nigar", "Dilbar", "Lala", "Zahra", "Ayan"};

        String name;
        Human child = new Human();
        String gender;

        Random random = new Random();
        int randomNum = random.nextInt(2);
        int randomNum2 = random.nextInt(5);

        if (randomNum == 0) {
            gender = "Man";
            name = ManNames[randomNum2];
        } else {
            gender = "Woman";
            name = WomanNames[randomNum2];
        }

        child.setIq((byte) random.nextInt(101));

        System.out.println("Child name:" + name + ", gender:" + gender + ", IQ:" + child.getIq()+
                ", mother:"+mother+", father:"+father);
        Family family=new Family(mother,father);
        child=new Human(name, father.getSurname(), year);
        family.addChild(child);
    }
}
