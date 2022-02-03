package com.utflnx.who.knows.backend.entity

import java.util.*
import javax.persistence.*

/**
 * Thu, 03 Feb 2022
 * who-knows-backend by utifmd
 **/
@Entity
@Table(name = "notifications")
data class Notification(
    @Id
    @Column(name = "notificationId")
    val notificationId: String,

    @Column(name = "userId")
    val userId: String,

    @Column(name = "roomId")
    val roomId: String,

    @Column(name = "event")
    val event: String,

    @Column(name = "seen")
    val seen: Boolean,

    @Column(name = "recipientId")
    val recipientId: String,

    @Column(name = "createdAt")
    val createdAt: Date,

    @Column(name = "updatedAt")
    val updatedAt: Date?,

    @ManyToOne(
        fetch = FetchType.LAZY,
        optional = false)
    @JoinColumn(
        name = "userId",
        nullable = false,
        insertable = false,
        updatable = false)
    val sender: User?
)
