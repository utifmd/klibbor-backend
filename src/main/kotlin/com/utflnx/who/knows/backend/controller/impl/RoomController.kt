package com.utflnx.who.knows.backend.controller.impl

import com.utflnx.who.knows.backend.controller.IRoomController
import com.utflnx.who.knows.backend.model.ListRequest
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

    @DeleteMapping(value = ["/api/rooms/{roomId}"], produces = ["application/json"])
    override fun deleteRoom(
        @PathVariable("roomId") id: String): WebResponse<String> {
        service.delete(id)

        return WebResponse(
            code = 200,
            status = "OK",
            data = id
        )
    }

    @GetMapping(value = ["/api/rooms"], produces = ["application/json"])
    override fun listRoom(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "size", defaultValue = "5") size: Int): WebResponse<List<Response>> {
        val response = service.list(ListRequest(page, size))

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }

    @GetMapping(value = ["/api/rooms/owner/{userId}"], produces = ["application/json"])
    override fun listRoom(
        @PathVariable("userId") userId: String,
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "size", defaultValue = "5") size: Int): WebResponse<List<Response>> {
        val response = service.list(userId, ListRequest(page, size))

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }
}