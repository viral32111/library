package com.viral32111.library

import net.fabricmc.api.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Main : ModInitializer {

    companion object {
        const val MOD_ID = "library"
        val LOGGER: Logger = LoggerFactory.getLogger("com.viral32111.$MOD_ID")
    }

    override fun onInitialize() {
        LOGGER.info("Library v${getModVersion()} initialized.")

        LOGGER.info(
            "Running Java ${getJavaVersion()}, Minecraft ${getMinecraftVersion()}, Fabric Loader ${getFabricLoaderVersion()}, Fabric API ${
                getFabricAPIVersion(
                    true
                )
            }, Fabric Language Kotlin ${getFabricLanguageKotlinVersion(true)}."
        )
        LOGGER.info(
            "The current date & time is ${getCurrentDateTimeInUTC()} (ISO-8601: ${getCurrentDateTimeInUTCAsISO8601()}). It has been ${
                System.currentTimeMillis().div(1000).toHumanReadableTime()
            } since the 1st of January 1970 UTC."
        )
    }

}
