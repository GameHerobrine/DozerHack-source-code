package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class GuiDozerHack extends GuiScreen{
	Minecraft mc;
    private GameSettings options;

    double c = 25D;
 

	public GuiDozerHack() {
 
    }


    public void initGui() {
    	controlList.add(new GuiBetterSlider(404, this.width / 5, this.height / 6 + 10, "FreeCamSpeed", hacks.getSliderString("FreeCamSpeed", (float)(hacks.realflyspeed / c)), (float)(hacks.realflyspeed / c)));
    	controlList.add(new GuiBetterSlider(405, this.width / 5, this.height / 6 + 45 , "RGB-Red", hacks.getSliderString("RGB-Red", (float)(hacks.red  / c)), (float)(hacks.red / c)));
    	controlList.add(new GuiBetterSlider(406, this.width / 5, this.height / 6 + 70 , "RGB-Green", hacks.getSliderString("RGB-Green", (float)(hacks.green  /c )), (float)(hacks.green / c)));
    	controlList.add(new GuiBetterSlider(407, this.width / 5, this.height / 6 + 95 , "RGB-Blue", hacks.getSliderString("RGB-Blue", (float)(hacks.blue /c)), (float)(hacks.blue/c)));
    	//controlList.add(new GuiBetterSlider(408, this.width / 5, this.height / 6 + 95 , "TimerSpeed", hacks.getSliderString("TimerSpeed", (float)(hacks.timerspeed /c)), (float)(hacks.timerspeed/c)));
    	/*if(hacks.animal =!hacks.animal) {
            controlList.add(new GuiButton(1, width / 2 + 90, height / 6 - 32, 80, 20, "Animal: \u00A7aEnable"));
    	}else {
            controlList.add(new GuiButton(1, width / 2 + 90, height / 6 - 32, 80, 20, "Animal: \u00A7cDisable"));

    	}
    	if(hacks.mobs =!hacks.mobs) {
            controlList.add(new GuiButton(2, width / 2 + 90, (height / 6 - 30) + 18, 80, 20, "Mob: \u00A7aEnable"));
    	}else {
            controlList.add(new GuiButton(2, width / 2 + 90, (height / 6 - 30) + 18, 80, 20, "Mob: \u00A7cDisable"));

    	}
    	if(hacks.player =!hacks.player) {
            controlList.add(new GuiButton(3, width / 2 + 90, (height / 6 - 30) + 38, 80, 20, "Player: \u00A7aEnable"));
    	}else {
            controlList.add(new GuiButton(3, width / 2 + 90, (height / 6 - 30) + 38, 80, 20, "Player: \u00A7cDisable"));

    	}
    	*/
    	//controlList.add(new GuiBetterSlider(408, this.width / 5, this.height / 6 + 135 , "TimerSpeed", hacks.getSliderString("TimerSpeed", (float)(hacks.timer /c)), (float)(hacks.timer/c)));

    	//controlList.add(new GuiButton(this.height, this.width / 6 + 14, 200, "soild"));
    
    }
    
    protected void actionPerformed(GuiButton var1) {
     
        }
    

    public void onGuiClosed() {
    }







    public void drawScreen(int var1, int var2, float var3) {
     	this.drawDefaultBackground();
     	fontRenderer.drawStringWithShadow(hacks.all, this.width / 2-40, this.height/ 50, 16755200);
     	super.drawScreen(var1, var2, var3);
    	

    }

  
    

}
