package ynotnaexists.netheriteelytra;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.Unit;

import static net.minecraft.item.Items.PHANTOM_MEMBRANE;
import static net.minecraft.item.Items.register;
import static net.minecraft.item.equipment.EquipmentAssetKeys.REGISTRY_KEY;

public class ModItems {
    public static final Item NETHERITE_ELYTRA = registerItem("netherite_elytra", new Item (new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(NetheriteElytra.MOD_ID, "netherite_elytra")))
            .maxDamage(432)
            .fireproof()
            .rarity(Rarity.EPIC)
            .component(DataComponentTypes.GLIDER, Unit.INSTANCE)
            .component(
                    DataComponentTypes.EQUIPPABLE,
                    EquippableComponent.builder(EquipmentSlot.CHEST).equipSound(ModSoundEvents.ITEM_ARMOR_EQUIP_NETHERITE_ELYTRA)
                    .model(RegistryKey.of(REGISTRY_KEY, Identifier.of("netheriteelytra", "netherite_elytra")))
                    .damageOnHurt(false).build()
            )
            .repairable(PHANTOM_MEMBRANE)
            .attributeModifiers(
                AttributeModifiersComponent.builder().add(
                    EntityAttributes.KNOCKBACK_RESISTANCE,
                    new EntityAttributeModifier(Identifier.of("netheriteelytra", "elytra.amor"),
                        0.1F, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.CHEST
                ).build()
            )
        )
    );

    private static Item registerItem(String name, Item item) {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.addAfter(Items.ELYTRA, ModItems.NETHERITE_ELYTRA);
        });
        return Registry.register(Registries.ITEM, Identifier.of(NetheriteElytra.MOD_ID, name), item);
    }
    public static void registerClass() {}
}
