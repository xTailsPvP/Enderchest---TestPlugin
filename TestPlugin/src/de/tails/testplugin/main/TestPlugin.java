package de.tails.testplugin.main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.tails.testplugin.enderchest.EnderchestModifyListener;
import de.tails.testplugin.enderchest.Enderchest_Command;

public class TestPlugin extends JavaPlugin {

	public static ArrayList<Player> ec = new ArrayList<Player>();

	private static TestPlugin plugin;
	private static String prefix = "§9[§3Enderchest§9] ";

	@Override
	public void onEnable() {
		plugin = this;

		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new EnderchestModifyListener(), this);

		getCommand("enderchest").setExecutor(new Enderchest_Command());

		Bukkit.getConsoleSender().sendMessage("§3Enderchest Plugin von xTailsPvP wurde gestartet!");
	}

	@Override
	public void onDisable() {
		plugin = null;
		Bukkit.getConsoleSender().sendMessage("§3Enderchest Plugin von xTailsPvP wurde gestoppt!");
	}

	public static String getPrefix() {
		return prefix;
	}

	public static TestPlugin getPlugin() {
		return plugin;
	}
}