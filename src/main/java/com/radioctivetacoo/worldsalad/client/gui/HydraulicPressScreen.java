package com.radioctivetacoo.worldsalad.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.container.HydraulicPressContainer;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class HydraulicPressScreen extends ContainerScreen<HydraulicPressContainer> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(WorldSalad.MOD_ID,
			"textures/gui/hydraulic_press_gui.png");

	public HydraulicPressScreen(HydraulicPressContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		super(screenContainer, inv, titleIn);

		this.guiLeft = 0;
		this.guiTop = 0;
		this.xSize = 176;
		this.ySize = 166;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
		this.minecraft.getTextureManager().bindTexture(TEXTURE);
		this.blit(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		// smelt progress
		this.blit(this.guiLeft + 106, this.guiTop + 35, 176, 0, this.container.getSmeltProgressionScaled(), 16);
		// energy bar
		if (this.container.tileEntity.isPowered()) {
			int i = this.container.getEnergyLeftScaled();
			this.blit(this.guiLeft + 8, this.guiTop + 37 + 30 - i, 192, 47 - i, 16, 30);
		}
		// fluid bar
		if (this.container.tileEntity.hasFluid()) {
			int i = this.container.getFluidLeftScaled();
			this.blit(this.guiLeft + 33, this.guiTop + 37 + 30 - i, 176, 47 - i, 16, 30);
		}
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		this.font.drawString(this.title.getFormattedText(), 8.0f, 8.0f, 0x404040);
		this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0f, 69.0f, 0x404040);
	}

	@Override
	public void render(int mouseX, int mouseY, float partialTicks) {
		this.renderBackground();
		super.render(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}
}