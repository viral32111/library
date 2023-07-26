package com.viral32111.library

import net.fabricmc.api.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Suppress( "UNUSED" )
class Main: ModInitializer {

	// A logger writes text to the console & log file.
	// It is best practice to use your mod id as the logger name, so it is clear which mod wrote messages.
	companion object {
		const val MOD_ID = "library"
		val LOGGER: Logger = LoggerFactory.getLogger( "com.viral32111.$MOD_ID" )
	}

	// Runs when the mod has initialized...
	override fun onInitialize() {
		LOGGER.info( "Library v${ getModVersion() } initialized." )
	}

}
