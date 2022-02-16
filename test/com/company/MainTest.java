package com.company;

import com.company.Items.Item;
import com.company.Items.Armor;
import com.company.Items.ArmorType;
import com.company.Items.ItemSlot;
import com.company.Items.WeaponType;
import com.company.Items.Weapon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Armor armor = new Armor("testarmor", 1, ItemSlot.Legs, ArmorType.Cloth, 6, 6, 1, 1);
    Weapon weapon = new Weapon("testweapon", 1,WeaponType.Staff, 4, 1);


    @Test
    void EquipWeapon_InvalidLevel_ShouldReturnError() throws InvalidArmorException, InvalidWeaponException, InvalidItemLvlException {
        Mage hero = new Mage("testman", 1);
        Weapon weapon = new Weapon("testweapon", 2,WeaponType.Staff, 4, 1);
        assertThrows(InvalidItemLvlException.class, () -> {
            hero.Equip(weapon);
        });

    }
    @Test
    void EquipWeapon_InvalidType_ShouldReturnError() throws InvalidArmorException, InvalidWeaponException, InvalidItemLvlException {
        Mage hero = new Mage("testman", 1);
        Weapon weapon = new Weapon("testweapon", 1,WeaponType.Sword, 4, 1);
        assertThrows(InvalidWeaponException.class, () -> {
            hero.Equip(weapon);
        });
    }
    @Test
    void EquipArmor_InvalidType_ShouldReturnError() throws InvalidArmorException, InvalidWeaponException, InvalidItemLvlException{
        Mage hero = new Mage("testman", 1);
        Armor armor = new Armor("testarmor", 1, ItemSlot.Legs, ArmorType.Mail, 6, 6, 1, 1);
        assertThrows(InvalidArmorException.class, () -> {
            hero.Equip(armor);
        });
    }
    @Test
    void EquipArmor_Valid_ShouldPass() throws InvalidArmorException, InvalidWeaponException, InvalidItemLvlException{
        Mage hero = new Mage("testman", 1);
        Armor armor = new Armor("testarmor", 1, ItemSlot.Legs, ArmorType.Cloth, 6, 6, 1, 1);
        hero.Equip(armor);
        Assertions.assertEquals(hero.getEquipment().get(ItemSlot.Legs).ItemName, "testarmor");
    }
    @Test
    void EquipWeapon_Valid_ShouldPass() throws InvalidArmorException, InvalidWeaponException, InvalidItemLvlException{
        Mage hero = new Mage("testman", 1);
        Weapon weapon = new Weapon("testweapon", 1,WeaponType.Staff, 4, 1);
        hero.Equip(weapon);
        Assertions.assertEquals(hero.getEquipment().get(ItemSlot.Weapon).ItemName, "testweapon");
    }
    @Test
    void CheckDpsWithWeapon_Valid_ShouldPass() throws InvalidArmorException, InvalidWeaponException, InvalidItemLvlException{
        Mage hero = new Mage("testman", 1);
        Weapon weapon = new Weapon("testweapon", 1,WeaponType.Staff, 4, 2);
        hero.Equip(weapon);
        Assertions.assertEquals(hero.getDamagePerSecond(), 8.64);
    }
    @Test
    void CheckDpsWithWeaponAndArmor_Valid_ShouldPass() throws InvalidArmorException, InvalidWeaponException, InvalidItemLvlException{
        Mage hero = new Mage("testman", 1);
        Weapon weapon = new Weapon("testweapon", 1,WeaponType.Staff, 4, 2);
        Armor armor = new Armor("testarmor", 1, ItemSlot.Legs, ArmorType.Cloth, 6, 6, 10, 1);
        hero.Equip(weapon);
        hero.Equip(armor);
        Assertions.assertEquals(hero.getDamagePerSecond(), 9.44);
    }




    @Test
    void getHeroLevel_CurrentValue_ShouldPass() {
        Mage hero = new Mage("testman", 1);
        Assertions.assertEquals(hero.getLevel(), 1);
    }

    @Test
    void CheckHeroStats_ShouldPass() {
        Mage hero = new Mage("testman", 1);

        Assertions.assertEquals(hero.getBasePrimaryAttributes().Dexterity, 1);
        Assertions.assertEquals(hero.getBasePrimaryAttributes().Strength, 1);
        Assertions.assertEquals(hero.getBasePrimaryAttributes().Intelligence, 8);
        Assertions.assertEquals(hero.getBasePrimaryAttributes().Vitality, 5);
    }

    @Test
    void LevelUpHero_NewValue_ShouldPass() {
        Mage hero = new Mage("testman", 1);
        hero.LevelUp();
        Assertions.assertEquals(hero.getLevel(), 2);
    }

    @Test
    void CheckHeroLvl2Stats_ShouldPass() {
        Mage hero = new Mage("testman", 1);
        hero.LevelUp();
        Assertions.assertEquals(hero.getTotalPrimaryAttributes().Dexterity, 2);
        Assertions.assertEquals(hero.getTotalPrimaryAttributes().Strength, 2);
        Assertions.assertEquals(hero.getTotalPrimaryAttributes().Intelligence, 13);
        Assertions.assertEquals(hero.getTotalPrimaryAttributes().Vitality, 8);
    }










}