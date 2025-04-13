package com.errorhorse.bizzarebijouteries.block.entity;

import com.errorhorse.bizzarebijouteries.BizzareBijouteries;
import com.errorhorse.bizzarebijouteries.block.ModBlocks;
import com.errorhorse.bizzarebijouteries.block.custom.BarrelOfBoats;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.BarrelBlock;
import net.minecraft.world.level.block.entity.BarrelBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, BizzareBijouteries.MODID);

    public static final Supplier<BlockEntityType<BarrelOfBoatsBlockEntity>> BARRELOFBOATS_BE =
            BLOCK_ENTITIES.register("barrelofboats_be", () -> BlockEntityType.Builder.of(BarrelOfBoatsBlockEntity::new, ModBlocks.BARREL_OF_BOATS.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
