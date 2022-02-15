package com.company.Items;

public enum ArmorType {

    Cloth(0),
    Leather(1),
    Mail(2),
    Plate(3);

    private final int value;

    private ArmorType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
