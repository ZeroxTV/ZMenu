package de.zeroxtv.zmenu;

import de.zeroxtv.zmenu.events.ClickListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ZMenu extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new ClickListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
