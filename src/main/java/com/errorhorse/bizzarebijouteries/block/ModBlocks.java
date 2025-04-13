package com.errorhorse.bizzarebijouteries.block;

import com.errorhorse.bizzarebijouteries.block.custom.BarrelOfBoats;
import com.errorhorse.bizzarebijouteries.block.custom.MagicalBarrelBlock;
import com.errorhorse.bizzarebijouteries.items.ModItems;
import com.errorhorse.bizzarebijouteries.BizzareBijouteries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(BizzareBijouteries.MODID);

    public static final DeferredBlock<Block> BARREL_OF_BOATS = registerBlock("barrel_of_boats",
            () -> new BarrelOfBoats(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(2.5F).sound(SoundType.WOOD).ignitedByLava()));

    public static final DeferredBlock<Block> MAGICAL_BARREL = BLOCKS.register("magical_barrel",
            () -> new MagicalBarrelBlock(BlockBehaviour.Properties.of(Blocks.BARREL).noLootTable()));

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block)
        {DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
        }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}