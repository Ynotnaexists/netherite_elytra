package ynotnaexists.netheriteelytra;

import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.Equippable;

import java.util.function.Function;

import static net.minecraft.world.item.Items.PHANTOM_MEMBRANE;
import static ynotnaexists.netheriteelytra.NetheriteElytra.MOD_ID;

public class ModItems {
    public static final Item NETHERITE_ELYTRA = registerItem("netherite_elytra", properties ->  new Item(properties
            .durability(532)
            .fireResistant()
            .rarity(Rarity.EPIC)
            .component(DataComponents.GLIDER, Unit.INSTANCE)
            .component(
                    DataComponents.EQUIPPABLE,
                    Equippable.builder(EquipmentSlot.CHEST)
                            .setEquipSound(ModSoundEvents.ITEM_ARMOR_EQUIP_NETHERITE_ELYTRA)
                            .setAsset(registerModel("netherite_elytra"))
                            .setDamageOnHurt(false)
                            .build()
            )
            .repairable(PHANTOM_MEMBRANE)
            .attributes(
                ItemAttributeModifiers.builder().add(
                    Attributes.KNOCKBACK_RESISTANCE,
                    new AttributeModifier(
                            Identifier.fromNamespaceAndPath(NetheriteElytra.MOD_ID, "elytra.amor"),
                            0.1F,
                            AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.CHEST
                ).build()
            )
        )
    );

    static ResourceKey<EquipmentAsset> registerModel(String name) {
        return ResourceKey.create(
                EquipmentAssets.ELYTRA.registryKey(),
                Identifier.fromNamespaceAndPath(NetheriteElytra.MOD_ID, name)
        );
    }
    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, name)))));
    }

    public static void registerClass() {}
}
