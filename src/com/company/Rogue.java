package com.company;

import com.company.Items.ArmorType;
import com.company.Items.WeaponType;

public class Rogue extends Hero{

    @Override
    public int getMainStatValue() {
        return getTotalPrimaryAttributes().getDexterity();
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

    public Rogue() {
    }

    public Rogue(String name, int lvl)
    {

        MaxArmorType = ArmorType.Mail;
        MinArmorType = ArmorType.Leather;
        MaxWeaponType = WeaponType.Sword;
        MinWeaponType = WeaponType.Dagger;

        Name = name;
        Level = lvl;
        ClassName = "Rogue";

        BasePrimaryAttributes = new PrimaryAttributes();

        BasePrimaryAttributes.setVitality(8);
        BasePrimaryAttributes.setStrength(2);
        BasePrimaryAttributes.setDexterity(6);
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
        BasePrimaryAttributes.Dexterity += 4;
        BasePrimaryAttributes.Strength++ ;
        BasePrimaryAttributes.Intelligence++;
        BasePrimaryAttributes.Vitality += 3;

        RefreshStats();
    }

}
