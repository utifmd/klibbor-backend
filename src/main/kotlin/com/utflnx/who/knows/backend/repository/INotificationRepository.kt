package com.utflnx.who.knows.backend.repository

import com.utflnx.who.knows.backend.entity.Notification
import com.utflnx.who.knows.backend.entity.Result
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

/**
 * Thu, 03 Feb 2022
 * who-knows-backend by utifmd
 **/
interface INotificationRepository: JpaRepository<Notification, String>{

    @Query("SELECT ntf FROM Notification ntf WHERE ntf.recipientId = :recipientId OR ntf.roomId = :roomId ORDER BY ntf.createdAt ASC")
    fun findAllByRecipientOrRoomId(
        @Param("recipientId") recipientId: String,
        @Param("roomId") roomId: String, pageable: Pageable): Page<Notification>

    @Query("SELECT ntf FROM Notification ntf WHERE ntf.recipientId = :recipientId ORDER BY ntf.createdAt ASC")
    fun findAllByRecipientId(
        @Param("recipientId") recipientId: String, pageable: Pageable): Page<Notification>

    @Query("SELECT ntf FROM Notification ntf WHERE ntf.roomId = :roomId AND ntf.userId = :userId")
    fun findByRoomIdAndUserIdOrNull(
        @Param("roomId") roomId: String,
        @Param("userId") userId: String): Notification?

    /*@Query("SELECT ntf FROM Notification ntf WHERE ntf.recipientId = :payloadId OR ntf.userId = :payloadId OR ntf.roomId = :payloadId")
    fun findAllByRecipientIdOrNull(
        @Param("payloadId") payloadId: String, pageable: Pageable): Page<Notification>*/
}