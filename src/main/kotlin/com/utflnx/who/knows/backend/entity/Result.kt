package com.utflnx.who.knows.backend.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "results")
data class Result(

    @Id
    @Column(name = "resultId")
    val resultId: String,

    @Column(name = "roomId")
    var roomId: String,

    @Column(name = "userId")
    var userId: String,

    @Column(name = "correctQuiz")
    @ElementCollection
    var correctQuiz: List<String>,

    @Column(name = "wrongQuiz")
    @ElementCollection
    var wrongQuiz: List<String>,

    @Column(name = "score")
    var score: Int?,

    @Column(name = "createdAt")
    var createdAt: Date,

    @Column(name = "updatedAt")
    var updatedAt:Date?
)