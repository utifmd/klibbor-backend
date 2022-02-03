package com.utflnx.who.knows.backend.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @Column(name = "userId")
    var userId: String,

    @Column(name = "fullName")
    var fullName: String,

    @Column(name = "email")
    var email: String,

    @Column(name = "phone")
    var phone: String,

    @Column(name = "username")
    var username: String,

    @Column(name = "password")
    var password: String,

    @Column(name = "profileUrl")
    var profileUrl: String,

    @Column(name = "createdAt")
    var createdAt: Date,

    @Column(name = "updatedAt")
    var updatedAt: Date?,

    /*@OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    @JoinColumn(name = "userId")
    var participants: List<Participant>,*/
)