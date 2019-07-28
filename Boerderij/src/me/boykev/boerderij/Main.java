package me.boykev.boerderij;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements Listener{
	
	public void onEnable() {
		PluginManager pm = Bukkit.getPluginManager();
		System.out.println(ChatColor.GREEN + "Boerderij Plugin ingeladen");
		System.out.println(ChatColor.GRAY + "by boykev");
		pm.registerEvents(this, this);
	}
	
	public void onDisable() {
		System.out.println(ChatColor.RED + "Boerderij plugin by boykev uitgeschakeld!");
	}
	
	public static String convertToInvisibleString(String s) {
        String hidden = "";
        for (char c : s.toCharArray()) hidden += ChatColor.COLOR_CHAR+""+c;
        return hidden;
    }
	
	public ItemStack makeBone(Integer count, String name) {
		ItemStack i = new ItemStack(Material.BONE, count);
		ItemMeta imeta = i.getItemMeta();
		ArrayList<String> lore = new ArrayList<String>();
		lore.add("Officieel Boeren Item!");
		imeta.setLore(lore);
		imeta.setDisplayName(name + " bot");
		i.setItemMeta(imeta);
		
		return i;
	}
	
	
	@EventHandler
	public void onMobDeath(EntityDeathEvent e) {
		
		if(e.getEntity().getKiller() instanceof Player) {
			if(e.getEntity().getType() == EntityType.PIG) {
				e.getDrops().clear();
				ItemStack i = new ItemStack(Material.PORK, 1);
				ItemMeta imeta = i.getItemMeta();
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("Officieel Boeren Voedsel! Ongezond");
				lore.add(convertToInvisibleString("vergiftigd"));
				imeta.setDisplayName("Rauw Varkens vlees");
				imeta.setLore(lore);
				i.setItemMeta(imeta);
				e.getDrops().add(i);
				e.getDrops().add(this.makeBone(2, "Varkens"));
				
			}
			if(e.getEntity().getType() == EntityType.CHICKEN) {
				e.getDrops().clear();
				ItemStack i = new ItemStack(Material.RAW_CHICKEN, 1);
				ItemMeta imeta = i.getItemMeta();
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("Officieel Boeren Voedsel! Ongezond");
				lore.add(convertToInvisibleString("vergiftigd"));
				imeta.setDisplayName("Rauw Kippen vlees");
				imeta.setLore(lore);
				i.setItemMeta(imeta);
				
				
				ItemStack i2 = new ItemStack(Material.FEATHER, 1);
				ItemMeta imeta2 = i2.getItemMeta();
				ArrayList<String> lore2 = new ArrayList<String>();
				lore2.add("Officieel Boeren Item!");
				imeta2.setLore(lore2);
				imeta2.setDisplayName("Veer");
				i2.setItemMeta(imeta2);
				
				e.getDrops().add(i);
				e.getDrops().add(i2);
				e.getDrops().add(this.makeBone(1, "Kippen"));
				
			}
			
			if(e.getEntity().getType() == EntityType.HORSE) {
				e.getDrops().clear();
				ItemStack i = new ItemStack(Material.LEATHER, 2);
				ItemMeta imeta = i.getItemMeta();
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("Officieel Boeren Item!");
				imeta.setLore(lore);
				imeta.setDisplayName("Leer");
				i.setItemMeta(imeta);
				
				e.getDrops().add(i);
				e.getDrops().add(this.makeBone(2, "Paarden"));
			}
			if(e.getEntity().getType() == EntityType.SHEEP) {
				e.getDrops().clear();
				ItemStack i = new ItemStack(Material.RABBIT, 1);
				ItemMeta imeta = i.getItemMeta();
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("Officieel Boeren Voedsel! Ongezond");
				lore.add(convertToInvisibleString("vergiftigd"));
				imeta.setDisplayName("Rauw Schapen vlees");
				imeta.setLore(lore);
				i.setItemMeta(imeta);
				
				ItemStack i2 = new ItemStack(Material.WOOL, 1);
				ItemMeta imeta2 = i2.getItemMeta();
				ArrayList<String> lore2 = new ArrayList<String>();
				lore2.add("Officieel Boeren Item!");
				imeta2.setDisplayName("Wol");
				imeta2.setLore(lore2);
				i2.setItemMeta(imeta2);
				
				
				e.getDrops().add(i);
				e.getDrops().add(i2);
				e.getDrops().add(this.makeBone(2, "Schapen"));
				
			}
			
			if(e.getEntity().getType() == EntityType.COW) {
				e.getDrops().clear();
				ItemStack i = new ItemStack(Material.PORK, 1);
				ItemMeta imeta = i.getItemMeta();
				ArrayList<String> lore = new ArrayList<String>();
				lore.add("Officieel Boeren Voedsel! Ongezond");
				lore.add(convertToInvisibleString("vergiftigd"));
				imeta.setDisplayName("Rauw Koeien vlees");
				imeta.setLore(lore);
				i.setItemMeta(imeta);
				e.getDrops().add(i);
				e.getDrops().add(this.makeBone(2, "Koeien"));
				
			}
			
		}
	}
	
}
