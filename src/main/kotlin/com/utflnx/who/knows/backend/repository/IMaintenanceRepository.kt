package com.utflnx.who.knows.backend.repository

import com.utflnx.who.knows.backend.entity.Maintenance
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

/**
 * Sat, 30 Jul 2022
 * who-knows-backend by utifmd
 **/
interface IMaintenanceRepository: JpaRepository<Maintenance, String>/*{
    @Query("SELECT mtn FROM Maintenance mtn WHERE mtn.active")
    fun findLatestByActiveOrNull(): Maintenance?
}*/