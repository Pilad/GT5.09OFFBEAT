package gregtech.loaders.postload;

import cpw.mods.fml.common.Loader;
import gregtech.GT_Mod;
import gregtech.api.GregTech_API;
import gregtech.api.enums.*;
import gregtech.api.util.GT_Log;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import ic2.core.Ic2Items;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class GT_CraftingRecipeLoader implements Runnable {
    private final static String aTextIron1 = "X X";
    private final static String aTextIron2 = "XXX";
    private final static String aTextMachineBeta = "machine.beta";
    private final static String aTextMachineAlpha = "machine.alpha";

    public void run() {
        GT_Log.out.println("GT_Mod: Adding nerfed Vanilla Recipes.");
        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.bucket, 1), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_SHAPED_RECIPES, new Object[]{"XhX", " X ", 'X', OrePrefixes.plate.get(Materials.Iron)});
        if (!GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.recipereplacements, "Iron.Bucket", true)) {
            GT_ModHandler.addCraftingRecipe(new ItemStack(Items.bucket, 1), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{aTextIron1, " X ", 'X', OrePrefixes.ingot.get(Materials.Iron)});
        }
        ItemStack tMat = new ItemStack(Items.iron_ingot);
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.recipereplacements, "Iron.PressurePlate", true)) {
            ItemStack tStack;
            if (null != (tStack = GT_ModHandler.removeRecipe(tMat, tMat, null, null, null, null, null, null, null))) {
            	GT_ModHandler.addCraftingRecipe(tStack, GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_RECIPES, new Object[]{"ShS", "XZX","SdS", 'X', OrePrefixes.plate.get(Materials.Iron), 'S', OrePrefixes.screw.get(Materials.Steel), 'Z', OrePrefixes.spring.get(Materials.Steel)});
            }
        }
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.recipereplacements, "Iron.Cauldron", true)) {
            ItemStack tStack;
            if (null != (tStack = GT_ModHandler.removeRecipe(tMat, null, tMat, tMat, null, tMat, tMat, tMat, tMat))) {
                GT_ModHandler.addCraftingRecipe(tStack, GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_RECIPES, new Object[]{aTextIron1, "XhX", aTextIron2, 'X', OrePrefixes.plate.get(Materials.Iron), 'S', OrePrefixes.stick.get(Materials.Wood), 'I', OrePrefixes.ingot.get(Materials.Iron)});
            }
        }
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.recipereplacements, "Iron.Hopper", true)) {
            ItemStack tStack;
            if (null != (tStack = GT_ModHandler.removeRecipe(tMat, null, tMat, tMat, new ItemStack(Blocks.chest, 1, 0), tMat, null, tMat, null))) {
                GT_ModHandler.addCraftingRecipe(tStack, GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_RECIPES, new Object[]{"XCX", "XGX", "wXh", 'X', OrePrefixes.plate.get(Materials.Iron), 'S', OrePrefixes.stick.get(Materials.Wood), 'I', OrePrefixes.ingot.get(Materials.Iron), 'G', OrePrefixes.gearGt.get(Materials.Iron), 'C', "craftingChest"});
            }
        }
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.recipereplacements, "Iron.Bars", true)) {
            ItemStack tStack;
            if (null != (tStack = GT_ModHandler.removeRecipe(tMat, tMat, tMat, tMat, tMat, tMat, null, null, null))) {
                tStack.stackSize /= 2;
                GT_ModHandler.addCraftingRecipe(tStack, GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_RECIPES, new Object[]{" w ", aTextIron2, aTextIron2, 'X', OrePrefixes.stick.get(Materials.Iron), 'S', OrePrefixes.stick.get(Materials.Wood), 'I', OrePrefixes.ingot.get(Materials.Iron)});
            }
        }
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("ironFence", 6L), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.REVERSIBLE, new Object[]{aTextIron2, aTextIron2, " w ", 'X', OrePrefixes.stick.get(Materials.Iron), 'S', OrePrefixes.stick.get(Materials.Wood), 'I', OrePrefixes.ingot.get(Materials.Iron)});

        tMat = new ItemStack(Items.gold_ingot);
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.recipereplacements, "Gold.PressurePlate", true)) {
            ItemStack tStack;
            if (null != (tStack = GT_ModHandler.removeRecipe(tMat, tMat, null, null, null, null, null, null, null))) {
            	GT_ModHandler.addCraftingRecipe(tStack, GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_RECIPES, new Object[]{"ShS", "XZX","SdS", 'X', OrePrefixes.plate.get(Materials.Gold), 'S', OrePrefixes.screw.get(Materials.Steel), 'Z', OrePrefixes.spring.get(Materials.Steel)});
            }
        }
        tMat = GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Rubber, 1L);
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.recipereplacements, "Rubber.Sheet", true)) {
            ItemStack tStack;
            if (null != (tStack = GT_ModHandler.removeRecipe(tMat, tMat, tMat, tMat, tMat, tMat, null, null, null))) {
                GT_ModHandler.addCraftingRecipe(tStack, GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_RECIPES, new Object[]{aTextIron2, aTextIron2, 'X', OrePrefixes.plate.get(Materials.Rubber)});
            }
        }
        GT_ModHandler.removeRecipeByOutput(ItemList.Bottle_Empty.get(1L));
        GT_ModHandler.removeRecipeByOutput(ItemList.IC2_Spray_WeedEx.get(1L));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("reBattery", 1L));
        GT_ModHandler.removeRecipeByOutput(new ItemStack(Blocks.tnt));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("dynamite", 1L));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("industrialTnt", 1L));

        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "stamps", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "stamps", 1L, 1), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "stamps", 1L, 2), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "stamps", 1L, 3), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "stamps", 1L, 4), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "stamps", 1L, 5), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "stamps", 1L, 6), true, false, true);

        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "engine", 1L, 0), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "engine", 1L, 1), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "engine", 1L, 2), true, false, true);
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "engine", 1L, 4), true, false, true);
        for (int i = 0; i < 29; i++) {
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "fences", 1L, i), true, false, true);
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "fencesFireproof", 1L, i), true, false, true);
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "stairs", 1L, i), true, false, true);
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "stairsFireproof", 1L, i), true, false, true);
        }
		GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "naturalistHelmet", 1L), true, false, true);
		GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "bronzePickaxe", 1L), true, false, true);
		GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "bronzeShovel", 1L), true, false, true);
		GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "wrench", 1L), true, false, true);
		GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("Forestry", "waxCast", 1L), true, false, true);


        GT_ModHandler.addCraftingRecipe(ItemList.FluidRegulator_LV.get(1L), new Object[]{"P", 'P', ItemList.Steam_Valve_LV.get(1L)});
        GT_ModHandler.addCraftingRecipe(ItemList.FluidRegulator_MV.get(1L), new Object[]{"P", 'P', ItemList.Steam_Valve_MV.get(1L)});
        GT_ModHandler.addCraftingRecipe(ItemList.FluidRegulator_HV.get(1L), new Object[]{"P", 'P', ItemList.Steam_Valve_HV.get(1L)});
        GT_ModHandler.addCraftingRecipe(ItemList.FluidRegulator_EV.get(1L), new Object[]{"P", 'P', ItemList.Steam_Valve_EV.get(1L)});
        GT_ModHandler.addCraftingRecipe(ItemList.FluidRegulator_IV.get(1L), new Object[]{"P", 'P', ItemList.Steam_Valve_IV.get(1L)});
        GT_ModHandler.addCraftingRecipe(ItemList.Steam_Valve_LV.get(1L), new Object[]{"P", 'P', ItemList.FluidRegulator_LV.get(1L)});
        GT_ModHandler.addCraftingRecipe(ItemList.Steam_Valve_MV.get(1L), new Object[]{"P", 'P', ItemList.FluidRegulator_MV.get(1L)});
        GT_ModHandler.addCraftingRecipe(ItemList.Steam_Valve_HV.get(1L), new Object[]{"P", 'P', ItemList.FluidRegulator_HV.get(1L)});
        GT_ModHandler.addCraftingRecipe(ItemList.Steam_Valve_EV.get(1L), new Object[]{"P", 'P', ItemList.FluidRegulator_EV.get(1L)});
        GT_ModHandler.addCraftingRecipe(ItemList.Steam_Valve_IV.get(1L), new Object[]{"P", 'P', ItemList.FluidRegulator_IV.get(1L)});


        ItemStack tStack = GT_ModHandler.removeRecipe(new ItemStack(Blocks.planks, 1, 0), null, null, new ItemStack(Blocks.planks, 1, 0));
        if (tStack != null) {
            GT_ModHandler.addCraftingRecipe(GT_Utility.copyAmount(GT_Mod.gregtechproxy.mNerfedWoodPlank ? tStack.stackSize : tStack.stackSize * 5 / 4, tStack), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"s", "P", "P", 'P', OrePrefixes.plank.get(Materials.Wood)});
            GT_ModHandler.addCraftingRecipe(GT_Utility.copyAmount(GT_Mod.gregtechproxy.mNerfedWoodPlank ? tStack.stackSize / 2 : tStack.stackSize, tStack), GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.BUFFERED, new Object[]{"P", "P", 'P', OrePrefixes.plank.get(Materials.Wood)});
        }
        //GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(Blocks.stone_button, 16, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.stone});

        GT_Log.out.println("GT_Mod: Adding Vanilla Convenience Recipes.");

        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.stonebrick, 1, 3), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"f", "X", 'X', new ItemStack(Blocks.double_stone_slab, 1, 8)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.gravel, 1, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"h", "X", 'X', new ItemStack(Blocks.cobblestone, 1, 0)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.sand, 1, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"h", "X", 'X', new ItemStack(Blocks.gravel, 1, 0)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.cobblestone, 1, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"h", "X", 'X', new ItemStack(Blocks.stone, 1, 0)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.stonebrick, 1, 2), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"h", "X", 'X', new ItemStack(Blocks.stonebrick, 1, 0)});

        GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(Blocks.double_stone_slab, 1, 8), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{new ItemStack(Blocks.double_stone_slab, 1, 0)});
        GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(Blocks.double_stone_slab, 1, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{new ItemStack(Blocks.double_stone_slab, 1, 8)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.double_stone_slab, 1, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"B", "B", 'B', new ItemStack(Blocks.stone_slab, 1, 0)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.cobblestone, 1, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"B", "B", 'B', new ItemStack(Blocks.stone_slab, 1, 3)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.brick_block, 1, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"B", "B", 'B', new ItemStack(Blocks.stone_slab, 1, 4)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.stonebrick, 1, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"B", "B", 'B', new ItemStack(Blocks.stone_slab, 1, 5)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.nether_brick, 1, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"B", "B", 'B', new ItemStack(Blocks.stone_slab, 1, 6)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.quartz_block, 1, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"B", "B", 'B', new ItemStack(Blocks.stone_slab, 1, 7)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.double_stone_slab, 1, 8), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"B", "B", 'B', new ItemStack(Blocks.stone_slab, 1, 8)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.planks, 1, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"B", "B", 'B', new ItemStack(Blocks.wooden_slab, 1, 0)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.planks, 1, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"B", "B", 'B', new ItemStack(Blocks.wooden_slab, 1, 1)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.planks, 1, 2), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"B", "B", 'B', new ItemStack(Blocks.wooden_slab, 1, 2)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.planks, 1, 3), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"B", "B", 'B', new ItemStack(Blocks.wooden_slab, 1, 3)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.planks, 1, 4), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"B", "B", 'B', new ItemStack(Blocks.wooden_slab, 1, 4)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.planks, 1, 5), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"B", "B", 'B', new ItemStack(Blocks.wooden_slab, 1, 5)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.planks, 1, 6), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"B", "B", 'B', new ItemStack(Blocks.wooden_slab, 1, 6)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.planks, 1, 7), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"B", "B", 'B', new ItemStack(Blocks.wooden_slab, 1, 7)});

        GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(Items.stick, 2, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{new ItemStack(Blocks.deadbush, 1, 32767)});
        GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(Items.stick, 2, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{new ItemStack(Blocks.tallgrass, 1, 0)});
        GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(Items.stick, 1, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.treeSapling});

        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.comparator, 1, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{" T ", "TQT", "SSS", 'Q', OreDictNames.craftingQuartz, 'S', OrePrefixes.stoneSmooth, 'T', OreDictNames.craftingRedstoneTorch});

		GT_ModHandler.removeRecipeByOutput(new ItemStack(Items.compass, 1, 0));
		GT_ModHandler.addCraftingRecipe(new ItemStack(Items.compass, 1, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"SGI", "RPR", "AsS", 'G', new ItemStack(Blocks.glass_pane, 1, 32767), 'S', OrePrefixes.screw.get(Materials.Iron), 'A', OrePrefixes.bolt.get(Materials.RedAlloy), 'I', OrePrefixes.bolt.get(Materials.Iron), 'R', OrePrefixes.ring.get(Materials.Iron), 'P', OrePrefixes.plate.get(Materials.Iron)});
		
		GT_ModHandler.removeRecipeByOutput(new ItemStack(Items.clock, 1, 0));
		GT_ModHandler.addCraftingRecipe(new ItemStack(Items.clock, 1, 0), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"SGI", "RPR", "AsS", 'G', new ItemStack(Blocks.glass_pane, 1, 32767), 'S', OrePrefixes.screw.get(Materials.Gold), 'A', OrePrefixes.bolt.get(Materials.RedAlloy), 'I', OrePrefixes.bolt.get(Materials.Gold), 'R', OrePrefixes.ring.get(Materials.Gold), 'P', OrePrefixes.plate.get(Materials.Gold)});

        GT_Log.out.println("GT_Mod: Adding Tool Recipes.");
        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.minecart, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_SHAPED_RECIPES, new Object[]{" h ", "PwP", "WPW", 'P', OrePrefixes.plate.get(Materials.Iron), 'W', ItemList.Component_Minecart_Wheels_Iron});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.minecart, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{" h ", "PwP", "WPW", 'P', OrePrefixes.plate.get(Materials.Steel), 'W', ItemList.Component_Minecart_Wheels_Steel});

        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.chest_minecart, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_SHAPED_RECIPES, new Object[]{"X", "C", 'C', new ItemStack(Items.minecart, 1), 'X', OreDictNames.craftingChest});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.furnace_minecart, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_SHAPED_RECIPES, new Object[]{"X", "C", 'C', new ItemStack(Items.minecart, 1), 'X', OreDictNames.craftingFurnace});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.hopper_minecart, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_SHAPED_RECIPES, new Object[]{"X", "C", 'C', new ItemStack(Items.minecart, 1), 'X', new ItemStack(Blocks.hopper, 1, 32767)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.tnt_minecart, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_SHAPED_RECIPES, new Object[]{"X", "C", 'C', new ItemStack(Items.minecart, 1), 'X', new ItemStack(Blocks.tnt, 1, 32767)});

        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.chainmail_helmet, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_SHAPED_RECIPES, new Object[]{"RRR", "RhR", 'R', OrePrefixes.ring.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.chainmail_chestplate, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_SHAPED_RECIPES, new Object[]{"RhR", "RRR", "RRR", 'R', OrePrefixes.ring.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.chainmail_leggings, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_SHAPED_RECIPES, new Object[]{"RRR", "RhR", "R R", 'R', OrePrefixes.ring.get(Materials.Steel)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.chainmail_boots, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE | GT_ModHandler.RecipeBits.REVERSIBLE | GT_ModHandler.RecipeBits.DELETE_ALL_OTHER_SHAPED_RECIPES, new Object[]{"R R", "RhR", 'R', OrePrefixes.ring.get(Materials.Steel)});

        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.stained_glass, 8, 0), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"GGG", "GDG", "GGG", 'G', new ItemStack(Blocks.glass, 1), 'D', Dyes.dyeWhite});

        GT_Log.out.println("GT_Mod: Putting a Potato on a Stick.");
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Packaged_PotatoChips.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.foil.get(Materials.Aluminium), ItemList.Food_PotatoChips});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Packaged_ChiliChips.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.foil.get(Materials.Aluminium), ItemList.Food_ChiliChips});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Packaged_Fries.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.plateDouble.get(Materials.Paper), ItemList.Food_Fries});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Chum_On_Stick.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.stick.get(Materials.Wood), ItemList.Food_Chum});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Potato_On_Stick.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.stick.get(Materials.Wood), ItemList.Food_Raw_Potato});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Potato_On_Stick_Roasted.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.stick.get(Materials.Wood), ItemList.Food_Baked_Potato});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Dough.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.bucket.get(Materials.Water), OrePrefixes.dust.get(Materials.Wheat)});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Dough_Sugar.get(2L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"foodDough", OrePrefixes.dust.get(Materials.Sugar)});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Dough_Chocolate.get(2L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"foodDough", OrePrefixes.dust.get(Materials.Cocoa)});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Dough_Chocolate.get(2L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"foodDough", OrePrefixes.dust.get(Materials.Chocolate)});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Flat_Dough.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"foodDough", ToolDictNames.craftingToolRollingPin});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Raw_Bun.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"foodDough"});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Raw_Bread.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"foodDough", "foodDough"});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Raw_Baguette.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"foodDough", "foodDough", "foodDough"});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Raw_Cake.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Dough_Sugar, ItemList.Food_Dough_Sugar, ItemList.Food_Dough_Sugar, ItemList.Food_Dough_Sugar});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_ChiliChips.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_PotatoChips, OrePrefixes.dust.get(Materials.Chili)});

        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Sliced_Buns.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Bun, ItemList.Food_Sliced_Bun});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Sliced_Breads.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Bread, ItemList.Food_Sliced_Bread});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Sliced_Baguettes.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Baguette, ItemList.Food_Sliced_Baguette});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Sliced_Bun.get(2L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Buns});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Sliced_Bread.get(2L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Breads});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Sliced_Baguette.get(2L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Baguettes});

        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Burger_Veggie.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Buns, ItemList.Food_Sliced_Cucumber, ItemList.Food_Sliced_Tomato, ItemList.Food_Sliced_Onion});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Burger_Cheese.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Buns, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Burger_Meat.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Buns, OrePrefixes.dust.get(Materials.MeatCooked)});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Burger_Chum.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Buns, ItemList.Food_Chum});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Burger_Veggie.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Bun, ItemList.Food_Sliced_Bun, ItemList.Food_Sliced_Cucumber, ItemList.Food_Sliced_Tomato, ItemList.Food_Sliced_Onion});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Burger_Cheese.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Bun, ItemList.Food_Sliced_Bun, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Burger_Meat.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Bun, ItemList.Food_Sliced_Bun, OrePrefixes.dust.get(Materials.MeatCooked)});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Burger_Chum.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Bun, ItemList.Food_Sliced_Bun, ItemList.Food_Chum});

        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Sandwich_Veggie.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Breads, ItemList.Food_Sliced_Cucumber, ItemList.Food_Sliced_Cucumber, ItemList.Food_Sliced_Tomato, ItemList.Food_Sliced_Tomato, ItemList.Food_Sliced_Onion});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Sandwich_Cheese.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Breads, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Sandwich_Bacon.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Breads, new ItemStack(Items.cooked_porkchop, 1)});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Sandwich_Steak.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Breads, new ItemStack(Items.cooked_beef, 1)});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Sandwich_Veggie.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Bread, ItemList.Food_Sliced_Bread, ItemList.Food_Sliced_Cucumber, ItemList.Food_Sliced_Cucumber, ItemList.Food_Sliced_Tomato, ItemList.Food_Sliced_Tomato, ItemList.Food_Sliced_Onion});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Sandwich_Cheese.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Bread, ItemList.Food_Sliced_Bread, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Sandwich_Bacon.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Bread, ItemList.Food_Sliced_Bread, new ItemStack(Items.cooked_porkchop, 1)});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Sandwich_Steak.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Bread, ItemList.Food_Sliced_Bread, new ItemStack(Items.cooked_beef, 1)});

        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Large_Sandwich_Veggie.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Baguettes, ItemList.Food_Sliced_Cucumber, ItemList.Food_Sliced_Cucumber, ItemList.Food_Sliced_Cucumber, ItemList.Food_Sliced_Tomato, ItemList.Food_Sliced_Tomato, ItemList.Food_Sliced_Tomato, ItemList.Food_Sliced_Onion});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Large_Sandwich_Cheese.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Baguettes, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Large_Sandwich_Bacon.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Baguettes, new ItemStack(Items.cooked_porkchop, 1), new ItemStack(Items.cooked_porkchop, 1)});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Large_Sandwich_Steak.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Baguettes, new ItemStack(Items.cooked_beef, 1), new ItemStack(Items.cooked_beef, 1)});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Large_Sandwich_Veggie.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Baguette, ItemList.Food_Sliced_Baguette, ItemList.Food_Sliced_Cucumber, ItemList.Food_Sliced_Cucumber, ItemList.Food_Sliced_Cucumber, ItemList.Food_Sliced_Tomato, ItemList.Food_Sliced_Tomato, ItemList.Food_Sliced_Tomato, ItemList.Food_Sliced_Onion});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Large_Sandwich_Cheese.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Baguette, ItemList.Food_Sliced_Baguette, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Large_Sandwich_Bacon.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Baguette, ItemList.Food_Sliced_Baguette, new ItemStack(Items.cooked_porkchop, 1), new ItemStack(Items.cooked_porkchop, 1)});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Large_Sandwich_Steak.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Sliced_Baguette, ItemList.Food_Sliced_Baguette, new ItemStack(Items.cooked_beef, 1), new ItemStack(Items.cooked_beef, 1)});

        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Raw_Pizza_Veggie.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Flat_Dough, ItemList.Food_Sliced_Cucumber, ItemList.Food_Sliced_Tomato, ItemList.Food_Sliced_Onion});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Raw_Pizza_Cheese.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Flat_Dough, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese, ItemList.Food_Sliced_Cheese});
        GT_ModHandler.addShapelessCraftingRecipe(ItemList.Food_Raw_Pizza_Meat.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{ItemList.Food_Flat_Dough, OrePrefixes.dust.get(Materials.MeatCooked)});

        GT_ModHandler.addCraftingRecipe(ItemList.Food_Sliced_Cheese.get(4L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"kX", 'X', "foodCheese"});
        GT_ModHandler.addCraftingRecipe(ItemList.Food_Sliced_Lemon.get(4L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"kX", 'X', "cropLemon"});
        GT_ModHandler.addCraftingRecipe(ItemList.Food_Sliced_Tomato.get(4L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"kX", 'X', "cropTomato"});
        GT_ModHandler.addCraftingRecipe(ItemList.Food_Sliced_Onion.get(4L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"kX", 'X', "cropOnion"});
        GT_ModHandler.addCraftingRecipe(ItemList.Food_Sliced_Cucumber.get(4L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"kX", 'X', "cropCucumber"});
        GT_ModHandler.addCraftingRecipe(ItemList.Food_Sliced_Bun.get(2L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"kX", 'X', ItemList.Food_Baked_Bun});
        GT_ModHandler.addCraftingRecipe(ItemList.Food_Sliced_Bread.get(2L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"kX", 'X', ItemList.Food_Baked_Bread});
        GT_ModHandler.addCraftingRecipe(ItemList.Food_Sliced_Baguette.get(2L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"kX", 'X', ItemList.Food_Baked_Baguette});
        GT_ModHandler.addCraftingRecipe(ItemList.Food_Raw_PotatoChips.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"kX", 'X', "cropPotato"});
        GT_ModHandler.addCraftingRecipe(ItemList.Food_Raw_Cookie.get(4L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"kX", 'X', ItemList.Food_Dough_Chocolate});

        GT_ModHandler.addCraftingRecipe(ItemList.Food_Raw_Fries.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"k", "X", 'X', "cropPotato"});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Items.bowl, 1), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"k", "X", 'X', OrePrefixes.plank.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Rubber, 1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"k", "X", 'X', OrePrefixes.plate.get(Materials.Rubber)});


        GT_ModHandler.removeRecipe(new ItemStack(Blocks.planks), null, new ItemStack(Blocks.planks), null, new ItemStack(Blocks.planks));
        GT_ModHandler.removeRecipeByOutput(ItemList.Food_Baked_Bread.get(1L));
        GT_ModHandler.removeRecipeByOutput(new ItemStack(Items.cookie, 1));
        GT_ModHandler.removeRecipe(GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Copper, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tin, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Copper, 1L));
        if (null != GT_Utility.setStack(GT_ModHandler.getRecipeOutput(true, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Copper, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Copper, 1L), null, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Copper, 1L), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Tin, 1L)), GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Bronze, GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "bronzeingotcrafting", true) ? 1L : 2L))) {
            GT_Log.out.println("GT_Mod: Changed Forestrys Bronze Recipe");
        }
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "enchantmenttable", false)) {
            GT_Log.out.println("GT_Mod: Removing the Recipe of the Enchantment Table, to have more Fun at enchanting with the Anvil and Books from Dungeons.");
            GT_ModHandler.removeRecipeByOutput(new ItemStack(Blocks.enchanting_table, 1));
        }
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "enderchest", false)) {
            GT_ModHandler.removeRecipeByOutput(new ItemStack(Blocks.ender_chest, 1));
        }
        tStack = GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Ash, 1L);
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getRecipeOutput(null, new ItemStack(Blocks.sand, 1, 0), null, null, GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Apatite, 1L), null, null, new ItemStack(Blocks.sand, 1, 0), null), new Object[]{"S", "A", "S", 'A', OrePrefixes.dust.get(Materials.Apatite), 'S', new ItemStack(Blocks.sand, 1, 32767)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getRecipeOutput(tStack, tStack, tStack, tStack, GT_OreDictUnificator.get(OrePrefixes.gem, Materials.Apatite, 1L), tStack, tStack, tStack, tStack), new Object[]{"SSS", "SAS", "SSS", 'A', OrePrefixes.dust.get(Materials.Apatite), 'S', OrePrefixes.dust.get(Materials.Ash)});

        GT_Log.out.println("GT_Mod: Adding Mixed Metal Ingot Recipes.");
        GT_ModHandler.removeRecipeByOutput(ItemList.IC2_Mixed_Metal_Ingot.get(1L));

        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Iron), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Iron), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Iron), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Aluminium)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Iron), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Iron), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Iron), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Aluminium)});

        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Nickel), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Nickel), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Nickel), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Aluminium)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Nickel), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Nickel), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Nickel), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Aluminium)});

        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(2L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Invar), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(2L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Invar), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Invar), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Aluminium)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(2L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Invar), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(2L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Invar), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Invar), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Aluminium)});

        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(2L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Steel), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(2L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Steel), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Steel), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Aluminium)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(2L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Steel), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(2L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Steel), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Steel), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Aluminium)});

        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.StainlessSteel), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.StainlessSteel), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(4L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.StainlessSteel), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Aluminium)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.StainlessSteel), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.StainlessSteel), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(4L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.StainlessSteel), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Aluminium)});

        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Titanium), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Titanium), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(4L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Titanium), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Aluminium)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Titanium), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Titanium), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(4L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Titanium), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Aluminium)});

        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Tungsten), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Tungsten), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(4L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Tungsten), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Aluminium)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Tungsten), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Tungsten), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(4L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.Tungsten), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Aluminium)});

        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(5L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.TungstenSteel), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(5L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.TungstenSteel), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(6L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.TungstenSteel), 'Y', OrePrefixes.plate.get(Materials.Bronze), 'Z', OrePrefixes.plate.get(Materials.Aluminium)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(5L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.TungstenSteel), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(5L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.TungstenSteel), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Zinc)});
        GT_ModHandler.addCraftingRecipe(ItemList.IC2_Mixed_Metal_Ingot.get(6L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"X", "Y", "Z", 'X', OrePrefixes.plate.get(Materials.TungstenSteel), 'Y', OrePrefixes.plate.get(Materials.Brass), 'Z', OrePrefixes.plate.get(Materials.Aluminium)});

        GT_Log.out.println("GT_Mod: Beginning to add regular Crafting Recipes.");
        //GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Superconductor, 3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"NPT", "CCC", "HPT", 'H', OrePrefixes.cell.get(Materials.Helium), 'N', OrePrefixes.cell.get(Materials.Nitrogen), 'T', OrePrefixes.pipeTiny.get(Materials.TungstenSteel), 'P', ItemList.Electric_Pump_LV, 'C', OrePrefixes.wireGt01.get(Materials.NiobiumTitanium)});
        //GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Superconductor, 3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"NPT", "CCC", "HPT", 'H', OrePrefixes.cell.get(Materials.Helium), 'N', OrePrefixes.cell.get(Materials.Nitrogen), 'T', OrePrefixes.pipeTiny.get(Materials.TungstenSteel), 'P', ItemList.Electric_Pump_LV, 'C', OrePrefixes.wireGt01.get(Materials.VanadiumGallium)});
        //GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Superconductor, 3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"NPT", "CCC", "NPT", 'N', OrePrefixes.cell.get(Materials.Nitrogen), 'T', OrePrefixes.pipeTiny.get(Materials.TungstenSteel), 'P', ItemList.Electric_Pump_LV, 'C', OrePrefixes.wireGt01.get(Materials.YttriumBariumCuprate)});
        //GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.wireGt01, Materials.Superconductor, 3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"NPT", "CCC", "NPT", 'N', OrePrefixes.cell.get(Materials.Nitrogen), 'T', OrePrefixes.pipeTiny.get(Materials.TungstenSteel), 'P', ItemList.Electric_Pump_LV, 'C', OrePrefixes.wireGt01.get(Materials.Naquadah)});

        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.IronMagnetic, 1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.stick.get(Materials.Iron), OrePrefixes.dust.get(Materials.Redstone), OrePrefixes.dust.get(Materials.Redstone), OrePrefixes.dust.get(Materials.Redstone), OrePrefixes.dust.get(Materials.Redstone)});
        GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.ring, Materials.Paper, 1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"PPk", 'P', OrePrefixes.plate.get(Materials.Paper)});

		GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.torch, 2), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"C", "S", 'C', OrePrefixes.dust.get(Materials.Sulfur), 'S', OrePrefixes.stick.get(Materials.Wood)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.torch, 6), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"C", "S", 'C', OrePrefixes.dust.get(Materials.Phosphorus), 'S', OrePrefixes.stick.get(Materials.Wood)});

        GT_ModHandler.removeRecipeByOutput(new ItemStack(Blocks.piston, 1));
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.piston, 1), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"WWW", "GBG", "CRC", 'W', OrePrefixes.plank.get(Materials.Wood), 'C', OrePrefixes.stoneCobble, 'R', OrePrefixes.plate.get(Materials.RedAlloy), 'G', OrePrefixes.gearGtSmall.get(Materials.Iron), 'B', new ItemStack(Blocks.fence, 1, 32767)});
        GT_ModHandler.addCraftingRecipe(new ItemStack(Blocks.piston, 1), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"WWW", "GBG", "CRC", 'W', OrePrefixes.plank.get(Materials.Wood), 'C', OrePrefixes.stoneCobble, 'R', OrePrefixes.plate.get(Materials.RedAlloy), 'G', OrePrefixes.gearGtSmall.get(Materials.Bronze), 'B', new ItemStack(Blocks.fence, 1, 32767)});
        
        if (!Materials.Steel.mBlastFurnaceRequired) {
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Steel, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Iron), OrePrefixes.dust.get(Materials.Coal), OrePrefixes.dust.get(Materials.Coal)});
        }
        if (GT_Mod.gregtechproxy.mNerfDustCrafting) {
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Electrum, 6L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Silver), OrePrefixes.dust.get(Materials.Gold)});
            GT_ModHandler.removeRecipeByOutput(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Brass, 1L));
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Brass, 3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Copper), OrePrefixes.dust.get(Materials.Copper), OrePrefixes.dust.get(Materials.Copper), OrePrefixes.dust.get(Materials.Zinc)});
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Brass, 9L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Tetrahedrite), OrePrefixes.dust.get(Materials.Tetrahedrite), OrePrefixes.dust.get(Materials.Tetrahedrite), OrePrefixes.dust.get(Materials.Zinc)});
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bronze, 3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Copper), OrePrefixes.dust.get(Materials.Copper), OrePrefixes.dust.get(Materials.Copper), OrePrefixes.dust.get(Materials.Tin)});
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Bronze, 9L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Tetrahedrite), OrePrefixes.dust.get(Materials.Tetrahedrite), OrePrefixes.dust.get(Materials.Tetrahedrite), OrePrefixes.dust.get(Materials.Tin)});
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dustSmall, Materials.Invar, 9L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Iron), OrePrefixes.dust.get(Materials.Iron), OrePrefixes.dust.get(Materials.Nickel)});
            
        } else {
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Electrum, 2L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Silver), OrePrefixes.dust.get(Materials.Gold)});
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Brass, 4L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Copper), OrePrefixes.dust.get(Materials.Copper), OrePrefixes.dust.get(Materials.Copper), OrePrefixes.dust.get(Materials.Zinc)});
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Brass, 3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Tetrahedrite), OrePrefixes.dust.get(Materials.Tetrahedrite), OrePrefixes.dust.get(Materials.Tetrahedrite), OrePrefixes.dust.get(Materials.Zinc)});
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bronze, 4L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Copper), OrePrefixes.dust.get(Materials.Copper), OrePrefixes.dust.get(Materials.Copper), OrePrefixes.dust.get(Materials.Tin)});
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Bronze, 3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Tetrahedrite), OrePrefixes.dust.get(Materials.Tetrahedrite), OrePrefixes.dust.get(Materials.Tetrahedrite), OrePrefixes.dust.get(Materials.Tin)});
            GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Invar, 3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Iron), OrePrefixes.dust.get(Materials.Iron), OrePrefixes.dust.get(Materials.Nickel)});
            
        }
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CobaltBrass, 9L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Brass), OrePrefixes.dust.get(Materials.Brass), OrePrefixes.dust.get(Materials.Brass), OrePrefixes.dust.get(Materials.Brass), OrePrefixes.dust.get(Materials.Brass), OrePrefixes.dust.get(Materials.Brass), OrePrefixes.dust.get(Materials.Brass), OrePrefixes.dust.get(Materials.Aluminium), OrePrefixes.dust.get(Materials.Cobalt)});
        //GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.FerriteMixture, 6L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Nickel), OrePrefixes.dust.get(Materials.Zinc), OrePrefixes.dust.get(Materials.Iron), OrePrefixes.dust.get(Materials.Iron), OrePrefixes.dust.get(Materials.Iron), OrePrefixes.dust.get(Materials.Iron)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.BorosilicateGlass, 8L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Boron), OrePrefixes.dust.get(Materials.Glass), OrePrefixes.dust.get(Materials.Glass), OrePrefixes.dust.get(Materials.Glass), OrePrefixes.dust.get(Materials.Glass), OrePrefixes.dust.get(Materials.Glass), OrePrefixes.dust.get(Materials.Glass), OrePrefixes.dust.get(Materials.Glass)});
        //GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EpoxidFiberReinforced, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Epoxid), ItemList.Circuit_Parts_GlassFiber.get(1, new Object[0])});
        //GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.EpoxidFiberReinforced, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Epoxid), GT_ModHandler.getIC2Item("carbonFiber", 1)});

        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.CobaltBrass, 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dustTiny.get(Materials.Brass), OrePrefixes.dustTiny.get(Materials.Brass), OrePrefixes.dustTiny.get(Materials.Brass), OrePrefixes.dustTiny.get(Materials.Brass), OrePrefixes.dustTiny.get(Materials.Brass), OrePrefixes.dustTiny.get(Materials.Brass), OrePrefixes.dustTiny.get(Materials.Brass), OrePrefixes.dustTiny.get(Materials.Aluminium), OrePrefixes.dustTiny.get(Materials.Cobalt)});
        

        GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(Items.gunpowder, 6), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Coal), 		OrePrefixes.dust.get(Materials.Coal), 		OrePrefixes.dust.get(Materials.Coal), 		OrePrefixes.dust.get(Materials.Sulfur), OrePrefixes.dust.get(Materials.Saltpeter), OrePrefixes.dust.get(Materials.Saltpeter)});
        GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(Items.gunpowder, 6), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Charcoal), 	OrePrefixes.dust.get(Materials.Charcoal), 	OrePrefixes.dust.get(Materials.Charcoal), 	OrePrefixes.dust.get(Materials.Sulfur), OrePrefixes.dust.get(Materials.Saltpeter), OrePrefixes.dust.get(Materials.Saltpeter)});
        GT_ModHandler.addShapelessCraftingRecipe(new ItemStack(Items.gunpowder, 6), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Carbon), 	OrePrefixes.dust.get(Materials.Carbon), 	OrePrefixes.dust.get(Materials.Carbon), 	OrePrefixes.dust.get(Materials.Sulfur), OrePrefixes.dust.get(Materials.Saltpeter), OrePrefixes.dust.get(Materials.Saltpeter)});

        GT_ModHandler.addShapelessCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.IndiumGalliumPhosphide, 3L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{OrePrefixes.dust.get(Materials.Indium), OrePrefixes.dust.get(Materials.Gallium), OrePrefixes.dust.get(Materials.Phosphor)});

        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("carbonFiber", 1L));
        if (GT_Mod.gregtechproxy.mDisableIC2Cables) {
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("copperCableItem", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("insulatedCopperCableItem", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("goldCableItem", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("insulatedGoldCableItem", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("insulatedIronCableItem", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("glassFiberCableItem", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("tinCableItem", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("ironCableItem", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("insulatedTinCableItem", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("detectorCableItem", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("splitterCableItem", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("electrolyzer", 1L));

            if (Loader.isModLoaded("NotEnoughItems")) {
                codechicken.nei.api.API.hideItem(GT_ModHandler.getIC2Item("copperCableItem", 1L));
                codechicken.nei.api.API.hideItem(GT_ModHandler.getIC2Item("insulatedCopperCableItem", 1L));
                codechicken.nei.api.API.hideItem(GT_ModHandler.getIC2Item("goldCableItem", 1L));
                codechicken.nei.api.API.hideItem(GT_ModHandler.getIC2Item("insulatedGoldCableItem", 1L));
                codechicken.nei.api.API.hideItem(GT_ModHandler.getIC2Item("insulatedIronCableItem", 1L));
                codechicken.nei.api.API.hideItem(GT_ModHandler.getIC2Item("glassFiberCableItem", 1L));
                codechicken.nei.api.API.hideItem(GT_ModHandler.getIC2Item("tinCableItem", 1L));
                codechicken.nei.api.API.hideItem(GT_ModHandler.getIC2Item("ironCableItem", 1L));
                codechicken.nei.api.API.hideItem(GT_ModHandler.getIC2Item("insulatedTinCableItem", 1L));
                codechicken.nei.api.API.hideItem(GT_ModHandler.getIC2Item("detectorCableItem", 1L));
                codechicken.nei.api.API.hideItem(GT_ModHandler.getIC2Item("splitterCableItem", 1L));
                codechicken.nei.api.API.hideItem(GT_ModHandler.getIC2Item("electrolyzer", 1L));
                codechicken.nei.api.API.hideItem(GT_ModHandler.getIC2Item("cutter", 1L));
            }
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("batBox", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("mfeUnit", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("lvTransformer", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("mvTransformer", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("hvTransformer", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("evTransformer", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("cesuUnit", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("luminator", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("teleporter", 1L));
            //GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("teleporter", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"GFG", "CMC", "GDG", 'C', OrePrefixes.cableGt01.get(Materials.Platinum), 'G', OrePrefixes.circuit.get(Materials.Advanced), 'D', OrePrefixes.gem.get(Materials.Diamond), 'M', GT_ModHandler.getIC2Item("machine", 1L), 'F', GT_ModHandler.getIC2Item("frequencyTransmitter", 1L)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("energyOMat", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("advBattery", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2", "itemAdvBat", 1, GT_Values.W), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[] {"WdW", "HBH", "HXH", 'W', OrePrefixes.wireGt02.get(Materials.Copper), 'H',  OrePrefixes.itemCasing.get(Materials.Copper),  'X', OrePrefixes.itemCasing.get(Materials.Lead), 'B', ItemList.Battery_Hull_MV});
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("boatElectric", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("cropnalyzer", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("coil", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("powerunit", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("remote", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("remote", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{" C ", "TLT", " F ", 'C', OrePrefixes.cableGt01.get(Materials.Copper), 'L', OrePrefixes.dust.get(Materials.Lapis), 'T', OrePrefixes.itemCasing.get(Materials.Tin), 'F', GT_ModHandler.getIC2Item("frequencyTransmitter", 1L)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("odScanner", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("ovScanner", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("solarHelmet", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("staticBoots", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("staticBoots", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"I I", "IWI", "CCC", 'C', OrePrefixes.cableGt01.get(Materials.Copper), 'I', OrePrefixes.ingot.get(Materials.Iron), 'W', new ItemStack(Blocks.wool)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("ecMeter", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("obscurator", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"RER", "CAC", "RRR", 'C', OrePrefixes.cableGt01.get(Materials.Gold), 'R', OrePrefixes.dust.get(Materials.Redstone), 'E', OrePrefixes.battery.get(Materials.Advanced), 'A', OrePrefixes.circuit.get(Materials.Advanced)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("overclockerUpgrade", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("overclockerUpgrade", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"CCC", "WEW", 'W', OrePrefixes.cableGt01.get(Materials.Copper), 'C', GT_ModHandler.getIC2Item("reactorCoolantSimple", 1L, 1), 'E', OrePrefixes.circuit.get(Materials.Basic)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("transformerUpgrade", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("transformerUpgrade", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"GGG", "WTW", "GEG", 'W', OrePrefixes.cableGt01.get(Materials.Gold), 'T', GT_ModHandler.getIC2Item("mvTransformer", 1L), 'E', OrePrefixes.circuit.get(Materials.Basic), 'G', OrePrefixes.block.get(Materials.Glass)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("energyStorageUpgrade", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("energyStorageUpgrade", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"PPP", "WBW", "PEP", 'W', OrePrefixes.cableGt01.get(Materials.Copper), 'E', OrePrefixes.circuit.get(Materials.Basic), 'P', OrePrefixes.plank.get(Materials.Wood), 'B', OrePrefixes.battery.get(Materials.Basic)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("ejectorUpgrade", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("suBattery", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("suBattery", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"W", "C", "R", 'W', OrePrefixes.cableGt01.get(Materials.Copper), 'C', OrePrefixes.dust.get(Materials.HydratedCoal), 'R', OrePrefixes.dust.get(Materials.Redstone)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("frequencyTransmitter", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("pullingUpgrade", 1L));
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("cutter", 1L));

        } else {
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("glassFiberCableItem", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"GGG", "EDE", "GGG", 'G', new ItemStack(Blocks.glass, 1, 32767), 'D', OrePrefixes.dust.get(Materials.Silver), 'E', ItemList.IC2_Energium_Dust.get(1L)});
        }

        if (Loader.isModLoaded("NotEnoughItems")) {
            codechicken.nei.api.API.hideItem(GT_ModHandler.getIC2Item("reactorUraniumSimple", 1L, 1));
            codechicken.nei.api.API.hideItem(GT_ModHandler.getIC2Item("reactorUraniumDual", 1L, 1));
            codechicken.nei.api.API.hideItem(GT_ModHandler.getIC2Item("reactorUraniumQuad", 1L, 1));
            codechicken.nei.api.API.hideItem(GT_ModHandler.getIC2Item("reactorMOXSimple", 1L, 1));
            codechicken.nei.api.API.hideItem(GT_ModHandler.getIC2Item("reactorMOXDual", 1L, 1));
            codechicken.nei.api.API.hideItem(GT_ModHandler.getIC2Item("reactorMOXQuad", 1L, 1));
        }

        if (!GregTech_API.mIC2Classic) {
            GT_ModHandler.addCraftingRecipe(ItemList.Uraniumcell_2.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"RPR", "   ", "   ", 'R', ItemList.Uraniumcell_1, 'P', OrePrefixes.plate.get(Materials.Zirconium)});
            GT_ModHandler.addCraftingRecipe(ItemList.Uraniumcell_4.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"RPR", "CPC", "RPR", 'R', ItemList.Uraniumcell_1, 'P', OrePrefixes.plate.get(Materials.Zirconium), 'C', OrePrefixes.plate.get(Materials.Copper)});
            GT_ModHandler.addCraftingRecipe(ItemList.Moxcell_2.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"RPR", "   ", "   ", 'R', ItemList.Moxcell_1, 'P', OrePrefixes.plate.get(Materials.Zirconium)});
            GT_ModHandler.addCraftingRecipe(ItemList.Moxcell_4.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"RPR", "CPC", "RPR", 'R', ItemList.Moxcell_1, 'P', OrePrefixes.plate.get(Materials.Zirconium), 'C', OrePrefixes.plate.get(Materials.Copper)});

            GT_ModHandler.removeRecipeByOutput(Ic2Items.miningLaser.copy());
            GT_ModHandler.addCraftingRecipe(Ic2Items.miningLaser.copy(), new Object[]{"PLP", "GEC", "SBd", 'P', OrePrefixes.plate.get(Materials.Titanium), 'L', OrePrefixes.plate.get(Materials.Gallium), 'G', OrePrefixes.gemExquisite.get(Materials.Diamond), 'E', ItemList.Emitter_EV, 'C', OrePrefixes.circuit.get(Materials.Elite), 'S', OrePrefixes.screw.get(Materials.Titanium), 'B', ItemList.LapotronCrystal.get(1)});
            GT_ModHandler.addCraftingRecipe(Ic2Items.miningLaser.copy(), new Object[]{"PLP", "GEC", "SBd", 'P', OrePrefixes.plate.get(Materials.Titanium), 'L', OrePrefixes.plate.get(Materials.Gallium), 'G', OrePrefixes.gemExquisite.get(Materials.Ruby), 'E', ItemList.Emitter_EV, 'C', OrePrefixes.circuit.get(Materials.Elite), 'S', OrePrefixes.screw.get(Materials.Titanium), 'B', ItemList.LapotronCrystal.get(1)});
            GT_ModHandler.addCraftingRecipe(Ic2Items.miningLaser.copy(), new Object[]{"PLP", "GEC", "SBd", 'P', OrePrefixes.plate.get(Materials.Titanium), 'L', OrePrefixes.plate.get(Materials.Gallium), 'G', OrePrefixes.gemExquisite.get(Materials.Jasper), 'E', ItemList.Emitter_EV, 'C', OrePrefixes.circuit.get(Materials.Elite), 'S', OrePrefixes.screw.get(Materials.Titanium), 'B', ItemList.LapotronCrystal.get(1)});
            GT_ModHandler.addCraftingRecipe(Ic2Items.miningLaser.copy(), new Object[]{"PLP", "GEC", "SBd", 'P', OrePrefixes.plate.get(Materials.Titanium), 'L', OrePrefixes.plate.get(Materials.Gallium), 'G', OrePrefixes.gemExquisite.get(Materials.GarnetRed), 'E', ItemList.Emitter_EV, 'C', OrePrefixes.circuit.get(Materials.Elite), 'S', OrePrefixes.screw.get(Materials.Titanium), 'B', ItemList.LapotronCrystal.get(1)});
        }
        GT_ModHandler.removeRecipeByOutput(ItemList.IC2_Energium_Dust.get(1L));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("lapotronCrystal", 1L));
		
        if (Loader.isModLoaded("GraviSuite")) {
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 3, 1));
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 3, 0));
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "advJetpack", 1));
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "advLappack", 1));
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "advNanoChestPlate", 1));
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "ultimateLappack", 1));
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "relocator", 1));
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "vajra", 1));
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "graviTool", 1));
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "advChainsaw", 1));
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "advDDrill", 1));
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 1L, 4));
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 1L, 5));
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 1L, 7));
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 1L, 2));
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 1L, 6));
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "itemSimpleItem", 1L, 3));
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "graviChestPlate", 1L));
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("GraviSuite", "kpChestPlate", 1L));
		}
		
        GT_ModHandler.removeRecipe(GT_ModHandler.getIC2Item("miningPipe", 8));
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("miningPipe", 1), new Object[]{"hPf", 'P', OrePrefixes.pipeSmall.get(Materials.Steel)});
        GT_ModHandler.addShapelessCraftingRecipe(GT_ModHandler.getIC2Item("miningPipe", 1L), new Object[]{GT_ModHandler.getIC2Item("miningPipeTip", 1L)});
        GT_Values.RA.addWiremillRecipe(GT_OreDictUnificator.get(OrePrefixes.pipeTiny, Materials.Steel, 1), GT_ModHandler.getIC2Item("miningPipe", 1), 200, 16);
        GT_Values.RA.addExtruderRecipe(GT_OreDictUnificator.get(OrePrefixes.pipeTiny, Materials.Steel, 1L), ItemList.Shape_Extruder_Pipe_Tiny.get(0L), GT_ModHandler.getIC2Item("miningPipe", 1), 1, 64);
        GT_Values.RA.addExtruderRecipe(GT_OreDictUnificator.get(OrePrefixes.pipeSmall, Materials.Steel, 1L), ItemList.Shape_Extruder_Pipe_Tiny.get(0L), GT_ModHandler.getIC2Item("miningPipe", 2), 4, 64);
        GT_Values.RA.addExtruderRecipe(GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.Steel, 1L), ItemList.Shape_Extruder_Pipe_Tiny.get(0L), GT_ModHandler.getIC2Item("miningPipe", 4), 8, 64);
        GT_Values.RA.addExtruderRecipe(GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.Steel, 1L), ItemList.Shape_Extruder_Pipe_Tiny.get(0L), GT_ModHandler.getIC2Item("miningPipe", 8), 16, 64);
        GT_Values.RA.addExtruderRecipe(GT_OreDictUnificator.get(OrePrefixes.pipeHuge, Materials.Steel, 1L), ItemList.Shape_Extruder_Pipe_Tiny.get(0L), GT_ModHandler.getIC2Item("miningPipe", 16), 32, 64);
        GT_Values.RA.addExtruderRecipe(GT_OreDictUnificator.get(OrePrefixes.pipeTiny, Materials.StainlessSteel, 1L), ItemList.Shape_Extruder_Pipe_Tiny.get(0L), GT_ModHandler.getIC2Item("miningPipe", 8), 4, 120);
        GT_Values.RA.addExtruderRecipe(GT_OreDictUnificator.get(OrePrefixes.pipeSmall, Materials.StainlessSteel, 1L), ItemList.Shape_Extruder_Pipe_Tiny.get(0L), GT_ModHandler.getIC2Item("miningPipe", 16), 8, 120);
        GT_Values.RA.addExtruderRecipe(GT_OreDictUnificator.get(OrePrefixes.pipeMedium, Materials.StainlessSteel, 1L), ItemList.Shape_Extruder_Pipe_Tiny.get(0L), GT_ModHandler.getIC2Item("miningPipe", 32), 16, 120);
        GT_Values.RA.addExtruderRecipe(GT_OreDictUnificator.get(OrePrefixes.pipeLarge, Materials.StainlessSteel, 1L), ItemList.Shape_Extruder_Pipe_Tiny.get(0L), GT_ModHandler.getIC2Item("miningPipe", 64), 32, 120);
        
        GT_ModHandler.removeRecipe(tStack = GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1L), tStack, tStack, tStack, new ItemStack(Items.coal, 1, 0), tStack, tStack, tStack, tStack);
        GT_ModHandler.removeRecipe(tStack = GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sulfur, 1L), tStack, tStack, tStack, new ItemStack(Items.coal, 1, 1), tStack, tStack, tStack, tStack);
        GT_ModHandler.removeRecipe(null, tStack = new ItemStack(Items.coal, 1), null, tStack, GT_OreDictUnificator.get(OrePrefixes.ingot, Materials.Iron, 1L), tStack, null, tStack, null);

        GT_ModHandler.removeFurnaceSmelting(new ItemStack(Blocks.hopper));

        GT_Log.out.println("GT_Mod: Applying harder Recipes for several Blocks.");
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.harderrecipes, "blockbreaker", false)) {
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.removeRecipe(new ItemStack(Blocks.cobblestone, 1), new ItemStack(Items.iron_pickaxe, 1), new ItemStack(Blocks.cobblestone, 1), new ItemStack(Blocks.cobblestone, 1), new ItemStack(Blocks.piston, 1), new ItemStack(Blocks.cobblestone, 1), new ItemStack(Blocks.cobblestone, 1), new ItemStack(Items.redstone, 1), new ItemStack(Blocks.cobblestone, 1)), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"RGR", "RPR", "RCR", 'G', OreDictNames.craftingGrinder, 'C', OrePrefixes.circuit.get(Materials.Advanced), 'R', OrePrefixes.plate.get(Materials.Steel), 'P', OreDictNames.craftingPiston});
        }
        if ((GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.harderrecipes, "reflector", true)) &&
                (GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("reactorReflector", 1L, 1)))) {
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("reactorReflector", 1L, 1), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"TGT", "GSG", "TGT", 'T', OrePrefixes.plate.get(Materials.Tin), 'G', OrePrefixes.dust.get(Materials.Graphite), 'S', OrePrefixes.plateDouble.get(Materials.Steel)});
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("reactorReflector", 1L, 1), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"TTT", "GSG", "TTT", 'T', OrePrefixes.plate.get(Materials.TinAlloy), 'G', OrePrefixes.dust.get(Materials.Graphite), 'S', OrePrefixes.plate.get(Materials.Beryllium)});
        }
        if ((GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.harderrecipes, "cropharvester", true)) &&
                (GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("crophavester", 1L)))) {
        }
        if ((GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.harderrecipes, "nuclearReactor", true)) &&
                (GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("nuclearReactor", 1L)))) {
            
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("reactorChamber", 1L));
            
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("reactorvessel", 1L));
            
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("reactorAccessHatch", 1L));
            
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("reactorFluidPort", 1L));
            
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("reactorRedstonePort", 1L));
		}
        if ((GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.harderrecipes, "rtg", true)) &&
                (GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("RTGenerator", 1L)))) {

            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("RTHeatGenerator", 1L));
        }
        if ((GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.harderrecipes, "windRotor", true)) &&
                (GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("carbonrotor", 1L)))) {
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("carbonrotor", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"dBS", "BTB", "SBw", 'B', GT_ModHandler.getIC2Item("carbonrotorblade", 1), 'S', OrePrefixes.screw.get(Materials.Iridium), 'T', GT_ModHandler.getIC2Item("steelshaft", 1)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("steelrotor", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("steelrotor", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"dBS", "BTB", "SBw", 'B', GT_ModHandler.getIC2Item("steelrotorblade", 1), 'S', OrePrefixes.screw.get(Materials.StainlessSteel), 'T', GT_ModHandler.getIC2Item("ironshaft", 1)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("ironrotor", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("ironrotor", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"dBS", "BTB", "SBw", 'B', GT_ModHandler.getIC2Item("ironrotorblade", 1), 'S', OrePrefixes.screw.get(Materials.WroughtIron), 'T', GT_ModHandler.getIC2Item("ironshaft", 1)});
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("woodrotor", 1L));
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("woodrotor", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"dBS", "BTB", "SBw", 'B', GT_ModHandler.getIC2Item("woodrotorblade", 1), 'S', OrePrefixes.screw.get(Materials.WroughtIron), 'T', OrePrefixes.stickLong.get(Materials.WroughtIron)});
        }
        if ((GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.harderrecipes, "sugarpaper", true))) {
            GT_ModHandler.removeRecipeByOutput(new ItemStack(Items.paper));
            GT_ModHandler.removeRecipeByOutput(new ItemStack(Items.sugar));
            GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Paper, 2), new Object[]{"SSS", " m ", 'S', new ItemStack(Items.reeds)});
            GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Sugar, 1), new Object[]{"Sm ", 'S', new ItemStack(Items.reeds)});
