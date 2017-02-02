package de.zeroxtv.zmenu.clickables;

import de.zeroxtv.zmenu.events.Clicked;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by ZeroxTV
 */
public class ClickButton implements Clickable {
    ItemStack itemStack;
    Clicked clicked;

    public ClickButton(Material material, int amount, short durability, Clicked clicked) {
        this.itemStack = new ItemStack(material, amount, durability);
        this.clicked = clicked;
    }

    @Override
    public ItemStack getItem() {
        return itemStack;
    }

    @Override
    public void click(InventoryClickEvent event) {
        clicked.click(event);
    }
}
