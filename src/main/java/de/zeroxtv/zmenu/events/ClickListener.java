package de.zeroxtv.zmenu.events;

import de.zeroxtv.zmenu.Menu;
import de.zeroxtv.zmenu.clickables.Clickable;
import de.zeroxtv.zmenu.clickables.ToggleButton;
import de.zeroxtv.zmenu.util.MenuHolder;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * Created by ZeroxTV
 */
public class ClickListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getInventory().getHolder() instanceof MenuHolder) {
            event.setCancelled(true);

            Menu menu = ((MenuHolder) event.getInventory().getHolder()).getMenu();
            int slot = event.getRawSlot();

            Clickable clickable = menu.getClickable(slot);

            if (clickable != null && event.getInventory().getItem(slot) != null) {
                Player clicker = (Player) event.getWhoClicked();
                clickable.click(event);
                if (clickable instanceof ToggleButton) {
                    menu.open(clicker);
                }
            }
        }
    }
}
