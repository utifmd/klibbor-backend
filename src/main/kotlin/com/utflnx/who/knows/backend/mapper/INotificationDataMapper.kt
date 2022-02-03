package com.utflnx.who.knows.backend.mapper

import com.utflnx.who.knows.backend.entity.Notification
import com.utflnx.who.knows.backend.model.notification.CreateRequest
import com.utflnx.who.knows.backend.model.notification.Response

/**
 * Thu, 03 Feb 2022
 * who-knows-backend by utifmd
 **/
interface INotificationDataMapper {
    fun toResult(createRequest: CreateRequest): Notification
    fun toResponse(notification: Notification): Response
    fun validate(any: Any)
}