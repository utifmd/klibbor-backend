package com.utflnx.who.knows.backend.mapper

import com.utflnx.who.knows.backend.entity.Notification
import com.utflnx.who.knows.backend.model.notification.CreateRequest
import com.utflnx.who.knows.backend.model.notification.Response
import com.utflnx.who.knows.backend.model.notification.UpdateRequest

/**
 * Thu, 03 Feb 2022
 * who-knows-backend by utifmd
 **/
interface INotificationDataMapper {
    fun toNotification(createRequest: CreateRequest): Notification
    fun toNotification(current: Notification, updateRequest: UpdateRequest): Notification
    fun toResponse(notification: Notification): Response
    fun validate(any: Any)
}