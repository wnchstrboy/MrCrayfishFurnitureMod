package com.mrcrayfish.furniture.blocks;

import com.mrcrayfish.furniture.gui.GuiEditValueContainer;
import com.mrcrayfish.furniture.tileentity.IValueContainer;
import com.mrcrayfish.furniture.tileentity.TileEntityModernTV;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * Author: MrCrayfish
 */
public class BlockModernTV extends BlockFurnitureTile
{
    public BlockModernTV()
    {
        super(Material.ANVIL);
        this.setUnlocalizedName("modern_tv");
        this.setRegistryName("modern_tv");
    }

    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        return new TileEntityModernTV(22, 12);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityModernTV(22, 12);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if(worldIn.isRemote)
        {
            TileEntity tileEntity = worldIn.getTileEntity(pos);
            if(tileEntity instanceof IValueContainer)
            {
                Minecraft mc = Minecraft.getMinecraft();
                mc.displayGuiScreen(new GuiEditValueContainer((IValueContainer) tileEntity));
            }
        }
        return true;
    }
}