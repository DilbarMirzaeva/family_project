package az.turingacademy.family;

import az.turingacademy.family.base.controller.FamilyController;
import az.turingacademy.family.base.dao.CollectionFamilyDao;
import az.turingacademy.family.base.dao.FamilyDao;
import az.turingacademy.family.human.Family;
import az.turingacademy.family.human.Human;
import az.turingacademy.family.human.Man;
import az.turingacademy.family.human.Woman;
import az.turingacademy.family.pet.Dog;
import az.turingacademy.family.pet.DomesticCat;
import az.turingacademy.family.pet.Pet;
import az.turingacademy.family.base.service.FamilyService;

public class Main {
    public static void main(String[] args) {

        Woman mother = new Woman("Leyla", "Mammadova", "21/12/1985", 99);
        Man father = new Man("Murad", "Mammadov", "18/12/1982", 90);
        Family family = new Family(mother, father);

        Pet pet1 = new Dog("Lessi");
        family.addPet(pet1);
        System.out.println(family);

        family.bornChild();
        System.out.println(family);
        family.deleteChild(0);
        System.out.println(family);

        System.out.println("----------------");
        System.out.println("\t\t** DAO test **");
        FamilyDao familyDao = new CollectionFamilyDao();
        FamilyController familyController = new FamilyController(new FamilyService(familyDao));
        Family family1 = new Family(new Human("Alice", "Smith", "19/08/1984"), new Human("Bob", "Smith", "29/09/1981"));
        Family family2 = new Family(new Human("Jane", "Doe", "19/07/1986"), new Human("John", "Doe", "17/08/1987"));
        Family family3 = new Family(new Human("Sarah", "Brown", "01/01/1980"), new Human("Michael", "Brown", "03/05/1988"));
        Family family4 = new Family(new Human("Emily", "Johnson", "13/08/1982"), new Human("David", "Johnson", "06/02/1985"));


        familyController.createNewFamily(family1);
        familyController.createNewFamily(family2);
        familyController.createNewFamily(family3);
        familyController.createNewFamily(family4);
        familyController.displayAllFamilies();
        System.out.println("----------------");
        familyController.bornChild(family1, "John", "Jessica");
        familyController.bornChild(family3,"Cedric","Jasmine");
        familyController.bornChild(family3,"Mete","");
        Pet pet2 = new DomesticCat("Bethoven");
        familyController.addPet(2, pet2);
        familyController.displayAllFamilies();
        System.out.println("----------------");
        System.out.println(familyController.getFamiliesBiggerThan(2));
        System.out.println("----------------");
        System.out.println(familyController.countFamiliesWithMemberNumber(4));

    }
}
