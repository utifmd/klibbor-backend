package com.utflnx.who.knows.backend.mapper

import com.utflnx.who.knows.backend.entity.Result
import com.utflnx.who.knows.backend.model.result.CreateRequest
import com.utflnx.who.knows.backend.model.result.Response
import com.utflnx.who.knows.backend.model.result.UpdateRequest

interface IResultDataMapper {
    fun toResult(createRequest: CreateRequest): Result
    fun toResult(current: Result, updateRequest: UpdateRequest): Result
    fun toResponse(result: Result): Response
}