package com.company;

import com.company.Items.ArmorType;
import com.company.Items.WeaponType;

public class Warrior extends Hero {

    @Override
    public int getMainStatValue() {
        return getTotalPrimaryAttributes().getStrength();
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

    public Warrior() {
    }

    public Warrior(String name, int lvl)
    {

        MaxArmorType = ArmorType.Plate;
        MinArmorType = ArmorType.Mail;
        MaxWeaponType = WeaponType.Hammer;
        MinWeaponType = WeaponType.Sword;

        Name = name;
        Level = lvl;
        ClassName = "Warrior";

        BasePrimaryAttributes = new PrimaryAttributes();

        BasePrimaryAttributes.setVitality(10);
        BasePrimaryAttributes.setStrength(5);
        BasePrimaryAttributes.setDexterity(2);
        BasePrimaryAttributes.setIntelligence(1);



        SecondaryAttributes = new SecondaryAttributes();

        SecondaryAttributes.setHealth(BasePrimaryAttributes.Vitality * 10);
        SecondaryAttributes.setArmorRating(BasePrimaryAttributes.Strength + BasePrimaryAttributes.Dexterity);
        SecondaryAttributes.setElementalResistance(BasePrimaryAttributes.Intelligence);

        DamagePerSecond = 0;
    }

    @Override
    public void LevelUp(){
        Level = Level +1;
        BasePrimaryAttributes.Dexterity += 2;
        BasePrimaryAttributes.Strength += 3 ;
        BasePrimaryAttributes.Intelligence++;
        BasePrimaryAttributes.Vitality += 5;

        RefreshStats();
    }
}
