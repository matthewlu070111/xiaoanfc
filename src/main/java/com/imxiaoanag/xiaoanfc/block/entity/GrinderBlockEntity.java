package com.imxiaoanag.xiaoanfc.block.entity;

import com.imxiaoanag.xiaoanfc.data.GrinderData;
import com.imxiaoanag.xiaoanfc.recipe.GrinderRecipes;
import com.imxiaoanag.xiaoanfc.screen.GrinderScreenHandler;
import com.imxiaoanag.xiaoanfc.util.ImplementedInventory;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class GrinderBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory<GrinderData>, ImplementedInventory {

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);

    private static final int INPUT_SLOT = 0;

    private static final int OUTPUT_SLOT = 1;

    protected final PropertyDelegate propertyDelegate;

    private int progress = 0;
    private int maxProgress = 72;

    public GrinderBlockEntity(BlockPos pos, BlockState state) {
        super(FarmingCoreBlockEntity.GRINDER_BLOCK_ENTITY_TYPE, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> GrinderBlockEntity.this.progress;
                    case 1 -> GrinderBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> GrinderBlockEntity.this.progress = value;
                    case 1 -> GrinderBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("container.grinder");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new GrinderScreenHandler(syncId, playerInventory, this.propertyDelegate, this);
    }

    @Override
    public GrinderData getScreenOpeningData(ServerPlayerEntity player) {
        return new GrinderData(pos);
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, this.inventory, false, registryLookup);
        nbt.putInt("grinder", progress);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, this.inventory, registryLookup);
        progress = nbt.getInt("grinder");
    }

    @Override
    public int getMaxCountPerStack() {
        return 64;
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if (world.isClient()) {
            return;
        }
        if (isOutputSlotEmpty()) {
            if (hasRecipe()) {
                progress++;
                markDirty(world, pos, state);
                if (progress >= maxProgress) {
                    grindItem();
                    progress = 0;
                }
            } else {
                progress = 0;
            }
        } else {
            progress = 0;
            markDirty(world, pos, state);
        }
    }

    private boolean isOutputSlotEmpty() {
        return getStack(OUTPUT_SLOT).isEmpty() || getStack(OUTPUT_SLOT).getCount() <= getMaxCountPerStack();
    }

    private boolean hasRecipe() {
        Optional<RecipeEntry<GrinderRecipes>> recipe = getCurrentRecipe();
        return recipe.isPresent() && canInsertAmountIntoOutputSlot(recipe.get().value().getResult(null)) &&
                canInsertIntoOutputSlot(recipe.get().value().getResult(null).getItem());
    }

    private boolean canInsertIntoOutputSlot(Item item) {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getItem() == item;
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result) {
        return this.getStack(OUTPUT_SLOT).getCount() + result.getCount() <= this.getMaxCountPerStack();
    }

    private void grindItem() {
        Optional<RecipeEntry<GrinderRecipes>> recipe = getCurrentRecipe();
        this.setStack(OUTPUT_SLOT, new ItemStack(recipe.get().value().getResult(null).getItem(), getStack(OUTPUT_SLOT).getCount() + recipe.get().value().getResult(null).getCount()));
        this.removeStack(INPUT_SLOT, 1);
    }

    private Optional<RecipeEntry<GrinderRecipes>> getCurrentRecipe() {
        SimpleInventory inputInventory = new SimpleInventory(this.size());
        for (int i = 0; i < this.size(); i++) {
            inputInventory.setStack(i, this.getStack(i));
        }
        return getWorld().getRecipeManager().getFirstMatch(GrinderRecipes.Type.INSTANCE,
                new SingleStackRecipeInput(inputInventory.getStack(INPUT_SLOT)), getWorld());
    }
}
