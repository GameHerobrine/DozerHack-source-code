package net.minecraft.src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;

public class hacks{
	public static Minecraft mc;
 	public static String name = "DozerHack TEST";
	public static String version = "\u00A75 1.6-3";
	public static String all = name + version;
	public static String text = "\u00A7b Lighter";
 	public static boolean building;
 	public static double red = 2;
 	public static float timerspeed = 2;
 	static double green = 1.5;
 	static double blue = 0;
 	public static boolean drawsoild;
 	public static boolean Speed;
 	public static double run = 1; 
 	public static boolean fall = true;
	public static boolean xray = false;
	public static boolean coord = true;
	public static boolean water = false;
	public static boolean PlayerESP = false;
	public static boolean zoom;
	public static boolean kill = false;
	public static boolean climb = false;
	public static boolean NooverLay = false;
	public static boolean Tracers = false;
	public static boolean noPushe = false;
	public static boolean instaMine = false;
	public static boolean Flight;
	public static boolean Owner = false;
	public static boolean freecam1 = false;
	public static boolean freecam = false;
	public static boolean step = false;
	public static boolean logout = false;
	public static boolean gui = false;
	public static boolean NoHinder = false;
	public static boolean AntiBurn = false;
	public static boolean autoeat  = false;
	public static boolean SmallPlayer = false;
 	public static double realflyspeed = 6D;
	public static boolean animal;
	public static boolean mobs = true;
	public static boolean player;
	public static boolean done;
	public static int mode = 2;
	// 0 NON, 1 Animal,2 Mobs,3 Player 
	public static boolean mine = false;
	public static boolean day;
	
	public static String getSliderString(String s, float f)
    {
        if(s.equalsIgnoreCase("FreeCamSpeed"))
        {
            String s1 = (new StringBuilder()).append(s).append(": ").toString();
            if(f == 0.0F)
            {
                return (new StringBuilder()).append(s1).append("0").toString();
            }
            if(f == 1.0F)
            {
                return (new StringBuilder()).append(s1).append("25.0").toString();
            }
            if(f < 0.05F)
            {
                return (new StringBuilder()).append(s1).append("Default").toString();
            } else
            {
                return (new StringBuilder()).append(s1).append(String.format("%.2f", new Object[] {
                    Float.valueOf(f * 25F)
                })).toString();
            }
            
        	}else if(s.equalsIgnoreCase("TimerSpeed"))
            {
        		String s1 = (new StringBuilder()).append(s).append(": ").toString();
                if(f == 0.0F)
                {
                    return (new StringBuilder()).append(s1).append("0").toString();
                }
                if(f == 1.0F)
                {
                    return (new StringBuilder()).append(s1).append("25.0").toString();
                }
                if(f < 0.05F)
                {
                    return (new StringBuilder()).append(s1).append("Default").toString();
                } else
                {
                    return (new StringBuilder()).append(s1).append(String.format("%.2f", new Object[] {
                        Float.valueOf(f * 25F)
                    })).toString();
                    
                }           
                
        	}else if(s.equalsIgnoreCase("RGB-Red"))
            {
        		String s1 = (new StringBuilder()).append(s).append(": ").toString();
                if(f == 0.0F)
                {
                    return (new StringBuilder()).append(s1).append("0").toString();
                }
                if(f == 1.0F)
                {
                    return (new StringBuilder()).append(s1).append("25.0").toString();
                }
                if(f < 0.05F)
                {
                    return (new StringBuilder()).append(s1).append("Default").toString();
                } else
                {
                    return (new StringBuilder()).append(s1).append(String.format("%.2f", new Object[] {
                        Float.valueOf(f * 25F)
                    })).toString();
                } 
            }
                else if(s.equalsIgnoreCase("RGB-Green"))
                {
            		String s1 = (new StringBuilder()).append(s).append(": ").toString();
                    if(f == 0.0F)
                    {
                        return (new StringBuilder()).append(s1).append("0").toString();
                    }
                    if(f == 1.0F)
                    {
                        return (new StringBuilder()).append(s1).append("25.0").toString();
                    }
                    if(f < 0.05F)
                    {
                        return (new StringBuilder()).append(s1).append("Default").toString();
                    } else
                    {
                        return (new StringBuilder()).append(s1).append(String.format("%.2f", new Object[] {
                            Float.valueOf(f * 25F)
                        })).toString();
                    } 
                }
                    else if(s.equalsIgnoreCase("RGB-Blue"))
                    {
                		String s1 = (new StringBuilder()).append(s).append(": ").toString();
                        if(f == 0.0F)
                        {
                            return (new StringBuilder()).append(s1).append("0").toString();
                        }
                        if(f == 1.0F)
                        {
                            return (new StringBuilder()).append(s1).append("25.0").toString();
                        }
                        if(f < 0.05F)
                        {
                            return (new StringBuilder()).append(s1).append("Default").toString();
                        } else
                        {
                            return (new StringBuilder()).append(s1).append(String.format("%.2f", new Object[] {
                                Float.valueOf(f * 25F)
                            })).toString();
                        }
                        
                
                
        	}else {
        		return null;

        	}
    }
	
