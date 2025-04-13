package com.errorhorse.bizzarebijouteries.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;

public class BarrelOfBoatsBlockEntity extends BlockEntity {
    public final ItemStackHandler inventory = new ItemStackHandler(27) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if(!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };

    public BarrelOfBoatsBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.BARRELOFBOATS_BE.get(), pos, blockState);
    }
}
