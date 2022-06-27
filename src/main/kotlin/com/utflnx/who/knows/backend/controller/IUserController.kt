package com.utflnx.who.knows.backend.controller

import com.utflnx.who.knows.backend.model.ListRequest
import com.utflnx.who.knows.backend.model.WebResponse
import com.utflnx.who.knows.backend.model.user.CreateRequest
import com.utflnx.who.knows.backend.model.user.LoginRequest
import com.utflnx.who.knows.backend.model.user.Response
import com.utflnx.who.knows.backend.model.user.UpdateRequest

interface IUserController {
    fun createUser(createRequest: CreateRequest): WebResponse<Response.Complete>
    fun readUser(readRequest: String): WebResponse<Response.Complete>
    fun updateUser(id: String, updateRequest: UpdateRequest): WebResponse<Response.Complete>
    fun deleteUser(id: String): WebResponse<String>
    fun listUser(page: Int, size: Int): WebResponse<List<Response.Complete>>
    fun activelyParticipants(page: Int, size: Int): WebResponse<List<Response.Censored>>
    fun searchUser(nameOrUsername: String, page: Int, size: Int): WebResponse<List<Response.Censored>>

    fun signInUser(loginRequest: LoginRequest): WebResponse<Response.Complete>
}