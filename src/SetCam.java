package net.minecraft.src;

public class SetCam extends EntityLiving{
	public SetCam(World world)
    {
        super(world);
    }

    public boolean canBePushed()
    {
        return false;
    }

    public void onEntityUpdate()
    {
    }

    public void onUpdate()
    {
    }

    public void onDeath(Entity entity)
    {
    }

    public boolean isEntityAlive()
    {
        return true;
    }

    public void setCamera(double d, double d1, double d2, float f, 
            float f1)
    {
        lastTickPosX = posX;
        lastTickPosY = posY;
        lastTickPosZ = posZ;
        posX += d;
        posY += d1;
        posZ += d2;
        prevRotationYaw = rotationYaw;
        prevRotationPitch = rotationPitch;
        rotationYaw = f;
        rotationPitch = f1;
    }
}
	

	 	


