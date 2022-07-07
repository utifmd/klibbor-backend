package com.utflnx.who.knows.backend.repository

import com.utflnx.who.knows.backend.entity.Result
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface IResultRepository: JpaRepository<Result, String> {
    @Query("SELECT * FROM results WHERE results.room_id = :roomId AND results.user_id = :userId ORDER BY results.created_at DESC LIMIT 1", nativeQuery = true)
    fun findByRoomIdAndUserIdOrNull(
        @Param("roomId") roomId: String,
        @Param("userId") userId: String): Result?

    /*@Query("SELECT rsl FROM Result rsl WHERE rsl.roomId = :roomId AND rsl.userId = :userId LIMIT 1")
    fun findAllByRoomIdAndUserIdOrNull(
        @Param("roomId") roomId: String,
        @Param("userId") userId: String): List<Result>*/
}