package com.utflnx.who.knows.backend.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
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

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    @JoinColumn(name = "userId")
    var participants: List<Participant>

    /*
    @OneToMany(
        mappedBy = "userId",
        orphanRemoval = true,
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL])
    var participants: List<Participant>,*/
)