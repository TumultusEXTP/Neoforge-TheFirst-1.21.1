package com.stonehill.thefirst.trim;

import com.stonehill.thefirst.TheFirst;
import com.stonehill.thefirst.item.ModItems;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;

import java.util.Map;

public class ModTrimMaterials {

    public static final ResourceKey<TrimMaterial> NIHILITY =
            ResourceKey.create(Registries.TRIM_MATERIAL, ResourceLocation.fromNamespaceAndPath(TheFirst.MODID, "nihility"));

    public static final ResourceKey<TrimMaterial> BISMUTH =
            ResourceKey.create(Registries.TRIM_MATERIAL, ResourceLocation.fromNamespaceAndPath(TheFirst.MODID, "bismuth"));

    public static void bootstrap(BootstrapContext<TrimMaterial> context) {
        register(context, NIHILITY, ModItems.NIHILITY.get(), Style.EMPTY.withColor(TextColor.parseColor("#000000").getOrThrow()), 0.3f);

        register(context, BISMUTH, ModItems.BISMUTH.get(), Style.EMPTY.withColor(TextColor.parseColor("#031cfc").getOrThrow()), 0.5f);
    }

    private static void register(BootstrapContext<TrimMaterial> context, ResourceKey<TrimMaterial> trimKey, Item item,
                                 Style style, float itemModelIndex) {
        TrimMaterial trimMaterial = TrimMaterial.create(trimKey.location().getPath(), item, itemModelIndex,
                Component.translatable(Util.makeDescriptionId("trim_material", trimKey.location())).withStyle(style), Map.of());
        context.register(trimKey, trimMaterial);
    }
}
