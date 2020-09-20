package de.tails.testplugin.enderchest;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.tails.testplugin.main.TestPlugin;

public class Enderchest_Command implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender.hasPermission("Enderchest.use"))) {
			sender.sendMessage(TestPlugin.getPrefix() + "§cDazu hast du §4keine Berechtigung§c!");
			return true;
		}
		if(!(sender instanceof Player))
			return true;
		Player player = (Player) sender;
		if(args.length == 0) {
			player.openInventory(player.getEnderChest());
			player.playSound(player.getLocation(), Sound.CHEST_OPEN, 1, 1);
		} else if(args.length == 1) {
			if(!(sender.hasPermission("Enderchest.other"))) {
				sender.sendMessage(TestPlugin.getPrefix() + "§cDazu hast du §4keine Berechtigung§c!");
				return true;
			}
			Player target = Bukkit.getPlayer(args[0]);
			if(target != null) {
				if(target != player) {
					TestPlugin.ec.add(player);
				}
				player.openInventory(target.getEnderChest());
				player.playSound(player.getLocation(), Sound.CHEST_OPEN, 1, 1);
			} else {
				player.sendMessage(TestPlugin.getPrefix() + "§cDieser Spieler wurde nicht gefunden!");
			}
		} else {
			player.sendMessage(TestPlugin.getPrefix() + "§cBitte verwende §4/ec | /ec <Spieler");
		}
		return false;
	}
}