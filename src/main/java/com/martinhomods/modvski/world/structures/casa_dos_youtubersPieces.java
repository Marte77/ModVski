package com.martinhomods.modvski.world.structures;

import com.google.common.collect.ImmutableMap;
import com.martinhomods.modvski.init.StructuresInit;
import com.martinhomods.modvski.modvski;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.TemplateStructurePiece;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.List;
import java.util.Map;
import java.util.Random;

/*
 * This class is based off of the IglooPieces class which I am assuming is doing the proper way of generating
 * structures. If you look at SwampHutPiece or DesertPyramidPiece, you'll see they manually hardcoded every block by
 * hand which is tedious and time consuming. It is also difficult to visualize it which is why I highly encourage the
 * use of structure blocks and Jigsaw structures. The way I am showing you right now is Structure Blocks + manual placing.
 *
 * Also, you might notice that some structures like Pillager Outposts or Villages uses a special block called
 * Jigsaw Block to randomize which structure nbt to use to attach to other parts of the structure and still keep it
 * looking clean. Jigsaw structures handles the height placing, rotations, and attaching pieces to each other for you!
 * Thus, Jigsaw structures are a great alternative (and preferable in my opinion) to this method I am currently showing you.
 * But once you're familiar with modding and is pretty experienced with coding, go try and make a structure using
 * Jigsaw blocks! (Look at PillagerOutpostPieces or VillagePieces and how it used JigsawPattern and JigsawManager.
 *  Once mastered, you will be able to generate massive structures that are unique every time you find one.
 */
public class casa_dos_youtubersPieces {
    /*
     * Here is a video on how to save a structure with structure blocks. https://www.youtube.com/watch?v=ylGFb4F4xVk&t=1s
     * Once saved, the structure nbt file is store in that world's save folder within the generated folder inside.
     *
     * Move the nbt file of your structure into data.mod_id.structures folder under src/main/resources in your mod.
     * That's data folder. Not assets. I messed up before and put it in the wrong place lmao. It goes in data folder!
     * Make sure the nbt file name is all lowercase and uses no spaces. That's the naming convention.
     *
     * Here, I have two structure nbt files named run_down_house_left_side.nbt and run_down_house_right_side.nbt
     * and I access them with the following resource locations below.
     */
    private static final ResourceLocation casa_youtubers = new ResourceLocation(modvski.MODID, "casa_dos_youtubers");
    private static final Map<ResourceLocation, BlockPos> OFFSET = ImmutableMap.of(casa_youtubers, new BlockPos(0, 1, 0));

    /*
     * Begins assembling your structure and where the pieces needs to go.
     */
    public static void start(TemplateManager templateManager, BlockPos pos, Rotation rotation, List<StructurePiece> pieceList, Random random) {
        int x = pos.getX();
        int z = pos.getZ();

        // This is how we factor in rotation for multi-piece structures.
        //
        // I would recommend using the OFFSET map above to have each piece at correct height relative of each other
        // and keep the X and Z equal to 0. And then in rotations, have the centermost piece have a rotation
        // of 0, 0, 0 and then have all other pieces' rotation be based off of the bottommost left corner of
        // that piece (the corner that is smallest in X and Z).
        //
        // Lots of trial and error may be needed to get this right for your structure.
        BlockPos rotationOffSet = new BlockPos(0, 0, 0).rotate(rotation);
        BlockPos blockpos = rotationOffSet.offset(x, pos.getY(), z);
        pieceList.add(new Piece(templateManager, casa_youtubers, blockpos, rotation));


    }

    /*
     * Here's where some voodoo happens. Most of this doesn't need to be touched but you do
     * have to pass in the IStructurePieceType you registered into the super constructors.
     *
     * The method you will most likely want to touch is the handleDataMarker method.
     */
    public static class Piece extends TemplateStructurePiece {
        private ResourceLocation resourceLocation;
        private Rotation rotation;

        public Piece(TemplateManager templateManagerIn, ResourceLocation resourceLocationIn, BlockPos pos, Rotation rotationIn) {
            super(StructuresInit.CASA_DOS_YOUTUBERS_PIECE, 0);
            this.resourceLocation = resourceLocationIn;
            BlockPos blockpos = casa_dos_youtubersPieces.OFFSET.get(resourceLocation);
            this.templatePosition = pos.offset(blockpos.getX(), blockpos.getY(), blockpos.getZ());
            this.rotation = rotationIn;
            this.setupPiece(templateManagerIn);
        }

        public Piece(TemplateManager templateManagerIn, CompoundNBT tagCompound) {
            super(StructuresInit.CASA_DOS_YOUTUBERS_PIECE, tagCompound);
            this.resourceLocation = new ResourceLocation(tagCompound.getString("Template"));
            this.rotation = Rotation.valueOf(tagCompound.getString("Rot"));
            this.setupPiece(templateManagerIn);
        }

        private void setupPiece(TemplateManager templateManager) {
            Template template = templateManager.get(this.resourceLocation);
            PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation).setMirror(Mirror.NONE);
            this.setup(template, this.templatePosition, placementsettings);
        }


        /**
         * (abstract) Helper method to read subclass data from NBT
         */
        @Override
        protected void addAdditionalSaveData(CompoundNBT tagCompound) {
            super.addAdditionalSaveData(tagCompound);
            tagCompound.putString("Template", this.resourceLocation.toString());
            tagCompound.putString("Rot", this.rotation.name());

        }




        /*
         * If you added any data marker structure blocks to your structure, you can access and modify them here.
         * In this case, our structure has a data maker with the string "chest" put into it. So we check to see
         * if the incoming function is "chest" and if it is, we now have that exact position.
         *
         * So what is done here is we replace the structure block with
         * a chest and we can then set the loottable for it.
         *
         * You can set other data markers to do other behaviors such as spawn a random mob in a certain spot,
         * randomize what rare block spawns under the floor, or what item an Item Frame will have.
         */

        @Override
        protected void handleDataMarker(String p_186175_1_, BlockPos p_186175_2_, IServerWorld p_186175_3_, Random p_186175_4_, MutableBoundingBox p_186175_5_) {

        }
    }
}
