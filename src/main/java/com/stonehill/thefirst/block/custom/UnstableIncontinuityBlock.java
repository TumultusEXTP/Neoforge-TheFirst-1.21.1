package com.stonehill.thefirst.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class UnstableIncontinuityBlock extends Block {
    public UnstableIncontinuityBlock(Properties properties) {
        super(properties);
    }

    //not working
    @Override
    protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, BlockPos neighborPos, boolean movedByPiston) {
        if(!level.isClientSide) {
            if(level.hasNeighborSignal(pos)) {
                level.explode(null,  pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                        8, Level.ExplosionInteraction.BLOCK);
            }
        }
    }

    @Override
    protected void onProjectileHit(Level level, BlockState state, BlockHitResult hit, Projectile projectile) {
        if(!level.isClientSide) {
            level.explode(null, projectile.getX(), projectile.getY(), projectile.getZ(),
                    6, Level.ExplosionInteraction.BLOCK);
        }
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if(!level.isClientSide) {
            level.explode(null, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                    4, Level.ExplosionInteraction.BLOCK);
        }
    }

    @Override
    public void wasExploded(Level level, BlockPos pos, Explosion explosion) {
        if(!level.isClientSide) {
            level.explode(null, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                    8, Level.ExplosionInteraction.BLOCK);
        }
    }
}
