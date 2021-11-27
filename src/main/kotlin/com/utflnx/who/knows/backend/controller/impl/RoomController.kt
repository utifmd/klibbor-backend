package com.utflnx.who.knows.backend.controller.impl

import com.utflnx.who.knows.backend.controller.IRoomController
import com.utflnx.who.knows.backend.model.WebResponse
import com.utflnx.who.knows.backend.model.room.CreateRequest
import com.utflnx.who.knows.backend.model.room.Response
import com.utflnx.who.knows.backend.model.room.UpdateRequest
import com.utflnx.who.knows.backend.service.IRoomService
import org.springframework.web.bind.annotation.*

@RestController
class RoomController(val service: IRoomService): IRoomController {

    @PostMapping(value = ["/api/rooms"],
        produces = ["application/json"],
        consumes = ["application/json"])
    override fun createRoom(
        @RequestBody createRequest: CreateRequest): WebResponse<Response> {
        val response = service.create(createRequest)

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }

    @GetMapping(value = ["/api/rooms/{roomId}"],
        produces = ["application/json"])
    override fun readRoom(
        @PathVariable("roomId") readRequest: String): WebResponse<Response> {
        val response = service.read(readRequest)

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }

    @PutMapping(value = ["/api/rooms/{roomId}"],
        produces = ["application/json"],
        consumes = ["application/json"])
    override fun updateRoom(
        @PathVariable("roomId") id: String,
        @RequestBody updateRequest: UpdateRequest): WebResponse<Response> {
        val response = service.update(id, updateRequest)

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }
}