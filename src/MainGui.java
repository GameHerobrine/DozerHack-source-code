package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class MainGui extends GuiScreen{
	public static boolean dragMode = false;
	public static boolean openMode = false;
	public static int mX =0 , mY=0;
	
	
	public static void drawRect(double x, double y, double x1, double y1, int color, int color2) {
		Gui.drawRect((int)x, (int)y, (int)x1, (int)y1, color);
        GL11.glScalef(0.5F, 0.5F, 0.5F);
        Gui.drawRect((int)x * 2 - 1,(int) y * 2, (int)x * 2, (int)y1 * 2 - 1, color2);
        Gui.drawRect((int)x * 2, (int)y * 2 - 1, (int)x1 * 2, (int)y * 2, color2);
        Gui.drawRect((int)x1 * 2,(int) y * 2, (int)x1 * 2 + 1, (int)y1 * 2 - 1, color2);
        Gui.drawRect((int)x * 2, (int)y1 * 2 - 1, (int)x1 * 2, (int)y1 * 2, color2);
        GL11.glScalef(2F, 2F, 2F);
	}
	public static void dragGUI(FontRenderer f) {
		drawRect(0+mX, 0+mY, 100+mX, 13+mY,0xbb000000,0xff000000);
		f.drawStringWithShadow(dragMode ? "\247 Mode": "\2472 Mode", 3 + mX, 3 +mY, 16755200);
	}
	public void mouseMove(int i, int j, int k) {
		if(k == 0) {
			dragMode = false;
		}
		
	}
	public void drawScreen(int i, int j, float f) {
			dragGUI(fontRenderer);
			modeDrag(i,j);
			super.drawScreen(i, j, f);		
	}
	
	public void mouseClicked(int i, int j, int k) {
		if(0 + mX < i && 100 + mX > i && 0 + mY < j && 13 + mY > j) {
			dragMode = true;
		}
		super.mouseClicked(i, j, k);
	}
	public void modeDrag(int i, int j) {
		if(dragMode) {
			mX = i-50;
			mY = j-5;
			
		}
	}
	
}
