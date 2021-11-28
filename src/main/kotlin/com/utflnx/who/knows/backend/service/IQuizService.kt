package com.utflnx.who.knows.backend.service

import com.utflnx.who.knows.backend.model.ListRequest
import com.utflnx.who.knows.backend.model.quiz.CreateRequest
import com.utflnx.who.knows.backend.model.quiz.Response
import com.utflnx.who.knows.backend.model.quiz.UpdateRequest

interface IQuizService {
    fun create(createRequest: CreateRequest): Response
    fun read(id: String): Response
    fun update(id: String, updateRequest: UpdateRequest): Response
    fun delete(id: String)
    fun list(listRequest: ListRequest): List<Response>
}