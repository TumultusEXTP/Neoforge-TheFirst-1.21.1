package com.stonehill.thefirst.datagen;

import com.stonehill.thefirst.TheFirst;
import com.stonehill.thefirst.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TheFirst.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.BISMUTH.get());
        basicItem(ModItems.RAW_BISMUTH.get());
        basicItem(ModItems.RADISH.get());
        basicItem(ModItems.FROSTFIRE_ICE.get());
        basicItem(ModItems.STARLIGHT_ASHES.get());
        basicItem(ModItems.CHISEL.get());
    }
}
