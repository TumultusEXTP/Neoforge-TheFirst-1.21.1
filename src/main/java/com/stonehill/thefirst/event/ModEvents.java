package com.stonehill.thefirst.event;

import com.stonehill.thefirst.TheFirst;
import com.stonehill.thefirst.block.ModBlocks;
import com.stonehill.thefirst.item.custom.HammerItem;
import com.stonehill.thefirst.item.custom.IncontinuitousBloomItem;
import com.stonehill.thefirst.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.HashSet;
import java.util.Set;

@EventBusSubscriber(modid = TheFirst.MODID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {

    //guess this is useless
    //private static final Set<BlockPos> BLOOM_PORTAL_FRAME = new HashSet<>();

    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    //no idea if this works (probably doesn't); I have tendencies to bite off more than I can chew
    //so I didn't completely ruin it, but it doesn't allow me to use the boolean
    //second attempt, this one after inquiring with whatever Google uses, it seems to work
    @SubscribeEvent
    public static void onBloomUsage(PlayerInteractEvent.RightClickBlock event) {

        Player player = event.getEntity();
        ItemStack mainHandItem = player.getMainHandItem();
        Level level = event.getLevel();
        BlockPos initialBlockPos = event.getPos();


        //is player holding bloom and using on bedrock
        if (mainHandItem.getItem() instanceof IncontinuitousBloomItem bloom
                && level.getBlockState(initialBlockPos).is(Blocks.BEDROCK)
                && player instanceof ServerPlayer serverPlayer) {

            //not sure why this wouldn't cooperate
            //boolean isProperSetup = true;

            //is proper setup
            for (BlockPos pos : IncontinuitousBloomItem.getBlocksForFrame(1, initialBlockPos, serverPlayer)) {

                BlockState state = level.getBlockState(pos);

                //isn't proper setup
                if (!state.is(ModTags.Blocks.INCONTINUITY_PORTAL_BLOCKS)) {return;}

                /*
                   //is proper frame material (why doesn't this let me use ModTags.Blocks.INCONTINUITY_PORTAL_BLOCKS?)
                   if (level.getBlockState(initialBlockPos).getBlock() == Blocks.BEDROCK
                        || level.getBlockState(initialBlockPos).getBlock() == ModBlocks.NIHIL_BLOCK.get()) {
                    isProperSetup = true;
                    continue;
                } else {
                    isProperSetup = false;
                    return;
                }*/
            }

            //was proper setup
            if (!level.isClientSide()) {

                level.setBlockAndUpdate(initialBlockPos, ModBlocks.NIHIL_BLOCK.get().defaultBlockState());

                mainHandItem.hurtAndBreak(1, (ServerLevel) level, serverPlayer,
                        item -> serverPlayer.onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, initialBlockPos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS);
            }
        }
    }

    // Done with the help of https://github.com/CoFH/CoFHCore/blob/1.19.x/src/main/java/cofh/core/event/AreaEffectEvents.java
    // Don't be a jerk License
    @SubscribeEvent
    public static void onHammerUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if (mainHandItem.getItem() instanceof HammerItem hammer && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if (HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            for (BlockPos pos : HammerItem.getBlocksToBeDestroyed(1, initialBlockPos, serverPlayer)) {
                if (pos == initialBlockPos || !hammer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }
    }

    @SubscribeEvent
    public static void livingDamage(LivingDamageEvent.Pre event) {
        if (event.getEntity() instanceof Sheep sheep && event.getSource().getDirectEntity() instanceof Player player) {
            if (player.getMainHandItem().getItem() == Items.END_ROD) {
                player.sendSystemMessage(Component.literal(player.getName().getString() + " just hit a sheep with an END ROD? YOU SICK FRICK! - Kaupenjoe, 2024"));
                sheep.addEffect(new MobEffectInstance(MobEffects.POISON, 600, 6));
                player.getMainHandItem().shrink(1);
            }
        }
    }
}
