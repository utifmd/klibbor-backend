package com.utflnx.who.knows.backend.repository

import com.utflnx.who.knows.backend.entity.Room
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface IRoomRepository: JpaRepository<Room, String> {
    @Query("SELECT rm FROM Room rm WHERE rm.userId = :userId")
    fun findAllByUserId(
        @Param("userId") userId: String): List<Room>

    @Query("SELECT rm FROM Room rm WHERE rm.userId = :userId")
    fun findAllByUserId(
        @Param("userId") userId: String, pageable: Pageable): Page<Room>

   /* @Query("SELECT rm FROM Room rm ORDER BY rm.createdAt ASC")
    fun findAllBy(
        @Param("recipientId") recipientId: String, pageable: Pageable
    ): Page<Room>*/
    /*@Query(value = "SELECT rm FROM Room rm WHERE rm.userId = :userId")
    fun findAllByUserId(
        @Param("userId") userId: String,
        pageable: Pageable): Page<Room>*/

    /*@Query(
      value = "SELECT * FROM Room rm WHERE rm.userId = :userId",
      nativeQuery = true)
      fun findAllByUserId(
        @Param("id") userId: String): List<Room>
      */
}