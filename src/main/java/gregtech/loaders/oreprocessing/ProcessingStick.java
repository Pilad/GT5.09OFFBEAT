package gregtech.loaders.oreprocessing;

import gregtech.api.enums.*;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import gregtech.common.GT_Proxy;
import net.minecraft.item.ItemStack;

public class ProcessingStick implements gregtech.api.interfaces.IOreRecipeRegistrator {
    public ProcessingStick() {
        OrePrefixes.stick.add(this);
    }

    @Override
    public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
        GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.springSmall, aMaterial, 1L), new Object[]{" s ", "fPx", 'P', OrePrefixes.stick.get(aMaterial)});
        if (!aMaterial.contains(gregtech.api.enums.SubTag.NO_WORKING)) {
            //GT_Values.RA.addLatheRecipe(aMaterial.contains(SubTag.CRYSTAL) ? GT_OreDictUnificator.get(OrePrefixes.gem, aMaterial, 1L) : GT_OreDictUnificator.get(OrePrefixes.ingot, aMaterial, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, aMaterial, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, aMaterial.mMacerateInto, 1L), new int[]{10000, 5000}, (int) Math.max(aMaterial.getMass() * 5L, 1L), 12);
            GT_Values.RA.addLatheRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, aMaterial, 2L), GT_OreDictUnificator.get(OrePrefixes.stickLong, aMaterial, 1L), null, (int) Math.max(aMaterial.getMass() * 3L, 1L), 12);
            GT_Values.RA.addCutterRecipe(GT_Utility.copyAmount(1L, new Object[]{aStack}), GT_OreDictUnificator.get(OrePrefixes.bolt, aMaterial, 4L), null, (int) Math.max(aMaterial.getMass() * 2L, 1L), 3);
            if ((aMaterial.mUnificatable) && (aMaterial.mMaterialInto == aMaterial)) {
                GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, aMaterial, 2L), GT_Proxy.tBits, new Object[]{"s", "X", Character.valueOf('X'), OrePrefixes.stickLong.get(aMaterial)});
                GT_ModHandler.addCraftingRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, aMaterial, 1L), GT_Proxy.tBits, new Object[]{"f ", " X", Character.valueOf('X'), OrePrefixes.ingot.get(aMaterial)});
            }
        }
        if (aMaterial.contains(gregtech.api.enums.SubTag.METAL) || aMaterial.contains(gregtech.api.enums.SubTag.CRYSTAL)) {
            GT_Values.RA.addLatheRecipe(aMaterial.contains(SubTag.CRYSTAL) ? GT_OreDictUnificator.get(OrePrefixes.gem, aMaterial, 1L) : GT_OreDictUnificator.get(OrePrefixes.ingot, aMaterial, 1L), GT_OreDictUnificator.get(OrePrefixes.stick, aMaterial, 1L), GT_OreDictUnificator.get(OrePrefixes.dust, aMaterial.mMacerateInto, 1L), new int[]{10000, 5000}, (int) Math.max(aMaterial.getMass() * 5L, 1L), 16);
        }        
        if (!aMaterial.contains(gregtech.api.enums.SubTag.NO_SMASHING)) {
            GT_Values.RA.addBenderRecipe(GT_Utility.copyAmount(1L, new Object[]{aStack}), GT_OreDictUnificator.get(OrePrefixes.springSmall, aMaterial, 2L), 100, 6);
            GT_Values.RA.addForgeHammerRecipe(GT_Utility.copyAmount(2L, new Object[]{aStack}), GT_OreDictUnificator.get(OrePrefixes.stickLong, aMaterial, 1L), (int) Math.max(aMaterial.getMass(), 1L), 12);
        }
        GT_Values.RA.addAssemblerRecipe(GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1), ItemList.Circuit_Integrated.getWithDamage(0L, 2L), Materials.SeedOil.getFluid(50L), ItemList.FR_Stick.get(1L), 16, 6);
    }
}
