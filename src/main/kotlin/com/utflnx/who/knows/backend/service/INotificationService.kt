package com.utflnx.who.knows.backend.service

import com.utflnx.who.knows.backend.model.ListRequest
import com.utflnx.who.knows.backend.model.notification.CreateRequest
import com.utflnx.who.knows.backend.model.notification.Response
import com.utflnx.who.knows.backend.model.notification.UpdateRequest

/**
 * Thu, 03 Feb 2022
 * who-knows-backend by utifmd
 **/
interface INotificationService {
    fun create(createRequest: CreateRequest): Response
    fun read(notificationId: String): Response
    fun update(id: String, updateRequest: UpdateRequest): Response
    fun delete(notificationId: String)
    fun delete(roomId: String, userId: String)
    fun list(listRequest: ListRequest): List<Response>
    fun list(recipientId: String, listRequest: ListRequest): List<Response>
}