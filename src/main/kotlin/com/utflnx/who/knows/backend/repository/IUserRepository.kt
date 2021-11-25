package com.utflnx.who.knows.backend.repository

import com.utflnx.who.knows.backend.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface IUserRepository: JpaRepository<User, String>