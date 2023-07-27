package com.viral32111.library

import java.text.NumberFormat
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.*

// UTC time-zone & default human-readable format
private val utcZone = ZoneId.of( "UTC" )
private const val defaultFormat = "dd/MM/yyyy HH:mm:ss Z"

/**
 * Gets the current human-readable date & time in the UTC time-zone.
 * @return The human-readable representation of the current date & time.
 * @since 0.1.0
 */
fun getCurrentDateTimeInUTC( format: String = defaultFormat ): String = ZonedDateTime.now( utcZone ).format( DateTimeFormatter.ofPattern( format.ifBlank { defaultFormat } ) )

/**
 * Gets the current date & time in the UTC time-zone formatted as ISO-8601.
 * @return The ISO-8601 representation of the current date & time.
 * @since 0.1.0
 */
fun getCurrentDateTimeInUTCAsISO8601(): String = ZonedDateTime.now( utcZone ).format( DateTimeFormatter.ISO_OFFSET_DATE_TIME )

/**
 * Gets the human-readable representation of the instant in the UTC time-zone.
 * @return The human-readable representation of the instant.
 * @since 0.1.0
 */
fun Instant.toHumanReadableInUTC( format: String = defaultFormat ): String = DateTimeFormatter.ofPattern( format.ifBlank { defaultFormat } ).format( this.atZone( utcZone ) )

/**
 * Converts seconds to a human-readable representation in days, hours, minutes & seconds.
 * @return The human-readable representation of the given seconds.
 * @since 0.1.0
 */
fun Long.toHumanReadableTime(): String = listOf(
	this / ( 24 * 3600 ) to "day",
	this / 3600 % 24 to "hour",
	this / 60 % 60 to "minute",
	this % 60 to "second"
)
	.filter { it.first > 0 }
	.joinToString( ", " ) { "${ NumberFormat.getNumberInstance( Locale.ENGLISH ).format( it.first ) } ${ it.second }${ if ( it.first > 1 ) "s" else "" }" }
	.ifEmpty { "less than a second" }

/**
 * Converts seconds to a human-readable representation in days, hours, minutes & seconds.
 * @return The human-readable representation of the given seconds.
 * @see Long.toHumanReadableTime
 * @since 0.1.0
 */
fun Int.toHumanReadableTime(): String = this.toLong().toHumanReadableTime()
