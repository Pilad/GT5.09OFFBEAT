package gregtech.api.threads;

import gregtech.api.GregTech_API;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.interfaces.tileentity.IMachineBlockUpdateable;
import gregtech.api.metatileentity.BaseMetaPipeEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;

import java.util.ArrayList;

public class GT_Runnable_MachineBlockUpdate implements Runnable {
    private final int mX, mY, mZ;
    private final World mWorld;

    public static boolean isProcessingAllowed = true;

    public GT_Runnable_MachineBlockUpdate(World aWorld, int aX, int aY, int aZ) {
        mWorld = aWorld;
        mX = aX;
        mY = aY;
        mZ = aZ;
    }

    private static void stepToUpdateMachine(World aWorld, int aX, int aY, int aZ, ArrayList<ChunkPosition> aList) {
        if(!isProcessingAllowed)
            return;
        aList.add(new ChunkPosition(aX, aY, aZ));
        TileEntity tTileEntity = aWorld.getTileEntity(aX, aY, aZ);
        if (tTileEntity instanceof IMachineBlockUpdateable) {
            ((IMachineBlockUpdateable) tTileEntity).onMachineBlockUpdate();
        }
        boolean isCable = false;
        if (tTileEntity instanceof IGregTechTileEntity) {
            isCable = tTileEntity instanceof BaseMetaPipeEntity;
        }
        if (aList.size() < 5 || (tTileEntity instanceof IMachineBlockUpdateable && !isCable) || (GregTech_API.isMachineBlock(aWorld.getBlock(aX, aY, aZ), aWorld.getBlockMetadata(aX, aY, aZ)) && !isCable)) {
            if (!aList.contains(new ChunkPosition(aX + 1, aY, aZ))) stepToUpdateMachine(aWorld, aX + 1, aY, aZ, aList);
            if (!aList.contains(new ChunkPosition(aX - 1, aY, aZ))) stepToUpdateMachine(aWorld, aX - 1, aY, aZ, aList);
            if (!aList.contains(new ChunkPosition(aX, aY + 1, aZ))) stepToUpdateMachine(aWorld, aX, aY + 1, aZ, aList);
            if (!aList.contains(new ChunkPosition(aX, aY - 1, aZ))) stepToUpdateMachine(aWorld, aX, aY - 1, aZ, aList);
            if (!aList.contains(new ChunkPosition(aX, aY, aZ + 1))) stepToUpdateMachine(aWorld, aX, aY, aZ + 1, aList);
            if (!aList.contains(new ChunkPosition(aX, aY, aZ - 1))) stepToUpdateMachine(aWorld, aX, aY, aZ - 1, aList);

            if (!aList.contains(new ChunkPosition(aX + 1, aY+1, aZ))) stepToUpdateMachine(aWorld, aX + 1, aY+1, aZ, aList);
            if (!aList.contains(new ChunkPosition(aX - 1, aY+1, aZ))) stepToUpdateMachine(aWorld, aX - 1, aY+1, aZ, aList);
            if (!aList.contains(new ChunkPosition(aX, aY+1, aZ + 1))) stepToUpdateMachine(aWorld, aX, aY+1, aZ + 1, aList);
            if (!aList.contains(new ChunkPosition(aX, aY+1, aZ - 1))) stepToUpdateMachine(aWorld, aX, aY+1, aZ - 1, aList);

            if (!aList.contains(new ChunkPosition(aX + 1, aY-1, aZ))) stepToUpdateMachine(aWorld, aX + 1, aY-1, aZ, aList);
            if (!aList.contains(new ChunkPosition(aX - 1, aY-1, aZ))) stepToUpdateMachine(aWorld, aX - 1, aY-1, aZ, aList);
            if (!aList.contains(new ChunkPosition(aX, aY-1, aZ + 1))) stepToUpdateMachine(aWorld, aX, aY-1, aZ + 1, aList);
            if (!aList.contains(new ChunkPosition(aX, aY-1, aZ - 1))) stepToUpdateMachine(aWorld, aX, aY-1, aZ - 1, aList);

        }
    }

    @Override
    public void run() {
        try {
            stepToUpdateMachine(mWorld, mX, mY, mZ, new ArrayList<>());
        } catch (Throwable e) {/**/}
    }
}