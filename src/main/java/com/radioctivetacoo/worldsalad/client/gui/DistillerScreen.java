package com.radioctivetacoo.worldsalad.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.container.DistillerContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class DistillerScreen extends ContainerScreen<DistillerContainer> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(WorldSalad.MOD_ID,
			"textures/gui/distiller_gui.png");

	public DistillerScreen(DistillerContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
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
		// Distilling progress
		this.blit(this.guiLeft + 46, this.guiTop + 52, 176, 0, this.container.getProgressScaled(), 16);
		// Input fluid bar
		if (this.container.tileEntity.hasInputFluid()) {
			int i = this.container.getInputFluidAmountScaled();
			this.blit(this.guiLeft + 16, this.guiTop + 16 + 30 - i, 176 + (this.container.getInputFluidType() * 16), 107 - i, 16, 30);
		}
		// Output fluid bar
		if (this.container.tileEntity.hasOutputFluid()) {
			int i = this.container.getOutputFluidAmountScaled();
			this.blit(this.guiLeft + 120, this.guiTop + 16 + 30 - i, 176 + (this.container.getOutputFluidType() * 16), 47 - i, 16, 30);
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