package net.minecraft.src;

import java.awt.Color;

import net.minecraft.client.Minecraft;

public class EntityClientPlayerMP extends EntityPlayerSP {
    public NetClientHandler sendQueue;
    private int inventoryUpdateTickCounter = 0;
    private boolean hasSetHealth = false;
    private double oldPosX;
    private double oldMinY;
    private double oldPosY;
    private double oldPosZ;
    private float oldRotationYaw;
    private float oldRotationPitch;
    private boolean wasOnGround = false;
    private boolean wasSneaking = false;
    private int timeSinceMoved = 0;
    private String[] signText;
    public Item items;
    public static boolean done = false;
    public static boolean started = false;
    public static int oldslot;
    public static long timer = 0l;
    
    public void Scaffold() {
    }

    public void AutoEat(){
        if(mc.thePlayer.health < 18){
            started = true;
            for (int i = 0; i < 9; i++) {
                int bestSlot = -1;
                ItemStack stack = mc.thePlayer.inventory.getStackInSlot(i);
                if(stack == null || !(stack.getItem() instanceof ItemFood))
                    continue;
                bestSlot = i;
                mc.thePlayer.inventory.currentItem = bestSlot;
                mc.getSendQueue().addToSendQueue(new Packet15Place(-1, -1, -1, 255, mc.thePlayer.inventory.getCurrentItem()));
                done = true;
            }
        }
        if(done == true) {
            timer++;
            if(timer == 5) {
                mc.thePlayer.inventory.currentItem = 0;/*slot which to switch back to after eating*/
                done = false;
                timer = 0;
                started = false;
            }
        }

}


	public boolean isEnabled() {
		return false;
	}

	public String[] getSignText()
	{
		return signText;
	}
	public void setSignText(String[] signText)
	{
		if(isEnabled() && this.signText == null)
			this.signText = signText;
	}
    public EntityClientPlayerMP(Minecraft var1, World var2, Session var3, NetClientHandler var4) {
        super(var1, var2, var3, 0);
        this.sendQueue = var4;
    }
    

    public boolean attackEntityFrom(Entity var1, int var2) {
        return false;
    }

    public void heal(int var1) {
    }
    

    public void onUpdate() {
        if (this.worldObj.blockExists(MathHelper.floor_double(this.posX), 7, MathHelper.floor_double(this.posZ))) {
            super.onUpdate();
            this.sendMotionUpdates();
        }
        this.Scaffold();
    	if(hacks.autoeat) {
    		this.AutoEat();
    	}
    }

