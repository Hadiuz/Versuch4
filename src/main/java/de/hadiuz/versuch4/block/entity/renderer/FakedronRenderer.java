package de.hadiuz.versuch4.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import de.hadiuz.versuch4.block.ModBlocks;
import de.hadiuz.versuch4.block.entity.FakedronEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;

import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.joml.Quaternionf;


public class FakedronRenderer implements BlockEntityRenderer<FakedronEntity> {
    public FakedronRenderer(BlockEntityRendererProvider.Context context){

    }

    @Override
    public void render(FakedronEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack itemStack = new ItemStack(ModBlocks.SOAP_WATER_BLOCK.get());

        pPoseStack.pushPose();
        pPoseStack.translate(0.5f, 0.65f, 0.5f);
        pPoseStack.scale(0.25f, 0.25f, 0.25f);
        pPoseStack.mulPose(new Quaternionf());
        itemRenderer.renderStatic(itemStack, ItemDisplayContext.GUI, 1, OverlayTexture.NO_OVERLAY, pPoseStack, pBuffer, null , 1);
        pPoseStack.popPose();


    }
}
