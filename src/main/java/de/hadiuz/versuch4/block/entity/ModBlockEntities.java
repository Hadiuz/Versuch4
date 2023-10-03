package de.hadiuz.versuch4.block.entity;

import de.hadiuz.versuch4.Versuch4;
import de.hadiuz.versuch4.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Versuch4.MOD_ID);

    public static final RegistryObject<BlockEntityType<FakedronEntity>> FAKEDRON =
            BLOCK_ENTITIES.register("fakedron", () ->
                    BlockEntityType.Builder.of(FakedronEntity::new, ModBlocks.FAKEDRON.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}