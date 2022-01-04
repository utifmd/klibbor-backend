package com.utflnx.who.knows.backend.controller.impl

import com.utflnx.who.knows.backend.controller.IFileDbController
import com.utflnx.who.knows.backend.model.WebResponse
import com.utflnx.who.knows.backend.model.file.ListRequest
import com.utflnx.who.knows.backend.model.file.Response
import com.utflnx.who.knows.backend.service.IFileDbService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.util.stream.Collectors

/**
 * Tue, 04 Jan 2022
 * who-knows-backend by utifmd
 **/
@RestController
class FileDbController(val service: IFileDbService): IFileDbController {
    @PostMapping("/upload")
    override fun create(
        @RequestParam file: MultipartFile): WebResponse<Response> {
        val response = service.create(file)

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }

    @GetMapping("/files/{id}")
    override fun read(
        @PathVariable("id") id: String): WebResponse<ByteArray> {
        val response = service.read(id).fileDb.data

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }

    @GetMapping("/files")
    override fun list(): WebResponse<List<Response>> {
        val response = service.list().collect(Collectors.toList())

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }

    @GetMapping("/files/ids")
    override fun list(
        @RequestBody listRequest: ListRequest): WebResponse<List<Response>> {
        val response = service.list(listRequest.ids).collect(Collectors.toList())

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }
}