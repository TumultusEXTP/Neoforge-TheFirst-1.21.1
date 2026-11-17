package com.stonehill.thefirst.util;

import com.stonehill.thefirst.TheFirst;
import com.stonehill.thefirst.component.ModDataComponents;
import com.stonehill.thefirst.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public class ModItemProperties {
    public static void addCustomItemProperties() {
        ItemProperties.register(ModItems.CHISEL.get(), ResourceLocation.fromNamespaceAndPath(TheFirst.MODID, "used"),
                (stack, level, entity, seed) -> stack.get(ModDataComponents.COORDINATES) != null ? 1f : 0f);
    }
}
