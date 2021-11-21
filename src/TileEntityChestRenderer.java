package net.minecraft.src;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;

public class TileEntityChestRenderer extends TileEntitySpecialRenderer {
	
	public void renderTileEntityChest(TileEntityChest var1, double var2, double var4, double var6, float var8) {
		if(GameSettings.ESP) {
			GL11.glPushMatrix();
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(770, 771);
			// GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glEnable(GL11.GL_LINE_SMOOTH);
			GL11.glDisable(GL11.GL_DEPTH_TEST);
			GL11.glDepthMask(false);
			GL11.glLineWidth(2);
			GL11.glColor4d(hacks.red, hacks.green, hacks.blue, 1);
			RenderUtils.drawOutlinedBoundingBox(new AxisAlignedBB(var2, var4, var6, var2 + 1D, var4 + 1D, var6 + 1D));
			GL11.glDisable(GL11.GL_LINE_SMOOTH);
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			// GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glEnable(GL11.GL_DEPTH_TEST);
			GL11.glDepthMask(true);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glPopMatrix();
		}
		
		if(hacks.drawsoild) {
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glColor4f(0.0F, 0.0F, 0.0F, 1.F);
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glLineWidth(2);
			GL11.glDepthMask(false);
			GL11.glEnable(GL11.GL_LINE_SMOOTH);
			GL11.glBlendFunc(770, 771);
			GL11.glDisable(3553 /* GL_TEXTURE_2D */);
			GL11.glDisable(2929 /* GL_DEPTH_TEST */);
			GL11.glDepthMask(false);
			GL11.glEnable(GL11.GL_LINE_SMOOTH);
			RenderUtils.drawSolidBlockESP(var2, var4, var6, hacks.red, hacks.green, hacks.blue, 1);
	  		GL11.glDepthMask(true);
			GL11.glEnable(3553 /* GL_TEXTURE_2D */);
			GL11.glEnable(2929 /* GL_DEPTH_TEST */);
			
			}
		}
    
    

    public void renderTileEntityAt(TileEntity var1, double var2, double var4, double var6, float var8) {
        this.renderTileEntityChest((TileEntityChest)var1, var2, var4, var6, var8);
    }
}


