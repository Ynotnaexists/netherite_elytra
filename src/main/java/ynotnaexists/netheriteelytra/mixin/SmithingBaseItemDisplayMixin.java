package ynotnaexists.netheriteelytra.mixin;

import net.minecraft.resources.Identifier;
import net.minecraft.world.item.SmithingTemplateItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import java.util.ArrayList;
import java.util.List;

import static ynotnaexists.netheriteelytra.NetheriteElytra.MOD_ID;

@Mixin(SmithingTemplateItem.class)
public class SmithingBaseItemDisplayMixin {
@Inject(method = "createNetheriteUpgradeIconList", at = @At("RETURN"), cancellable = true)
    private static void injectElytraTexture(CallbackInfoReturnable<List<Identifier>> cir) {
        List<Identifier> modifiedList = new ArrayList<>(cir.getReturnValue());
        modifiedList.add(Identifier.fromNamespaceAndPath(MOD_ID, "elytra"));
        cir.setReturnValue(modifiedList);
    }
}