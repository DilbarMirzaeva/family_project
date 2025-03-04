package az.turingacademy.family;

import az.turingacademy.family.base.controller.FamilyController;
import az.turingacademy.family.base.dao.CollectionFamilyDao;
import az.turingacademy.family.base.dao.FamilyDao;
import az.turingacademy.family.base.service.FamilyService;
import az.turingacademy.family.human.*;
import az.turingacademy.family.pet.Dog;
import az.turingacademy.family.pet.DomesticCat;
import az.turingacademy.family.pet.Pet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static az.turingacademy.family.util.InputUtil.getInput;

public class FamilyMenu {
    static FamilyDao familyDao = new CollectionFamilyDao();
    static FamilyService familyService = new FamilyService(familyDao);
    static FamilyController familyController = new FamilyController(familyService);

    public static void menu() {
        System.out.println("\t\t\t--- Family App ---");
        while (true) {
            int input = getInput("""
                    1.Fill with test data
                    2.Display all families
                    3.Show families with more than a certain number of members
                    4.Show families with fewer than a certain number of members
                    5.Count families wit h a specific number of members
                    6.Create a new family
                    7.Delete a family by index
                    8.Edit a family by index
                    9.Remove all children over a certain age
                    10.Exit
                    """, Integer.class);
            while (input < 1 || input > 10) {
                input = getInput("Try again(between 1 and 10): ", Integer.class);
            }

            switch (input) {
                case 1:
                    fillData();
                    break;
                case 2:
                    familyController.displayAllFamilies();
                    break;
                case 3:
                    System.out.println(familyController.getFamiliesBiggerThan(getInput("Enter the certain members count: ", Integer.class)));
                    break;
                case 4:
                    System.out.println(familyController.getFamiliesLessThan(getInput("Enter the certain member count: ", Integer.class)));
                    System.out.println("-------------------------");
                    break;
                case 5:
                    System.out.println(familyController.countFamiliesWithMemberNumber(getInput("Enter the certain member count: ", Integer.class)));
                    System.out.println("-------------------------");
                    break;
                case 6:
                    createFam();
                    break;
                case 7:
                    if (familyController.deleteFamilyByIndex(getInput("Enter index:", Integer.class))) {
                        System.out.println("Family deleted");
                        System.out.println("-------------------------");
                    }
                    break;
                case 8:
                    editFam();
                    break;
                case 9:
                    familyController.deleteAllChildrenOlderThan(getInput("Enter the certain age: ", Integer.class));
                    break;
                case 10:
                    return;
            }
        }
    }

    public static void fillData() {
        Man father1 = new Man("Bob", "Smith", "29/09/1981");
        Man father2 = new Man("John", "Doe", "17/08/1987");
        Woman mother1 = new Woman("Alice", "Smith", "19/08/1984");
        Woman mother2 = new Woman("Jane", "Doe", "19/07/1986");

        Pet pet1 = new Dog("Lessi");
        Pet pet2 = new DomesticCat("Miki");

        Human child1 = new Man("Tyler", "Smith", "06/08/2004");
        Human child2 = new Woman("Marla", "Doe", "30/06/2006");

        Map<DayOfWeek, String> schedule = new HashMap<>();
        schedule.put(DayOfWeek.FRIDAY, "Go to the Park");
        schedule.put(DayOfWeek.SATURDAY, "Sleep");

        Family family1 = new Family(mother1, father1);
        family1.addPet(pet1);
        family1.addChild(child1);
        familyDao.saveFamily(family1);
        Family family2 = new Family(mother2, father2);
        family2.addPet(pet2);
        family2.addChild(child2);
        familyDao.saveFamily(family2);
    }

    public static void createFam() {
        String mName = getInput("Enter the mother name: ", String.class);
        String mSurname = getInput("Enter the mother Surname: ", String.class);
        String mBirth = getInput("Enter the mother's birthday", String.class);
        Woman woman = new Woman(mName, mSurname, mBirth);
        String fName = getInput("Enter the father name: ", String.class);
        String fSurname = getInput("Enter the father Surname: ", String.class);
        String fBirth = getInput("Enter the father's birthday", String.class);
        Man man = new Man(fName, fSurname, fBirth);
        familyController.createNewFamily(man,woman);
        System.out.println("Family created");
    }

    public static void editFam() {
        int index = getInput("Enter the Family ID: ", Integer.class);
        Family editFam = familyController.getFamilyByIndex(index);
        while (true) {
            int choice = getInput("""
                    You have 3 choice:
                    1.Give birth to a baby
                    2.Adopt a child
                    3.Return to main menu
                    """, Integer.class);
            while (choice < 1 || choice > 3) {
                choice = getInput("Try again ,between 1 and 3: ", Integer.class);
            }
            switch (choice) {
                case 1:
                    System.out.println("-------------------------");
                    String girlName = getInput("Please enter the girl baby name: ", String.class);
                    String boyName = getInput("Please enter the boy baby name: ", String.class);
                    familyController.bornChild(editFam, girlName, boyName);
                    System.out.println("Baby born successfully");
                    System.out.println("-------------------------");
                    break;
                case 2:
                    String childName = getInput("Enter the child name which you want adopted: ", String.class);
                    String childSurname = getInput("Enter the child Surname: ", String.class);
                    String childBirth = getInput("Enter the child's birthday", String.class);
                    int childIq = getInput("Enter the child IQ: ", Integer.class);
                    Human child = new Human(childName, childSurname, childBirth, childIq);
                    familyController.adoptChild(editFam, child);
                    System.out.println("Baby adopted successfully");
                    System.out.println("-------------------------");
                    break;
                case 3:
                    return;
            }
        }
    }


}
