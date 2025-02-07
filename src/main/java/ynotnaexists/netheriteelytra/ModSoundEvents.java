package ynotnaexists.netheriteelytra;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSoundEvents {

    public static final RegistryEntry<SoundEvent> ITEM_ARMOR_EQUIP_NETHERITE_ELYTRA = registerSoundEvent("equip_netherite_elytra");

    private static RegistryEntry.Reference<SoundEvent> registerSoundEvent(String name) {
        Identifier id = Identifier.of(NetheriteElytra.MOD_ID, name);
        return Registry.registerReference(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
    public static void registerClass() {}
}