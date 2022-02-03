package com.utflnx.who.knows.backend.repository

import com.utflnx.who.knows.backend.entity.User
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
}