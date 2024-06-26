package gregtech.loaders.oreprocessing;

import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;

public class ProcessingSaplings implements gregtech.api.interfaces.IOreRecipeRegistrator {
    public ProcessingSaplings() {
        OrePrefixes.treeSapling.add(this);
    }

    @Override
    public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
        GT_ModHandler.addCompressionRecipe(GT_Utility.copyAmount(8L, new Object[]{aStack}), ItemList.IC2_Plantball.get(1L));
        GT_Values.RA.addLatheRecipe(GT_Utility.copyAmount(1L, new Object[]{aStack}), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.Wood, 1L), null, 16, 6);
    }
}
