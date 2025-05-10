package com.vfyjxf.rwfj;

import com.mojang.math.Axis;
import mezz.jei.api.gui.ITickTimer;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.common.util.TickTimer;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;

import java.util.List;
import java.util.stream.Stream;

public class InternalDrawable implements IDrawable {

    private final int width;
    private final int height;
    private final ITickTimer tickTimer;
    private final List<ResourceLocation> resourceLocations = Stream.of(
            "config_button_cheat0",
            "config_button_cheat1",
            "config_button_cheat2",
            "config_button_cheat3",
            "config_button_cheat4",
            "config_button_cheat5",
            "config_button_cheat6",
            "config_button_cheat7"
    ).map(it -> ResourceLocation.fromNamespaceAndPath(RWFJ.MODID, it)).toList();

    public InternalDrawable(int width, int height) {
        this.width = width;
        this.height = height;
        this.tickTimer = new TickTimer(15, 7, false);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
    
    @Override
    public void draw(GuiGraphics guiGraphics, int xOffset, int yOffset) {
        int index = tickTimer.getValue();
        int angle = 360 / resourceLocations.size();
        var poseStack = guiGraphics.pose();
        poseStack.pushPose();
        poseStack.translate(xOffset + (float) width / 2, yOffset + (float) height / 2, 0);
        poseStack.mulPose(Axis.ZP.rotationDegrees(angle * index));
        guiGraphics.blitSprite(resourceLocations.get(index), xOffset-width/2, yOffset-height/2, width, height);
        poseStack.popPose();
    }

}