	public static void setSliderValue(String s, float f)
    {
		 if(s.equalsIgnoreCase("RGB-Red"))
	        {
	            if(f == 0.0F)
	            {
	            	red = 0.5F;
	            } else
	            if(f == 1.0F)
	            {
	            	red = 25F;
	            } else
	            {
	                if(f < 0.05F)
	                {
	                	red = 0.5F;
	                    return;
	                }
	                red = f * 25F;
	            }
	            return;
	        }
		 
		 if(s.equalsIgnoreCase("RGB-Green"))
	        {
	            if(f == 0.0F)
	            {
	            	green = 0.5F;
	            } else
	            if(f == 1.0F)
	            {
	            	green = 25F;
	            } else
	            {
	                if(f < 0.05F)
	                {
	                	green = 0.5F;
	                    return;
	                }
	                green = f * 25F;
	            }
	            return;
	        }
		 if(s.equalsIgnoreCase("RGB-Blue"))
	        {
	            if(f == 0.0F)
	            {
	            	blue = 0.5F;
	            } else
	            if(f == 1.0F)
	            {
	            	blue = 25F;
	            } else
	            {
	                if(f < 0.05F)
	                {
	                	blue = 0.5F;
	                    return;
	                }
	                blue = f * 25F;
	            }
	            return;
	        }
		 
        if(s.equalsIgnoreCase("FreeCamSpeed"))
        {
            if(f == 0.0F)
            {
            	realflyspeed = 0.5F;
            } else
            if(f == 1.0F)
            {
            	realflyspeed = 25F;
            } else
            {
                if(f < 0.05F)
                {
                	realflyspeed = 0.5F;
                    return;
                }
                realflyspeed = f * 25F;
            }
            return;
        }
		 if(s.equalsIgnoreCase("TimerSpeed"))
	        {
	            if(timerspeed == 0.0F)
	            {
	            	timerspeed = 0.5F;
	            } else
	            if(timerspeed == 1.0F)
	            {
	            	timerspeed = 25F;
	            } else
	            {
	                if(f < 0.05F)
	                {
	                	timerspeed = 0.5F;
	                    return;
	                }
	                timerspeed = f * 25F;
	            }
	            return;
	        }
    }

	public static void Flightt(EntityPlayerSP entityplayersp)
	
    {		
		Minecraft mc = entityplayersp.mc;
		boolean inGameHasFocus = mc.inGameHasFocus;
        entityplayersp.onGround = false;
        entityplayersp.motionX = 0.0D;
        entityplayersp.motionY = 0.0D;
        entityplayersp.motionZ = 0.0D;
        double yaw = entityplayersp.rotationYaw + 90F;
        boolean wKey = mc.thePlayer.movementInput.moveForward>0f;
        boolean aKey = mc.thePlayer.movementInput.moveStrafe>0f;
        boolean sKey = mc.thePlayer.movementInput.moveForward<0f;
        boolean dKey = mc.thePlayer.movementInput.moveStrafe<0f;
        
        if(wKey)
        {
            if(aKey)
                yaw -= 45D;
            else if(dKey)
                yaw += 45D;
        } else if(sKey) {
            yaw += 180D;
            if(aKey)
                yaw += 45D;
            else if(dKey)
                yaw -= 45D;
        } else if(aKey)
            yaw -= 90D;
        else if(dKey)
            yaw += 90D;
        if(wKey || aKey || sKey || dKey)
        {
            entityplayersp.motionX = Math.cos(Math.toRadians(yaw));
            entityplayersp.motionZ = Math.sin(Math.toRadians(yaw));
        }
       
        if(Keyboard.isKeyDown(Keyboard.KEY_SPACE) && inGameHasFocus)
            entityplayersp.motionY += 1;
        else if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) && inGameHasFocus)
            entityplayersp.motionY -= 1;
        entityplayersp.motionX *= realflyspeed /10;
        entityplayersp.motionY *= realflyspeed /10;
        entityplayersp.motionZ *= realflyspeed /10;
    }
	
	
	public static void run(EntityPlayerSP entityplayersp)
    {
        entityplayersp.onGround = false;
        entityplayersp.motionX = 0.0D;
        entityplayersp.motionY = 0.0D;
        entityplayersp.motionZ = 0.0D;
        double d = entityplayersp.rotationYaw + 90F;
        boolean flag = Keyboard.isKeyDown(17);
        boolean flag1 = Keyboard.isKeyDown(31);
        boolean flag2 = Keyboard.isKeyDown(30);
        boolean flag3 = Keyboard.isKeyDown(32);
        if(flag)
        {
            if(flag2)
            {
                d -= 45D;
            } else
            if(flag3)
            {
                d += 45D;
            }
        } else
        if(flag1)
        {
            d += 180D;
            if(flag2)
            {
                d += 45D;
            } else
            if(flag3)
            {
                d -= 45D;
            }
        } else
        if(flag2)
        {
            d -= 90D;
        } else
        if(flag3)
        {
            d += 90D;
        }
        if(flag || flag2 || flag1 || flag3)
        {
            entityplayersp.motionX = Math.cos(Math.toRadians(d));
            entityplayersp.motionZ = Math.sin(Math.toRadians(d));
        }
        entityplayersp.motionX *= run;
        entityplayersp.motionY *= run;
        entityplayersp.motionZ *= run;
    }
    

	public static void modifyFile(String filePath, String oldString, String newString)
    {
        File fileToBeModified = new File(filePath);        
        String oldContent = "";        
        BufferedReader reader = null;      
        FileWriter writer = null;
         
        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));
            String line = reader.readLine();          
            while (line != null) 
            {
                oldContent = oldContent + line + System.lineSeparator();
                line = reader.readLine();
            }
            String newContent = oldContent.replaceAll(oldString, newString); 
            writer = new FileWriter(fileToBeModified);
            writer.write(newContent);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                reader.close();                
                writer.close();
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
    }

    }
	
	
	
	

	
	