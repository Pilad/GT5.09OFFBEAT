package gregtech.loaders.oreprocessing;

import gregtech.GT_Mod;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.enums.SubTag;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public class ProcessingOre implements gregtech.api.interfaces.IOreRecipeRegistrator {
    private final ArrayList<Materials> mAlreadyListedOres = new ArrayList(1000);

    public ProcessingOre() {
        for (OrePrefixes tPrefix : OrePrefixes.values())
            if ((tPrefix.name().startsWith("ore")) && (tPrefix != OrePrefixes.orePoor) && (tPrefix != OrePrefixes.oreSmall) && (tPrefix != OrePrefixes.oreRich) && (tPrefix != OrePrefixes.oreNormal))
                tPrefix.add(this);
    }

    @Override
    public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
        boolean tIsRich = (aPrefix == OrePrefixes.oreNetherrack) || (aPrefix == OrePrefixes.oreNether) || (aPrefix == OrePrefixes.oreEndstone) || (aPrefix == OrePrefixes.oreEnd) || (aPrefix == OrePrefixes.oreRich) || (aPrefix == OrePrefixes.oreDense);

        if (aMaterial == Materials.Oilsands) {
            GT_Values.RA.addCentrifugeRecipe(GT_Utility.copyAmount(1L, aStack), null, null, Materials.Oil.getFluid(tIsRich ? 1000L : 500L), new ItemStack(net.minecraft.init.Blocks.sand, 1, 0), null, null, null, null, null, new int[]{tIsRich ? '?' : '?'}, tIsRich ? 2000 : 1000, 5);
        } else {
            registerStandardOreRecipes(aPrefix, aMaterial, GT_Utility.copyAmount(1L, aStack), Math.max(1, gregtech.api.GregTech_API.sOPStuff.get(gregtech.api.enums.ConfigCategories.Materials.oreprocessingoutputmultiplier, aMaterial.toString(), 1)) * (tIsRich ? 2 : 1));
        }
    }

    private boolean registerStandardOreRecipes(OrePrefixes aPrefix, Materials aMaterial, ItemStack aOreStack, int aMultiplier) {
        if ((aOreStack == null) || (aMaterial == null)) return false;
        GT_ModHandler.addValuableOre(GT_Utility.getBlockFromStack(aOreStack), aOreStack.getItemDamage(), aMaterial.mOreValue);
        Materials tMaterial = aMaterial.mOreReplacement;
        Materials tPrimaryByMaterial = null;
        aMultiplier = Math.max(1, aMultiplier);
        aOreStack = GT_Utility.copyAmount(1L, aOreStack);
        aOreStack.stackSize = 1;


        ItemStack tIngot = GT_OreDictUnificator.get(OrePrefixes.ingot, aMaterial.mDirectSmelting, 1L);
        ItemStack tGem = GT_OreDictUnificator.get(OrePrefixes.gem, tMaterial, 1L);
        ItemStack tSmeltInto = tIngot == null ? null : aMaterial.contains(SubTag.SMELTING_TO_GEM) ? GT_OreDictUnificator.get(OrePrefixes.gem, tMaterial.mDirectSmelting, GT_OreDictUnificator.get(OrePrefixes.crystal, tMaterial.mDirectSmelting, GT_OreDictUnificator.get(OrePrefixes.gem, tMaterial, GT_OreDictUnificator.get(OrePrefixes.crystal, tMaterial, 1L), 1L), 1L), 1L) : tIngot;

        ItemStack tDust = GT_OreDictUnificator.get(OrePrefixes.dust, tMaterial, tGem, 1L);
        ItemStack tCleaned = GT_OreDictUnificator.get(OrePrefixes.crushedPurified, tMaterial, tDust, 1L);
        ItemStack tGCleaned = GT_OreDictUnificator.get(OrePrefixes.crushedPurified, tMaterial, aMaterial.mOreMultiplier * aMultiplier);
        ItemStack tCrushed = GT_OreDictUnificator.get(OrePrefixes.crushed, tMaterial, aMaterial.mOreMultiplier * aMultiplier);
        ItemStack tPrimaryByProduct = null;

        if (tCrushed == null) {
            tCrushed = GT_OreDictUnificator.get(OrePrefixes.dustImpure, tMaterial, GT_Utility.copyAmount(aMaterial.mOreMultiplier * aMultiplier, tCleaned, tDust, tGem), aMaterial.mOreMultiplier * aMultiplier);
        }

        ArrayList<ItemStack> tByProductStacks = new ArrayList();

        for (Materials tMat : aMaterial.mOreByProducts) {
            ItemStack tByProduct = GT_OreDictUnificator.get(OrePrefixes.dust, tMat, 1L);
            if (tByProduct != null) tByProductStacks.add(tByProduct);
            if (tPrimaryByProduct == null) {
                tPrimaryByMaterial = tMat;
                tPrimaryByProduct = GT_OreDictUnificator.get(OrePrefixes.dust, tMat, 1L);
                if (GT_OreDictUnificator.get(OrePrefixes.dustSmall, tMat, 1L) == null)
                    GT_OreDictUnificator.get(OrePrefixes.dustTiny, tMat, GT_OreDictUnificator.get(OrePrefixes.nugget, tMat, 2L), 2L);
            }
            GT_OreDictUnificator.get(OrePrefixes.dust, tMat, 1L);
            if (GT_OreDictUnificator.get(OrePrefixes.dustSmall, tMat, 1L) == null)
                GT_OreDictUnificator.get(OrePrefixes.dustTiny, tMat, GT_OreDictUnificator.get(OrePrefixes.nugget, tMat, 2L), 2L);
        }
        if ((!tByProductStacks.isEmpty()) && (!this.mAlreadyListedOres.contains(aMaterial))) {
            this.mAlreadyListedOres.add(aMaterial);
            //Deprecated in IMPACT 1.0.2.1+
            //gregtech.api.util.GT_Recipe.GT_Recipe_Map.sByProductList.addFakeRecipe(false, new ItemStack[]{GT_OreDictUnificator.get(OrePrefixes.ore, aMaterial, aOreStack, 1L)}, tByProductStacks.toArray(new ItemStack[tByProductStacks.size()]), null, null, null, null, 0, 0, 0);
        }

        if (tPrimaryByMaterial == null) tPrimaryByMaterial = tMaterial;
        if (tPrimaryByProduct == null) tPrimaryByProduct = tDust;
        boolean tHasSmelting = false;

        if (tSmeltInto != null) {
            if ((aMaterial.mBlastFurnaceRequired) || (aMaterial.mDirectSmelting.mBlastFurnaceRequired)) {
                GT_ModHandler.removeFurnaceSmelting(aOreStack);
            } else {
                tHasSmelting = GT_ModHandler.addSmeltingRecipe(aOreStack, GT_Utility.copyAmount(aMultiplier * aMaterial.mSmeltingMultiplier, tSmeltInto));
            }

            if (aMaterial.contains(SubTag.BLASTFURNACE_CALCITE_TRIPLE)) {
                GT_Values.RA.addBlastRecipe(aOreStack, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcite, aMultiplier), null, null, GT_Utility.mul(aMultiplier * 3 * aMaterial.mSmeltingMultiplier, tSmeltInto), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkAsh, 1L), tSmeltInto.stackSize * 500, 120, 1500);
                GT_Values.RA.addBlastRecipe(aOreStack, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quicklime, aMultiplier), null, null, GT_Utility.mul(aMultiplier * 3 * aMaterial.mSmeltingMultiplier, tSmeltInto), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkAsh, 1L), tSmeltInto.stackSize * 500, 120, 1500);
            } else if (aMaterial.contains(SubTag.BLASTFURNACE_CALCITE_DOUBLE)) {
                GT_Values.RA.addBlastRecipe(aOreStack, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Calcite, aMultiplier), null, null, GT_Utility.mul(aMultiplier * (GT_Mod.gregtechproxy.mMixedOreOnlyYieldsTwoThirdsOfPureOre ? 2 : 3) * aMaterial.mSmeltingMultiplier, tSmeltInto), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkAsh, 1L), tSmeltInto.stackSize * 500, 120, 1500);
                GT_Values.RA.addBlastRecipe(aOreStack, GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Quicklime, aMultiplier), null, null, GT_Utility.mul(aMultiplier * 8 * aMaterial.mSmeltingMultiplier, tSmeltInto), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.DarkAsh, 4L), tSmeltInto.stackSize * 2000, 120, 1500);
            }
        }

        //IndustrialPulverizer
        /*GT_Values.RA.addIndustrialPulverizerRecipe(GT_Utility.copyAmount(1L, new Object[]{aOreStack}), Materials.Water.getFluid(1800L), Materials.SluiceJuice.getFluid(1400L), GT_OreDictUnificator.get(OrePrefixes.crushedPurified, aMaterial, 2 * aMultiplier), GT_OreDictUnificator.get(OrePrefixes.dust, GT_Utility.selectItemInList(0, aMaterial.mMacerateInto, aMaterial.mOreByProducts), 1L), GT_OreDictUnificator.get(OrePrefixes.dustTiny, GT_Utility.selectItemInList(0, aMaterial, aMaterial.mOreByProducts), 2L), GT_OreDictUnificator.getDust(aPrefix.mSecondaryMaterial), new int[]{10000, 1000, 10000, 5000}, 200, 60);
        if (aMaterial.contains(SubTag.WASHING_MERCURY))
        	GT_Values.RA.addIndustrialPulverizerRecipe(GT_Utility.copyAmount(1L, new Object[]{aOreStack}), Materials.Mercury.getFluid(1800L), Materials.SluiceJuice.getFluid(1400L), GT_OreDictUnificator.get(OrePrefixes.crushedPurified, aMaterial, 2 * aMultiplier), GT_OreDictUnificator.get(OrePrefixes.dust, GT_Utility.selectItemInList(0, aMaterial.mMacerateInto, aMaterial.mOreByProducts), 1L), GT_OreDictUnificator.get(OrePrefixes.dust, aMaterial.mMacerateInto, 2L), GT_OreDictUnificator.getDust(aPrefix.mSecondaryMaterial), new int[]{10000, 1000, 7000, 5000}, 200, 60);
            if (aMaterial.contains(SubTag.WASHING_SODIUMPERSULFATE))
            	GT_Values.RA.addIndustrialPulverizerRecipe(GT_Utility.copyAmount(1L, new Object[]{aOreStack}), Materials.SodiumPersulfate.getFluid(1800L), Materials.SluiceJuice.getFluid(1400L), GT_OreDictUnificator.get(OrePrefixes.crushedPurified, aMaterial, 2 * aMultiplier), GT_OreDictUnificator.get(OrePrefixes.dust, GT_Utility.selectItemInList(0, aMaterial.mMacerateInto, aMaterial.mOreByProducts), 1L), GT_OreDictUnificator.get(OrePrefixes.dust, aMaterial.mMacerateInto, 2L), GT_OreDictUnificator.getDust(aPrefix.mSecondaryMaterial), new int[]{10000, 1000, 7000, 5000}, 200, 60);
            for (Materials tMaterials : aMaterial.mOreByProducts) {
            if (tMaterials.contains(SubTag.WASHING_MERCURY))
            	GT_Values.RA.addIndustrialPulverizerRecipe(GT_Utility.copyAmount(1L, new Object[]{aOreStack}), Materials.Mercury.getFluid(1800L), Materials.SluiceJuice.getFluid(1400L), GT_OreDictUnificator.get(OrePrefixes.crushedPurified, aMaterial, 2 * aMultiplier), GT_OreDictUnificator.get(OrePrefixes.dust, GT_Utility.selectItemInList(0, aMaterial.mMacerateInto, aMaterial.mOreByProducts), 1L), GT_OreDictUnificator.get(OrePrefixes.dust, aMaterial.mMacerateInto, 2L), GT_OreDictUnificator.getDust(aPrefix.mSecondaryMaterial), new int[]{10000, 1000, 7000, 5000}, 200, 60);
            if (tMaterials.contains(SubTag.WASHING_SODIUMPERSULFATE))
            	GT_Values.RA.addIndustrialPulverizerRecipe(GT_Utility.copyAmount(1L, new Object[]{aOreStack}), Materials.SodiumPersulfate.getFluid(1800L), Materials.SluiceJuice.getFluid(1400L), GT_OreDictUnificator.get(OrePrefixes.crushedPurified, aMaterial, 2 * aMultiplier), GT_OreDictUnificator.get(OrePrefixes.dust, GT_Utility.selectItemInList(0, aMaterial.mMacerateInto, aMaterial.mOreByProducts), 1L), GT_OreDictUnificator.get(OrePrefixes.dust, aMaterial.mMacerateInto, 2L), GT_OreDictUnificator.getDust(aPrefix.mSecondaryMaterial), new int[]{10000, 1000, 7000, 5000}, 200, 60);
            }*/
        if (!tHasSmelting) {
            GT_ModHandler.addSmeltingRecipe(aOreStack, GT_OreDictUnificator.get(OrePrefixes.gem, tMaterial.mDirectSmelting, Math.max(1, aMultiplier * aMaterial.mSmeltingMultiplier / 2)));
        }

        if (tCrushed != null) {
            GT_Values.RA.addForgeHammerRecipe(aOreStack, GT_Utility.copy(GT_Utility.copyAmount(tCrushed.stackSize, tGem), tCrushed), 16, 10);
           
            boolean isNotOre = aPrefix != OrePrefixes.ore; //Deprecated in IMPACT 1.0.2.1+
            if (isNotOre) {
                GT_ModHandler.addPulverisationRecipe(aOreStack, GT_Utility.mul(2L, tCrushed), tMaterial.contains(SubTag.PULVERIZING_CINNABAR) ? GT_OreDictUnificator.get(OrePrefixes.crystal, Materials.Cinnabar, GT_OreDictUnificator.get(OrePrefixes.gem, tPrimaryByMaterial, GT_Utility.copyAmount(1L, tPrimaryByProduct), 1L), 1L) : GT_OreDictUnificator.get(OrePrefixes.gem, tPrimaryByMaterial, GT_Utility.copyAmount(1L, tPrimaryByProduct), 1L), tPrimaryByProduct == null ? 0 : tPrimaryByProduct.stackSize * 10 * aMultiplier * aMaterial.mByProductMultiplier, GT_OreDictUnificator.getDust(aPrefix.mSecondaryMaterial), 50, true);
            }
        }

        if (tGCleaned != null) {
            GT_Values.RA.addIndustrialPulverizerRecipe(aOreStack, Materials.Water.getFluid(1800L), Materials.SluiceJuice.getFluid(1400L), new ItemStack[]{GT_Utility.mul(2L, tGCleaned), tMaterial.contains(SubTag.PULVERIZING_CINNABAR) ? GT_OreDictUnificator.get(OrePrefixes.crystal, Materials.Cinnabar, GT_OreDictUnificator.get(OrePrefixes.gem, tPrimaryByMaterial, GT_Utility.copyAmount(1L, tPrimaryByProduct), 1L), 1L) : GT_OreDictUnificator.get(OrePrefixes.gem, tPrimaryByMaterial, GT_Utility.copyAmount(1L, tPrimaryByProduct), 1L), /*tPrimaryByProduct == null ? 0 : tPrimaryByProduct.stackSize * 10 * aMultiplier * aMaterial.mByProductMultiplier,*/ GT_OreDictUnificator.get(OrePrefixes.dust, GT_Utility.selectItemInList(0, aMaterial, aMaterial.mOreByProducts), 1L), GT_OreDictUnificator.getDust(aPrefix.mSecondaryMaterial)}, new int[]{10000, 1000, 2500, 5000}, 200, 60);
            if (aMaterial.contains(SubTag.WASHING_MERCURY))
                GT_Values.RA.addIndustrialPulverizerRecipe(GT_Utility.copyAmount(1L, aOreStack), Materials.Mercury.getFluid(1800L), Materials.SluiceJuice.getFluid(1400L), new ItemStack[]{GT_Utility.mul(2L, tGCleaned), tMaterial.contains(SubTag.PULVERIZING_CINNABAR) ? GT_OreDictUnificator.get(OrePrefixes.crystal, Materials.Cinnabar, GT_OreDictUnificator.get(OrePrefixes.gem, tPrimaryByMaterial, GT_Utility.copyAmount(1L, tPrimaryByProduct), 1L), 1L) : GT_OreDictUnificator.get(OrePrefixes.gem, tPrimaryByMaterial, GT_Utility.copyAmount(1L, tPrimaryByProduct), 1L), GT_OreDictUnificator.get(OrePrefixes.dust, aMaterial.mMacerateInto, 2L), GT_OreDictUnificator.getDust(aPrefix.mSecondaryMaterial)}, new int[]{10000, 1000, 7000, 5000}, 200, 60);
            if (aMaterial.contains(SubTag.WASHING_SODIUMPERSULFATE))
                GT_Values.RA.addIndustrialPulverizerRecipe(GT_Utility.copyAmount(1L, aOreStack), Materials.SodiumPersulfate.getFluid(1800L), Materials.SluiceJuice.getFluid(1400L), new ItemStack[]{GT_Utility.mul(2L, tGCleaned), tMaterial.contains(SubTag.PULVERIZING_CINNABAR) ? GT_OreDictUnificator.get(OrePrefixes.crystal, Materials.Cinnabar, GT_OreDictUnificator.get(OrePrefixes.gem, tPrimaryByMaterial, GT_Utility.copyAmount(1L, tPrimaryByProduct), 1L), 1L) : GT_OreDictUnificator.get(OrePrefixes.gem, tPrimaryByMaterial, GT_Utility.copyAmount(1L, tPrimaryByProduct), 1L), GT_OreDictUnificator.get(OrePrefixes.dust, aMaterial.mMacerateInto, 2L), GT_OreDictUnificator.getDust(aPrefix.mSecondaryMaterial)}, new int[]{10000, 1000, 7000, 5000}, 200, 60);
            for (Materials tMaterials : aMaterial.mOreByProducts) {
                if (tMaterials.contains(SubTag.WASHING_MERCURY))
                    GT_Values.RA.addIndustrialPulverizerRecipe(GT_Utility.copyAmount(1L, aOreStack), Materials.Mercury.getFluid(1800L), Materials.SluiceJuice.getFluid(1400L), new ItemStack[]{GT_Utility.mul(2L, tGCleaned), tMaterial.contains(SubTag.PULVERIZING_CINNABAR) ? GT_OreDictUnificator.get(OrePrefixes.crystal, Materials.Cinnabar, GT_OreDictUnificator.get(OrePrefixes.gem, tPrimaryByMaterial, GT_Utility.copyAmount(1L, tPrimaryByProduct), 1L), 1L) : GT_OreDictUnificator.get(OrePrefixes.gem, tPrimaryByMaterial, GT_Utility.copyAmount(1L, tPrimaryByProduct), 1L), GT_OreDictUnificator.get(OrePrefixes.dust, tMaterial.mMacerateInto, 2L), GT_OreDictUnificator.getDust(aPrefix.mSecondaryMaterial)}, new int[]{10000, 1000, 7000, 5000}, 200, 60);
                if (tMaterials.contains(SubTag.WASHING_SODIUMPERSULFATE))
                    GT_Values.RA.addIndustrialPulverizerRecipe(GT_Utility.copyAmount(1L, aOreStack), Materials.SodiumPersulfate.getFluid(1800L), Materials.SluiceJuice.getFluid(1400L), new ItemStack[]{GT_Utility.mul(2L, tGCleaned), tMaterial.contains(SubTag.PULVERIZING_CINNABAR) ? GT_OreDictUnificator.get(OrePrefixes.crystal, Materials.Cinnabar, GT_OreDictUnificator.get(OrePrefixes.gem, tPrimaryByMaterial, GT_Utility.copyAmount(1L, tPrimaryByProduct), 1L), 1L) : GT_OreDictUnificator.get(OrePrefixes.gem, tPrimaryByMaterial, GT_Utility.copyAmount(1L, tPrimaryByProduct), 1L), GT_OreDictUnificator.get(OrePrefixes.dust, tMaterial.mMacerateInto, 2L), GT_OreDictUnificator.getDust(aPrefix.mSecondaryMaterial)}, new int[]{10000, 1000, 7000, 5000}, 200, 60);
            }
        }
        return true;
    }
}
