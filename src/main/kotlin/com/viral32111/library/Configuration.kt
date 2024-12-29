package com.viral32111.library

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import net.fabricmc.loader.api.FabricLoader
import java.nio.file.StandardOpenOption
import kotlin.io.path.*
import kotlin.reflect.full.hasAnnotation

/**
 * Loads a configuration file.
 * Automatically creates the configuration file if it doesn't exist.
 * @since 0.1.1
 */
inline fun <reified ConfigurationType : Any> loadConfigurationFile(
    directoryName: String,
    fileName: String,
    defaultConfiguration: () -> ConfigurationType
): ConfigurationType {
    // Ensure the configuration is annotated with @Serializable
    if (!ConfigurationType::class.hasAnnotation<Serializable>()) throw IllegalArgumentException("Configuration data class must be annotated with @Serializable!")

    // Get relevant filesystem paths
    val serverConfigurationDirectoryPath = FabricLoader.getInstance().configDir
    val configurationDirectoryPath = serverConfigurationDirectoryPath.resolve(directoryName)
    val configurationFilePath = configurationDirectoryPath.resolve(fileName)

    // Create the configuration directory if it doesn't exist
    if (configurationDirectoryPath.notExists()) {
        configurationDirectoryPath.createDirectory()
        Main.LOGGER.info("Created directory '${configurationDirectoryPath.absolutePathString()}' for configuration files.")
    }

    // Create the configuration file if it doesn't exist
    if (configurationFilePath.notExists()) {
        val configAsJSON = PrettyJSON.encodeToString(defaultConfiguration()) // Pretty-print JSON
        configurationFilePath.writeText(
            configAsJSON, options = arrayOf(
                StandardOpenOption.CREATE_NEW,
                StandardOpenOption.WRITE
            )
        )
        Main.LOGGER.info("Created configuration file '${configurationFilePath.absolutePathString()}'.")
    }

    // Load the configuration file
    val configAsJSON = configurationFilePath.readText()
    val config = PrettyJSON.decodeFromString<ConfigurationType>(configAsJSON)
    Main.LOGGER.info("Loaded configuration from file '${configurationFilePath.absolutePathString()}'")

    return config
}
