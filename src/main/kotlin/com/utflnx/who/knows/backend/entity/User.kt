package com.utflnx.who.knows.backend.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.hibernate.annotations.Filter
import org.hibernate.annotations.FilterJoinTable
import org.hibernate.annotations.FilterJoinTables
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "users")
@JsonIgnoreProperties(value = [
    "phone", "email", "password", "participants", "rooms", "notifications", "createdAt", "updatedAt"])
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

    @Column(name = "tokens")
    @ElementCollection
    var tokens: List<String>,

    //@JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    @JoinColumn(name = "userId")
    var participants: List<Participant>,

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    @JoinColumn(name = "userId")
    var rooms: List<Room>,

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    @JoinColumn(name = "recipientId", referencedColumnName = "userId")
    var notifications: List<Notification>

    /*
    @OneToMany(
        mappedBy = "userId",
        orphanRemoval = true,
        fetch = FetchType.LAZY,
        cascade = [CascadeType.ALL])
    var participants: List<Participant>,*/
)