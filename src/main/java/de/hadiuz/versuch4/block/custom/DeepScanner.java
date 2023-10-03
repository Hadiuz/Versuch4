package de.hadiuz.versuch4.block.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class DeepScanner extends Block {
    public DeepScanner(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        int xDifference = (pPos.getX()%16+16)%16;
        int zDifference = (pPos.getZ()%16+16)%16;
        int xStart = pPos.getX()-xDifference;
        int zStart = pPos.getZ()-zDifference;
        int xEnd = pPos.getX()+15-xDifference;
        int zEnd = pPos.getZ()+15-zDifference;
        int y = pPos.getY();
        boolean foundBlock = false;
        for (int i = xStart; i < xEnd; i++) {
            for (int j = zStart; j < zEnd; j++) {
                BlockPos pos = new BlockPos(i, y, j);
                for (int k = 0; k <= y + 64; k++) {
                    BlockState state = pLevel.getBlockState(pos.below(k));

                    if (isValuableBlock(state)) {
                        outputValuableCoordinates(pos.below(i), pPlayer, state.getBlock());
                        foundBlock = true;

                    }
                }
            }
        }

        if(!foundBlock) {
            pPlayer.sendSystemMessage(Component.literal("No valuables Found!"));
        }
        return  InteractionResult.SUCCESS;
    }
    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Found " + I18n.get(block.getDescriptionId()) + " at " +
                "(" + blockPos.getX() + ", " + blockPos.getY() + "," + blockPos.getZ() + ")"));
    }

    private boolean isValuableBlock(BlockState state) {
        String s = state.getBlock().getName().toString();
        String ore = s.substring(s.length()-14, s.length()-11);
        return ore.equals("ore");
    }

}

