package com.radioctivetacoo.worldsalad.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import com.radioctivetacoo.worldsalad.WorldSalad;
import com.radioctivetacoo.worldsalad.container.PolymerizationReactorContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class PolymerizationReactorScreen extends ContainerScreen<PolymerizationReactorContainer> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(WorldSalad.MOD_ID,
			"textures/gui/polymerization_reactor_gui.png");

	public PolymerizationReactorScreen(PolymerizationReactorContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
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
		// energy bar
		if (this.container.tileEntity.isPowered()) {
		int i = this.container.getEnergyLeftScaled();
		this.blit(this.guiLeft + 8, this.guiTop + 37 + 30 - i, 192, 47 - i, 16, 30);
		}
		// fluid bar
		if (this.container.tileEntity.hasOil()) {
		int i = this.container.getOilAmountScaled();
		this.blit(this.guiLeft + 33, this.guiTop + 37 + 30 - i, 176, 47 - i, 16, 30);
		}
		
		// progress bar
		int j = this.container.getProgressScaled();
		this.blit(this.guiLeft + 136, this.guiTop + 26 + 34 - j, 210, 49 - j, 4, 34);
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