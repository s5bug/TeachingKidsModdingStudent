package org.jointheleague.mod;

import org.jointheleague.mod.block.FunBlock;
import org.jointheleague.mod.funItem.FunItem;

import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = LeagueMod.MODID, name = "TheLeagueMod", version = "1.0")
public class LeagueMod {
	
	public static final String MODID = "LeagueMod";
	public static FunBlock funBlock;
	public static FunItem funItem;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		funBlock = new FunBlock();
		funItem = new FunItem();
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
		GameRegistry.registerBlock(funBlock, "funBlock");
		GameRegistry.registerItem(funItem, "funItem");
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		GameRegistry.addShapedRecipe(new ItemStack(funBlock), new Object[]{
			/*
			 * This is the 3x3 crafting grid.
			 * You can shorten it by removing one of the rows or
			 * decreasing the amount of letters in each row.
			 */
			"   ",
			"   ",
			"   ",
			'X', Blocks.dirt // Dirt is the item you need to put in everywhere there
							 // is an X in the grid.
		});
		// The first is the input (top) next the output (right) then the xp.
		GameRegistry.addSmelting(Blocks.dirt, new ItemStack(funItem), 0.0F);
		// Currently you are smelting dirt to get FunItem and 0 xp points.
	}

}