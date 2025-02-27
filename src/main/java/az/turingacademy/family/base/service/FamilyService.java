package az.turingacademy.family.base.service;

import az.turingacademy.family.base.dao.FamilyDao;
import az.turingacademy.family.human.Family;
import az.turingacademy.family.human.Human;
import az.turingacademy.family.human.Man;
import az.turingacademy.family.human.Woman;
import az.turingacademy.family.pet.Pet;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class FamilyService {
    private final FamilyDao familyDao;

    public FamilyService(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }

    public List<Family> getAllFamilies(){
        return familyDao.getAllFamilies();
    }

    public Family getFamilyByIndex(int index){
        return familyDao.getFamilyByIndex(index);
    }

    public int count(){
        return familyDao.getAllFamilies().size();
    }

    public Set<Pet> getPets(int familyIndex){
        return  getFamilyByIndex(familyIndex).getPets();
    }

    public void displayAllFamilies(){
        getAllFamilies().forEach(Family::prettyFormat);
    }

    public List<Family> getFamiliesBiggerThan(int count) {
        return getAllFamilies().stream().filter(family -> family.countFamily()>count).toList();
    }

    public List<Family> getFamiliesLessThan(int count){
        return getAllFamilies().stream().filter(family -> family.countFamily()<count).toList();
    }

    public long countFamiliesWithMemberNumber(int number){
        return getAllFamilies().stream().filter(family -> family.countFamily()==number).count();
    }

    public void createNewFamily(Human father, Human mother){
            Family family=new Family(mother,father);
            familyDao.saveFamily(family);
    }

    public void createNewFamily(Family family) {
        familyDao.saveFamily(family);
    }

    public boolean deleteFamilyByIndex(int index){
        return familyDao.deleteFamily(index);
    }

    public void bornChild(Family family,String masculineName,String feminineName){
        boolean genderMan=new Random().nextBoolean();
        String name=genderMan? masculineName:feminineName;
        Human child=genderMan? new Man(name,family.getFather().getSurname(),"21/10/2000"): new Woman(name,family.getFather().getSurname(),"30/06/2006");
        child.setFamily(family);
        family.addChild(child);
        familyDao.saveFamily(family);
    }

    public void adoptChild(Family family,Human child){
        family.addChild(child);
        familyDao.saveFamily(family);
    }

    public void deleteAllChildrenOlderThan(int age){
        for (Family family:getAllFamilies()){
            if(family.getChildren().removeIf(child-> Period.between(child.getBirthDate(), LocalDate.now()).getYears()>age)){
                familyDao.saveFamily(family);
            }
        }
    }

    public void addPet(int familyIndex,Pet pet){
        Family family=getFamilyByIndex(familyIndex);
        if(family!=null){
            family.addPet(pet);
            familyDao.saveFamily(family);
        }
    }

}
