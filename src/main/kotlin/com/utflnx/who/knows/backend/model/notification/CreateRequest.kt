package com.utflnx.who.knows.backend.model.notification

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

/**
 * Thu, 03 Feb 2022
 * who-knows-backend by utifmd
 **/
data class CreateRequest(
    @field:NotBlank
    val notificationId: String,

    @field:NotBlank
    val userId: String,

    @field:NotBlank
    val recipientId: String,

    @field:NotNull
    val recipientIds: List<String>?,

    @field:NotBlank
    val roomId: String,

    @field:NotBlank
    val event: String,

    @field:NotNull
    val seen: Boolean
)
