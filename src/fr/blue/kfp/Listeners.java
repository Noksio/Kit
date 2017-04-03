package fr.blue.kfp;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

public class Listeners implements Listener {
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e){
		final Player defender = e.getEntity();
		Player attacker = defender.getKiller();
		
		if (defender instanceof Player){
			if(attacker instanceof Player){	
				int amountv = 0;
				int amounta = 0;
				for (ItemStack is : attacker.getInventory().all(new ItemStack(Material.POTION, 1, (short) 16421)).values()) {
					amounta = amounta + is.getAmount();
				}
				for (ItemStack is : defender.getInventory().all(new ItemStack(Material.POTION, 1, (short) 16421)).values()) {
					amountv = amountv + is.getAmount();
				}
				int potted = amounta - amountv;
				e.setDeathMessage(attacker.getName()+"(§c"+amounta+" pots§f) a enculé "+defender.getName() + "(§c"+amountv+" pots§f) [§2"+ potted +" potted§f]");
			}else{
				int amountv = 0;
				for (ItemStack is : defender.getInventory().all(new ItemStack(Material.POTION, 1, (short) 16421)).values()) {
					amountv = amountv + is.getAmount();
				}
				e.setDeathMessage(defender.getName()+"(§c"+amountv+" pots§f) est mort comme une grosse merde.");
			}
		}
		
		e.setDroppedExp(0);
		e.getDrops().clear();
	}
	
	@EventHandler
	public void onCreatureSpawn(CreatureSpawnEvent e){
		e.setCancelled(true);
	}
}
