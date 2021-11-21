package net.minecraft.src;

public class TileEntityChest extends TileEntity implements IInventory {
    private ItemStack[] chestContents = new ItemStack[36];
    public TileEntityChest field_35152_b;
    public TileEntityChest field_35153_c;
    public TileEntityChest field_35150_d;
    public TileEntityChest field_35151_e;
    public float field_35148_f;
    public float field_35149_g;
    public int field_35156_h;
    private int field_35154_q;
    public boolean field_35155_a = false;


    public int getSizeInventory() {
        return 27;
    }

    public ItemStack getStackInSlot(int var1) {
        return this.chestContents[var1];
    }


    public ItemStack decrStackSize(int var1, int var2) {
        if (this.chestContents[var1] != null) {
            ItemStack var3;
            if (this.chestContents[var1].stackSize <= var2) {
                var3 = this.chestContents[var1];
                this.chestContents[var1] = null;
                this.onInventoryChanged();
                return var3;
            } else {
                var3 = this.chestContents[var1].splitStack(var2);
                if (this.chestContents[var1].stackSize == 0) {
                    this.chestContents[var1] = null;
                }

                this.onInventoryChanged();
                return var3;
            }
        } else {
            return null;
        }
    }

    public void setInventorySlotContents(int var1, ItemStack var2) {
        this.chestContents[var1] = var2;
        if (var2 != null && var2.stackSize > this.getInventoryStackLimit()) {
            var2.stackSize = this.getInventoryStackLimit();
        }

        this.onInventoryChanged();
    }

    public String getInvName() {
        return "Chest";
    }

    public void readFromNBT(NBTTagCompound var1) {
        super.readFromNBT(var1);
        NBTTagList var2 = var1.getTagList("Items");
        this.chestContents = new ItemStack[this.getSizeInventory()];

        for(int var3 = 0; var3 < var2.tagCount(); ++var3) {
            NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
            int var5 = var4.getByte("Slot") & 255;
            if (var5 >= 0 && var5 < this.chestContents.length) {
                this.chestContents[var5] = new ItemStack(var4);
            }
        }

    }

    public void writeToNBT(NBTTagCompound var1) {
        super.writeToNBT(var1);
        NBTTagList var2 = new NBTTagList();

        for(int var3 = 0; var3 < this.chestContents.length; ++var3) {
            if (this.chestContents[var3] != null) {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte)var3);
                this.chestContents[var3].writeToNBT(var4);
                var2.setTag(var4);
            }
        }

        var1.setTag("Items", var2);
    }

    public int getInventoryStackLimit() {
        return 640;
    }

    public boolean canInteractWith(EntityPlayer var1) {
        if (this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this) {
            return false;
        } else {
            return var1.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
        }
    }
    public void func_35147_g() {
        if (!this.field_35155_a) {
            this.field_35155_a = true;
            this.field_35152_b = null;
            this.field_35153_c = null;
            this.field_35150_d = null;
            this.field_35151_e = null;
            if (this.worldObj.getBlockId(this.xCoord - 1, this.yCoord, this.zCoord) == Block.chest.blockID) {
                this.field_35150_d = (TileEntityChest)this.worldObj.getBlockTileEntity(this.xCoord - 1, this.yCoord, this.zCoord);
            }

            if (this.worldObj.getBlockId(this.xCoord + 1, this.yCoord, this.zCoord) == Block.chest.blockID) {
                this.field_35153_c = (TileEntityChest)this.worldObj.getBlockTileEntity(this.xCoord + 1, this.yCoord, this.zCoord);
            }

            if (this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord - 1) == Block.chest.blockID) {
                this.field_35152_b = (TileEntityChest)this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord - 1);
            }

            if (this.worldObj.getBlockId(this.xCoord, this.yCoord, this.zCoord + 1) == Block.chest.blockID) {
                this.field_35151_e = (TileEntityChest)this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord + 1);
            }

            if (this.field_35152_b != null) {
                this.field_35152_b.func_35144_b();
            }

            if (this.field_35151_e != null) {
                this.field_35151_e.func_35144_b();
            }

            if (this.field_35153_c != null) {
                this.field_35153_c.func_35144_b();
            }

            if (this.field_35150_d != null) {
                this.field_35150_d.func_35144_b();
            }

        }
    }
    public void func_35144_b() {
        super.func_35144_b();
        this.field_35155_a = false;
    }
}
