package com.utflnx.who.knows.backend.controller

import com.utflnx.who.knows.backend.model.WebResponse
import com.utflnx.who.knows.backend.model.room.CreateRequest
import com.utflnx.who.knows.backend.model.room.Response
import com.utflnx.who.knows.backend.model.room.UpdateRequest


interface IRoomController {
    fun createRoom(createRequest: CreateRequest): WebResponse<Response>
    fun readRoom(readRequest: String): WebResponse<Response>
    fun updateRoom(id: String, updateRequest: UpdateRequest): WebResponse<Response>
//    fun deleteRoom(id: String): WebResponse<String>
//    fun listRoom(page: Int, size: Int): WebResponse<List<Response>>
}