package com.utflnx.who.knows.backend.controller

import com.utflnx.who.knows.backend.model.WebResponse
import com.utflnx.who.knows.backend.model.result.CreateRequest
import com.utflnx.who.knows.backend.model.result.Response
import com.utflnx.who.knows.backend.model.result.UpdateRequest

interface IResultController {
    fun createResult(createRequest: CreateRequest): WebResponse<Response>
    fun readResult(readRequest: String): WebResponse<Response>
    fun readResult(roomId: String, userId: String): WebResponse<Response>
    fun updateResult(id: String, updateRequest: UpdateRequest): WebResponse<Response>
    fun deleteResult(id: String): WebResponse<String>
    fun deleteResult(roomId: String, userId: String): WebResponse<String>
    fun listResult(page: Int, size: Int): WebResponse<List<Response>>
}