    public void sendMotionUpdates() {
    	
    	if(hacks.freecam)
        {
            sendQueue.addToSendQueue(new Packet0KeepAlive());
            return;
        }

    	if(hacks.climb && this.mc.thePlayer.ticksExisted % 20 == 0) {
            sendQueue.addToSendQueue(new Packet19EntityAction(this, 3));
            return;
    	}
  
    	
    	if(hacks.kill) {
            for (int i = 0; i < mc.theWorld.loadedEntityList.size(); i++)
            {
            	if(hacks.mode == 1) {
            		if((Entity)mc.theWorld.loadedEntityList.get(i) != this && getDistanceSqToEntity((Entity)mc.theWorld.loadedEntityList.get(i)) < 25D && ((Entity)mc.theWorld.loadedEntityList.get(i) instanceof EntityAnimal))
            			{                  	   
            				mc.playerController.attackEntity(this, (Entity)mc.theWorld.loadedEntityList.get(i));
                         
                    		}
            	}
            	if(hacks.mode == 2) {
            		if((Entity)mc.theWorld.loadedEntityList.get(i) != this && getDistanceSqToEntity((Entity)mc.theWorld.loadedEntityList.get(i)) < 25D && ((Entity)mc.theWorld.loadedEntityList.get(i) instanceof EntityMob))
            			{                  	   
            				mc.playerController.attackEntity(this, (Entity)mc.theWorld.loadedEntityList.get(i));
                     
            			}
            	}
            	if(hacks.mode == 3) {
            		if((Entity)mc.theWorld.loadedEntityList.get(i) != this && getDistanceSqToEntity((Entity)mc.theWorld.loadedEntityList.get(i)) < 25D && ((Entity)mc.theWorld.loadedEntityList.get(i) instanceof EntityPlayer))
            		{                  	   
            			mc.playerController.attackEntity(this, (Entity)mc.theWorld.loadedEntityList.get(i));
                     
                		}
            		}
            	}
            }
    	
    	
    	
    	
    	
            if (!this.mc.statFileWriter.hasAchievementUnlocked(AchievementList.openInventory)) {
                this.mc.guiAchievement.queueAchievementInformation(AchievementList.openInventory);
            }
        
        if (this.inventoryUpdateTickCounter++ == 20) {
            this.sendInventoryChanged();
            this.inventoryUpdateTickCounter = 0;
        }

        boolean var1 = this.isSneaking();
        if (var1 != this.wasSneaking) {
            if (var1) {
                this.sendQueue.addToSendQueue(new Packet19EntityAction(this, 1));
            } else {
                this.sendQueue.addToSendQueue(new Packet19EntityAction(this, 2));
            }

            this.wasSneaking = var1;
        }

        double var2 = this.posX - this.oldPosX;
        double var4 = this.boundingBox.minY - this.oldMinY;
        double var6 = this.posY - this.oldPosY;
        double var8 = this.posZ - this.oldPosZ;
        double var10 = (double)(this.rotationYaw - this.oldRotationYaw);
        double var12 = (double)(this.rotationPitch - this.oldRotationPitch);
        boolean var14 = var4 != 0.0D || var6 != 0.0D || var2 != 0.0D || var8 != 0.0D;
        boolean var15 = var10 != 0.0D || var12 != 0.0D;
        if (this.ridingEntity != null) {
        	
        	if(var15)
            {
                if(hacks.fall || hacks.Flight)
                {
                    sendQueue.addToSendQueue(new Packet11PlayerPosition(motionX, -999D, -999D, motionZ, true));
                } else
                {
                    sendQueue.addToSendQueue(new Packet11PlayerPosition(motionX, -999D, -999D, motionZ, onGround));
                }
            } else
            if(hacks.fall || hacks.Flight)
            {
                sendQueue.addToSendQueue(new Packet13PlayerLookMove(motionX, -999D, -999D, motionZ, rotationYaw, rotationPitch, true));
            } else
            {
                sendQueue.addToSendQueue(new Packet13PlayerLookMove(motionX, -999D, -999D, motionZ, rotationYaw, rotationPitch, onGround));
            }
            var14 = false;
        } else
        if(var14 && var15)
        {
            if(hacks.fall || hacks.Flight)
            {
                sendQueue.addToSendQueue(new Packet13PlayerLookMove(posX, boundingBox.minY, posY, posZ, rotationYaw, rotationPitch, true));
            } else
            {
                sendQueue.addToSendQueue(new Packet13PlayerLookMove(posX, boundingBox.minY, posY, posZ, rotationYaw, rotationPitch, onGround));
            }
            timeSinceMoved = 0;
        } else
        if(var14)
        {
            if(hacks.fall || hacks.Flight)
            {
                sendQueue.addToSendQueue(new Packet11PlayerPosition(posX, boundingBox.minY, posY, posZ, true));
            } else
            {
                sendQueue.addToSendQueue(new Packet11PlayerPosition(posX, boundingBox.minY, posY, posZ, onGround));
            }
            timeSinceMoved = 0;
        } else
          
        if(var15)
        {
            if(hacks.fall)
            {
                sendQueue.addToSendQueue(new Packet12PlayerLook(rotationYaw, rotationPitch, true));
            } else
            {
                sendQueue.addToSendQueue(new Packet12PlayerLook(rotationYaw, rotationPitch, onGround));
            }
            timeSinceMoved = 0;
        } else
        {
            sendQueue.addToSendQueue(new Packet10Flying());
            if(wasOnGround != onGround || timeSinceMoved > 200)
            {
                timeSinceMoved = 0;
            } else
            {
                timeSinceMoved++;
            }
        }
        wasOnGround = onGround;

        this.wasOnGround = this.onGround;
        if (var14) {
            this.oldPosX = this.posX;
            this.oldMinY = this.boundingBox.minY;
            this.oldPosY = this.posY;
            this.oldPosZ = this.posZ;
        }

        if (var15) {
            this.oldRotationYaw = this.rotationYaw;
            this.oldRotationPitch = this.rotationPitch;
        }

    }

    public void dropCurrentItem() {
        this.sendQueue.addToSendQueue(new Packet14BlockDig(4, 0, 0, 0, 0));
    }

    private void sendInventoryChanged() {
    }

    protected void joinEntityItemWithWorld(EntityItem var1) {
    }

