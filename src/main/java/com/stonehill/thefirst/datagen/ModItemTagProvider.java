package com.stonehill.thefirst.datagen;

import com.stonehill.thefirst.TheFirst;
import com.stonehill.thefirst.block.ModBlocks;
import com.stonehill.thefirst.item.ModItems;
import com.stonehill.thefirst.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, TheFirst.MODID, existingFileHelper);
    }



    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(ModTags.Items.NIHIL_ITEMS)
                .add(ModBlocks.NIHIL_BLOCK.get().asItem())
                .add(ModItems.NIHILITY.get());

        tag(ModTags.Items.INCONTINUITOUS_ITEMS)
                .add(ModBlocks.INCONTINUITOUS_BLOCK.get().asItem())
                .add(ModItems.INCONTINUITOUS_BLOOM.get())
                .add(ModItems.INCONTINUITOUS_SHARD.get())
                .add(ModBlocks.UNSTABLE_INCONTINUITY_BLOCK.get().asItem());

        tag(Tags.Items.BUCKETS)
                .add(ModItems.NIHIL_BUCKET.asItem());

        //remove below after tutorial
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(Items.COAL)
                .add(Items.STICK)
                .add(Items.COMPASS)
                .add(ModItems.BISMUTH.get())
                .add(ModItems.RAW_BISMUTH.get());

        tag(ItemTags.SWORDS)
                .add(ModItems.BISMUTH_SWORD.get());
        tag(ItemTags.AXES)
                .add(ModItems.BISMUTH_AXE.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.BISMUTH_PICKAXE.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.BISMUTH_SHOVEL.get());
        tag(ItemTags.HOES)
                .add(ModItems.BISMUTH_HOE.get());
    }
}
