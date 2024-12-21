package az.turingacademy.family;

public enum Species {
    CAT(false, 4, true),
    DOG(false, 4, true),
    BIRD(true, 2, true),
    FISH(false, 0, false),
    HAMSTER(false, 4, true);

    private boolean canFly;
    private int legs;
    private boolean fur;

    Species(boolean canFly, int legs, boolean fur) {
        this.canFly = canFly;
        this.legs = legs;
        this.fur = fur;
    }

    public String getSpecies() {
        return "can fly:" + canFly + " ,legs:" + legs + " ,fur:" + fur;
    }

}
