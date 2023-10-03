package de.hadiuz.versuch4.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class FakedronEntity extends BlockEntity {
    public FakedronEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.FAKEDRON.get(), pPos, pBlockState);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, FakedronEntity pEntity) {
        if(level.isClientSide()) {
            return;
        }
    }
}
