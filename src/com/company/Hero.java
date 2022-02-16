package com.company;

import com.company.Items.*;
import com.company.PrimaryAttributes;
import com.company.SecondaryAttributes;

import java.util.HashMap;
import java.util.Map;

public class Hero {


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public double getDamagePerSecond() {
        return DamagePerSecond;
    }

    public void setDamagePerSecond(double damagePerSecond) {
        DamagePerSecond = damagePerSecond;
    }

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    public PrimaryAttributes getBasePrimaryAttributes() {
        return BasePrimaryAttributes;
    }

    public void setBasePrimaryAttributes(PrimaryAttributes basePrimaryAttributes) {
        BasePrimaryAttributes = basePrimaryAttributes;
    }

    public PrimaryAttributes getTotalPrimaryAttributes() {
        return TotalPrimaryAttributes;
    }

    public void setTotalPrimaryAttributes(PrimaryAttributes totalPrimaryAttributes) {
        TotalPrimaryAttributes = totalPrimaryAttributes;
    }

    public com.company.SecondaryAttributes getSecondaryAttributes() {
        return SecondaryAttributes;
    }

    public void setSecondaryAttributes(com.company.SecondaryAttributes secondaryAttributes) {
        SecondaryAttributes = secondaryAttributes;
    }


    public int getMainStatValue() {
        return MainStatValue;
    }

    public void setMainStatValue(int mainStatValue) {
        MainStatValue = mainStatValue;
    }

    public ArmorType getMaxArmorType() {
        return MaxArmorType;
    }

    public void setMaxArmorType(ArmorType maxArmorType) {
        MaxArmorType = maxArmorType;
    }

    public ArmorType getMinArmorType() {
        return MinArmorType;
    }

    public void setMinArmorType(ArmorType minArmorType) {
        MinArmorType = minArmorType;
    }

    public WeaponType getMaxWeaponType() {
        return MaxWeaponType;
    }

    public void setMaxWeaponType(WeaponType maxWeaponType) {
        MaxWeaponType = maxWeaponType;
    }

    public WeaponType getMinWeaponType() {
        return MinWeaponType;
    }

    public void setMinWeaponType(WeaponType minWeaponType) {
        MinWeaponType = minWeaponType;
    }


    public String Name;
    public int Level;

    public double DamagePerSecond;

    public String ClassName;


    protected PrimaryAttributes BasePrimaryAttributes;

    //TotalPrimary doesn't need to be set...
    protected PrimaryAttributes TotalPrimaryAttributes;
    protected com.company.SecondaryAttributes SecondaryAttributes;


    public Map<ItemSlot, Item> getEquipment() {
        return Equipment;
    }

    public void setEquipment(Map<ItemSlot, Item> equipment) {
        Equipment = equipment;
    }


    protected Map<ItemSlot, Item> Equipment = new HashMap<ItemSlot, Item>();


    //these were abstract earlier???
    protected  int MainStatValue;

    protected ArmorType MaxArmorType;
    protected ArmorType MinArmorType;

    protected WeaponType MaxWeaponType;
    protected WeaponType MinWeaponType;



    void LevelUp() {
        //override by all subclasses
    }


    protected void RefreshStats() {

        TotalPrimaryAttributes = new PrimaryAttributes();

        TotalPrimaryAttributes.Dexterity = BasePrimaryAttributes.Dexterity;
        TotalPrimaryAttributes.Strength = BasePrimaryAttributes.Strength;
        TotalPrimaryAttributes.Intelligence = BasePrimaryAttributes.Intelligence;
        TotalPrimaryAttributes.Vitality = BasePrimaryAttributes.Vitality;

        if (Equipment.containsKey(ItemSlot.Legs))
        {

            Armor legs = (Armor)Equipment.get(ItemSlot.Legs);
            TotalPrimaryAttributes.Strength += legs.ArmorAttributes.Strength;
            TotalPrimaryAttributes.Intelligence += legs.ArmorAttributes.Intelligence;
            TotalPrimaryAttributes.Dexterity += legs.ArmorAttributes.Dexterity;
            TotalPrimaryAttributes.Vitality  += legs.ArmorAttributes.Vitality;

        }
        if (Equipment.containsKey(ItemSlot.Body))
        {
            Armor body = (Armor)Equipment.get(ItemSlot.Body);
            TotalPrimaryAttributes.Strength += body.ArmorAttributes.Strength;
            TotalPrimaryAttributes.Intelligence += body.ArmorAttributes.Intelligence;
            TotalPrimaryAttributes.Dexterity += body.ArmorAttributes.Dexterity;
            TotalPrimaryAttributes.Vitality += body.ArmorAttributes.Vitality;

        }
        if (Equipment.containsKey(ItemSlot.Head))
        {
            Armor head = (Armor)Equipment.get(ItemSlot.Head);
            TotalPrimaryAttributes.Strength += head.ArmorAttributes.Strength;
            TotalPrimaryAttributes.Intelligence += head.ArmorAttributes.Intelligence;
            TotalPrimaryAttributes.Dexterity += head.ArmorAttributes.Dexterity;
            TotalPrimaryAttributes.Vitality += head.ArmorAttributes.Vitality;

        }

        SecondaryAttributes.Health = TotalPrimaryAttributes.Vitality * 10;
        SecondaryAttributes.ArmorRating = TotalPrimaryAttributes.Strength + TotalPrimaryAttributes.Dexterity;
        SecondaryAttributes.ElementalResistance = TotalPrimaryAttributes.Intelligence;
        MainStatValue = getMainStatValue();

        if (Equipment.containsKey(ItemSlot.Weapon))
        {
            Weapon weapon = (Weapon)Equipment.get(ItemSlot.Weapon);
            double atkSpeed = weapon.WeaponAttributes.AttackSpeed;
            double damage = weapon.WeaponAttributes.Damage;

            DamagePerSecond = (atkSpeed * damage) * (1.0 + ((double)MainStatValue / 100.0));
        } else
        {
            DamagePerSecond = 0;
        }

    }


