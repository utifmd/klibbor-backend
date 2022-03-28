package com.utflnx.who.knows.backend.controller

import com.utflnx.who.knows.backend.model.ListRequest
import com.utflnx.who.knows.backend.model.WebResponse
import com.utflnx.who.knows.backend.model.room.CreateRequest
import com.utflnx.who.knows.backend.model.room.Response
import com.utflnx.who.knows.backend.model.room.UpdateRequest


interface IRoomController {
    fun createRoom(createRequest: CreateRequest): WebResponse<Response.Complete>
    fun readRoom(readRequest: String): WebResponse<Response.Complete>
    fun updateRoom(id: String, updateRequest: UpdateRequest): WebResponse<Response.Complete>
    fun deleteRoom(id: String): WebResponse<String>
    fun listRoom(page: Int, size: Int): WebResponse<List<Response.Censored>>
    fun listRoom(userId: String, page: Int, size: Int): WebResponse<List<Response.Complete>>
}