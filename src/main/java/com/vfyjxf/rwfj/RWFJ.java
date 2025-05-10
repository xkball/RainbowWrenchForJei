package com.vfyjxf.rwfj;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(value = RWFJ.MODID,dist = Dist.CLIENT)
public class RWFJ {
    public static final String MODID = "rwfj";
    private static final Logger LOGGER = LogUtils.getLogger();

    public RWFJ(IEventBus modEventBus, ModContainer modContainer) {

    }
    
}
