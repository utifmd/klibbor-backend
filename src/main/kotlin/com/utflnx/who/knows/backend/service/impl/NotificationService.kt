package com.utflnx.who.knows.backend.service.impl

import com.utflnx.who.knows.backend.entity.Notification
import com.utflnx.who.knows.backend.mapper.INotificationDataMapper
import com.utflnx.who.knows.backend.model.ListRequest
import com.utflnx.who.knows.backend.model.notification.CreateRequest
import com.utflnx.who.knows.backend.model.notification.Response
import com.utflnx.who.knows.backend.model.notification.UpdateRequest
import com.utflnx.who.knows.backend.repository.INotificationRepository
import com.utflnx.who.knows.backend.repository.IRoomRepository
import com.utflnx.who.knows.backend.repository.IUserRepository
import com.utflnx.who.knows.backend.service.INotificationService
import com.utflnx.who.knows.backend.validation.DataExistException
import com.utflnx.who.knows.backend.validation.DataNotFoundException
import com.utflnx.who.knows.backend.validation.NotFoundException
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.stream.Collectors

/**
 * Thu, 03 Feb 2022
 * who-knows-backend by utifmd
 **/
@Service
class NotificationService(
    private val reposNotification: INotificationRepository,
    private val reposUser: IUserRepository,
    private val reposRoom: IRoomRepository,
    private val mapper: INotificationDataMapper): INotificationService {

    override fun create(createRequest: CreateRequest): Response {
        val notification = mapper.toNotification(createRequest)

        if (reposNotification.existsById(notification.notificationId))
            throw DataExistException()

        reposUser.findByIdOrNull(notification.recipientId) ?:
            throw DataNotFoundException("recipientId")

        reposUser.findByIdOrNull(notification.userId) ?:
            throw DataNotFoundException("userId")

        reposRoom.findByIdOrNull(notification.roomId) ?:
            throw DataNotFoundException("roomId")

        return reposNotification.save(notification).let(mapper::toResponse)
    }

    override fun read(notificationId: String): Response {
        val notification = reposNotification.findByIdOrNull(notificationId) ?: throw NotFoundException()

        return mapper.toResponse(notification)
    }

    override fun update(id: String, updateRequest: UpdateRequest): Response {
        val current = reposNotification.findByIdOrNull(id) ?: throw NotFoundException()
        val updatedRequest = mapper.toNotification(current, updateRequest)

        reposNotification.save(updatedRequest)

        return mapper.toResponse(updatedRequest)
    }

    override fun delete(notificationId: String) {
        val notification = reposNotification.findByIdOrNull(notificationId) ?: throw NotFoundException()

        reposNotification.delete(notification)
    }

    override fun delete(roomId: String, userId: String) {
        val notification = reposNotification.findByRoomIdAndUserIdOrNull(roomId, userId) ?: throw NotFoundException()

        reposNotification.delete(notification)
    }

    override fun list(listRequest: ListRequest): List<Response> {
        val pageNotification = reposNotification.findAll(PageRequest.of(listRequest.page, listRequest.size))
        val notification = pageNotification.get().collect(Collectors.toList())

        return notification.map(mapper::toResponse)
    }

    override fun list(recipientId: String, listRequest: ListRequest): List<Response> {

        val notifications = reposNotification
            .findAllByRecipientIds(recipientId, PageRequest.of(listRequest.page, listRequest.size))

        return notifications.get().collect(Collectors.toList()).map(mapper::toResponse)
    }

    override fun list(recipientId: String, roomId: String, listRequest: ListRequest): List<Response> {
        val notifications = reposNotification
            .findAllByRecipientOrRoomId(recipientId, roomId, PageRequest.of(listRequest.page, listRequest.size))

        return notifications.map(mapper::toResponse)
            .sortedBy { it.seen }
    }
}