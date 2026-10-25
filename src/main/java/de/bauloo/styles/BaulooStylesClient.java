package de.bauloo.styles;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.minecraft.util.Identifier;

public class BaulooStylesClient implements ClientModInitializer {
	public static final String MOD_ID = "bauloo-styles";

	@Override
	public void onInitializeClient() {
		StylesConfig.load();

		HudElementRegistry.addLast(
			Identifier.of(MOD_ID, "info"),
			(context, tickCounter) -> HudStyler.render(context)
		);

		ScreenEvents.AFTER_INIT.register(MenuStyler::onScreenInit);
	}
}
