package com.snoweverywhere;

import com.snoweverywhere.blocks.registries.SnowEverywhereBlockEntities;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class SnowEverywhereClient implements ClientModInitializer {
	public static final SpriteIdentifier SNOW_SPRITE_IDENTIFIER = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, new Identifier("minecraft", "block/snow"));
	@Override
	public void onInitializeClient() {
		BlockEntityRendererFactories.register(SnowEverywhereBlockEntities.SNOW_EVERYWHERE_BLOCK_ENTITY, SnowEverywhereBlockEntityRenderer::new);
	}

	public static void log(String message) {
		MinecraftClient client = MinecraftClient.getInstance();
		for(PlayerEntity player : client.world.getPlayers()) {
			player.sendMessage(Text.literal(message), false);
		}
	}
}