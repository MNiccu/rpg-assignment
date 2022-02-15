package com.company.Items;

public class Item {

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String ItemName;

    public int getItemLvl() {
        return ItemLvl;
    }

    public void setItemLvl(int itemLvl) {
        ItemLvl = itemLvl;
    }

    public int ItemLvl;


    public ItemSlot getSlot() {
        return Slot;
    }

    public void setSlot(ItemSlot slot) {
        Slot = slot;
    }

    public ItemSlot Slot = null;
}
