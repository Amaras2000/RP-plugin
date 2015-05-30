package fr.amaras.rp.cmd;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.amaras.rp.RP;

public class ClassPlayerCmd implements CommandExecutor {

	public RP rp;

	public ClassPlayerCmd(RP rp) {
		this.rp = rp;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage("Il faut être un joueur pour faire cette commande");
			return true;
		}
		Player pl = (Player) sender;
		Inventory iv = rp.getServer().createInventory(pl, 54,
				"- selectionnez votre classe -");

		ItemStack is = new ItemStack(Material.DIAMOND_AXE);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName("Barbare");
		is.setItemMeta(im);
		iv.setItem(0, is);

		ItemStack is2 = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta im2 = is2.getItemMeta();
		im2.setDisplayName("Guerrier");
		is2.setItemMeta(im2);
		iv.setItem(1, is2);

		ItemStack is3 = new ItemStack(Material.BOW);
		ItemMeta im3 = is3.getItemMeta();
		im3.setDisplayName("Archer");
		is3.setItemMeta(im3);
		iv.setItem(2, is3);

		ItemStack is4 = new ItemStack(Material.BLAZE_ROD);
		ItemMeta im4 = is4.getItemMeta();
		im4.setDisplayName("Mage");
		is4.setItemMeta(im4);
		iv.setItem(3, is4);

		ItemStack is5 = new ItemStack(Material.GOLD_NUGGET);
		ItemMeta im5 = is5.getItemMeta();
		im5.setDisplayName("Bandit");
		is5.setItemMeta(im5);
		iv.setItem(4, is5);

		pl.openInventory(iv);
		return true;
	}

}
