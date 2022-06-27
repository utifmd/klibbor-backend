package com.utflnx.who.knows.backend.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

/**
 * Fri, 27 May 2022
 * who-knows-backend by utifmd
 **/
@Entity
@Table(name = "impressions")
data class Impression(
    @Id
    @Column(name = "impressionId")
    val impressionId: String,

    @Column(name = "postId")
    val postId: String,

    @Column(name = "userId")
    val userId: String,

    @Column(name = "good")
    val good: Boolean
)
