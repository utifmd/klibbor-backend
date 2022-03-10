package com.utflnx.who.knows.backend.mapper.impl

import com.utflnx.who.knows.backend.entity.Notification
import com.utflnx.who.knows.backend.mapper.INotificationDataMapper
import com.utflnx.who.knows.backend.model.notification.CreateRequest
import com.utflnx.who.knows.backend.model.notification.Response
import com.utflnx.who.knows.backend.model.notification.UpdateRequest
import com.utflnx.who.knows.backend.validation.IDataValidator
import org.springframework.stereotype.Component
import java.util.*

/**
 * Thu, 03 Feb 2022
 * who-knows-backend by utifmd
 **/
@Component
class NotificationDataMapper(
    private val validator: IDataValidator): INotificationDataMapper {

    override fun toResult(createRequest: CreateRequest): Notification {
        validate(createRequest)

        return Notification(
            notificationId = createRequest.notificationId,
            userId = createRequest.userId,
            roomId = createRequest.roomId,
            event = createRequest.event,
            seen = createRequest.seen,
            recipientId = createRequest.recipientId,
            createdAt = Date(),
            updatedAt = null,
            sender = null
        )
    }

    override fun toResult(current: Notification, updateRequest: UpdateRequest): Notification {
        validator.validate(updateRequest)

        return current.apply {
            event = updateRequest.event
            seen = updateRequest.seen
        }
    }

    override fun toResponse(notification: Notification): Response {
        return Response(
            notificationId = notification.notificationId,
            userId = notification.userId,
            roomId = notification.roomId,
            event = notification.event,
            seen = notification.seen,
            recipientId = notification.recipientId,
            createdAt = notification.createdAt,
            updatedAt = notification.updatedAt,
            sender = notification.sender
        )
    }

    override fun validate(any: Any) {
        validator.validate(any)
    }
}