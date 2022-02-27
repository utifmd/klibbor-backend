package com.utflnx.who.knows.backend.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "questions")
data class Quiz(

    @Id
    @Column(name = "quizId")
    val quizId: String,

    @Column(name = "roomId")
    var roomId: String,

    @Column(name = "images")
    @ElementCollection
    var images: List<String>,

    @Column(name = "question")
    var question: String,

    @Column(name = "options")
    @ElementCollection
    var options: List<String>,

    @Column(name = "answer")
    var answer: String,

    @Column(name = "createdBy")
    var createdBy: String,

    @Column(name = "createdAt")
    var createdAt: Date,

    @Column(name = "updatedAt")
    var updatedAt: Date?,

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "createdBy", referencedColumnName = "userId", insertable = false, updatable = false)
    var user: User?
)