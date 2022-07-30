package com.utflnx.who.knows.backend.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

/**
 * Sat, 30 Jul 2022
 * who-knows-backend by utifmd
 **/
@Entity
@Table(name = "maintenances")
data class Maintenance(
    @Id
    @Column(name = "id")
    val id: String,

    @Column(name = "versionCode")
    val versionCode: Int,

    @Column(name = "versionName")
    val versionName: String,

    @Column(name = "active")
    val active: Boolean
)