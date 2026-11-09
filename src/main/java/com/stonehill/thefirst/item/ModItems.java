package com.stonehill.thefirst.item;

import com.stonehill.thefirst.TheFirst;
import com.stonehill.thefirst.block.ModBlocks;
import com.stonehill.thefirst.item.custom.*;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TheFirst.MODID);

    //armor
    public static final DeferredItem<ArmorItem> DISMAL_HELMET = ITEMS.register("dismal_helmet",
            () -> new ModArmorItem(ModArmorMaterials.DISMAL_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(32))));
    public static final DeferredItem<ArmorItem> DISMAL_CHESTPLATE = ITEMS.register("dismal_chestplate",
            () -> new ArmorItem(ModArmorMaterials.DISMAL_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(32))));
    public static final DeferredItem<ArmorItem> DISMAL_LEGGINGS = ITEMS.register("dismal_leggings",
            () -> new ArmorItem(ModArmorMaterials.DISMAL_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(32))));
    public static final DeferredItem<ArmorItem> DISMAL_BOOTS = ITEMS.register("dismal_boots",
            () -> new ArmorItem(ModArmorMaterials.DISMAL_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(32))));

    //incontinuitous tool set
    public static final DeferredItem<SwordItem> INCONTINUITOUS_SWORD = ITEMS.register("incontinuitous_sword",
            () -> new SwordItem(ModToolTiers.INCONTINUITOUS, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.INCONTINUITOUS, 3, -1f))));
    public static final DeferredItem<AxeItem> INCONTINUITOUS_AXE = ITEMS.register("incontinuitous_axe",
            () -> new AxeItem(ModToolTiers.INCONTINUITOUS, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.INCONTINUITOUS, 6f, -2.4f))));
    public static final DeferredItem<PickaxeItem> INCONTINUITOUS_PICKAXE = ITEMS.register("incontinuitous_pickaxe",
            () -> new PickaxeItem(ModToolTiers.INCONTINUITOUS, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.INCONTINUITOUS, 1f, -2.4f))));
    public static final DeferredItem<ShovelItem> INCONTINUITOUS_SHOVEL = ITEMS.register("incontinuitous_shovel",
            () -> new ShovelItem(ModToolTiers.INCONTINUITOUS, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.INCONTINUITOUS, 1.5f, -2.5f))));
    public static final DeferredItem<HoeItem> INCONTINUITOUS_HOE = ITEMS.register("incontinuitous_hoe",
            () -> new HoeItem(ModToolTiers.INCONTINUITOUS, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.INCONTINUITOUS, 0f, -2f))));

    //tools
    public static final DeferredItem<Item> INCONTINUITOUS_BLOOM = ITEMS.register("incontinuitous_bloom",
            () -> new IncontinuitousBloomItem(
                    new Item.Properties()
                            .durability(127)
            )
    );

    public static final DeferredItem<Item> NIHIL_BUCKET = ITEMS.register("nihil_bucket",
            () -> new SolidBucketItem(
                    ModBlocks.NIHIL_BLOCK.get(),
                    SoundEvents.EMPTY,
                    new Item.Properties()
                            .stacksTo(1)
            )
    );

    //ingredients
    public static final DeferredItem<Item> INCONTINUITOUS_SHARD = ITEMS.register("incontinuitous_shard",
            () -> new Item(new Item.Properties())
    );

    public static final DeferredItem<Item> NIHILITY = ITEMS.register("nihility",
            () -> new Item(new Item.Properties())
    );

    /*

    !!!! REMOVE THE FOLLOWING ITEMS WHEN DONE WITH TUTORIAL !!!!

     */

    //bismuth
    public static final DeferredItem<Item> BISMUTH = ITEMS.register("bismuth",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_BISMUTH = ITEMS.register("raw_bismuth",
            () -> new Item(new Item.Properties()));

    //chisel
    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)));

    //radish
    public static final DeferredItem<Item> RADISH = ITEMS.register("radish",
            () -> new Item(new Item.Properties().food(ModFoodProperties.RADISH)) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.oiprotoikosmoi.radish.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    //fuels
    public static final DeferredItem<Item> FROSTFIRE_ICE = ITEMS.register("frostfire_ice",
            () -> new FuelItem(new Item.Properties(), 800));
    public static final DeferredItem<Item> STARLIGHT_ASHES = ITEMS.register("starlight_ashes",
            () -> new Item(new Item.Properties()));

    //bismuth tools
    public static final DeferredItem<SwordItem> BISMUTH_SWORD = ITEMS.register("bismuth_sword",
            () -> new SwordItem(ModToolTiers.BISMUTH, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.BISMUTH, 5, -2.4f))));
    public static final DeferredItem<PickaxeItem> BISMUTH_PICKAXE = ITEMS.register("bismuth_pickaxe",
            () -> new PickaxeItem(ModToolTiers.BISMUTH, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.BISMUTH, 1f, -3f))));
    public static final DeferredItem<AxeItem> BISMUTH_AXE = ITEMS.register("bismuth_axe",
            () -> new AxeItem(ModToolTiers.BISMUTH, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.BISMUTH, 6f, -3.2f))));
    public static final DeferredItem<ShovelItem> BISMUTH_SHOVEL = ITEMS.register("bismuth_shovel",
            () -> new ShovelItem(ModToolTiers.BISMUTH, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.BISMUTH, 1.5f, -2.8f))));
    public static final DeferredItem<HoeItem> BISMUTH_HOE = ITEMS.register("bismuth_hoe",
            () -> new HoeItem(ModToolTiers.BISMUTH, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.BISMUTH, 0f, -3f))));

    public static final DeferredItem<HammerItem> BISMUTH_HAMMER = ITEMS.register("bismuth_hammer",
            () -> new HammerItem(ModToolTiers.BISMUTH, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.BISMUTH, 7f, -3.5f))));

    //bismuth armor
    public static final DeferredItem<ArmorItem> BISMUTH_HELMET = ITEMS.register("bismuth_helmet",
            () -> new ModArmorItem(ModArmorMaterials.BISMUTH_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(19))));
    public static final DeferredItem<ArmorItem> BISMUTH_CHESTPLATE = ITEMS.register("bismuth_chestplate",
            () -> new ArmorItem(ModArmorMaterials.BISMUTH_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(19))));
    public static final DeferredItem<ArmorItem> BISMUTH_LEGGINGS = ITEMS.register("bismuth_leggings",
            () -> new ArmorItem(ModArmorMaterials.BISMUTH_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(19))));
    public static final DeferredItem<ArmorItem> BISMUTH_BOOTS = ITEMS.register("bismuth_boots",
            () -> new ArmorItem(ModArmorMaterials.BISMUTH_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(19))));

    public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
