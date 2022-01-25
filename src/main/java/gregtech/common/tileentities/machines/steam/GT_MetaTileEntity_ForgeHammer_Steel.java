package gregtech.common.tileentities.machines.steam;

import gregtech.api.GregTech_API;
import gregtech.api.enums.Textures;
import gregtech.api.gui.GT_GUIContainer_BasicMachine;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_BasicMachine_Steel;

import gregtech.api.render.TextureFactory;
import gregtech.api.util.GT_Recipe;
import gregtech.api.util.GT_Utility;
import net.minecraft.entity.player.InventoryPlayer;

import static gregtech.api.enums.Textures.BlockIcons.*;

public class GT_MetaTileEntity_ForgeHammer_Steel extends GT_MetaTileEntity_BasicMachine_Steel {
    public GT_MetaTileEntity_ForgeHammer_Steel(int aID, String aName, String aNameRegional) {
        super(aID, aName, aNameRegional, "Forge Hammer", 1, 1, false);
    }

    public GT_MetaTileEntity_ForgeHammer_Steel(String aName, String aDescription, ITexture[][][] aTextures) {
        super(aName, aDescription, aTextures, 1, 1, false);
    }

    public GT_MetaTileEntity_ForgeHammer_Steel(String aName, String[] aDescription, ITexture[][][] aTextures) {
        super(aName, aDescription, aTextures, 1, 1, false);
    }

    public MetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new GT_MetaTileEntity_ForgeHammer_Steel(this.mName, this.mDescriptionArray, this.mTextures);
    }

    public Object getClientGUI(int aID, InventoryPlayer aPlayerInventory, IGregTechTileEntity aBaseMetaTileEntity) {
        return new GT_GUIContainer_BasicMachine(aPlayerInventory, aBaseMetaTileEntity, getLocalName(), "SteelHammer.png", GT_Recipe.GT_Recipe_Map.sHammerRecipes.mUnlocalizedName, (byte) 6, (byte) 3);
    }

    public int checkRecipe() {
        GT_Recipe tRecipe = GT_Recipe.GT_Recipe_Map.sHammerRecipes.findRecipe(getBaseMetaTileEntity(), false, gregtech.api.enums.GT_Values.V[2], null, getAllInputs());
        if ((tRecipe != null) && (canOutput(tRecipe.mOutputs)) && (tRecipe.isRecipeInputEqual(true, null, getAllInputs()))) {
            this.mOutputItems[0] = tRecipe.getOutput(0);
            this.mEUt = (tRecipe.mEUt * 2);
            this.mMaxProgresstime = tRecipe.mDuration;
            return 2;
        }
        return 0;
    }

    public void startSoundLoop(byte aIndex, double aX, double aY, double aZ) {
        super.startSoundLoop(aIndex, aX, aY, aZ);
        if (aIndex == 1) {
            GT_Utility.doSoundAtClient((String) GregTech_API.sSoundList.get(Integer.valueOf(1)), 10, 1.0F, aX, aY, aZ);
        }
    }

    public void startProcess() {
        sendLoopStart((byte) 1);
    }
    
    @Override
    public ITexture[] getSideFacingActive(byte aColor) {
        return new ITexture[]{
                super.getSideFacingActive(aColor)[0],
                TextureFactory.of(OVERLAY_SIDE_STEAM_HAMMER_ACTIVE)};
    }
    
    @Override
    public ITexture[] getSideFacingInactive(byte aColor) {
        return new ITexture[]{
                super.getSideFacingInactive(aColor)[0],
                TextureFactory.of(OVERLAY_SIDE_STEAM_HAMMER)};
    }
    
    @Override
    public ITexture[] getFrontFacingActive(byte aColor) {
        return new ITexture[]{
                super.getFrontFacingActive(aColor)[0],
                TextureFactory.of(OVERLAY_FRONT_STEAM_HAMMER_ACTIVE),
                TextureFactory.builder().addIcon(OVERLAY_FRONT_STEAM_HAMMER_ACTIVE_GLOW).glow().build()};
    }
    
    @Override
    public ITexture[] getFrontFacingInactive(byte aColor) {
        return new ITexture[]{
                super.getFrontFacingInactive(aColor)[0],
                TextureFactory.of(OVERLAY_FRONT_STEAM_HAMMER)};
    }
    
    @Override
    public ITexture[] getTopFacingActive(byte aColor) {
        return new ITexture[]{
                super.getTopFacingActive(aColor)[0],
                TextureFactory.of(OVERLAY_TOP_STEAM_HAMMER_ACTIVE)};
    }
    
    @Override
    public ITexture[] getTopFacingInactive(byte aColor) {
        return new ITexture[]{
                super.getTopFacingInactive(aColor)[0],
                TextureFactory.of(OVERLAY_TOP_STEAM_HAMMER)};
    }
    
    @Override
    public ITexture[] getBottomFacingActive(byte aColor) {
        return new ITexture[]{
                super.getBottomFacingActive(aColor)[0],
                TextureFactory.of(OVERLAY_BOTTOM_STEAM_HAMMER_ACTIVE)};
    }
    
    @Override
    public ITexture[] getBottomFacingInactive(byte aColor) {
        return new ITexture[]{
                super.getBottomFacingInactive(aColor)[0],
                TextureFactory.of(OVERLAY_BOTTOM_STEAM_HAMMER)};
    }
}
