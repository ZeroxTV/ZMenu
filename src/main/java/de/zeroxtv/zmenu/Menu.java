package de.zeroxtv.zmenu;

import de.zeroxtv.zmenu.clickables.Clickable;
import de.zeroxtv.zmenu.util.MenuHolder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/**
 * Created by ZeroxTV
 */
public class Menu {
    String name;
    Clickable[] clickables;

    public Menu(String name, int rows) {
        this.name = name;
        clickables = new Clickable[rows*9];
    }

    public void setItem(int x, int y, Clickable clickable) {
        int slot = Math.abs(y-1)*9 + Math.abs(x-1);
        if (slot >= 0 && slot < clickables.length) {
            clickables[slot] = clickable;
        }
    }

    public void setItem(int slot, Clickable clickable) {
        if (slot >= 0 && slot < clickables.length) {
            clickables[slot] = clickable;
        }
    }

    public Clickable getClickable(int x, int y) {
        int slot = Math.abs(y - 1) * 9 + Math.abs(x - 1);
        if (slot >= 0 && slot < clickables.length) {
            return clickables[slot];
        }
        return null;
    }

    public Clickable getClickable(int slot) {
        if (slot >= 0 && slot < clickables.length)  {
            return clickables[slot];
        }
        return null;
    }

    public int getRows() {
        return clickables.length/9;
    }

    public int getSize() {
        return clickables.length;
    }

    public String getName() {
        return name;
    }

    public void open(Player player) {
        Inventory inventory = Bukkit.createInventory(new MenuHolder(this), clickables.length, name);

        for (int i = 0; i < clickables.length; i++) {
            if (clickables[i] != null) {
                inventory.setItem(i, clickables[i].getItem());
            }
        }
        player.openInventory(inventory);
    }
}
