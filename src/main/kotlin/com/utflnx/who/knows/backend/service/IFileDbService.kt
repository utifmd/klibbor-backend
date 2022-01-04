package com.utflnx.who.knows.backend.service

import com.utflnx.who.knows.backend.entity.FileDb
import com.utflnx.who.knows.backend.model.file.Response
import org.springframework.web.multipart.MultipartFile
import java.util.stream.Stream

/**
 * Tue, 04 Jan 2022
 * who-knows-backend by utifmd
 **/
interface IFileDbService {
    fun create(file: MultipartFile): Response
    fun read(id: String): Response
    fun list(ids: List<String>): Stream<Response>
    fun list(): Stream<Response>

    /*
    fun create(file: MultipartFile): FileDb
    fun read(id: String): FileDb
    fun list(): Stream<FileDb>
    * */
}