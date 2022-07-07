package com.utflnx.who.knows.backend.controller.impl

import com.utflnx.who.knows.backend.controller.IParticipantController
import com.utflnx.who.knows.backend.model.ListRequest
import com.utflnx.who.knows.backend.model.WebResponse
import com.utflnx.who.knows.backend.model.participant.CreateRequest
import com.utflnx.who.knows.backend.model.participant.Response
import com.utflnx.who.knows.backend.model.participant.UpdateRequest
import com.utflnx.who.knows.backend.service.IParticipantService
import org.springframework.web.bind.annotation.*

@RestController
class ParticipantController(val service: IParticipantService): IParticipantController {
    @PostMapping(value = ["/api/participants"], produces = ["application/json"], consumes = ["application/json"])
    override fun createParticipant(
        @RequestBody createRequest: CreateRequest): WebResponse<Response> {
        val response = service.create(createRequest)

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }

    @GetMapping(value = ["/api/participants/{participantId}"], produces = ["application/json"])
    override fun readParticipant(
        @PathVariable("participantId") id: String): WebResponse<Response> {
        val response = service.read(id)

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }

    @GetMapping(value = ["/api/participants/owner/with_args"], produces = ["application/json"])
    override fun readParticipant(
        @RequestParam(value = "userId", defaultValue = "") userId: String,
        @RequestParam(value = "roomId", defaultValue = "") roomId: String): WebResponse<Response> {
        val response = service.read(userId, roomId)

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }

    @PutMapping(value = ["/api/participants/{participantId}"], produces = ["application/json"], consumes = ["application/json"])
    override fun updateParticipant(
        @PathVariable("participantId") id: String,
        @RequestBody updateRequest: UpdateRequest): WebResponse<Response> {
        val response = service.update(id, updateRequest)

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }

    @DeleteMapping(value = ["/api/participants/{participantId}"], produces = ["application/json"])
    override fun deleteParticipant(
        @PathVariable("participantId") id: String): WebResponse<String> {
        service.delete(id)

        return WebResponse(
            code = 200,
            status = "OK",
            data = id
        )
    }

    @GetMapping(value = ["/api/participants"], produces = ["application/json"])
    override fun listParticipant(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "size", defaultValue = "5") size: Int): WebResponse<List<Response>> {
        val response = service.list(ListRequest(page, size))

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }
}