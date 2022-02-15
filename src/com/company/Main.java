package com.company;

import com.company.Items.*;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    //TODO
    static ArrayList<Hero> heroes = new ArrayList<Hero>();
    static ArrayList<Item> items = new ArrayList<Item>();


    public static void main(String[] args) {

        heroes.add(new Mage("Dude", 1));
        heroes.add(new Ranger("Glorp", 1));
        heroes.add(new Warrior("Mondo", 1));
        heroes.add(new Rogue("Edgelord", 1));

        Armor armor = new Armor("leggings of coding", 1, ItemSlot.Legs, ArmorType.Cloth, 1, 2, 3, 2);
        Armor armor2 = new Armor("hat of pain", 3, ItemSlot.Head, ArmorType.Leather, 4,2,0,2);
        Armor armor3 = new Armor("leggings of shame", 1, ItemSlot.Legs, ArmorType.Cloth, 6, 6, 1, 1);
        Weapon weapon = new Weapon("staff of staff management", 1, WeaponType.Staff, 4, 1);
        Weapon weapon2 = new Weapon("Sword of swordness", 2, WeaponType.Sword, 7, 1);
        items.add(armor);
        items.add(armor2);
        items.add(armor3);
        items.add(weapon);
        items.add(weapon2);


        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("HERO INTERFACE");
            System.out.println("\n1: Create Hero\n2: Display chosen Hero\n3: Level up Hero\n4: Equip item");
            String choice1 = scanner.nextLine();
            if (choice1.equals("1")) {
                //create hero not currently done
                HeroCreate();
            } else if (choice1.equals("2")) {
                //choose hero and display stats
                HeroDisplay();
            } else if (choice1.equals("3")) {
                //lvl up chosen hero
                ChooseLevelUp();
            } else if (choice1.equals("4")) {
                //equip chosen item to chosen hero
                EquipSomething();
            } else {
                //any other input ends program
                break;
            }


        }
    }

    static void EquipSomething()
    {

        Scanner scanner = new Scanner(System.in);
        System.out.println("who do you want to equip to?");

        for (int i = 0; i < heroes.size(); i++)
        {
            System.out.println(i + 1 + ": " + heroes.get(i).Name + " | lvl " + heroes.get(i).Level + " " + heroes.get(i).ClassName);

        }

        Integer choice = 0;
        String userInput;
        while (choice < 1 || choice > heroes.size() || choice == null) {

            userInput = scanner.nextLine();
            choice = parseIntOrNull(userInput);

            if(choice < 1 || choice > heroes.size() || choice == null){
                System.out.println("invalid input");
            }
        }

        choice--;

        System.out.println("what item to equip?");
        for (int i = 0; i < items.size(); i++)
        {
            System.out.println(i + 1 + ": " + items.get(i).ItemName + " | lvl " + items.get(i).ItemLvl );

        }

        Integer choice2 = 0;

        while (choice2 < 1 || choice2 > items.size() || choice2 == null) {

            userInput = scanner.nextLine();
            choice2 = parseIntOrNull(userInput);

            if(choice2 < 1 || choice2 > items.size() || choice2 == null){
                System.out.println("invalid input");
            }

        }
        choice2--;

        //chosen hero, equip chosen item
        try {
            heroes.get(choice).Equip(items.get(choice2));
        } catch (InvalidArmorException | InvalidWeaponException e) {
            e.printStackTrace();
        }

    }

    static void ChooseLevelUp(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("who do you want to level up?");

        for (int i = 0; i < heroes.size(); i++)
        {
            System.out.println(i + 1 + ": " + heroes.get(i).Name + " | lvl " + heroes.get(i).Level + " " + heroes.get(i).ClassName);

        }

        Integer choice = 0;
        String userInput;
        while (choice < 1 || choice > heroes.size() || choice == null) {

            userInput = scanner.nextLine();
            choice = parseIntOrNull(userInput);

            if(choice < 1 || choice > heroes.size() || choice == null){
                System.out.println("invalid input");
            }

        }
        choice--;


        System.out.println("Leveling up\n ------------- \n");
        heroes.get(choice).LevelUp();

    }

    static void HeroDisplay(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("who do you want to see?");

        for (int i = 0; i < heroes.size(); i++)
        {
            System.out.println(i + 1 + ": " + heroes.get(i).Name + " | lvl " + heroes.get(i).Level + " " + heroes.get(i).ClassName);

        }

        Integer choice = 0;
        String userInput;
        while (choice < 1 || choice > heroes.size() || choice == null) {

            userInput = scanner.nextLine();
            choice = parseIntOrNull(userInput);

            if(choice < 1 || choice > heroes.size() || choice == null){
                System.out.println("invalid input");
            }

        }
        choice--;

        System.out.println(heroes.get(choice).ToString());

    }


    static void HeroCreate(){
        System.out.println("hero creation not implemented");
    }

    static Integer parseIntOrNull(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}