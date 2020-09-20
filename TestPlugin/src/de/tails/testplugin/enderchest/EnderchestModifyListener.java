package de.tails.testplugin.enderchest;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

import de.tails.testplugin.main.TestPlugin;

public class EnderchestModifyListener implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		if(TestPlugin.ec.contains(player)) {
			if(!player.hasPermission("Enderchest.modify")) {
				event.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void onInventoryClose(InventoryCloseEvent event) {
		Player player = (Player) event.getPlayer();
		if(TestPlugin.ec.contains(player)) {
			TestPlugin.ec.remove(player);
		}
	}
}