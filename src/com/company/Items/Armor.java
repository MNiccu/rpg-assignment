package com.company.Items;

import com.company.PrimaryAttributes;

public class Armor extends Item {

    private int armorValue;


    public PrimaryAttributes getArmorAttributes() {
        return ArmorAttributes;
    }

    public void setArmorAttributes(PrimaryAttributes armorAttributes) {
        ArmorAttributes = armorAttributes;
    }

    public PrimaryAttributes ArmorAttributes = new PrimaryAttributes();


    public com.company.Items.ArmorType getArmorType() {
        return ArmorType;
    }

    public void setArmorType(com.company.Items.ArmorType armorType) {
        ArmorType = armorType;
    }

    public ArmorType ArmorType;


    public Armor(){

    }
    public Armor(String name, int lvl, ItemSlot slot, ArmorType armortype, int strength, int dexterity, int intelligence, int vitality){
        ItemName = name;
        ItemLvl = lvl;
        Slot = slot;
        ArmorType = armortype;

        ArmorAttributes.setStrength(strength);
        ArmorAttributes.setDexterity(dexterity);
        ArmorAttributes.setIntelligence(intelligence);
        ArmorAttributes.setVitality(vitality);

    }


}
