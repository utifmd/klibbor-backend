package com.utflnx.who.knows.backend.controller

import com.utflnx.who.knows.backend.model.WebResponse
import com.utflnx.who.knows.backend.model.notification.CreateRequest
import com.utflnx.who.knows.backend.model.notification.Response

interface INotificationController {
    fun createNotification(createRequest: CreateRequest): WebResponse<Response>
    fun readNotification(notificationId: String): WebResponse<Response>
    fun deleteNotification(notificationId: String): WebResponse<String>
    fun listNotification(page: Int, size: Int): WebResponse<List<Response>>
    fun listNotification(recipientId: String, page: Int, size: Int): WebResponse<List<Response>>
}