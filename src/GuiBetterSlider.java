package net.minecraft.src;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;

public class GuiBetterSlider extends GuiButton{
	
    public GuiBetterSlider(int i, int j, int k, String s, String s1, float f)
    {
        super(i, j, k, 150, 20, s1);
        dragging = false;
        sConfig = s;
        sliderValue = f;
    }

    protected int getHoverState(boolean flag)
    {
        return 0;
    }

    protected void mouseDragged(Minecraft minecraft, int i, int j)
    {
        if(!enabled2)
        {
            return;
        }
        if(dragging)
        {
            sliderValue = (float)(i - (xPosition + 4)) / (float)(width - 8);
            if(sliderValue < 0.0F)
            {
                sliderValue = 0.0F;
            }
            if(sliderValue > 1.0F)
            {
                sliderValue = 1.0F;
            }
            hacks.setSliderValue(sConfig, sliderValue);
            displayString = hacks.getSliderString(sConfig, sliderValue);
        }
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        drawTexturedModalRect(xPosition + (int)(sliderValue * (float)(width - 8)), yPosition, 0, 66, 4, 20);
        drawTexturedModalRect(xPosition + (int)(sliderValue * (float)(width - 8)) + 4, yPosition, 196, 66, 4, 20);
    }

    public boolean mousePressed(Minecraft minecraft, int i, int j)
    {
        if(super.mousePressed(minecraft, i, j))
        {
            sliderValue = (float)(i - (xPosition + 4)) / (float)(width - 8);
            if(sliderValue < 0.0F)
            {
                sliderValue = 0.0F;
            }
            if(sliderValue > 1.0F)
            {
                sliderValue = 1.0F;
            }
            hacks.setSliderValue(sConfig, sliderValue);
            displayString = hacks.getSliderString(sConfig, sliderValue);
            dragging = true;
            return true;
        } else
        {
            return false;
        }
    }

    public void mouseReleased(int i, int j)
    {
        dragging = false;
    }

    public float sliderValue;
    public boolean dragging;
    private String sConfig;
}


