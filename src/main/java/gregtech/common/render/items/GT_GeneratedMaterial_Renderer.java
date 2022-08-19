package gregtech.common.render.items;

import gregtech.api.interfaces.IIconContainer;
import gregtech.api.items.GT_MetaGenerated_Item;
import gregtech.api.util.GT_Utility;
import gregtech.common.render.GT_RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.fluids.FluidStack;
import org.lwjgl.opengl.GL11;

public class GT_GeneratedMaterial_Renderer implements IItemRenderer {

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return type == ItemRenderType.EQUIPPED
            || type == ItemRenderType.EQUIPPED_FIRST_PERSON
            || type == ItemRenderType.INVENTORY
            || type == ItemRenderType.ENTITY;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return type == ItemRenderType.ENTITY;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack aStack, Object... data) {
        short aMetaData = (short) aStack.getItemDamage();
        GT_MetaGenerated_Item aItem = (GT_MetaGenerated_Item) aStack.getItem();

        IIconContainer aIconContainer = aItem.getIconContainer(aMetaData);

        if (aIconContainer == null) {
            return;
        }

        IIcon tIcon = aIconContainer.getIcon();
        IIcon tOverlay = aIconContainer.getOverlayIcon();

        if (tIcon != null) {
            renderRegularItem(type, aStack, tIcon);
        }

        FluidStack aFluid = GT_Utility.getFluidForFilledItem(aStack, true);
        if (tOverlay != null && aFluid != null && aFluid.getFluid() != null) {
            IIcon fluidIcon = aFluid.getFluid().getIcon(aFluid);
            if (fluidIcon != null) {
                renderContainedFluid(type, aFluid, fluidIcon);
            }
        }

        if (tOverlay != null) {
            GL11.glColor3f(1.0F, 1.0F, 1.0F);
            Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationItemsTexture);
            if (type.equals(IItemRenderer.ItemRenderType.INVENTORY)) {
                GT_RenderUtil.renderItemIcon(tOverlay, 16.0D, 0.001D, 0.0F, 0.0F, -1.0F);
            } else {
                ItemRenderer.renderItemIn2D(Tessellator.instance, tOverlay.getMaxU(), tOverlay.getMinV(), tOverlay.getMinU(), tOverlay.getMaxV(), tOverlay.getIconWidth(), tOverlay.getIconHeight(), 0.0625F);
            }
        }
    }

    public void renderRegularItem(ItemRenderType type, ItemStack aStack, IIcon icon) {
        GT_MetaGenerated_Item aItem = (GT_MetaGenerated_Item) aStack.getItem();

        enableBlendingItemTexture();

        short[] tModulation = aItem.getRGBa(aStack);
        GL11.glColor3f(tModulation[0] / 255.0F, tModulation[1] / 255.0F, tModulation[2] / 255.0F);
        Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationItemsTexture);

        if (type.equals(IItemRenderer.ItemRenderType.INVENTORY)) {
            GT_RenderUtil.renderItemIcon(icon, 16.0D, 0.001D, 0.0F, 0.0F, -1.0F);
        } else {
            ItemRenderer.renderItemIn2D(Tessellator.instance, icon.getMaxU(), icon.getMinV(), icon.getMinU(), icon.getMaxV(), icon.getIconWidth(), icon.getIconHeight(), 0.0625F);
        }

        GL11.glDisable(GL11.GL_BLEND);
    }

    public void renderContainedFluid(ItemRenderType type, FluidStack tFluid, IIcon fluidIcon) {
        enableBlendingItemTexture();

        int tColor = tFluid.getFluid().getColor(tFluid);
        GL11.glColor3f((tColor >> 16 & 0xFF) / 255.0F, (tColor >> 8 & 0xFF) / 255.0F, (tColor & 0xFF) / 255.0F);
        Minecraft.getMinecraft().renderEngine.bindTexture(TextureMap.locationBlocksTexture);

        GL11.glDepthFunc(GL11.GL_EQUAL);
        if (type.equals(IItemRenderer.ItemRenderType.INVENTORY)) {
            GT_RenderUtil.renderItemIcon(fluidIcon, 16.0D, 0.001D, 0.0F, 0.0F, -1.0F);
        } else {
            ItemRenderer.renderItemIn2D(Tessellator.instance, fluidIcon.getMaxU(), fluidIcon.getMinV(), fluidIcon.getMinU(), fluidIcon.getMaxV(), fluidIcon.getIconWidth(), fluidIcon.getIconHeight(), 0.0625F);
        }
        GL11.glDepthFunc(GL11.GL_LEQUAL);

        GL11.glDisable(GL11.GL_BLEND);
    }

    protected void enableBlendingItemTexture() {
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glColor3f(1.0F, 1.0F, 1.0F);
    }

}