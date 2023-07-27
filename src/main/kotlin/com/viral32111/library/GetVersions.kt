package com.viral32111.library

import net.fabricmc.loader.api.FabricLoader
import net.minecraft.MinecraftVersion

/**
 * Gets the version of a mod.
 * @param modIdentifier The ID of the mod.
 * @param fabricLoader An instance of the Fabric Loader.
 * @return The version of the mod.
 * @since 0.1.0
 */
fun getModVersion( modIdentifier: String = Main.MOD_ID, fabricLoader: FabricLoader = FabricLoader.getInstance() ): String =
	fabricLoader.getModContainer( modIdentifier ).orElseThrow {
		throw IllegalStateException( "Container for mod with ID '${ modIdentifier }' not found" )
	}.metadata.version.friendlyString

/**
 * Gets the version of Java.
 * @return The Java version.
 * @since 0.1.0
 */
fun getJavaVersion(): String = System.getProperty( "java.version" )

/**
 * Gets the version of Minecraft.
 * @return The Minecraft version.
 * @since 0.1.0
 */
fun getMinecraftVersion(): String = MinecraftVersion.CURRENT.name

/**
 * Gets the version of the Fabric Loader.
 * @return The Fabric Loader version.
 * @since 0.1.0
 */
fun getFabricLoaderVersion(): String = getModVersion( "fabricloader" )

/**
 * Gets the version of the Fabric API mod.
 * @return The mod version.
 * @since 0.1.0
 */
fun getFabricAPIVersion( stripSuffix: Boolean = false ): String =
	getModVersion( "fabric-api" ).let { if ( stripSuffix ) it.split( "+", limit = 2 ).first() else it }

/**
 * Gets the version of the Fabric Language Kotlin mod.
 * @return The mod version.
 * @since 0.1.0
 */
fun getFabricLanguageKotlinVersion( stripSuffix: Boolean = false ): String =
	getModVersion( "fabric-language-kotlin" ).let { if ( stripSuffix ) it.split( "+", limit = 2 ).first() else it }
