package com.utflnx.who.knows.backend.controller

import com.utflnx.who.knows.backend.model.WebResponse
import com.utflnx.who.knows.backend.model.file.ListRequest
import com.utflnx.who.knows.backend.model.file.Response
import org.springframework.http.ResponseEntity
import org.springframework.web.multipart.MultipartFile

/**
 * Tue, 04 Jan 2022
 * who-knows-backend by utifmd
 **/
interface IFileDbController {
    fun create(file: MultipartFile): WebResponse<Response>
    fun read(id: String): ResponseEntity<ByteArray>
    fun list(): WebResponse<List<Response>>
    fun list(listRequest: ListRequest): WebResponse<List<Response>>
}