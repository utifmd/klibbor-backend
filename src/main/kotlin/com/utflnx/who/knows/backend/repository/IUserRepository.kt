package com.utflnx.who.knows.backend.repository

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.utflnx.who.knows.backend.entity.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface IUserRepository: JpaRepository<User, String> {

    @Query("SELECT usr FROM User usr WHERE usr.email = :email")
    fun findByEmailOrNull(
        @Param("email") email: String): User?

    @Query("SELECT usr FROM User usr WHERE " +
            "usr.email = :payload OR " +
            "usr.phone = :payload OR " +
            "usr.username = :payload")
    fun findByEmailOrPhoneOrUnameOrNull(
        @Param("payload") payload: String): User?

    @Query("SELECT *\n" +
            "FROM users\n" +
            "WHERE (SELECT COUNT(participants.user_id) FROM participants WHERE participants.user_id = users.user_id) > 0\n" +
            "ORDER BY (SELECT COUNT(participants.user_id) FROM participants WHERE participants.user_id = users.user_id) DESC",
        nativeQuery = true)
    fun findActivelyParticipants(pageable: Pageable): Page<User>
}