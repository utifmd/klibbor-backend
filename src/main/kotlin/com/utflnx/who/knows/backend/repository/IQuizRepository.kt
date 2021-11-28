package com.utflnx.who.knows.backend.repository

import com.utflnx.who.knows.backend.entity.Quiz
import org.springframework.data.jpa.repository.JpaRepository

interface IQuizRepository: JpaRepository<Quiz, String>