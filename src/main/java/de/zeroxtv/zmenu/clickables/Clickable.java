package de.zeroxtv.zmenu.clickables;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by ZeroxTV
 */
public interface Clickable {
    ItemStack getItem();
    void click(InventoryClickEvent event);
}
