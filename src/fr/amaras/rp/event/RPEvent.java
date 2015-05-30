package fr.amaras.rp.event;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.amaras.rp.RP;

public class RPEvent implements Listener {

	public RP rp;
	Player p;
	public String Player;
	public String classPlayer;
	
	public RPEvent(RP rp){
		this.rp = rp;
	}
	
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		p = e.getPlayer();
		
		rp.saveDefaultConfig();
		classPlayer= rp.getConfig().getString(p.getName() + ".classPlayer");
		if(!(classPlayer == null)){
		p.sendMessage("Bienvenue " + p.getName() + " Vous êtes un " + classPlayer);
		}
		else{
			p.sendMessage("Bienvenue " + p.getName() + " vous n'avez aucune classe pour en choisir une fait /classe");
		}
	}
	
	
	@EventHandler
	  public void onInventoryClick(InventoryClickEvent e)
	  {
	    if (e.getInventory().getName().equals("- selectionnez votre classe -"))
	    {
	      Player p = (Player)e.getWhoClicked();
	      e.setCancelled(true);
	      if (e.getCurrentItem().getType() == Material.DIAMOND_AXE)
	      {
	        p.closeInventory();
	        p.sendMessage("Vous avez choisis la classe Barbare.");
	        classPlayer = "barbare";
	        rp.saveDefaultConfig();
	        rp.getConfig().set(p.getName() + ".classPlayer", String.valueOf(classPlayer));
	      }
	      if (e.getCurrentItem().getType() == Material.DIAMOND_SWORD)
	      {
	        p.closeInventory();
	        p.sendMessage("Vous avez choisis la classe Guerrier.");
	        classPlayer = "guerrier";
	        rp.saveDefaultConfig();
	        rp.getConfig().set(p.getName() + ".classPlayer", String.valueOf(classPlayer));
	      }
	      if (e.getCurrentItem().getType() == Material.BOW)
	      {
	        p.closeInventory();
	        p.sendMessage("Vous avez choisis la classe Archer.");
	        classPlayer = "archer";
	        rp.saveDefaultConfig();
	        rp.getConfig().set(p.getName() + ".classPlayer", String.valueOf(classPlayer));
	      }
	      if (e.getCurrentItem().getType() == Material.BLAZE_ROD)
	      {
	        p.closeInventory();
	        p.sendMessage("Vous avez choisis la classe Mage.");
	        classPlayer = "mage";
	        rp.saveDefaultConfig();
	        rp.getConfig().set(p.getName() + ".classPlayer", String.valueOf(classPlayer));
	      }
	      if (e.getCurrentItem().getType() == Material.GOLD_NUGGET)
	      {
	        p.closeInventory();
	        p.sendMessage("Vous avez choisis la classe Bandit.");
	        classPlayer = "bandit";
	        rp.saveDefaultConfig();
	        rp.getConfig().set(p.getName() + ".classPlayer", String.valueOf(classPlayer));
	      }
	    }
	  }
}
