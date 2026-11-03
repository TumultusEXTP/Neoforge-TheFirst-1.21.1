package com.stonehill.thefirst.block.custom;

import com.stonehill.thefirst.block.ModBlocks;
import com.stonehill.thefirst.item.ModItems;
import com.stonehill.thefirst.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class NihilBlock extends Block {
    public NihilBlock(Properties properties) {
        super(properties);
    }

    /*
    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if(entity instanceof ItemEntity itemEntity) {
            if(!(isNihil(itemEntity.getItem()) || isIncontinuitous(itemEntity.getItem()))){
                itemEntity.setItem(new ItemStack(Items.BLACK_DYE, itemEntity.getItem().getCount()));
            } else if(isNihil(itemEntity.getItem())){
                itemEntity.setItem(new ItemStack(ModBlocks.INCONTINUITOUS_BLOCK, itemEntity.getItem().getCount()));
            }
        }
        super.entityInside(state, level, pos, entity);
    }
    */

    /*@Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if(entity instanceof ItemEntity itemEntity) {
            if(true*itemEntity.getItem().getItem() == Items.DANDELION*) {
                //itemEntity.setItem(new ItemStack(Items.WITHER_ROSE, itemEntity.getItem().getCount()));
                itemEntity.hurt(level.damageSources().cactus(), 1.0F);
            }
        }
        //super.entityInside(state, level, pos, entity);
    }*/

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity itemEntity) {
            /*if(isNihil(itemEntity.getItem())) {
                itemEntity.setItem(new ItemStack(Items.DIAMOND, itemEntity.getItem().getCount()));
            }*/

            if(true) {
                itemEntity.setItem(new ItemStack(Items.WITHER_ROSE, itemEntity.getItem().getCount()));
            }
        }
        super.stepOn(level, pos, state, entity);
    }

    private boolean isNihil(ItemStack item) {
        return item.is(ModTags.Items.NIHIL_ITEMS);
    }

    private boolean isIncontinuitous(ItemStack item) {
        return item.is(ModTags.Items.INCONTINUITOUS_ITEMS);
    }
}
