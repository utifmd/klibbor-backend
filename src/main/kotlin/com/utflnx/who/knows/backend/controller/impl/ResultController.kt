package com.utflnx.who.knows.backend.controller.impl

import com.utflnx.who.knows.backend.controller.IResultController
import com.utflnx.who.knows.backend.model.ListRequest
import com.utflnx.who.knows.backend.model.WebResponse
import com.utflnx.who.knows.backend.model.result.CreateRequest
import com.utflnx.who.knows.backend.model.result.Response
import com.utflnx.who.knows.backend.model.result.UpdateRequest
import com.utflnx.who.knows.backend.service.IResultService
import org.springframework.web.bind.annotation.*

@RestController
class ResultController(val service: IResultService): IResultController {
    @PostMapping(value = ["/api/results"], produces = ["application/json"], consumes = ["application/json"])
    override fun createResult(
        @RequestBody createRequest: CreateRequest): WebResponse<Response> {
        val response = service.create(createRequest)

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }

    @GetMapping(value = ["/api/results/{resultId}"], produces = ["application/json"])
    override fun readResult(
        @PathVariable("resultId") readRequest: String): WebResponse<Response> {
        val response = service.read(readRequest)

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }

    @PutMapping(value = ["/api/results/{resultId}"], produces = ["application/json"], consumes = ["application/json"])
    override fun updateResult(
        @PathVariable("resultId") id: String,
        @RequestBody updateRequest: UpdateRequest): WebResponse<Response> {
        val response = service.update(id, updateRequest)

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }

    @DeleteMapping(value = ["/api/results/{resultId}"], produces = ["application/json"])
    override fun deleteResult(
        @PathVariable("resultId") id: String): WebResponse<String> {
        service.delete(id)

        return WebResponse(
            code = 200,
            status = "OK",
            data = id
        )
    }

    @GetMapping(value = ["/api/results"], produces = ["application/json"])
    override fun listResult(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "size", defaultValue = "0") size: Int): WebResponse<List<Response>> {
        val response = service.list(ListRequest(page, size))

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }
}