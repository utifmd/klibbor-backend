package com.utflnx.who.knows.backend.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "participants")
data class Participant(

    @Id
    @Column(name = "participantId")
    val id: String,
    
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
    var updatedAt: Date?   
)