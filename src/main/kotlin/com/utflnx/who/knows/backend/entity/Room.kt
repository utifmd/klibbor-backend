package com.utflnx.who.knows.backend.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "rooms")
data class Room(
    @Id
    @Column(name = "roomId")
    val id: String,

    @Column(name = "userId")
    var userId: String,

    @Column(name = "minute")
    var minute: Int,

    @Column(name = "title")
    var title: String,

    @Column(name = "description")
    var description: String,

    @Column(name = "expired")
    var expired: Boolean,

    @Column(name = "createdAt")
    var createdAt: Date,

    @Column(name = "updatedAt")
    var updatedAt: Date?
)