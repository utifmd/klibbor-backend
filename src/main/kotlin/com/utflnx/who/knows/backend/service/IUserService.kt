package com.utflnx.who.knows.backend.service

import com.utflnx.who.knows.backend.entity.User
import com.utflnx.who.knows.backend.model.user.CreateRequest
import com.utflnx.who.knows.backend.model.ListRequest
import com.utflnx.who.knows.backend.model.user.LoginRequest
import com.utflnx.who.knows.backend.model.user.Response
import com.utflnx.who.knows.backend.model.user.UpdateRequest

interface IUserService {
    fun create(createRequest: CreateRequest): Response.Complete
    fun read(userId: String): Response.Complete
    fun count(username: String): Int
    fun update(userId: String, updateRequest: UpdateRequest): Response.Complete
    fun update(userId: String, user: User): Response.Complete
    fun delete(userId: String)
    fun list(listRequest: ListRequest): List<Response.Complete>
//    fun readExplore(): Response.Complete
    fun activelyParticipants(listRequest: ListRequest): List<Response.Censored>

    fun signIn(loginRequest: LoginRequest): Response.Complete
    fun search(query: String, listRequest: ListRequest): List<Response.Censored>
}