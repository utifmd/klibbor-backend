package com.utflnx.who.knows.backend.repository

import com.utflnx.who.knows.backend.entity.Quiz
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface IQuizRepository: JpaRepository<Quiz, String>/*{
    @Query("SELECT * FROM questions que INNER JOIN quiz_options opt ON que.quiz_id = opt.quiz_quiz_id WHERE opt.options = :option", nativeQuery = true)
    fun findAllByOption(
        @Param("option") option: String): List<Quiz>
}*/