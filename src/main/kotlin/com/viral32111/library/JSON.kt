package com.viral32111.library

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

/**
 * JSON serialization/deserialization pretty-print format.
 * @since 0.1.1
 */
@OptIn(ExperimentalSerializationApi::class)
val PrettyJSON = Json {
    prettyPrint = true
    prettyPrintIndent = "\t"
    ignoreUnknownKeys = true
}

/**
 * JSON serialization/deserialization compact format.
 * @since 0.1.1
 */
val JSON = Json {
    prettyPrint = false
    ignoreUnknownKeys = true
}
