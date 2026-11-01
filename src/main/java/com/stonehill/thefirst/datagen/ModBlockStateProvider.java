package com.stonehill.thefirst.datagen;

import com.stonehill.thefirst.TheFirst;
import com.stonehill.thefirst.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output,ExistingFileHelper existingFileHelper) {
        super(output, TheFirst.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.BISMUTH_BLOCK);
        blockWithItem(ModBlocks.BISMUTH_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_BISMUTH_ORE);
        blockWithItem(ModBlocks.MAGIC_BLOCK);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
