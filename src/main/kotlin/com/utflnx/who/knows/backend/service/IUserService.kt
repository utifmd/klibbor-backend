package com.utflnx.who.knows.backend.service

import com.utflnx.who.knows.backend.model.user.CreateRequest
import com.utflnx.who.knows.backend.model.ListRequest
import com.utflnx.who.knows.backend.model.user.LoginRequest
import com.utflnx.who.knows.backend.model.user.Response
import com.utflnx.who.knows.backend.model.user.UpdateRequest

interface IUserService {
    fun create(createRequest: CreateRequest): Response.Complete
    fun read(readRequest: String): Response.Complete
    fun update(id: String, updateRequest: UpdateRequest): Response.Complete
    fun delete(deleteRequest: String)
    fun list(listRequest: ListRequest): List<Response.Complete>
//    fun readExplore(): Response.Complete
    fun activelyParticipants(listRequest: ListRequest): List<Response.Censored>

    fun signIn(loginRequest: LoginRequest): Response.Complete
}