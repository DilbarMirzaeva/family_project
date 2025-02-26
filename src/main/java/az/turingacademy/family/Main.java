package az.turingacademy.family;

import az.turingacademy.family.controller.FamilyController;
import az.turingacademy.family.dao.CollectionFamilyDao;
import az.turingacademy.family.dao.FamilyDao;
import az.turingacademy.family.human.Family;
import az.turingacademy.family.human.Man;
import az.turingacademy.family.human.Woman;
import az.turingacademy.family.pet.Dog;
import az.turingacademy.family.pet.Pet;
import az.turingacademy.family.service.FamilyService;

public class Main {
    public static void main(String[] args) {

        Woman mother=new Woman("Leyla","Mammadova","21/12/1985",99);
        Man father=new Man("Murad","Mammadov","18/12/1982",90);
        Family family=new Family(mother,father);

        Pet pet1=new Dog("Lessi");
        family.addPet(pet1);
        System.out.println(family);

        family.bornChild();
        System.out.println(family);
        family.deleteChild(0);
        System.out.println(family);

        System.out.println("----------------");
        System.out.println("\t\t** DAO test **");
        FamilyDao familyDao=new CollectionFamilyDao();
        FamilyController familyController=new FamilyController(new FamilyService(familyDao));



    }
}
