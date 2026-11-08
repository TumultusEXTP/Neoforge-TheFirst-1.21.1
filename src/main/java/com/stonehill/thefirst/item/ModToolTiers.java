package com.stonehill.thefirst.item;

import com.stonehill.thefirst.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {

    public static final Tier BISMUTH = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_BISMUTH_TOOL,
            1400, 4f, 3f, 28, () -> Ingredient.of(ModItems.BISMUTH));

    public static final Tier INCONTINUITOUS = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_INCONTINUITOUS_TOOL,
            2048, 10f, 5f, 6, () -> Ingredient.of(ModItems.INCONTINUITOUS_SHARD));
}

