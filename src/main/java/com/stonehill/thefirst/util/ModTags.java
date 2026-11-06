package com.stonehill.thefirst.util;

import com.stonehill.thefirst.TheFirst;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static class Blocks {

        public static final TagKey<Block> NEEDS_BISMUTH_TOOL = createTag("needs_bismuth_tool");
        public static final TagKey<Block> INCORRECT_FOR_BISMUTH_TOOL = createTag("incorrect_for_bismuth_tool");

        public static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(TheFirst.MODID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> NIHIL_ITEMS = createTag("nihil_items");
        public static final TagKey<Item> INCONTINUITOUS_ITEMS = createTag("incontinuitous_items");

        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        public static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(TheFirst.MODID, name));
        }
    }
}
