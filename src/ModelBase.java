package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

public abstract class ModelBase {
    public float onGround;
    public boolean isRiding = false;
    public List field_35394_j = new ArrayList();

    public void render(float var1, float var2, float var3, float var4, float var5, float var6) {
    }

    public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6) {
    }

    public void setLivingAnimations(EntityLiving var1, float var2, float var3, float var4) {
    }
}
