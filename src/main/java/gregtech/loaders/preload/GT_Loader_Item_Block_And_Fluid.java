package gregtech.loaders.preload;

import codechicken.nei.api.API;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.registry.GameRegistry;
import gregtech.GT_Mod;
import gregtech.api.GregTech_API;
import gregtech.api.enums.*;
import gregtech.api.items.GT_Generic_Item;
import gregtech.api.items.GT_RadioactiveCellIC_Item;
import gregtech.api.metatileentity.BaseMetaPipeEntity;
import gregtech.api.metatileentity.BaseMetaTileEntity;
import gregtech.api.util.GT_Log;
import gregtech.api.util.GT_ModHandler;
import gregtech.api.util.GT_OreDictUnificator;
import gregtech.api.util.GT_Utility;
import gregtech.common.blocks.*;
import gregtech.common.items.*;
import gregtech.common.items.armor.ElectricModularArmor1;
import gregtech.common.items.armor.ModularArmor_Item;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;

import java.util.Locale;

public class GT_Loader_Item_Block_And_Fluid
        implements Runnable {
    public void run() {
        Materials.Water.mFluid = (Materials.Ice.mFluid = GT_ModHandler.getWater(1000L).getFluid());
        Materials.Lava.mFluid = GT_ModHandler.getLava(1000L).getFluid();

        GT_Log.out.println("GT_Mod: Register Books.");

        GT_Utility.getWrittenBook("Manual_Printer", "Printer Manual V2.0", "Gregorius Techneticies", "This Manual explains the different Functionalities the GregTech Printing Factory has built in, which are not in NEI. Most got NEI Support now, but there is still some left without it.",
                "1. Coloring Items and Blocks: You know those Crafting Recipes, which have a dye surrounded by 8 Item to dye them? Or the ones which have just one Item and one Dye in the Grid? Those two Recipe Types can be cheaply automated using the Printer.",
                "The Colorization Functionality even optimizes the Recipes, which normally require 8 Items + 1 Dye to 1 Item and an 8th of the normally used Dye in Fluid Form, isn't that awesome?",
                "2. Copying Books: This Task got slightly harder. The first Step is putting the written and signed Book inside the Scanner with a Data Stick ready to receive the Data.",
                "Now insert the Stick into the Data Slot of the Printer and add 3 pieces of Paper together with 144 Liters of actual Ink Fluid. Water mixed and chemical Dyes won't work on Paper without messing things up!",
                "You got a stack of Pages for your new Book, just put them into the Assembler with some Glue and a piece of Leather for the Binding, and you receive an identical copy of the Book, which would stack together with the original.",
                "3. Renaming Items: This Functionality is no longer Part of the Printer. There is now a Name Mold for the Forming Press to imprint a Name into an Item, just rename the Mold in an Anvil and use it in the Forming Press on any Item.",
                "4. Crafting of Books, Maps, Nametags etc etc etc: Those Recipes moved to other Machines, just look them up in NEI.");

        GT_Utility.getWrittenBook("Manual_Punch_Cards", "Punch Card Manual V0.0", "Gregorius Techneticies", "This Manual will explain the Functionality of the Punch Cards, once they are fully implemented. And no, they won't be like the IRL Punch Cards. This is just a current Idea Collection.",
                "(i1&&i2)?o1=15:o1=0;=10", "ignore all Whitespace Characters, use Long for saving the Numbers", "&& || ^^ & | ^ ! ++ -- + - % / // * ** << >> >>> < > <= >= == !=  ~ ( ) ?: , ; ;= ;=X; = i0 i1 i2 i3 i4 i5 o0 o1 o2 o3 o4 o5 v0 v1 v2 v3 v4 v5 v6 v7 v8 v9 m0 m1 m2 m3 m4 m5 m6 m7 m8 m9 A B C D E F",
                "'0' = false, 'everything but 0' = true, '!' turns '0' into '1' and everything else into '0'", "',' is just a separator for multiple executed Codes in a row.",
                "';' means that the Program waits until the next tick before continuing. ';=10' and ';=10;' both mean that it will wait 10 Ticks instead of 1. And ';=0' or anything < 0 will default to 0.",
                "If the '=' Operator is used within Brackets, it returns the value the variable has been set to.", "The Program saves the Char Index of the current Task, the 10 Variables (which reset to 0 as soon as the Program Loop stops), the 10 Member Variables and the remaining waiting Time in its NBT.",
                "A = 10, B = 11, C = 12, D = 13, E = 14, F = 15, just for Hexadecimal Space saving, since Redstone has only 4 Bits.",
                "For implementing Loops you just need 1 Punch Card per Loop, these Cards can restart once they are finished, depending on how many other Cards there are in the Program Loop you inserted your Card into, since it will process them procedurally.",
                "A Punch Card Processor can run up to four Loops, each with the length of seven Punch Cards, parallel.",
                "Why does the Punch Card need Ink to be made, you ask? Because the empty one needs to have some lines on, and the for the punched one it prints the Code to execute in a human readable format on the Card.");

        GT_Utility.getWrittenBook("Manual_Microwave", "Microwave Oven Manual", "Kitchen Industries", "Congratulations, you inserted a random seemingly empty Book into the Microwave and these Letters appeared out of nowhere.",
                "You just got a Microwave Oven and asked yourself 'why do I even need it?'. It's simple, the Microwave can cook for just 128 EU and at an insane speed. Not even a normal E-furnace can do it that fast and cheap!",
                "This is the cheapest and fastest way to cook for you. That is why the Microwave Oven can be found in almost every Kitchen (see www.youwannabuyakitchen.ly).",
                "Long time exposure to Microwaves can cause Cancer, but we doubt Steve lives long enough to die because of that.",
                "Do not insert any Metals. It might result in an Explosion.", "Do not dry Animals with it. It will result in a Hot Dog, no matter which Animal you put into it.",
                "Do not insert inflammable Objects. The Oven will catch on Fire.", "Do not insert Explosives such as Eggs. Just don't.");

        GT_Log.out.println("GT_Mod: Register Items.");

        new GT_IntegratedCircuit_Item();
        new GT_MetaGenerated_Item_01();
        new GT_MetaGenerated_Item_02();
        new GT_MetaGenerated_Item_03();
        new GT_MetaGenerated_Item_04();
        new GT_MetaGenerated_Tool_01();
        new GT_FluidDisplayItem();

        ItemList.Rotor_LV.set(GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Tin, 1L));
        ItemList.Rotor_MV.set(GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Bronze, 1L));
        ItemList.Rotor_HV.set(GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.Steel, 1L));
        ItemList.Rotor_EV.set(GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.StainlessSteel, 1L));
        ItemList.Rotor_IV.set(GT_OreDictUnificator.get(OrePrefixes.rotor, Materials.TungstenSteel, 1L));

        ItemList.VOLUMETRIC_FLASK.set(new GT_VolumetricFlask("Volumetric_Flask", "Volumetric flask", 1000));
        Item tItem = (Item) GT_Utility.callConstructor("gregtech.common.items.GT_SensorCard_Item", 0, null, false, new Object[]{"sensorcard", "GregTech Sensor Card"});
        ItemList.NC_SensorCard.set(tItem == null ? new GT_Generic_Item("sensorcard", "GregTech Sensor Card", "Nuclear Control not installed", false) : tItem);
        
        ItemList.Neutron_Reflector.set(new GT_NeutronReflector_Item("neutronreflector", "Iridium Neutron Reflector", 0));
        
        ItemList.Reactor_Coolant_He_1.set(GregTech_API.constructCoolantCellItem("60k_Helium_Coolantcell", "60k He Coolant Cell", 60000));
        
        ItemList.Reactor_Coolant_He_3.set(GregTech_API.constructCoolantCellItem("180k_Helium_Coolantcell", "180k He Coolant Cell", 180000));
        
        ItemList.Reactor_Coolant_He_6.set(GregTech_API.constructCoolantCellItem("360k_Helium_Coolantcell", "360k He Coolant Cell", 360000));
        
        ItemList.Reactor_Coolant_NaK_1.set(GregTech_API.constructCoolantCellItem("60k_NaK_Coolantcell", "60k NaK Coolantcell", 60000));
        
        ItemList.Reactor_Coolant_NaK_3.set(GregTech_API.constructCoolantCellItem("180k_NaK_Coolantcell", "180k NaK Coolantcell", 180000));
        
        ItemList.Reactor_Coolant_NaK_6.set(GregTech_API.constructCoolantCellItem("360k_NaK_Coolantcell", "360k NaK Coolantcell", 360000));
        
        ItemList.neutroniumHeatCapacitor.set(GregTech_API.constructCoolantCellItem("neutroniumHeatCapacitor", "1G Neutronium Heat Capacitor", 1000000000));
        
        ItemList.Reactor_Coolant_Le_1.set(GregTech_API.constructCoolantCellItem("180k_Ledox_Coolantcell", "180k Super Coolant Cell", 180000));
        
        ItemList.Reactor_Coolant_Le_2.set(GregTech_API.constructCoolantCellItem("360k_Ledox_Coolantcell", "360k Super Coolant Cell", 360000));
        
		ItemList.Reactor_Coolant_Le_3.set(GregTech_API.constructCoolantCellItem("540k_Ledox_Coolantcell", "540k Super Coolant Cell", 540000));
        
		ItemList.Reactor_Coolant_Le_6.set(GregTech_API.constructCoolantCellItem("1080k_Ledox_Coolantcell", "1080k Super Coolant Cell", 1080000));
        
        if(!GregTech_API.mIC2Classic){
        ItemList.Depleted_Thorium_1.set(new GT_DepletetCell_Item("ThoriumcellDep", "Fuel Rod (Depleted Thorium)", 1));
        ItemList.Depleted_Thorium_2.set(new GT_DepletetCell_Item("Double_ThoriumcellDep", "Dual Fuel Rod (Depleted Thorium)", 1));
        ItemList.Depleted_Thorium_4.set(new GT_DepletetCell_Item("Quad_ThoriumcellDep", "Quad Fuel Rod (Depleted Thorium)", 1));

        ItemList.ThoriumCell_1.set(new GT_RadioactiveCellIC_Item("Thoriumcell", "Fuel Rod (Thorium)", 1, 50000, 0.4F, 0, 0.25F, ItemList.Depleted_Thorium_1.get(1),false));

        ItemList.ThoriumCell_2.set(new GT_RadioactiveCellIC_Item("Double_Thoriumcell", "Dual Fuel Rod (Thorium)", 2, 50000, 0.4F, 0, 0.25F, ItemList.Depleted_Thorium_2.get(1),false));
        GT_ModHandler.addCraftingRecipe(ItemList.ThoriumCell_2.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"RPR", "   ", "   ", 'R', ItemList.ThoriumCell_1, 'P', OrePrefixes.plate.get(Materials.Zirconium)});

        ItemList.ThoriumCell_4.set(new GT_RadioactiveCellIC_Item("Quad_Thoriumcell", "Quad Fuel Rod (Thorium)", 4, 50000, 0.4F, 0, 0.25F, ItemList.Depleted_Thorium_4.get(1),false));
        GT_ModHandler.addCraftingRecipe(ItemList.ThoriumCell_4.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"RPR", "CPC", "RPR", 'R', ItemList.ThoriumCell_1, 'P', OrePrefixes.plate.get(Materials.Zirconium), 'C', OrePrefixes.plate.get(Materials.Copper)});

        ItemList.Depleted_Naquadah_1.set(new GT_DepletetCell_Item("NaquadahcellDep", "Fuel Rod (Depleted Naquadah)", 1));
        ItemList.Depleted_Naquadah_2.set(new GT_DepletetCell_Item("Double_NaquadahcellDep", "Dual Fuel Rod (Depleted Naquadah)", 1));
        ItemList.Depleted_Naquadah_4.set(new GT_DepletetCell_Item("Quad_NaquadahcellDep", "Quad Fuel Rod (Depleted Naquadah)", 1));
        ItemList.NaquadahCell_1.set(new GT_RadioactiveCellIC_Item("Naquadahcell", "Fuel Rod (Naquadah)", 1, 100000, 2F, 1, 1F, ItemList.Depleted_Naquadah_1.get(1), false));
        ItemList.NaquadahCell_2.set(new GT_RadioactiveCellIC_Item("Double_Naquadahcell", "Dual Fuel Rod (Naquadah)", 2, 100000, 2F, 1, 1F, ItemList.Depleted_Naquadah_2.get(1), false));
        ItemList.NaquadahCell_4.set(new GT_RadioactiveCellIC_Item("Quad_Naquadahcell", "Quad Fuel Rod (Naquadah)", 4, 100000, 2F, 1, 1F, ItemList.Depleted_Naquadah_4.get(1), false));
        
        GT_Values.RA.addAssemblerRecipe(ItemList.NaquadahCell_1.get(2L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 4L), GT_Values.NF, ItemList.NaquadahCell_2.get(1L), 100, 400);
        
        GT_Values.RA.addAssemblerRecipe(ItemList.NaquadahCell_2.get(2L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 4L), GT_Values.NF, ItemList.NaquadahCell_4.get(1L), 100, 400);
        GT_Values.RA.addAssemblerRecipe(ItemList.NaquadahCell_1.get(4L), GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.TungstenSteel, 6L), GT_Values.NF, ItemList.NaquadahCell_4.get(1L), 150, 400);
        
        ////GT_ModHandler.addCraftingRecipe(ItemList.NaquadahCell_2.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"RPR", "   ", "   ", 'R', ItemList.NaquadahCell_1, 'P', OrePrefixes.plate.get(Materials.Iron)});
        ////GT_ModHandler.addCraftingRecipe(ItemList.NaquadahCell_4.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"RPR", "CPC", "RPR", 'R', ItemList.NaquadahCell_1, 'P', OrePrefixes.plate.get(Materials.Iron), 'C', OrePrefixes.plate.get(Materials.Copper)});
        //(ItemStack aInput1, ItemStack aInput2, FluidStack aFluidInput, FluidStack aFluidOutput, ItemStack aOutput1, ItemStack aOutput2, ItemStack aOutput3, ItemStack aOutput4, ItemStack aOutput5, ItemStack aOutput6, int[] aChances, int aDuration, int aEUt)

        ItemList.Depleted_MNq_1.set(new GT_DepletetCell_Item("MNqCellDep", "Fuel Rod (Depleted Nq+)", 1));
        ItemList.Depleted_MNq_2.set(new GT_DepletetCell_Item("Double_MNqCellDep", "Dual Fuel Rod (Depleted Nq+)", 1));
        ItemList.Depleted_MNq_4.set(new GT_DepletetCell_Item("Quad_MNqCellDep", "Quad Fuel Rod (Depleted Nq+)", 1));
        ItemList.MNqCell_1.set(new GT_RadioactiveCellIC_Item("MNqCell", "Fuel Rod (Nq+ - MOX like behaviour)", 1, 100000, 2F, 1, 1F, ItemList.Depleted_MNq_1.get(1), true));
        ItemList.MNqCell_2.set(new GT_RadioactiveCellIC_Item("Double_MNqCell", "Dual Fuel Rod (Nq+ - MOX like behaviour)", 2, 100000, 2F, 1, 1F, ItemList.Depleted_MNq_2.get(1), true));
        ItemList.MNqCell_4.set(new GT_RadioactiveCellIC_Item("Quad_MNqCell", "Quad Fuel Rod (Nq+ - MOX like behaviour)", 4, 100000, 2F, 1, 1F, ItemList.Depleted_MNq_4.get(1), true));

        GT_Values.RA.addAssemblerRecipe(ItemList.MNqCell_1.get(2L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 4L), GT_Values.NF, ItemList.MNqCell_2.get(1L), 100, 400);
        
        GT_Values.RA.addAssemblerRecipe(ItemList.MNqCell_2.get(2L), GT_OreDictUnificator.get(OrePrefixes.stick, Materials.TungstenSteel, 4L), GT_Values.NF, ItemList.MNqCell_4.get(1L), 100, 400);
        GT_Values.RA.addAssemblerRecipe(ItemList.MNqCell_1.get(4L), GT_OreDictUnificator.get(OrePrefixes.stickLong, Materials.TungstenSteel, 6L), GT_Values.NF, ItemList.MNqCell_4.get(1L), 150, 400);

        ItemList.Uraniumcell_1.set(new GT_RadioactiveCellIC_Item("reactorUraniumSimple", "Fuel Rod (Uranium)"       , 1, 20000, 2F, 1, 1F, GT_ModHandler.getIC2Item("reactorDepletedUraniumSimple", 1),false));
        ItemList.Uraniumcell_2.set(new GT_RadioactiveCellIC_Item("reactorUraniumDual", "Dual Fuel Rod (Uranium)"  , 2, 20000, 2F, 1, 1F, GT_ModHandler.getIC2Item("reactorDepletedUraniumDual", 1),false));
        ItemList.Uraniumcell_4.set(new GT_RadioactiveCellIC_Item("reactorUraniumQuad"  , "Quad Fuel Rod (Uranium)"  , 4, 20000, 2F, 1, 1F, GT_ModHandler.getIC2Item("reactorDepletedUraniumQuad"  , 1),false));
        ItemList.Moxcell_1.set(new GT_RadioactiveCellIC_Item("reactorMOXSimple", "Fuel Rod (Mox)", 1, 10000, 2F, 1, 1F, GT_ModHandler.getIC2Item("reactorDepletedMOXSimple", 1),true));
        ItemList.Moxcell_2.set(new GT_RadioactiveCellIC_Item("reactorMOXDual"  , "Dual Fuel Rod (Mox)", 2, 10000, 2F, 1, 1F, GT_ModHandler.getIC2Item("reactorDepletedMOXDual", 1),true));
        ItemList.Moxcell_4.set(new GT_RadioactiveCellIC_Item("reactorMOXQuad", "Quad Fuel Rod (Mox)"  , 4, 10000, 2F, 1, 1F, GT_ModHandler.getIC2Item("reactorDepletedMOXQuad"  , 1),true));

        ItemList.Depleted_MThCell_1.set(new GT_DepletetCell_Item("MThCellDep", "Fuel Rod (Depleted MOX Thorium)", 1));
        ItemList.Depleted_MThCell_2.set(new GT_DepletetCell_Item("Double_MThCellDep", "Dual Fuel Rod (Depleted MOX Thorium)", 1));
        ItemList.Depleted_MThCell_4.set(new GT_DepletetCell_Item("Quad_MThCellDep", "Quad Fuel Rod (Depleted MOX Thorium)", 1));

        ItemList.MThCell_1.set(new GT_RadioactiveCellIC_Item("MThcell", "Fuel Rod (MOX Thorium)", 1, 20000, 1F, 1, 0.5F, ItemList.Depleted_MThCell_1.get(1),true));
        ItemList.MThCell_2.set(new GT_RadioactiveCellIC_Item("Double_MThcell", "Dual Fuel Rod (MOX Thorium)", 2, 20000, 1F, 1, 0.5F, ItemList.Depleted_MThCell_2.get(1),true));
        ItemList.MThCell_4.set(new GT_RadioactiveCellIC_Item("Quad_MThcell", "Quad Fuel Rod (MOX Thorium)", 4, 20000, 1F, 1, 0.5F, ItemList.Depleted_MThCell_4.get(1),true));

        GT_ModHandler.addCraftingRecipe(ItemList.MThCell_2.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"RPR", "   ", "   ", 'R', ItemList.MThCell_1, 'P', OrePrefixes.plate.get(Materials.Zirconium)});
        GT_ModHandler.addCraftingRecipe(ItemList.MThCell_4.get(1L), GT_ModHandler.RecipeBits.BUFFERED | GT_ModHandler.RecipeBits.NOT_REMOVABLE, new Object[]{"RPR", "CPC", "RPR", 'R', ItemList.MThCell_1, 'P', OrePrefixes.plate.get(Materials.Zirconium), 'C', OrePrefixes.plate.get(Materials.Copper)});

        }
        GT_Log.out.println("GT_Mod: Adding Blocks.");
        GregTech_API.sBlockMachines = new GT_Block_Machines();
        GregTech_API.sBlockCasings1 = new GT_Block_Casings1();
        GregTech_API.sBlockCasings2 = new GT_Block_Casings2();
        GregTech_API.sBlockCasings3 = new GT_Block_Casings3();
        GregTech_API.sBlockCasings4 = new GT_Block_Casings4();
        GregTech_API.sBlockCasings5 = new GT_Block_Casings5();
        GregTech_API.sBlockCasings6 = new GT_Block_Casings6();
        GregTech_API.sBlockCasings7 = new GT_Block_Casings7();
        GregTech_API.sBlockCasings8 = new GT_Block_Casings8();
        GregTech_API.sBlockCasings9 = new GT_Block_Casings9();
        GregTech_API.sBlockCasingsNH = new GT_Block_CasingsNH();    
        GregTech_API.sBlockGranites = new GT_Block_Granites();
        GregTech_API.sBlockConcretes = new GT_Block_Concretes();
        GregTech_API.sBlockStones = new GT_Block_Stones();
        GregTech_API.sBlockOres1 = new GT_Block_Ores();
        if(Loader.isModLoaded("UndergroundBiomes") && GT_Mod.gregtechproxy.enableUBOres) {
            GregTech_API.sBlockOresUb1 = new GT_Block_Ores_UB1();
            GregTech_API.sBlockOresUb2 = new GT_Block_Ores_UB2();
            GregTech_API.sBlockOresUb3 = new GT_Block_Ores_UB3();
        }
        /*if(Loader.isModLoaded("GalacticraftCore") && Loader.isModLoaded("GalacticraftMars") && GT_Mod.gregtechproxy.enableGCOres) {
            GregTech_API.sBlockOresGC = new GT_Block_Ores_GC();
        }*/
        GregTech_API.sBlockMetal1 = new GT_Block_Metal("gt.blockmetal1", new Materials[]{
                Materials.Adamantium,
                Materials.Aluminium,
                Materials.Americium,
                Materials.AnnealedCopper,
                Materials.Antimony,
                Materials.Arsenic,
                Materials._NULL,
                Materials.BatteryAlloy,
                Materials.Beryllium,
                Materials.Bismuth,
                Materials.BismuthBronze,
                Materials.BlackBronze,
                Materials.BlackSteel,
                Materials.BlueAlloy,
                Materials.BlueSteel,
                Materials.Brass}, OrePrefixes.block, gregtech.api.enums.Textures.BlockIcons.STORAGE_BLOCKS1);

        GregTech_API.sBlockMetal2 = new GT_Block_Metal("gt.blockmetal2", new Materials[]{
                Materials.Bronze,
                Materials.Caesium,
                Materials.Cerium,
                Materials.Chrome,
                Materials.ChromiumDioxide,
                Materials.Cobalt,
                Materials.CobaltBrass,
                Materials.Copper,
                Materials.Cupronickel,
                Materials.DamascusSteel,
                Materials.DarkIron,
                Materials.DeepIron,
                Materials.Desh,
                Materials.Duranium,
                Materials._NULL,
                Materials.Electrum
        }, OrePrefixes.block, gregtech.api.enums.Textures.BlockIcons.STORAGE_BLOCKS2);

        GregTech_API.sBlockMetal3 = new GT_Block_Metal("gt.blockmetal3", new Materials[]{
                Materials.ElectrumFlux,
                Materials.Enderium,
                Materials._NULL,
                Materials.Europium,
                Materials._NULL,
                Materials.Gadolinium,
                Materials.Gallium,
                Materials._NULL,
                Materials.HSLA,
                Materials.Indium,
                Materials._NULL,
                Materials.Invar,
                Materials.Iridium,
                Materials.IronMagnetic,
                Materials._NULL,
                Materials.Kanthal
        }, OrePrefixes.block, gregtech.api.enums.Textures.BlockIcons.STORAGE_BLOCKS3);

        GregTech_API.sBlockMetal4 = new GT_Block_Metal("gt.blockmetal4", new Materials[]{
                Materials._NULL,
                Materials.Lanthanum,
                Materials.Lead,
                Materials.Lutetium,
                Materials.Magnalium,
                Materials.Magnesium,
                Materials.Manganese,
                Materials.MeteoricIron,
                Materials.MeteoricSteel,
                Materials._NULL,
                Materials.Mithril,
                Materials.Molybdenum,
                Materials.Naquadah,
                Materials.NaquadahAlloy,
                Materials.NaquadahEnriched,
                Materials.Naquadria
        }, OrePrefixes.block, gregtech.api.enums.Textures.BlockIcons.STORAGE_BLOCKS4);

        GregTech_API.sBlockMetal5 = new GT_Block_Metal("gt.blockmetal5", new Materials[]{
                Materials.Neodymium,
                Materials.NeodymiumMagnetic,
                Materials.Neutronium,
                Materials.Nichrome,
                Materials.Nickel,
                Materials.Niobium,
                Materials._NULL,
                Materials.NiobiumTitanium,
                Materials.Osmiridium,
                Materials.Osmium,
                Materials.Palladium,
                Materials._NULL,
                Materials.Platinum,
                Materials.Plutonium,
                Materials.Plutonium241,
                Materials._NULL
        }, OrePrefixes.block, gregtech.api.enums.Textures.BlockIcons.STORAGE_BLOCKS5);

        GregTech_API.sBlockMetal6 = new GT_Block_Metal("gt.blockmetal6", new Materials[]{
                Materials._NULL,
                Materials.RedAlloy,
                Materials.RedSteel,
                Materials.RoseGold,
                Materials.Rubidium,
                Materials.Samarium,
                Materials._NULL,
                Materials._NULL,
                Materials._NULL,
                Materials.Silicon,
                Materials.Silver,
                Materials.SolderingAlloy,
                Materials.StainlessSteel,
                Materials.Steel,
                Materials.SteelMagnetic,
                Materials._NULL
        }, OrePrefixes.block, gregtech.api.enums.Textures.BlockIcons.STORAGE_BLOCKS6);

        GregTech_API.sBlockMetal7 = new GT_Block_Metal("gt.blockmetal7", new Materials[]{
                Materials.Sunnarium,
                Materials.Tantalum,
                Materials.Tellurium,
                Materials._NULL,
                Materials._NULL,
                Materials.Thorium,
                Materials._NULL,
                Materials.Tin,
                Materials.TinAlloy,
                Materials.Titanium,
                Materials.Tritanium,
                Materials.Tungsten,
                Materials.TungstenSteel,
                Materials.Ultimet,
                Materials.Uranium,
                Materials.Uranium235
        }, OrePrefixes.block, gregtech.api.enums.Textures.BlockIcons.STORAGE_BLOCKS7);

        GregTech_API.sBlockMetal8 = new GT_Block_Metal("gt.blockmetal8", new Materials[]{
                Materials.Vanadium,
                Materials.VanadiumGallium,
                Materials.WroughtIron,
                Materials.Ytterbium,
                Materials.Yttrium,
                Materials.YttriumBariumCuprate,
                Materials.Zinc,
                Materials.TungstenCarbide,
                Materials.VanadiumSteel,
                Materials.HSSG,
                Materials.HSSE,
                Materials.HSSS,
                Materials.EuropiumoxideMagnetic,
                Materials.Steeleaf,
                Materials.Blaze,
                Materials._NULL
        }, OrePrefixes.block, gregtech.api.enums.Textures.BlockIcons.STORAGE_BLOCKS8);

        GregTech_API.sBlockGem1 = new GT_Block_Metal("gt.blockgem1", new Materials[]{
                Materials._NULL,
                Materials.Amber,
                Materials.Amethyst,
                Materials._NULL,
                Materials.BlueTopaz,
                Materials.CertusQuartz,
                Materials._NULL,
                Materials.EnderEye,
                Materials.EnderPearl,
                Materials.FoolsRuby,
                Materials._NULL,
                Materials.Forcicium,
                Materials.Forcillium,
                Materials.GreenSapphire,
                Materials._NULL,
                Materials.Jasper
        }, OrePrefixes.block, gregtech.api.enums.Textures.BlockIcons.STORAGE_BLOCKS9);

        GregTech_API.sBlockGem2 = new GT_Block_Metal("gt.blockgem2", new Materials[]{
                Materials.Lazurite,
                Materials.Lignite,
                Materials.Monazite,
                Materials._NULL,
                Materials.Olivine,
                Materials.Opal,
                Materials._NULL,
                Materials._NULL,
                Materials.Phosphorus,
                Materials.Quartzite,
                Materials.GarnetRed,
                Materials.Ruby,
                Materials.Sapphire,
                Materials.Sodalite,
                Materials.Tanzanite,
                Materials._NULL
        }, OrePrefixes.block, gregtech.api.enums.Textures.BlockIcons.STORAGE_BLOCKS10);

        GregTech_API.sBlockGem3 = new GT_Block_Metal("gt.blockgem3", new Materials[]{
                Materials.Topaz,
                Materials._NULL,
                Materials.GarnetYellow,
                Materials.NetherStar,
                Materials.Charcoal
        }, OrePrefixes.block, gregtech.api.enums.Textures.BlockIcons.STORAGE_BLOCKS11);

        GregTech_API.sBlockReinforced = new GT_Block_Reinforced("gt.blockreinforced");


        GT_Log.out.println("GT_Mod: Register TileEntities.");


        BaseMetaTileEntity tBaseMetaTileEntity = GregTech_API.constructBaseMetaTileEntity();

        GT_Log.out.println("GT_Mod: Testing BaseMetaTileEntity.");
        if (tBaseMetaTileEntity == null) {
            GT_Log.out.println("GT_Mod: Fatal Error ocurred while initializing TileEntities, crashing Minecraft.");
            throw new RuntimeException("");
        }
        GT_Log.out.println("GT_Mod: Registering the BaseMetaTileEntity.");
        GameRegistry.registerTileEntity(tBaseMetaTileEntity.getClass(), "BaseMetaTileEntity");
        FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", tBaseMetaTileEntity.getClass().getName());

        GT_Log.out.println("GT_Mod: Registering the BaseMetaPipeEntity.");
        GameRegistry.registerTileEntity(BaseMetaPipeEntity.class, "BaseMetaPipeEntity");
        FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", BaseMetaPipeEntity.class.getName());

        GT_Log.out.println("GT_Mod: Registering the Ore TileEntity.");
        GameRegistry.registerTileEntity(GT_TileEntity_Ores.class, "GT_TileEntity_Ores");
        FMLInterModComms.sendMessage("appliedenergistics2", "whitelist-spatial", GT_TileEntity_Ores.class.getName());
        if(!GregTech_API.mIC2Classic){
        GT_Log.out.println("GT_Mod: Registering Fluids.");
        Materials.ConstructionFoam.mFluid = GT_Utility.getFluidForFilledItem(GT_ModHandler.getIC2Item("CFCell", 1L), true).getFluid();
        Materials.UUMatter.mFluid = GT_Utility.getFluidForFilledItem(GT_ModHandler.getIC2Item("uuMatterCell", 1L), true).getFluid();
        }

        GT_Mod.gregtechproxy.addFluid("Air", "Air", Materials.Air, 2, 295, ItemList.Cell_Air.get(1L), ItemList.Cell_Empty.get(1L), 2000);
        GT_Mod.gregtechproxy.addFluid("Oxygen", "Oxygen", Materials.Oxygen, 2, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oxygen, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("Hydrogen", "Hydrogen", Materials.Hydrogen, 2, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Hydrogen, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("Deuterium", "Deuterium", Materials.Deuterium, 2, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Deuterium, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("Tritium", "Tritium", Materials.Tritium, 2, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Tritium, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("Helium", "Helium", Materials.Helium, 2, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Helium, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("Argon", "Argon", Materials.Argon, 2, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Argon, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("Radon", "Radon", Materials.Radon, 2, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Radon, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("Fluorine", "Fluorine", Materials.Fluorine, 2, 53, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Fluorine, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("Titaniumtetrachloride", "Titaniumtetrachloride", Materials.Titaniumtetrachloride, 1, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Titaniumtetrachloride, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("Helium-3", "Helium-3", Materials.Helium_3, 2, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Helium_3, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("Methane", "Methane", Materials.Methane, 2, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Methane, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("Nitrogen", "Nitrogen", Materials.Nitrogen, 2, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Nitrogen, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("NitrogenDioxide", "Nitrogen Dioxide", Materials.NitrogenDioxide, 2, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.NitrogenDioxide, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("Steam", "Steam", Materials.Water, 2, 375, GT_ModHandler.getIC2Item("steamCell", 1), ItemList.Cell_Empty.get(1), 1000);
        GT_Values.RA.addFluidCannerRecipe(Materials.Empty.getCells(1), GT_ModHandler.getIC2Item("steamCell", 1), GT_ModHandler.getSteam(1000), null);
        Materials.Ice.mGas = Materials.Water.mGas;
        Materials.Water.mGas.setTemperature(375).setGaseous(true);

        ItemList.sOilExtraHeavy = GT_Mod.gregtechproxy.addFluid("liquid_extra_heavy_oil", "Very Heavy Oil", null, 1, 295);
        ItemList.sEpichlorhydrin = GT_Mod.gregtechproxy.addFluid("liquid_epichlorhydrin", "Epichlorohydrin", Materials.Epichlorohydrin, 1, 295, Materials.Epichlorohydrin.getCells(1), Materials.Empty.getCells(1), 1000);
        ItemList.sDrillingFluid = GT_Mod.gregtechproxy.addFluid("liquid_drillingfluid", "Drilling Fluid", null, 1, 295);
        ItemList.sToluene = GT_Mod.gregtechproxy.addFluid("liquid_toluene", "Toluene", Materials.Toluene, 1, 295, Materials.Toluene.getCells(1), Materials.Empty.getCells(1), 1000);
        ItemList.sNitrationMixture = GT_Mod.gregtechproxy.addFluid("liquid_nitrationmixture", "Nitration Mixture", Materials.NitrationMixture, 1, 295, Materials.NitrationMixture.getCells(1), Materials.Empty.getCells(1), 1000);
        ItemList.sHerbicide = GT_Mod.gregtechproxy.addFluid("herbicide", "Herbicide", null, 1, 295);

        GT_Mod.gregtechproxy.addFluid("liquid_heavy_oil", "Heavy Oil", Materials.OilHeavy, 1, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.OilHeavy, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("liquid_medium_oil", "Raw Oil", Materials.OilMedium, 1, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.OilMedium, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("liquid_light_oil", "Light Oil", Materials.OilLight, 1, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.OilLight, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("gas_natural_gas", "Natural Gas", Materials.NatruralGas, 2, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.NatruralGas, 1L), ItemList.Cell_Empty.get(1L), 1000);
        ItemList.sHydricSulfur = GT_Mod.gregtechproxy.addFluid("liquid_hydricsulfur", "Hydrogen Sulfide", Materials.HydricSulfide, 2, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.HydricSulfide, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("gas_sulfuricgas", "Sulfuric Gas", Materials.SulfuricGas, 2, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.SulfuricGas, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("gas_gas", "Refinery Gas", Materials.Gas, 2, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Gas, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("liquid_sulfuricnaphtha", "Sulfuric Naphtha", Materials.SulfuricNaphtha, 1, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.SulfuricNaphtha, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("liquid_sufluriclight_fuel", "Sulfuric Light Fuel", Materials.SulfuricLightFuel, 1, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.SulfuricLightFuel, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("liquid_sulfuricheavy_fuel", "Sulfuric Heavy Fuel", Materials.SulfuricHeavyFuel, 1, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.SulfuricHeavyFuel, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("liquid_naphtha", "Naphtha", Materials.Naphtha, 1, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Naphtha, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("liquid_light_fuel", "Light Fuel", Materials.LightFuel, 1, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.LightFuel, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("liquid_heavy_fuel", "Heavy Fuel", Materials.HeavyFuel, 1, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.HeavyFuel, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("liquid_lpg", "LPG", Materials.LPG, 1, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.LPG, 1L), ItemList.Cell_Empty.get(1L), 1000);

        GT_Mod.gregtechproxy.addFluid("charcoal_byproducts", "molten.autogenerated", "Charcoal Byproducts", Materials.CharcoalByproducts, Materials.CharcoalByproducts.mRGBa, 2, 775, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.CharcoalByproducts, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("molten.bisphenol_a", "molten.autogenerated", "Molten Bisphenol A", Materials.BisphenolA, Materials.BisphenolA.mRGBa, 1, 432, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.BisphenolA, 1L), ItemList.Cell_Empty.get(1L), 1000);
        
        GT_Mod.gregtechproxy.addFluid("UUAmplifier", "UU Amplifier", Materials.UUAmplifier, 1, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.UUAmplifier, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("Chlorine", "Chlorine", Materials.Chlorine, 2, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Chlorine, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("Mercury", "Mercury", Materials.Mercury, 1, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Mercury, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("NitroFuel", "Cetane-Boosted Diesel", Materials.NitroFuel, 1, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.NitroFuel, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("SodiumPersulfate", "Sodium Persulfate", Materials.SodiumPersulfate, 1, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.SodiumPersulfate, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("Glyceryl", "Glyceryl Trinitrate", Materials.Glyceryl, 1, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Glyceryl, 1L), ItemList.Cell_Empty.get(1L), 1000);

        GT_Mod.gregtechproxy.addFluid("lubricant", "Lubricant", Materials.Lubricant, 1, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Lubricant, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("creosote", "Creosote Oil", Materials.Creosote, 1, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Creosote, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("seedoil", "Seed Oil", Materials.SeedOil, 1, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.SeedOil, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("fishoil", "Fish Oil", Materials.FishOil, 1, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.FishOil, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("oil", "Oil", Materials.Oil, 1, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Oil, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("fuel", "Diesel", Materials.Fuel, 1, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Fuel, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("for.honey", "Honey", Materials.Honey, 1, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Honey, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("biomass", "Biomass", Materials.Biomass, 1, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Biomass, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("bioethanol", "Bio Ethanol", Materials.Ethanol, 1, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Ethanol, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("sulfuricacid", "Sulfuric Acid", Materials.SulfuricAcid, 1, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.SulfuricAcid, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("milk", "Milk", Materials.Milk, 1, 290, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Milk, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("mcguffium", "Mc Guffium 239", Materials.McGuffium239, 1, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.McGuffium239, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("glue", "Glue", Materials.Glue, 1, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Glue, 1L), ItemList.Cell_Empty.get(1L), 1000);
        GT_Mod.gregtechproxy.addFluid("hotfryingoil", "Hot Frying Oil", Materials.FryingOilHot, 1, 400, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.FryingOilHot, 1L), ItemList.Cell_Empty.get(1L), 1000);

        GT_Mod.gregtechproxy.addFluid("holywater", "Holy Water", Materials.HolyWater, 1, 295, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.HolyWater, 1L), ItemList.Cell_Empty.get(1L), 1000);
        
        FluidContainerRegistry.registerFluidContainer(new FluidContainerRegistry.FluidContainerData(Materials.Milk.getFluid(1000L), GT_OreDictUnificator.get(OrePrefixes.bucket, Materials.Milk, 1L), GT_OreDictUnificator.get(OrePrefixes.bucket, Materials.Empty, 1L)));
        FluidContainerRegistry.registerFluidContainer(new FluidContainerRegistry.FluidContainerData(Materials.Milk.getFluid(250L), ItemList.Bottle_Milk.get(1L), ItemList.Bottle_Empty.get(1L)));
        FluidContainerRegistry.registerFluidContainer(new FluidContainerRegistry.FluidContainerData(Materials.HolyWater.getFluid(250L), ItemList.Bottle_Holy_Water.get(1L), ItemList.Bottle_Empty.get(1L)));
        FluidContainerRegistry.registerFluidContainer(new FluidContainerRegistry.FluidContainerData(Materials.McGuffium239.getFluid(250L), ItemList.McGuffium_239.get(1L), ItemList.Bottle_Empty.get(1L)));
        FluidContainerRegistry.registerFluidContainer(new FluidContainerRegistry.FluidContainerData(Materials.Fuel.getFluid(100L), ItemList.Tool_Lighter_Invar_Full.get(1L), ItemList.Tool_Lighter_Invar_Empty.get(1L)));
        FluidContainerRegistry.registerFluidContainer(new FluidContainerRegistry.FluidContainerData(Materials.Fuel.getFluid(1000L), ItemList.Tool_Lighter_Platinum_Full.get(1L), ItemList.Tool_Lighter_Platinum_Empty.get(1L)));

        Dyes.dyeBlack.addFluidDye(GT_Mod.gregtechproxy.addFluid("squidink", "Squid Ink", null, 1, 295));
        Dyes.dyeBlue.addFluidDye(GT_Mod.gregtechproxy.addFluid("indigo", "Indigo Dye", null, 1, 295));
        for (byte i = 0; i < Dyes.VALUES.length; i = (byte) (i + 1)) {
            Dyes tDye = Dyes.VALUES[i];
            Fluid tFluid;
            tDye.addFluidDye(tFluid = GT_Mod.gregtechproxy.addFluid("dye.watermixed." + tDye.name().toLowerCase(Locale.ENGLISH), "dyes", "Water Mixed " + tDye.mName + " Dye", null, tDye.getRGBA(), 1, 295, null, null, 0));
            tDye.addFluidDye(tFluid = GT_Mod.gregtechproxy.addFluid("dye.chemical." + tDye.name().toLowerCase(Locale.ENGLISH), "dyes", "Chemical " + tDye.mName + " Dye", null, tDye.getRGBA(), 1, 295, null, null, 0));
            FluidContainerRegistry.registerFluidContainer(new FluidStack(tFluid, 2304), ItemList.SPRAY_CAN_DYES[i].get(1L), ItemList.Spray_Empty.get(1L));
        }
        GT_Mod.gregtechproxy.addFluid("ice", "Crushed Ice", Materials.Ice, 0, 270, GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Ice, 1L), ItemList.Cell_Empty.get(1L), 1000);
        Materials.Water.mSolid = Materials.Ice.mSolid;


        GT_Mod.gregtechproxy.addFluid("molten.glass", "Molten Glass", Materials.Glass, 4, 1500);
        GT_Mod.gregtechproxy.addFluid("molten.redstone", "Molten Redstone", Materials.Redstone, 4, 500);
        GT_Mod.gregtechproxy.addFluid("molten.blaze", "Molten Blaze", Materials.Blaze, 4, 6400);
        GT_Mod.gregtechproxy.addFluid("molten.concrete", "Wet Concrete", Materials.Concrete, 4, 300);
        for (Materials tMaterial : Materials.values()) {
            if ((tMaterial.mStandardMoltenFluid == null) && (tMaterial.contains(SubTag.SMELTING_TO_FLUID)) && (!tMaterial.contains(SubTag.NO_SMELTING))) {
                GT_Mod.gregtechproxy.addAutogeneratedMoltenFluid(tMaterial);
                if ((tMaterial.mSmeltInto != tMaterial) && (tMaterial.mSmeltInto.mStandardMoltenFluid == null)) {
                    GT_Mod.gregtechproxy.addAutogeneratedMoltenFluid(tMaterial.mSmeltInto);
                }
            }
            if (tMaterial.mElement != null) {
                GT_Mod.gregtechproxy.addAutogeneratedPlasmaFluid(tMaterial);
            }
        	if (tMaterial.hasCorrespondingFluid()) {
        		GT_Mod.gregtechproxy.addAutoGeneratedCorrespondingFluid(tMaterial);
        	}
        	if (tMaterial.hasCorrespondingMoltenHot()) {
        		GT_Mod.gregtechproxy.addAutogeneratedMoltenHotFluid(tMaterial);
        	}
        	if (tMaterial.hasCorrespondingGas()) {
        		GT_Mod.gregtechproxy.addAutoGeneratedCorrespondingGas(tMaterial);
        	}
        	if (tMaterial.canBeCracked()) {
                GT_Mod.gregtechproxy.addAutoGeneratedHydroCrackedFluids(tMaterial);
                GT_Mod.gregtechproxy.addAutoGeneratedSteamCrackedFluids(tMaterial);
            }
        }

        if (!GT_Values.D1) {
            try {
                Class.forName("codechicken.nei.api.API");
                GT_Log.out.println("GT_Mod: Hiding certain Items from NEI.");
                API.hideItem(ItemList.Display_Fluid.getWildcard(1L));
            } catch (Throwable e) {
                if (GT_Values.D1) {
                    e.printStackTrace(GT_Log.err);
                }
            }
        }
        GT_ModHandler.addPulverisationRecipe(new ItemStack(Blocks.cobblestone, 1, 32767), new ItemStack(Blocks.sand, 1), null, 0, false);
        //GT_ModHandler.addPulverisationRecipe(new ItemStack(Blocks.stone, 1, 32767), new ItemStack(Blocks.cobblestone, 1), null, 0, false);
        GT_ModHandler.addPulverisationRecipe(new ItemStack(Blocks.gravel, 1, 32767), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 1L), null, 0, false);
        GT_ModHandler.addPulverisationRecipe(new ItemStack(Blocks.furnace, 1, 32767), new ItemStack(Blocks.sand, 6), null, 0, false);
        GT_ModHandler.addPulverisationRecipe(new ItemStack(Blocks.lit_furnace, 1, 32767), GT_OreDictUnificator.get(OrePrefixes.dust, Materials.Stone, 8L), null, 0, false);

        ItemList.ModularBasicHelmet.set(new ModularArmor_Item(0, 0, "modulararmor_helmet",0));
        ItemList.ModularBasicChestplate.set(new ModularArmor_Item(0, 1, "modulararmor_chestplate",0));
        ItemList.ModularBasicLeggings.set(new ModularArmor_Item(0, 2, "modulararmor_leggings",0));
        ItemList.ModularBasicBoots.set(new ModularArmor_Item(0, 3, "modulararmor_boots",0));
        ItemList.ModularElectric1Helmet.set(new ElectricModularArmor1(0, 0, "modularelectric1_helmet",1));
        ItemList.ModularElectric1Chestplate.set(new ElectricModularArmor1(0, 1, "modularelectric1_chestplate",1));
        ItemList.ModularElectric1Leggings.set(new ElectricModularArmor1(0, 2, "modularelectric1_leggings",1));
        ItemList.ModularElectric1Boots.set(new ElectricModularArmor1(0, 3, "modularelectric1_boots",1));
        ItemList.ModularElectric2Helmet.set(new ElectricModularArmor1(0, 0, "modularelectric2_helmet",2));
        ItemList.ModularElectric2Chestplate.set(new ElectricModularArmor1(0, 1, "modularelectric2_chestplate",2));
        ItemList.ModularElectric2Leggings.set(new ElectricModularArmor1(0, 2, "modularelectric2_leggings",2));
        ItemList.ModularElectric2Boots.set(new ElectricModularArmor1(0, 3, "modularelectric2_boots",2));

        GT_OreDictUnificator.set(OrePrefixes.dust, Materials.Coffee, ItemList.IC2_CoffeePowder.get(1L));
	//Enable naquadah fuels for Nq Reactors
        FluidContainerRegistry.registerFluidContainer(new FluidContainerRegistry.FluidContainerData(Materials.Naquadah.getMolten(1000L), GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Naquadah, 1L), GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Empty, 1L)));
        FluidContainerRegistry.registerFluidContainer(new FluidContainerRegistry.FluidContainerData(Materials.NaquadahEnriched.getMolten(1000L), GT_OreDictUnificator.get(OrePrefixes.cell, Materials.NaquadahEnriched, 1L), GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Empty, 1L)));
        FluidContainerRegistry.registerFluidContainer(new FluidContainerRegistry.FluidContainerData(Materials.Naquadria.getMolten(1000L), GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Naquadria, 1L), GT_OreDictUnificator.get(OrePrefixes.cell, Materials.Empty, 1L)));
        //
	GregTech_API.registerMachineBlock(GT_Utility.getBlockFromStack(GT_ModHandler.getIC2Item("reinforcedGlass", 0)), 0);
    }
}
