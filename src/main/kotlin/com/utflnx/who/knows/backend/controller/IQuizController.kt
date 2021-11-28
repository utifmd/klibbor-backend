package com.utflnx.who.knows.backend.controller

import com.utflnx.who.knows.backend.model.WebResponse
import com.utflnx.who.knows.backend.model.quiz.CreateRequest
import com.utflnx.who.knows.backend.model.quiz.Response
import com.utflnx.who.knows.backend.model.quiz.UpdateRequest

interface IQuizController {
    fun createRoom(createRequest: CreateRequest): WebResponse<Response>
    fun readRoom(readRequest: String): WebResponse<Response>
    fun updateRoom(id: String, updateRequest: UpdateRequest): WebResponse<Response>
    fun deleteRoom(id: String): WebResponse<String>
    fun listRoom(page: Int, size: Int): WebResponse<List<Response>>
}