    public void Equip (Item item) throws InvalidArmorException, InvalidWeaponException, InvalidItemLvlException  {

        if( item.ItemLvl > Level){
            throw new InvalidItemLvlException();
        }
        if (item.Slot == ItemSlot.Weapon) {
            EquipWeapon((Weapon)item);
        } else
        {
            EquipArmor((Armor)item);
        }

    }


    private void EquipArmor(Armor item) throws InvalidArmorException {

        if (item.ArmorType.getValue() >= MinArmorType.getValue()
                && item.ArmorType.getValue() <= MaxArmorType.getValue())
        {
            Equipment.put(item.Slot, item);
            RefreshStats();

        } else
        {
            throw new InvalidArmorException();
        }

    }


    private void EquipWeapon(Weapon item) throws InvalidWeaponException{

        if (item.WeaponType.getValue() >= MinWeaponType.getValue()
                && item.WeaponType.getValue() <= MaxWeaponType.getValue())
        {
            Equipment.put(item.Slot, item);
            RefreshStats();
        } else
        {
            throw new InvalidWeaponException();
        }


    }


    public String ToString()
    {
        RefreshStats();
        StringBuilder sb = new StringBuilder();
        sb.append("-----------------\nName: " + Name);
        sb.append("   Lvl: " + Level + " " + ClassName);
        sb.append("\nSTR: " + TotalPrimaryAttributes.Strength);
        sb.append("   DEX: " + TotalPrimaryAttributes.Dexterity);
        sb.append("   INT: " + TotalPrimaryAttributes.Intelligence);
        sb.append("   VIT: " + TotalPrimaryAttributes.Vitality);
        sb.append("\nHealth: " + SecondaryAttributes.Health);
        sb.append("   Armor Rating: " + SecondaryAttributes.ArmorRating);
        sb.append("   Elemental Resistance: " + SecondaryAttributes.ElementalResistance);
        sb.append("\nDPS: " + DamagePerSecond);
        sb.append("\n-----------------\n \n");

        return sb.toString();
    }




    public PrimaryAttributes GetBaseStats(){

        PrimaryAttributes primarys = new PrimaryAttributes();
        primarys.Strength = BasePrimaryAttributes.Strength;
        primarys.Vitality = BasePrimaryAttributes.Vitality;
        primarys.Intelligence = BasePrimaryAttributes.Intelligence;
        primarys.Dexterity = BasePrimaryAttributes.Dexterity;

        return primarys;
    };

    public PrimaryAttributes GetTotalStats(){

        PrimaryAttributes totals = new PrimaryAttributes();
        totals.Strength = TotalPrimaryAttributes.Strength;
        totals.Vitality = TotalPrimaryAttributes.Vitality;
        totals.Intelligence = TotalPrimaryAttributes.Intelligence;
        totals.Dexterity = TotalPrimaryAttributes.Dexterity;

        return totals;
    }

    public SecondaryAttributes GetSecondaryStats(){

        SecondaryAttributes secondaries = new SecondaryAttributes();
        secondaries.Health = SecondaryAttributes.Health;
        secondaries.ArmorRating = SecondaryAttributes.ArmorRating;
        secondaries.ElementalResistance = SecondaryAttributes.ElementalResistance;

        return secondaries;
    }

}