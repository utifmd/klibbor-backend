package com.utflnx.who.knows.backend.repository

import com.utflnx.who.knows.backend.entity.Result
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface IResultRepository: JpaRepository<Result, String> {
    @Query("SELECT rsl FROM Result rsl WHERE rsl.roomId = :roomId AND rsl.userId = :userId")
    fun findByRoomIdAndUserIdOrNull(
        @Param("roomId") roomId: String,
        @Param("userId") userId: String): Result?
}