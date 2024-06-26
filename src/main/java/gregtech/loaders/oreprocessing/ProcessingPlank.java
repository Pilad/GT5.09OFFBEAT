package gregtech.loaders.oreprocessing;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ProcessingPlank implements gregtech.api.interfaces.IOreRecipeRegistrator {
    public ProcessingPlank() {
        OrePrefixes.plank.add(this);
    }

    @Override
    public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
        if (aOreDictName.startsWith("plankWood")) {
            GT_Values.RA.addLatheRecipe(GT_Utility.copyAmount(1L, new Object[]{aStack}), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 2L), null, 10, 6);
            GT_Values.RA.addCNCRecipe(GT_Utility.copyAmount(4L, new Object[]{aStack}), GT_OreDictUnificator.get(OrePrefixes.gearGt, Materials.Wood, 1L), 800, 1);
            GT_Values.RA.addAssemblerRecipe(GT_Utility.copyAmount(1L, new Object[]{aStack}), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Iron, 1L), ItemList.Crate_Empty.get(1L), 200, 1);
            GT_Values.RA.addAssemblerRecipe(GT_Utility.copyAmount(1L, new Object[]{aStack}), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.WroughtIron, 1L), ItemList.Crate_Empty.get(1L), 200, 1);
            GT_Values.RA.addAssemblerRecipe(GT_Utility.copyAmount(1L, new Object[]{aStack}), GT_OreDictUnificator.get(OrePrefixes.screw, Materials.Steel, 1L), ItemList.Crate_Empty.get(1L), 200, 1);
            GT_Values.RA.addAssemblerRecipe(GT_Utility.copyAmount(1L, new Object[]{aStack}), ItemList.Circuit_Integrated.getWithDamage(0L, 1L), new ItemStack(Blocks.wooden_button, 1), 100, 3);
            GT_Values.RA.addAssemblerRecipe(GT_Utility.copyAmount(4L, new Object[]{aStack}), ItemList.Circuit_Integrated.getWithDamage(0L, 4L), new ItemStack(Blocks.crafting_table, 1), 400, 3);
            GT_Values.RA.addAssemblerRecipe(GT_Utility.copyAmount(8L, new Object[]{aStack}), ItemList.Circuit_Integrated.getWithDamage(0L, 8L), new ItemStack(Blocks.chest, 1), 80, 3);
            GT_Values.RA.addAssemblerRecipe(GT_Utility.copyAmount(6L, new Object[]{aStack}), new ItemStack(Items.book, 3), new ItemStack(Blocks.bookshelf, 1), 400, 3);

            if (aStack.getItemDamage() == 32767) {
                for (byte i = 0; i < 64; i = (byte) (i + 1)) {
                    ItemStack tStack = GT_Utility.copyMetaData(i, new Object[]{aStack});
                    ItemStack tOutput = GT_ModHandler.getRecipeOutput(new ItemStack[]{tStack, tStack, tStack});
                    if ((tOutput != null) && (tOutput.stackSize >= 3)) {
                        GT_Values.RA.addCutterRecipe(GT_Utility.copyAmount(1L, new Object[]{tStack}), GT_Utility.copyAmount(tOutput.stackSize / 3, new Object[]{tOutput}), null, 25, 3);
                        GT_ModHandler.removeRecipe(new ItemStack[]{tStack, tStack, tStack});
                        GT_ModHandler.addCraftingRecipe(GT_Utility.copyAmount(tOutput.stackSize / 3, new Object[]{tOutput}), new Object[]{"sP", 'P', tStack});
                    }
                    if((tStack == null) && (i >= 16)) break;
                }
            } else {
                ItemStack tOutput = GT_ModHandler.getRecipeOutput(new ItemStack[]{aStack, aStack, aStack});
                if ((tOutput != null) && (tOutput.stackSize >= 3)) {
                    GT_Values.RA.addCutterRecipe(GT_Utility.copyAmount(1L, new Object[]{aStack}), GT_Utility.copyAmount(tOutput.stackSize / 3, new Object[]{tOutput}), null, 25, 3);
                    GT_ModHandler.removeRecipe(new ItemStack[]{aStack, aStack, aStack});
                    GT_ModHandler.addCraftingRecipe(GT_Utility.copyAmount(tOutput.stackSize / 3, new Object[]{tOutput}), new Object[]{"sP", 'P', aStack});
                }
            }
        }
    }
}
