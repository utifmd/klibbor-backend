package com.utflnx.who.knows.backend.controller.impl

import com.utflnx.who.knows.backend.controller.IQuizController
import com.utflnx.who.knows.backend.model.ListRequest
import com.utflnx.who.knows.backend.model.WebResponse
import com.utflnx.who.knows.backend.model.quiz.CreateRequest
import com.utflnx.who.knows.backend.model.quiz.Response
import com.utflnx.who.knows.backend.model.quiz.UpdateRequest
import com.utflnx.who.knows.backend.service.IQuizService
import org.springframework.web.bind.annotation.*

@RestController
class QuizController(val service: IQuizService): IQuizController {
    @PostMapping(value = ["/api/questions"], produces = ["application/json"], consumes = ["application/json"])
    override fun createRoom(
        @RequestBody createRequest: CreateRequest): WebResponse<Response> {
        val response = service.create(createRequest)

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }

    @GetMapping(value = ["/api/questions/{quizId}"], produces = ["application/json"])
    override fun readRoom(
        @PathVariable("quizId") readRequest: String): WebResponse<Response> {
        val response = service.read(readRequest)

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }

    @PutMapping(value = ["/api/questions/{quizId}"], produces = ["application/json"], consumes = ["application/json"])
    override fun updateRoom(
        @PathVariable("quizId") id: String,
        @RequestBody updateRequest: UpdateRequest): WebResponse<Response> {
        val response = service.update(id, updateRequest)

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }

    @DeleteMapping(value = ["/api/questions/{quizId}"], produces = ["application/json"])
    override fun deleteRoom(id: String): WebResponse<String> {
        service.delete(id)

        return WebResponse(
            code = 200,
            status = "OK",
            data = id
        )
    }

    @GetMapping(value = ["/api/questions"], produces = ["application/json"])
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

}