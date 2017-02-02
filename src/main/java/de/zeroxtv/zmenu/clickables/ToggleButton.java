package de.zeroxtv.zmenu.clickables;

import de.zeroxtv.zmenu.events.Clicked;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by ZeroxTV
 */
public class ToggleButton implements Clickable {
    private boolean state;
    private ItemStack on;
    private Clicked onClick;
    private Clicked offClick;
    private ItemStack off;

    @Override
    public ItemStack getItem() {
        if (state) return on;
        else return off;
    }

    @Override
    public void click(InventoryClickEvent event) {
        if (state) onClick.click(event);
        else offClick.click(event);
    }

    public ToggleButton(ItemStack on, ItemStack off, Clicked onClick, Clicked offClick, boolean state) {
        this.on = on;
        this.off = off;
        this.state = state;
        this.onClick = onClick;
        this.offClick = offClick;

        this.onClick = event -> {
            toggle();
            onClick.click(event);
        };

        this.offClick = event -> {
            toggle();
            offClick.click(event);
        };
    }

    public ToggleButton(Material on, int onAmount, Material off, int offAmount, Clicked onClick, Clicked offClick, boolean state) {
        this.on = new ItemStack(on, onAmount);
        this.off = new ItemStack(off, offAmount);
        this.state = state;
        this.onClick = onClick;
        this.offClick = offClick;

        this.onClick = event -> {
            toggle();
            onClick.click(event);
        };

        this.offClick = event -> {
            toggle();
            offClick.click(event);
        };
    }

    public ToggleButton(Material on, int onAmount, short onDurability, Material off, int offAmount, short offDurability, Clicked onClick, Clicked offClick, boolean state) {
        this.on = new ItemStack(on, onAmount, onDurability);
        this.off = new ItemStack(off, offAmount, offDurability);
        this.state = state;
        this.onClick = event -> {
            toggle();
            onClick.click(event);
        };

        this.offClick = event -> {
            toggle();
            offClick.click(event);
        };
    }

    public void setOnAmount(int amount) {
        on.setAmount(amount);
    }

    public void setOffAmount(int amount) {
        off.setAmount(amount);
    }

    public void setOnDurability(short durability) {
        on.setDurability(durability);
    }

    public void setOffDurability(short durability) {
        off.setDurability(durability);
    }

    private void toggle() {
        state = !state;
    }
}
