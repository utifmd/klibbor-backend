package com.utflnx.who.knows.backend.controller.impl

import com.utflnx.who.knows.backend.controller.IFileDbController
import com.utflnx.who.knows.backend.model.WebResponse
import com.utflnx.who.knows.backend.model.file.ListRequest
import com.utflnx.who.knows.backend.model.file.Response
import com.utflnx.who.knows.backend.service.IFileDbService
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.util.stream.Collectors

/**
 * Tue, 04 Jan 2022
 * who-knows-backend by utifmd
 **/
@RestController
class FileDbController(val service: IFileDbService): IFileDbController {
    @PostMapping("/upload-file")
    override fun create(
        @RequestParam("file") file: MultipartFile): WebResponse<Response> {
        val response = service.create(file)

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }

    @PostMapping("/upload-files")
    override fun create(
        @RequestParam("files") files: List<MultipartFile>): WebResponse<List<Response>> {
        val response = service.create(files).collect(Collectors.toList())

        return WebResponse(
            code = 200,
            status = "ok",
            data = response
        )
    }

    @DeleteMapping(value = ["/files/{id}"], produces = ["application/json"])
    override fun delete(
        @PathVariable("id") id: String): WebResponse<String> {
        service.delete(id)

        return WebResponse(
            code = 200,
            status = "OK",
            data = id
        )
    }

    @GetMapping("/files/{id}")
    override fun read(
        @PathVariable("id") id: String): ResponseEntity<ByteArray> {
        val response = service.read(id)

        val headers = HttpHeaders()
        headers.contentType = when(response.type){
            MediaType.IMAGE_PNG_VALUE -> MediaType.IMAGE_PNG
            MediaType.IMAGE_GIF_VALUE -> MediaType.IMAGE_GIF
            else -> MediaType.IMAGE_JPEG
        }

        return ResponseEntity.ok()
            .headers(headers)
            .body(response.fileDb.data)
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