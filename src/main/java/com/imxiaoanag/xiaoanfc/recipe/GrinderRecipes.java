package com.imxiaoanag.xiaoanfc.recipe;

import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.List;

public class GrinderRecipes implements Recipe<SingleStackRecipeInput> {
    private final ItemStack output;
    private final List<Ingredient> recipeItems;

    public GrinderRecipes(List<Ingredient> recipeItems, ItemStack output) {
        this.recipeItems = recipeItems;
        this.output = output;
    }

    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> defaultedList = DefaultedList.ofSize(this.recipeItems.size());
        defaultedList.addAll(this.recipeItems);
        return defaultedList;
    }

    @Override
    public boolean matches(SingleStackRecipeInput input, World world) {
        if (world.isClient()) {
            return false;
        }
        return recipeItems.get(0).test(input.item());
    }

    @Override
    public ItemStack craft(SingleStackRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return this.output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return this.output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<GrinderRecipes> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "grinder";
    }

    public static class Serializer implements RecipeSerializer<GrinderRecipes> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "grinder";

        public static final MapCodec<GrinderRecipes> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                (Ingredient.DISALLOW_EMPTY_CODEC.listOf().fieldOf("ingredients")).flatXmap(ingredients -> {
                    Ingredient[] ingredients1 = (Ingredient[]) ingredients.stream().filter(ingredient -> !ingredient.isEmpty()).toArray(Ingredient[]::new);
                    if (ingredients1.length == 0) {
                        return DataResult.error(() -> "No ingredients");
                    }
                    if (ingredients1.length > 9) {
                        return DataResult.error(() -> "Too many ingredients");
                    }
                    return DataResult.success(DefaultedList.copyOf(Ingredient.EMPTY, ingredients1));
                }, DataResult::success).forGetter(recipe -> recipe.getIngredients()),
                (ItemStack.VALIDATED_CODEC.fieldOf("output")).forGetter(recipe -> recipe.output)).apply(instance, GrinderRecipes::new));

        public static final PacketCodec<RegistryByteBuf, GrinderRecipes> PACKET_CODEC = PacketCodec.ofStatic(
                Serializer::write, Serializer::read);

        private static GrinderRecipes read(RegistryByteBuf registryByteBuf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(registryByteBuf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.PACKET_CODEC.decode(registryByteBuf));
            }
            ItemStack output = ItemStack.PACKET_CODEC.decode(registryByteBuf);
            return new GrinderRecipes(inputs, output);
        }

        private static void write(RegistryByteBuf registryByteBuf, GrinderRecipes polishingMachineRecipe) {
            registryByteBuf.writeInt(polishingMachineRecipe.getIngredients().size());

            for (Ingredient ingredient : polishingMachineRecipe.getIngredients()) {
                Ingredient.PACKET_CODEC.encode(registryByteBuf, ingredient);
            }
            ItemStack.PACKET_CODEC.encode(registryByteBuf, polishingMachineRecipe.getResult(null));
        }

        @Override
        public MapCodec<GrinderRecipes> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, GrinderRecipes> packetCodec() {
            return PACKET_CODEC;
        }
    }
}
