package com.company.Items;

//interface "implements"
public class Weapon extends Item {


    public com.company.Items.WeaponAttributes getWeaponAttributes() {
        return WeaponAttributes;
    }

    public void setWeaponAttributes(WeaponAttributes weaponAttributes) {
        WeaponAttributes = weaponAttributes;
    }

    public WeaponAttributes WeaponAttributes;

    public com.company.Items.WeaponType getWeaponType() {
        return WeaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        WeaponType = weaponType;
    }
    public WeaponType WeaponType;

    public Weapon(){

    }
    public Weapon(String name, int level, WeaponType weapontype, int damage, int attackSpeed){
        ItemName = name;
        ItemLvl = level;
        Slot = ItemSlot.Weapon;

        WeaponAttributes wpnAttributes = new WeaponAttributes();
        wpnAttributes.setDamage(damage);
        wpnAttributes.setAttackSpeed(attackSpeed);


        WeaponType = weapontype;


    }

}
