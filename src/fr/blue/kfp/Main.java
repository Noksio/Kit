package fr.blue.kfp;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements CommandExecutor{
	
	public static Main instance;
	
	@Override
	public void onEnable() {
		instance = this;
		getCommand("nd").setExecutor(this);
		Bukkit.getPluginManager().registerEvents(new Listeners(), this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player){
			Player p = (Player) sender;
			
			if(cmd.getName().equalsIgnoreCase("nd")){
				if(args.length != 0){
					p.sendMessage("§cUtilisation: /nd");
					return false;
				}
				p.getInventory().clear();

				p.getInventory().setHelmet(null);
				p.getInventory().setChestplate(null);
				p.getInventory().setLeggings(null);
				p.getInventory().setBoots(null);
				
				for(int i = 0; i < 35; i++){
					ItemStack item = new ItemStack(Material.POTION, 1, (short) 16421);
					p.getInventory().setItem(i, item);
				}
				
				//Caque
				ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
				item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				item.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
				
				//Plastron
				ItemStack item1 = new ItemStack(Material.DIAMOND_CHESTPLATE);
				item1.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				item1.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
				
				//Pantalon
				ItemStack item2 = new ItemStack(Material.DIAMOND_LEGGINGS);
				item2.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				item2.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
				
				//Botte
				ItemStack item3 = new ItemStack(Material.DIAMOND_BOOTS);
				item3.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
				item3.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 4);
				item3.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
				
				//Épée
				ItemStack item4 = new ItemStack(Material.DIAMOND_SWORD);
				item4.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
				item4.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
				item4.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
				
				//Épée
				ItemStack item5 = new ItemStack(Material.WOOD_SWORD);
				item5.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 6);
				item5.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
				item5.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
				
				ItemStack enderpearl = new ItemStack(Material.ENDER_PEARL, 16);
				ItemStack speed = new ItemStack(Material.POTION, 1, (short) 8226);
				ItemStack fireres = new ItemStack(Material.POTION, 1, (short) 8259);
				ItemStack bouffe = new ItemStack(Material.COOKED_BEEF, 64);
				
				if(!new SimpleDateFormat("MM/dd").format(new Date()).equals("04/01")){
					p.getInventory().setItem(0, item4);
				}else{
					p.getInventory().setItem(0, item5);
				}
				p.getInventory().setItem(1, enderpearl);
				p.getInventory().setItem(8, bouffe);
				p.getInventory().setItem(3, speed);
				p.getInventory().setItem(2, fireres);
				p.getInventory().setItem(17, speed);
				p.getInventory().setItem(26, speed);
				p.getInventory().setItem(35, speed);
				
				p.getInventory().setHelmet(item);
				p.getInventory().setChestplate(item1);
				p.getInventory().setLeggings(item2);
				p.getInventory().setBoots(item3);
				
				p.updateInventory();
			}
		}
		return true;
	}
}
