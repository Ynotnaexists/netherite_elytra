package ynotnaexists.netheriteelytra.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
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
import net.minecraft.item.equipment.EquipmentModel;
import net.minecraft.item.equipment.EquipmentModels;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.Unit;
import ynotnaexists.netheriteelytra.NetheriteElytra;

import java.util.Optional;
import java.util.function.BiConsumer;

import static net.minecraft.command.argument.RegistryKeyArgumentType.registryKey;
import static net.minecraft.item.Items.PHANTOM_MEMBRANE;
import static net.minecraft.item.Items.register;

public class ModItems {


    public static final Item NETHERITE_ELYTRA = registerItem("netherite_elytra", new Item (new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(NetheriteElytra.MOD_ID, "netherite_elytra")))
            .maxDamage(432)
            .fireproof()
            .rarity(Rarity.EPIC)
            .component(DataComponentTypes.GLIDER, Unit.INSTANCE)
            .component(
                    DataComponentTypes.EQUIPPABLE,
                    EquippableComponent.builder(EquipmentSlot.CHEST).equipSound(SoundEvents.ITEM_ARMOR_EQUIP_ELYTRA)
                    .model(Identifier.of("netheriteelytra", "netherite_elytra"))
                    .damageOnHurt(false).build()
            )
            .repairable(PHANTOM_MEMBRANE)
            .attributeModifiers(createKnockbackModifier(0.1F, "elytra.amor")))
    );


    private static Item registerItem(String name, Item item) {
        registerModItems();
        return Registry.register(Registries.ITEM, Identifier.of(NetheriteElytra.MOD_ID, name), item);
    }
    public static void registerModItems() {
        NetheriteElytra.LOGGER.info("Registering Mod Items for " + NetheriteElytra.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addToToolsAndUtilitiesTab);
    }
    public static void addToToolsAndUtilitiesTab(FabricItemGroupEntries entries) {
        entries.addAfter(Items.ELYTRA, ModItems.NETHERITE_ELYTRA);
    }

    public static AttributeModifiersComponent createKnockbackModifier(float knockback, String path) {
        return AttributeModifiersComponent.builder()
                .add(
                        EntityAttributes.KNOCKBACK_RESISTANCE,
                        new EntityAttributeModifier(Identifier.of("netheriteelytra", path), knockback, EntityAttributeModifier.Operation.ADD_VALUE), AttributeModifierSlot.CHEST
                )
                .build();

    }
}
