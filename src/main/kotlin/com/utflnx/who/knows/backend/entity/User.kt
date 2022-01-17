package com.utflnx.who.knows.backend.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id // @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    val id: String,

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
    var updatedAt: Date? //, @JoinColumn(name = "userId") @OneToMany var rooms: List<Room>?
)