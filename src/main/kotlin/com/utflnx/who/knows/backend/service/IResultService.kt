package com.utflnx.who.knows.backend.service

import com.utflnx.who.knows.backend.entity.Result
import com.utflnx.who.knows.backend.model.ListRequest
import com.utflnx.who.knows.backend.model.result.CreateRequest
import com.utflnx.who.knows.backend.model.result.Response
import com.utflnx.who.knows.backend.model.result.UpdateRequest

interface IResultService {
    fun create(createRequest: CreateRequest): Response
    fun read(resultId: String): Response
    fun update(resultId: String, updateRequest: UpdateRequest): Response
    fun delete(resultId: String)
    fun list(listRequest: ListRequest): List<Response>
}