package de.zeroxtv.zmenu.util;

import de.zeroxtv.zmenu.Menu;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

/**
 * Created by ZeroxTV
 */
public class MenuHolder implements InventoryHolder {

    private Menu menu;

    public MenuHolder(Menu menu) {
        this.menu = menu;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        if (menu != null) {
            this.menu = menu;
        }
    }

    @Override
    public Inventory getInventory() {
        return Bukkit.createInventory(null, menu.getSize());
    }
}
