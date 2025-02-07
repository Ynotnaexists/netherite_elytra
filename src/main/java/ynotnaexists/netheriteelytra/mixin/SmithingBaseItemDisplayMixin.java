package ynotnaexists.netheriteelytra.mixin;

import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import java.util.ArrayList;
import java.util.List;

@Mixin(SmithingTemplateItem.class)
public class SmithingBaseItemDisplayMixin {
    @Inject(method = "getNetheriteUpgradeEmptyBaseSlotTextures", at = @At("RETURN"), cancellable = true)
    private static void injectElytraTexture(CallbackInfoReturnable<List<Identifier>> cir) {
        List<Identifier> modifiedList = new ArrayList<>(cir.getReturnValue());
        modifiedList.add(Identifier.of("netheriteelytra", "item/empty_slot_netherite_elytra"));
        cir.setReturnValue(modifiedList);
    }
}