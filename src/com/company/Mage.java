package com.company;

import com.company.Items.ArmorType;
import com.company.Items.WeaponType;

public class Mage extends Hero {

    @Override
    public int getMainStatValue() {
        return MainStatValue;
    }

    @Override
    public void setMainStatValue(int mainStatValue) {
        MainStatValue = mainStatValue;
    }

    @Override
    public ArmorType getMaxArmorType() {
        return MaxArmorType;
    }

    @Override
    public void setMaxArmorType(ArmorType maxArmorType) {
        MaxArmorType = maxArmorType;
    }

    @Override
    public ArmorType getMinArmorType() {
        return MinArmorType;
    }

    @Override
    public void setMinArmorType(ArmorType minArmorType) {
        MinArmorType = minArmorType;
    }

    @Override
    public WeaponType getMaxWeaponType() {
        return MaxWeaponType;
    }

    @Override
    public void setMaxWeaponType(WeaponType maxWeaponType) {
        MaxWeaponType = maxWeaponType;
    }

    @Override
    public WeaponType getMinWeaponType() {
        return MinWeaponType;
    }

    @Override
    public void setMinWeaponType(WeaponType minWeaponType) {
        MinWeaponType = minWeaponType;
    }


    public int MainStatValue;

   // public ArmorType MaxArmorType;

   // public ArmorType MinArmorType;

   // public WeaponType MaxWeaponType;

   // public WeaponType MinWeaponType;



    public Mage() {
    }

    public Mage(String name, int lvl)
    {

        MaxArmorType = ArmorType.Cloth;
        MinArmorType = ArmorType.Cloth;
        MaxWeaponType = WeaponType.Wand;
        MinWeaponType = WeaponType.Staff;

        MainStatValue = getTotalPrimaryAttributes().Intelligence;


        Name = name;
        Level = lvl;
        ClassName = "Mage";

        BasePrimaryAttributes = new PrimaryAttributes();

        BasePrimaryAttributes.setVitality(5);
        BasePrimaryAttributes.setStrength(1);
        BasePrimaryAttributes.setDexterity(1);
        BasePrimaryAttributes.setIntelligence(8);




        SecondaryAttributes = new SecondaryAttributes();

        SecondaryAttributes.setHealth(BasePrimaryAttributes.Vitality * 10);
        SecondaryAttributes.setArmorRating(BasePrimaryAttributes.Strength + BasePrimaryAttributes.Dexterity);
        SecondaryAttributes.setElementalResistance(BasePrimaryAttributes.Intelligence);

        DamagePerSecond = 0;
    }

    @Override
    public void LevelUp(){
        Level = Level +1;
        BasePrimaryAttributes.Dexterity++;
        BasePrimaryAttributes.Strength++ ;
        BasePrimaryAttributes.Intelligence += 5;
        BasePrimaryAttributes.Vitality += 3;

        RefreshStats();
    }

}