//            ItemStack brick = new ItemStack(new ItemStack(Blocks.stone_slab).getItem().setContainerItem(new ItemStack(Blocks.stone_slab).getItem()));         
//            GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.paper, Materials.Empty, 2), new Object[]{" C ", "SSS", " C ", 'S', GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Paper, 1), 'C', brick});
            GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.paper, Materials.Empty, 2), new Object[]{" C ", "SSS", 'S', GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Paper, 1), 'C', ToolDictNames.craftingToolRollingPin});
//            GameRegistry.addRecipe(GT_OreDictUnificator.get(OrePrefixes.paper, Materials.Empty, 2), " C ", "SSS", " C ", 'S', GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Paper, 1), 'C', brick);
            GT_Values.RA.addFluidSolidifierRecipe(ItemList.Shape_Mold_Ball.get(0), new FluidStack(FluidRegistry.getFluid("molten.borosilicateglass"), 144), ItemList.VOLUMETRIC_FLASK.get(1), 44, 24);
        }

        GT_Log.out.println("GT_Mod: Applying Recipes for Tools");
        if ((GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.harderrecipes, "nanosaber", true)) &&
                (GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("nanoSaber", 1L)))) {
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.getIC2Item("nanoSaber", 1L), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"PI ", "PI ", "CLC", 'L', ItemList.LapotronCrystal, 'I', OrePrefixes.plateAlloy.get("Iridium"), 'P', OrePrefixes.plate.get(Materials.Platinum), 'C', OrePrefixes.circuit.get(Materials.Elite)});
        }
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.harderrecipes, "namefix", true)) {
            GT_ModHandler.addCraftingRecipe(GT_ModHandler.removeRecipeByOutput(new ItemStack(Items.flint_and_steel, 1)) ? new ItemStack(Items.flint_and_steel, 1) : null, GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"S ", " F", 'F', new ItemStack(Items.flint, 1), 'S', "nuggetIron"});
        }
        if (GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("diamondDrill", 1L))) {
        }
        if (GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("miningDrill", 1L))) {
        }
        if (GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("chainsaw", 1L))) {
        }
        GT_Log.out.println("GT_Mod: Removing Q-Armor Recipes if configured.");
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "QHelmet", false)) {
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("quantumHelmet", 1L));
        }
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "QPlate", false)) {
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("quantumBodyarmor", 1L));
        }
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "QLegs", false)) {
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("quantumLeggings", 1L));
        }
        if (GregTech_API.sRecipeFile.get(ConfigCategories.Recipes.disabledrecipes, "QBoots", false)) {
            GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getIC2Item("quantumBoots", 1L));
        }
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemArmorAdvBatpack", 1L, GT_Values.W));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemArmorEnergypack", 1L, GT_Values.W));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemAdvBat", 1L, GT_Values.W));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemNightvisionGoggles", 1L, GT_Values.W));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemArmorJetpackElectric", 1, GT_Values.W));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemArmorJetpack", 1L, GT_Values.W));
        GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("IC2", "itemArmorBatpack", 1, GT_Values.W));
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2", "itemArmorBatpack", 1, 27), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[] {"RCR", "RAR", "RTR", 'R', GT_ModHandler.getModItem("IC2", "itemBatREDischarged", 1, 0), 'C', OrePrefixes.circuit.get(Materials.Basic), 'A',  OrePrefixes.itemCasing.get(Materials.Aluminium),  'T', OrePrefixes.wireGt02.get(Materials.Tin)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2", "itemArmorAdvBatpack", 1, 27), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[] {"RCR", "RAR", "RTR", 'R', GT_ModHandler.getModItem("IC2", "itemAdvBat", 1, GT_Values.W), 'C', OrePrefixes.circuit.get(Materials.Good), 'A',  GT_ModHandler.getModItem("IC2", "itemArmorBatpack", 1, GT_Values.W),  'T', OrePrefixes.wireGt04.get(Materials.AnnealedCopper)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2", "itemArmorEnergypack", 1, 27), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[] {"CSC", "EXE", "STS", 'E', ItemList.EnergyCrystal, 'C', OrePrefixes.circuit.get(Materials.Advanced), 'X',  GT_ModHandler.getModItem("IC2", "itemArmorAdvBatpack", 1, GT_Values.W),  'T', OrePrefixes.wireGt08.get(Materials.Gold), 'S', OrePrefixes.itemCasing.get(Materials.StainlessSteel)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2", "itemArmorJetpackElectric", 1, 27), new Object[] {"SCS", "MBM", "EWE", 'S', OrePrefixes.itemCasing.get(Materials.StainlessSteel),  'C', OrePrefixes.circuit.get(Materials.Advanced),  'M', ItemList.Electric_Motor_HV,  'B', GT_ModHandler.getModItem("IC2", "itemArmorBatpack", 1, GT_Values.W), 'W', OrePrefixes.wireGt04.get(Materials.AnnealedCopper), 'E', OrePrefixes.rotor.get(Materials.StainlessSteel)});
        GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2", "itemArmorJetpack", 1, 27), GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[] {"SXS", "TCT", "EZE", 'S', OrePrefixes.itemCasing.get(Materials.StainlessSteel),  'X', OrePrefixes.circuit.get(Materials.Advanced),  'T', ItemList.Large_Fluid_Cell_Steel.get(1), 'C', GT_ModHandler.getModItem("IC2", "reactorCoolantSix", 1, 1), 'Z', OrePrefixes.pipeMedium.get(Materials.Steel), 'E', OrePrefixes.rotor.get(Materials.StainlessSteel)});
        
        if (Loader.isModLoaded("GalacticraftCore")) {
			GT_ModHandler.removeRecipeByOutput(GT_ModHandler.getModItem("GalacticraftCore", "item.sensorLens", 1, 0));
			GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("GalacticraftCore", "item.sensorLens", 1, 0), new Object[]{"RDR", "CGC", "STS", 'R', OrePrefixes.ring.get(Materials.RedAlloy), 'D',  OrePrefixes.lens.get(Materials.Diamond), 'G', OrePrefixes.lens.get(Materials.ReinforcedGlass), 'C', OrePrefixes.circuit.get(Materials.Advanced), 'S', OrePrefixes.screw.get(Materials.StainlessSteel),  'T', ToolDictNames.craftingToolScrewdriver});
			GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2", "itemNightvisionGoggles", 1, 27), new Object[] {"AXA", "RBR", "SdS", 'A', GT_ModHandler.getModItem("IC2", "reactorHeatSwitchDiamond", 1, 1),  'X', OrePrefixes.screw.get(Materials.StainlessSteel),  'B', OrePrefixes.bolt.get(Materials.StainlessSteel), 'R', OrePrefixes.ring.get(Materials.StainlessSteel), 'S', GT_ModHandler.getModItem("GalacticraftCore", "item.sensorLens", 1, 0)});
		}else {
			GT_ModHandler.addCraftingRecipe(GT_ModHandler.getModItem("IC2", "itemNightvisionGoggles", 1, 27), new Object[] {"AXA", "RBR", "SdS", 'A', GT_ModHandler.getModItem("IC2", "reactorHeatSwitchDiamond", 1, 1),  'X', OrePrefixes.screw.get(Materials.StainlessSteel),  'B', OrePrefixes.bolt.get(Materials.StainlessSteel), 'R', OrePrefixes.ring.get(Materials.StainlessSteel), 'S', OrePrefixes.lens.get(Materials.ReinforcedGlass)});
		}
		
		long bits = GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE;
        /*GT_ModHandler.addCraftingRecipe(ItemList.ModularBasicHelmet.getWildcard(1), bits, new Object[]{"AAA", "B B", 'A', new ItemStack(Items.leather, 1, 32767), 'B', OrePrefixes.ring.get(Materials.Iron)});
        GT_ModHandler.addCraftingRecipe(ItemList.ModularBasicChestplate.getWildcard(1), bits, new Object[]{"A A", "BAB", "AAA", 'A', new ItemStack(Items.leather, 1, 32767), 'B', OrePrefixes.ring.get(Materials.Iron)});
        GT_ModHandler.addCraftingRecipe(ItemList.ModularBasicLeggings.getWildcard(1), bits, new Object[]{"BAB", "A A", "A A", 'A', new ItemStack(Items.leather, 1, 32767), 'B', OrePrefixes.ring.get(Materials.Iron)});
        GT_ModHandler.addCraftingRecipe(ItemList.ModularBasicBoots.getWildcard(1), bits, new Object[]{"A A", "B B", "A A", 'A', new ItemStack(Items.leather, 1, 32767), 'B', OrePrefixes.ring.get(Materials.Iron)});
        GT_ModHandler.addCraftingRecipe(ItemList.ModularElectric1Helmet.getWildcard(1), bits, new Object[]{"ACA", "B B", 'A', OrePrefixes.stick.get(Materials.Aluminium), 'B', OrePrefixes.plate.get(Materials.Steel), 'C', OrePrefixes.battery.get(Materials.Advanced)});
        GT_ModHandler.addCraftingRecipe(ItemList.ModularElectric1Chestplate.getWildcard(1), bits, new Object[]{"A A", "BCB", "AAA", 'A', OrePrefixes.stick.get(Materials.Aluminium), 'B', OrePrefixes.plate.get(Materials.Steel), 'C', OrePrefixes.battery.get(Materials.Advanced)});
        GT_ModHandler.addCraftingRecipe(ItemList.ModularElectric1Leggings.getWildcard(1), bits, new Object[]{"BCB", "A A", "A A", 'A', OrePrefixes.stick.get(Materials.Aluminium), 'B', OrePrefixes.plate.get(Materials.Steel), 'C', OrePrefixes.battery.get(Materials.Advanced)});
        GT_ModHandler.addCraftingRecipe(ItemList.ModularElectric1Boots.getWildcard(1), bits, new Object[]{"A A", "BCB", "A A", 'A', OrePrefixes.stick.get(Materials.Aluminium), 'B', OrePrefixes.plate.get(Materials.Steel), 'C', OrePrefixes.battery.get(Materials.Advanced)});
        GT_ModHandler.addCraftingRecipe(ItemList.ModularElectric2Helmet.getWildcard(1), bits, new Object[]{"ACA", "B B", 'A', OrePrefixes.stick.get(Materials.TungstenSteel), 'B', OrePrefixes.plateAlloy.get(Materials.Carbon), 'C', ItemList.LapotronCrystal});
        GT_ModHandler.addCraftingRecipe(ItemList.ModularElectric2Chestplate.getWildcard(1), bits, new Object[]{"A A", "BCB", "AAA", 'A', OrePrefixes.stick.get(Materials.TungstenSteel), 'B', OrePrefixes.plateAlloy.get(Materials.Carbon), 'C', ItemList.LapotronCrystal});
        GT_ModHandler.addCraftingRecipe(ItemList.ModularElectric2Leggings.getWildcard(1), bits, new Object[]{"BCB", "A A", "A A", 'A', OrePrefixes.stick.get(Materials.TungstenSteel), 'B', OrePrefixes.plateAlloy.get(Materials.Carbon), 'C', ItemList.LapotronCrystal});
        GT_ModHandler.addCraftingRecipe(ItemList.ModularElectric2Boots.getWildcard(1), bits, new Object[]{"A A", "BCB", "A A", 'A', OrePrefixes.stick.get(Materials.TungstenSteel), 'B', OrePrefixes.plateAlloy.get(Materials.Carbon), 'C', ItemList.LapotronCrystal});*/
    }
}
