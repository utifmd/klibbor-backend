package com.utflnx.who.knows.backend.service

import com.utflnx.who.knows.backend.model.user.CreateRequest
import com.utflnx.who.knows.backend.model.user.Response

interface IUserService {
    fun create(createRequest: CreateRequest): Response
//    fun read(readRequest: String): Response
//    fun readExplore(): Response
}