package ynotnaexists.netheriteelytra;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetheriteElytra implements ModInitializer {
	public static final String MOD_ID = "netheriteelytra";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerClass();
		ModSoundEvents.registerClass();
	}
}