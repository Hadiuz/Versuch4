package de.hadiuz.versuch4.event;

import de.hadiuz.versuch4.Versuch4;
import de.hadiuz.versuch4.block.entity.ModBlockEntities;
import de.hadiuz.versuch4.block.entity.renderer.FakedronRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
public class ClientEvents {
    @Mod.EventBusSubscriber(modid = Versuch4.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
        }
    }


        @SubscribeEvent
        public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntities.FAKEDRON.get(), FakedronRenderer::new);
        }
    }