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

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if(entity instanceof ItemEntity itemEntity) {

            if(!(isNihil(itemEntity.getItem()) || isIncontinuitous(itemEntity.getItem()))){
                itemEntity.setItem(new ItemStack(Items.BLACK_DYE, itemEntity.getItem().getCount()));

            } else if(itemEntity.getItem().getItem() == ModBlocks.NIHIL_BLOCK.asItem()){
                itemEntity.setItem(new ItemStack(ModBlocks.INCONTINUITOUS_BLOCK, itemEntity.getItem().getCount()));
            }
        }
        super.entityInside(state, level, pos, entity);
    }

    private boolean isNihil(ItemStack item) {
        return item.is(ModTags.Items.NIHIL_ITEMS);
    }

    private boolean isIncontinuitous(ItemStack item) {
        return item.is(ModTags.Items.INCONTINUITOUS_ITEMS);
    }
}
