package com.utflnx.who.knows.backend.controller

import com.utflnx.who.knows.backend.model.WebResponse
import com.utflnx.who.knows.backend.model.notification.CreateRequest
import com.utflnx.who.knows.backend.model.notification.Response
import com.utflnx.who.knows.backend.model.notification.UpdateRequest

interface INotificationController {
    fun createNotification(createRequest: CreateRequest): WebResponse<Response>
    fun readNotification(notificationId: String): WebResponse<Response>
    fun deleteNotification(notificationId: String): WebResponse<String>
    fun updateNotification(id: String, updateRequest: UpdateRequest): WebResponse<Response>
    fun listNotification(page: Int, size: Int): WebResponse<List<Response>>
    fun listNotification(recipientId: String, page: Int, size: Int): WebResponse<List<Response>>
}