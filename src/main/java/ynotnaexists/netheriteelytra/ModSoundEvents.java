package ynotnaexists.netheriteelytra;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceKey;

public class ModSoundEvents {

    public static final Holder<SoundEvent> ITEM_ARMOR_EQUIP_NETHERITE_ELYTRA = registerSoundEvent("equip_netherite_elytra");

    private static Holder.Reference<SoundEvent> registerSoundEvent(String name) {
        Identifier id = Identifier.fromNamespaceAndPath(NetheriteElytra.MOD_ID, name);
        return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createFixedRangeEvent(id, 16.0F));
    }

    public static void registerClass() {}
}