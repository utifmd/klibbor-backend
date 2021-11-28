package com.utflnx.who.knows.backend.mapper

import com.utflnx.who.knows.backend.entity.Quiz
import com.utflnx.who.knows.backend.model.quiz.CreateRequest
import com.utflnx.who.knows.backend.model.quiz.Response
import com.utflnx.who.knows.backend.model.quiz.UpdateRequest

interface IQuizDataMapper {
    fun toQuiz(createRequest: CreateRequest): Quiz
    fun toQuiz(current: Quiz, updateRequest: UpdateRequest): Quiz
    fun toResponse(quiz: Quiz): Response
}