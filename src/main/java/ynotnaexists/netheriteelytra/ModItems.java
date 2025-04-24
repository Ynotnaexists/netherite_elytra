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
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.Unit;
import static net.minecraft.item.Items.PHANTOM_MEMBRANE;

public class ModItems {
    public static final Item NETHERITE_ELYTRA = register("netherite_elytra", new Item (new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(NetheriteElytra.MOD_ID, "netherite_elytra")))
            .maxDamage(532)
            .fireproof()
            .rarity(Rarity.EPIC)
            .component(DataComponentTypes.GLIDER, Unit.INSTANCE)
            .component(
                    DataComponentTypes.EQUIPPABLE,
                    EquippableComponent.builder(EquipmentSlot.CHEST).equipSound(ModSoundEvents.ITEM_ARMOR_EQUIP_NETHERITE_ELYTRA)
                    .model(registerModel("netherite_elytra"))
                    .damageOnHurt(false).build()
            )
            .repairable(PHANTOM_MEMBRANE)
            .attributeModifiers(
                AttributeModifiersComponent.builder().add(
                    EntityAttributes.KNOCKBACK_RESISTANCE,
                    new EntityAttributeModifier(Identifier.of(NetheriteElytra.MOD_ID, "elytra.amor"),
                        0.1F, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.CHEST
                ).build()
            )
        )
    );

    static RegistryKey<EquipmentAsset> registerModel(String name) {
        return RegistryKey.of(RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset")), Identifier.of(NetheriteElytra.MOD_ID, name));
    }
    private static Item register(String name, Item item) {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> entries.addAfter(Items.ELYTRA, ModItems.NETHERITE_ELYTRA));
        return Registry.register(Registries.ITEM, Identifier.of(NetheriteElytra.MOD_ID, name), item);
    }

    public static void registerClass() {}
}
