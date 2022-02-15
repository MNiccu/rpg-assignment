package com.company.Items;

public enum ItemSlot {
    Head(0),
    Body(1),
    Legs(2),
    Weapon(3);


    private final int value;

    private ItemSlot(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
