package com.utflnx.who.knows.backend.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "participants")
data class Participant(

    @Id
    @Column(name = "participantId")
    val participantId: String,

    @Column(name = "roomId")
    var roomId: String,

    @Column(name = "userId")
    var userId: String,

    @Column(name = "currentPage")
    var currentPage: String,

    @Column(name = "timeLeft")
    var timeLeft: Int?,

    @Column(name = "expired")
    var expired: Boolean,

    @Column(name = "createdAt")
    var createdAt: Date,

    @Column(name = "updatedAt")
    var updatedAt: Date?,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    var user: User?

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "participantId")
//    var results: List<Result>

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "resultId")
//    var result: Result?
)