    String t = "\u00A76[DozerHack] ";
    String commands[] = {".help"};
    public void sendChatMessage(String var1) {
    	
    	switch(var1) {    	
    	case ".help":
    		addChatMessage(t+"\u00A7eCommands list");
    		addChatMessage("	\u00A76.coord | \u00A7f	Enable or Disable coord");
    		addChatMessage("	\u00A76.timer [value] | \u00A7f	Timer speed");	
    		addChatMessage("	\u00A76.owner | \u00A7f Show worlf's owner");	
    		addChatMessage("	\u00A76.killmode [value] | \u00A7fChoose which entity you want to hit with"); 
    		addChatMessage("	\u00A731 animal 2 mobs 3 player");
    		addChatMessage("\u00A76.day | \u00A7fRender daylight on client-side");
    		return;
    		
    	case ".day":
    		hacks.day = !hacks.day;
    		addChatMessage(t+ "\u00A7bDay light"+ (hacks.day? " \u00A7atrue" : " \u00A7cfalse"));    		
    		addChatMessage("	\u00A76.day | \u00A7 Render day light on client-sdie"); 
    		return;

    	case ".owner":
    		addChatMessage(t + "\u00A7aThis hack has been" +(hacks.Owner ? "\u00A74 DISABLE" : "\u00A72 ENABLE"));
			hacks.Owner = !hacks.Owner;  
    		return;
    		
    	case ".coord":
    		addChatMessage(t + "\u00A7aThis hack has been" +(hacks.coord ? "\u00A74 DISABLE" : "\u00A72 ENABLE"));
			hacks.coord = !hacks.coord;  
    		return;

    		default:
    			break;
    	}
    	
    	if(var1.startsWith(".timer")) {
    		if(!var1.endsWith(".timer")) {	
    			try {
    			String vals[] = var1.split(" ");
    			float y = Float.parseFloat(vals[1]);
    			addChatMessage(t + "\u00A72 Your Timer Speed has been set to " + "\u00A7e" + y );
       			mc.timer.timerSpeed = y;
       			mc.timer.updateTimer();
    		}catch(Exception exception){
    			addChatMessage(t + "\u00A74You need to enter a number!");
    			} 
    			return;
    		}
    		addChatMessage(t + "\u00A72Current Timer Speed is " + "\u00A7e" + mc.timer.timerSpeed + " \u00A7b("+ "\u00A7bDefault: 1.0" + ")");
    		return;
    	}
    	if(var1.startsWith(".up")) {
    		if(!var1.endsWith(".up")) {
    			try {
    			String vals[] = var1.split(" ");
    			double y = Double.parseDouble(vals[1]);
    			addChatMessage(t + "\u00A72 Your position has been updated " + "\u00A7e" + y + " \u00A72blocks high");
       			mc.thePlayer.setPosition(mc.thePlayer.prevPosX, mc.thePlayer.prevPosY+y, mc.thePlayer.prevPosZ);
    		}catch(Exception exception){
    			addChatMessage(t + "\u00A74You need to enter a number!");
    			} 
    			return;
    		}
    		return;
    	}
    	if(var1.startsWith(".killmode")) {
    		if(!var1.endsWith(".killmode")) {
				try { 
					String vals[] = var1.split(" ");
					int y = Integer.parseInt(vals[1]);
					hacks.mode =y;
					switch(y){
					case 1:
						hacks.animal = !hacks.animal;
						break;
						
					case 2:
						hacks.mobs = !hacks.mobs;
					break;
					
					case 3:
						hacks.player = !hacks.player;
						break;
						
					default:
						addChatMessage(t+"\u00A7cInvail number!");
							return;
					}
					
				}catch(Exception e) {
					
				}
			}
			addChatMessage(t+"\u00A7bCurrent killaura target");
			addChatMessage("\u00A73Animal:" + (hacks.animal? " \u00A7aEnable" : " \u00A7cDisable"));
			addChatMessage("\u00A73Mobs:" + (hacks.mobs? " \u00A7aEnable" : " \u00A7cDisable"));
			addChatMessage("\u00A73Players:" + (hacks.player? " \u00A7aEnable" : " \u00A7cDisable"));
			return;
    	}
    	
        
    	this.sendQueue.addToSendQueue(new Packet3Chat(var1));
    }
    
    public void swingItem() {
        super.swingItem();
        this.sendQueue.addToSendQueue(new Packet18Animation(this, 1));
    }

    public void respawnPlayer() {
        this.sendInventoryChanged();
        this.sendQueue.addToSendQueue(new Packet9Respawn((byte)this.dimension));
    }

    protected void damageEntity(int var1) {
        this.health -= var1;
    }

    public void closeScreen() {
        this.sendQueue.addToSendQueue(new Packet101CloseWindow(this.craftingInventory.windowId));
        this.inventory.setItemStack((ItemStack)null);
        super.closeScreen();
    }

    public void setHealth(int var1) {
        if (this.hasSetHealth) {
            super.setHealth(var1);
        } else {
            this.health = var1;
            this.hasSetHealth = true;
        }

    }

    public void addStat(StatBase var1, int var2) {
        if (var1 != null) {
            if (var1.isIndependent) {
                super.addStat(var1, var2);
            }

        }
    }

    public void incrementStat(StatBase var1, int var2) {
        if (var1 != null) {
            if (!var1.isIndependent) {
                super.addStat(var1, var2);
            }

        }
    }
}
