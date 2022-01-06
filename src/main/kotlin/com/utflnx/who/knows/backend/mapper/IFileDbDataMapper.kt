package com.utflnx.who.knows.backend.mapper

import com.utflnx.who.knows.backend.entity.FileDb
import com.utflnx.who.knows.backend.entity.Quiz
import com.utflnx.who.knows.backend.model.file.CreateRequest
import com.utflnx.who.knows.backend.model.file.Response
import com.utflnx.who.knows.backend.model.quiz.UpdateRequest
import org.springframework.web.multipart.MultipartFile

/**
 * Tue, 04 Jan 2022
 * who-knows-backend by utifmd
 **/
interface IFileDbDataMapper {
    fun asFileDb(file: MultipartFile): FileDb
    fun asFilesDb(files: List<MultipartFile>): List<FileDb>
    fun fileDownloadUri(fileId: String): String
    fun asResponse(fileDb: FileDb): Response
    fun asResponse(filesDb: List<FileDb>): List<Response>

    /*fun asResponse(createRequest: CreateRequest): Response*/
    /*fun toQuiz(current: Quiz, updateRequest: UpdateRequest): FileDb
    fun toFileDb(createRequest: CreateRequest): FileDb
    fun toResponse(fileDb: FileDb): Response
    fun validate(any: Any)*/
}