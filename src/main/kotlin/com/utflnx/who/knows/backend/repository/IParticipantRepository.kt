package com.utflnx.who.knows.backend.repository

import com.utflnx.who.knows.backend.entity.Participant
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface IParticipantRepository: JpaRepository<Participant, String> {
    @Query("SELECT ppn FROM Participant ppn WHERE ppn.roomId = :roomId AND ppn.userId = :userId")
    fun findByRoomIdAndUserIdOrNull(
        @Param("roomId") roomId: String,
        @Param("userId") userId: String): Participant?

    /*@Query(
        "SELECT ppn\n" +
            "FROM Participant ppn\n" +
            "GROUP BY ppn.participantId\n" +
            "ORDER BY COUNT(ppn.participantId) DESC")
    fun findAllByUserIdCount(pageable: Pageable): Page<Participant>*/
}