package com.utflnx.who.knows.backend.service.impl

import com.utflnx.who.knows.backend.entity.FileDb
import com.utflnx.who.knows.backend.mapper.IFileDbDataMapper
import com.utflnx.who.knows.backend.model.file.Response
import com.utflnx.who.knows.backend.repository.IFileDbRepository
import com.utflnx.who.knows.backend.service.IFileDbService
import com.utflnx.who.knows.backend.validation.NotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.IOException
import java.util.stream.Stream
import kotlin.jvm.Throws

/**
 * Tue, 04 Jan 2022
 * who-knows-backend by utifmd
 **/
@Service
class FileDbService(
    val repos: IFileDbRepository,
    val mapper: IFileDbDataMapper): IFileDbService {

    @Throws(IOException::class)
    override fun create(file: MultipartFile): Response {
        val fileDb = mapper.asFileDb(file)

        return repos.save(fileDb).let {
            mapper.asResponse(it)
        }
    }

    @Throws(IOException::class)
    override fun create(files: List<MultipartFile>): Stream<Response> {
        val filesDb = mapper.asFilesDb(files)
        val list = repos.saveAll(filesDb).let {
            mapper.asResponse(it)
        }

        return list.stream()
    }

    override fun delete(id: String) {
        val fileDb = repos.findByIdOrNull(id) ?: throw NotFoundException()

        repos.delete(fileDb)
    }

    override fun read(id: String): Response {
        val fileDb = repos.findByIdOrNull(id) ?: throw NotFoundException()

        return mapper.asResponse(fileDb)
    }

    override fun list(ids: List<String>): Stream<Response> {

        return repos.findAllById(ids).map(mapper::asResponse).stream()
        /*val list = */
        /*return list.map {
            mapper.asResponse(it)
        }*/
    }

    override fun list(): Stream<Response> {
        return repos.findAll().map(mapper::asResponse).stream()
    /*{
            (it)
        }*//*.stream()

        return list.map {
            mapper.asResponse(it)
        }*/
    }
}