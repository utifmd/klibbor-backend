package com.utflnx.who.knows.backend.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    val userId: String,

    @Column(name = "fullName")
    val fullName: String,

    @Column(name = "email")
    val email: String,

    @Column(name = "phone")
    val phone: Int,

    @Column(name = "username")
    val username: String,

    @Column(name = "password")
    val password: String,

    @Column(name = "createdAt")
    val createdAt: Date,

    @Column(name = "updatedAt")
    val updatedAt: Date?
)