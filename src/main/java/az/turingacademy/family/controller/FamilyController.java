package az.turingacademy.family.controller;

import az.turingacademy.family.dao.FamilyDao;
import az.turingacademy.family.human.Family;
import az.turingacademy.family.human.Human;
import az.turingacademy.family.pet.Pet;
import az.turingacademy.family.service.FamilyService;
import java.util.List;
import java.util.Set;

public class FamilyController {
    private final FamilyService familyService;

    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    List<Family> getAllFamilies() {
        return familyService.getAllFamilies();
    }

    public Family getFamilyByIndex(int index) {
        return familyService.getFamilyByIndex(index);
    }

    public int count() {
        return familyService.count();
    }

    public Set<Pet> getPets(int familyIndex) {
        return familyService.getPets(familyIndex);
    }

    public void displayAllFamilies() {
        familyService.displayAllFamilies();
    }

    public List<Family> getFamiliesBiggerThan(int count) {
        return familyService.getFamiliesBiggerThan(count);
    }

    public List<Family> getFamiliesLessThan(int count) {
        return familyService.getFamiliesLessThan(count);
    }

    public long countFamiliesWithMemberNumber(int number) {
        return familyService.countFamiliesWithMemberNumber(number);
    }

    public void createNewFamily(Human father, Human mother) {
        familyService.createNewFamily(father, mother);
    }

    public boolean deleteFamilyByIndex(int index) {
        return familyService.deleteFamilyByIndex(index);
    }

    public void bornChild(Family family, String masculineName, String feminineName) {
        familyService.bornChild(family, masculineName, feminineName);
    }

    public void adoptChild(Family family, Human child) {
        familyService.adoptChild(family, child);
    }

    public void deleteAllChildrenOlderThan(int age) {
        familyService.deleteAllChildrenOlderThan(age);
    }

    public void addPet(int familyIndex, Pet pet) {
        familyService.addPet(familyIndex, pet);
    }


}
