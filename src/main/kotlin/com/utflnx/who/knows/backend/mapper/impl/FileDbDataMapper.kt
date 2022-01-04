package com.utflnx.who.knows.backend.mapper.impl

import com.utflnx.who.knows.backend.entity.FileDb
import com.utflnx.who.knows.backend.mapper.IFileDbDataMapper
import com.utflnx.who.knows.backend.model.file.CreateRequest
import com.utflnx.who.knows.backend.model.file.Response
import com.utflnx.who.knows.backend.validation.IDataValidator
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

/**
 * Tue, 04 Jan 2022
 * who-knows-backend by utifmd
 **/
@Component
class FileDbDataMapper(val validator: IDataValidator) : IFileDbDataMapper {
    override fun asResponse(fileDb: FileDb): Response {
        validator.validate(fileDb)

        return Response(
            fileDb.name ?: "",
            fileDownloadUri(fileDb.id ?: ""),
            fileDb.type ?: "",
            fileDb,
            fileDb.data.size.toLong()
        )
    }

    /*override fun asResponse(createRequest: CreateRequest): Response {
        validator.validate(createRequest)

        val fileDb = FileDb(
            name = createRequest.name,
            type = createRequest.type,
            data = createRequest.data
        )

        return Response(
            fileDb.name ?: "",
            fileDownloadUri(fileDb.id ?: ""),
            fileDb.type ?: "",
            fileDb.data.size.toLong()
        )
    }*/

    override fun fileDownloadUri(fileId: String): String {
        validator.validate(fileId)

        return ServletUriComponentsBuilder
            .fromCurrentContextPath()
            .path("/files/")
            .path(fileId)
            .toUriString()
    }

    override fun asFileDb(file: MultipartFile): FileDb {
        validator.validate(file)

        return FileDb(
            name = file.originalFilename,
            type = file.contentType,
            data = file.bytes,
        )
    }
}