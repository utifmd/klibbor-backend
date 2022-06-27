package com.utflnx.who.knows.backend.repository

import com.utflnx.who.knows.backend.entity.Impression
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

/**
 * Fri, 27 May 2022
 * who-knows-backend by utifmd
 **/
interface IImpressionRepository: JpaRepository<Impression, String> {
    @Query("SELECT imp FROM Impression imp WHERE imp.userId = :userId AND imp.postId = :postId")
    fun findImpressionByUserIdAndPostId(
        @Param("userId") userId: String,
        @Param("postId") postId: String): Impression?
}