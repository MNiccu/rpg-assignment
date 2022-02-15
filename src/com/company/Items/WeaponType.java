package com.company.Items;

public enum WeaponType {
    Staff(0),
    Wand(1),
    Bow(2),
    Dagger(3),
    Sword(4),
    Axe(5),
    Hammer(6);

    private final int value;

    private WeaponType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
