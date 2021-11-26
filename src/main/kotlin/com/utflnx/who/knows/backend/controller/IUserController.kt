package com.utflnx.who.knows.backend.controller

import com.utflnx.who.knows.backend.model.WebResponse
import com.utflnx.who.knows.backend.model.user.CreateRequest
import com.utflnx.who.knows.backend.model.user.ListRequest
import com.utflnx.who.knows.backend.model.user.Response
import com.utflnx.who.knows.backend.model.user.UpdateRequest

interface IUserController {
    fun createUser(createRequest: CreateRequest): WebResponse<Response>
    fun readUser(readRequest: String): WebResponse<Response>
    fun updateUser(id: String, updateRequest: UpdateRequest): WebResponse<Response>
    fun deleteUser(id: String): WebResponse<String>
    fun listUser(page: Int, size: Int): WebResponse<List<Response>>
}