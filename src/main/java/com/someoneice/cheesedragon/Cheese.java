package com.someoneice.cheesedragon;

/*
*Ported via @anIceyGirl's NoDragon Cheese
*/
import net.minecraft.world.damagesource.BadRespawnPointDamage;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.boss.EnderDragonPart;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("cheese_dragon")
public class Cheese {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "cheese_dragon";

    public Cheese()
    {
        MinecraftForge.EVENT_BUS.register(this);
        IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

        forgeEventBus.addListener(this::onEntityDamage);
    }

    private void onEntityDamage(final LivingHurtEvent event)
    {
        if (isEnderDragon(event.getEntity()) && event.getSource() instanceof BadRespawnPointDamage)
        {
            event.setCanceled(true);
        }
    }

    private boolean isEnderDragon(Entity entity)
    {
        return (entity instanceof EnderDragon || entity instanceof EnderDragonPart);
    }
}
