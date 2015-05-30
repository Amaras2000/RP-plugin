package fr.amaras.rp.event;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.amaras.rp.RP;

public class RPEvent implements Listener {

	public RP rp;
	Player p;
	public String Player;
	public String classPlayer;

	public RPEvent(RP rp) {
		this.rp = rp;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		p = e.getPlayer();
		Inventory i = p.getInventory();
		rp.saveDefaultConfig();
		classPlayer = rp.getConfig().getString(p.getName() + ".classPlayer");
		if (!(classPlayer == null)) {
			p.sendMessage("Bienvenue " + p.getName() + " vous êtes un "
					+ classPlayer);
		} else {
			p.sendMessage("Bienvenue "
					+ p.getName()
					+ " vous n'avez aucune classe pour en choisir une fait /classe");
		}

		ItemStack is = new ItemStack(Material.CHEST);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName("Bourse");
		is.setItemMeta(im);
		i.setItem(17, is);
	}

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		p = (org.bukkit.entity.Player) e.getWhoClicked();
		if (e.getInventory().getName().equals("- selectionnez votre classe -")) {
			Player p = (Player) e.getWhoClicked();
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.DIAMOND_AXE) {
				p.closeInventory();
				p.sendMessage("Vous avez choisis la classe Barbare.");
				classPlayer = "barbare";
				rp.saveDefaultConfig();
				rp.getConfig().set(p.getName() + ".classPlayer",
						String.valueOf(classPlayer));
				rp.getConfig().set(p.getName() + ".axe", "1");
				rp.saveConfig();
				classPlayer = "";
				p.setMaxHealth(24.0F);
				p.setHealth(24.0F);
				for (PotionEffect effect : p.getActivePotionEffects()) {

					p.removePotionEffect(effect.getType());

				}
				p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,
						Integer.MAX_VALUE, 0));
				p.addPotionEffect(new PotionEffect(
						PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE,
						0));

			}
			if (e.getCurrentItem().getType() == Material.DIAMOND_SWORD) {
				p.closeInventory();
				p.sendMessage("Vous avez choisis la classe Guerrier.");
				classPlayer = "guerrier";
				rp.saveDefaultConfig();
				rp.getConfig().set(p.getName() + ".classPlayer",
						String.valueOf(classPlayer));
				rp.getConfig().set(p.getName() + ".sword", "1");
				rp.saveConfig();
				classPlayer = "";
				p.setMaxHealth(20.0F);
				p.setHealth(20.0F);
				for (PotionEffect effect : p.getActivePotionEffects()) {

					p.removePotionEffect(effect.getType());

				}
			}
			if (e.getCurrentItem().getType() == Material.BOW) {
				p.closeInventory();
				p.sendMessage("Vous avez choisis la classe Archer.");
				classPlayer = "archer";
				rp.saveDefaultConfig();
				rp.getConfig().set(p.getName() + ".classPlayer",
						String.valueOf(classPlayer));
				rp.getConfig().set(p.getName() + ".bow", "1");
				rp.saveConfig();
				classPlayer = "";
				p.setMaxHealth(10.F);
				p.setHealth(10.0F);
				for (PotionEffect effect : p.getActivePotionEffects()) {

					p.removePotionEffect(effect.getType());

				}
				p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,
						Integer.MAX_VALUE, 1));
				p.addPotionEffect(new PotionEffect(
						PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0));
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,
						Integer.MAX_VALUE, 0));
			}
			if (e.getCurrentItem().getType() == Material.BLAZE_ROD) {
				p.closeInventory();
				p.sendMessage("Vous avez choisis la classe Mage.");
				classPlayer = "mage";
				rp.saveDefaultConfig();
				rp.getConfig().set(p.getName() + ".classPlayer",
						String.valueOf(classPlayer));
				rp.getConfig().set(p.getName() + ".blazerod", "1");
				rp.saveConfig();
				classPlayer = "";
				p.setMaxHealth(16.0F);
				p.setHealth(16.0F);
				for (PotionEffect effect : p.getActivePotionEffects()) {

					p.removePotionEffect(effect.getType());

				}
				p.addPotionEffect(new PotionEffect(
						PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 0));

			}
			if (e.getCurrentItem().getType() == Material.GOLD_NUGGET) {
				p.closeInventory();
				p.sendMessage("Vous avez choisis la classe Bandit.");
				classPlayer = "bandit";
				rp.saveDefaultConfig();
				rp.getConfig().set(p.getName() + ".classPlayer", classPlayer);
				rp.saveConfig();
				rp.getConfig().set(p.getName() + ".sword", "1");
				classPlayer = "";
				p.setMaxHealth(16.0F);
				p.setHealth(16.0F);
				for (PotionEffect effect : p.getActivePotionEffects()) {

					p.removePotionEffect(effect.getType());

				}
				p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,
						Integer.MAX_VALUE, 0));
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,
						Integer.MAX_VALUE, 0));
			}
		}

		// if(e.getCurrentItem().getType() == Material.CHEST &&
		// e.getCurrentItem().getItemMeta().getDisplayName() == "Bourse"){
		// Inventory iv = rp.getServer().createInventory(p, 27,
		// "- Bourse de " + p.getName() + " -");
		// p.openInventory(iv);
		// }

	}
}
