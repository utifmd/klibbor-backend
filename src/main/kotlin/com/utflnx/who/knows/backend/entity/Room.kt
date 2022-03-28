package com.utflnx.who.knows.backend.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "rooms")
@JsonIgnoreProperties(value = ["createdAt", "updatedAt", "questions", "participants"])
data class Room(
    @Id
    @Column(name = "roomId")
    val roomId: String,

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
    var updatedAt: Date?,

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.REFRESH])
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    var user: User?,

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE, CascadeType.REFRESH])
    @JoinColumn(name = "roomId")
    var questions: List<Quiz>,

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE, CascadeType.REFRESH])
    @JoinColumn(name = "roomId")
    var participants: List<Participant>
)