package fr.amaras.rp;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import fr.amaras.rp.cmd.ClassPlayerCmd;
import fr.amaras.rp.event.RPEvent;

public class RP extends JavaPlugin {

	ScoreboardManager sm;
	Scoreboard s;
	Objective obj;
	PluginManager pm;

	public void onEnable() {
		getLogger().info("[RP Plugin] is enable");
		
		pm.registerEvents(new RPEvent(this), this);
		getCommand("class").setExecutor(new ClassPlayerCmd(this));
	}

}
