package com.utflnx.who.knows.backend.service.impl

import com.utflnx.who.knows.backend.mapper.IImpressionDataMapper
import com.utflnx.who.knows.backend.model.ListRequest
import com.utflnx.who.knows.backend.model.impression.CreateRequest
import com.utflnx.who.knows.backend.model.impression.Response
import com.utflnx.who.knows.backend.model.impression.UpdateRequest
import com.utflnx.who.knows.backend.repository.IImpressionRepository
import com.utflnx.who.knows.backend.service.IImpressionService
import com.utflnx.who.knows.backend.validation.DataExistException
import com.utflnx.who.knows.backend.validation.DataNotFoundException
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.util.stream.Collectors

/**
 * Fri, 27 May 2022
 * who-knows-backend by utifmd
 **/
@Service
class ImpressionService(
    private val repository: IImpressionRepository,
    private val mapper: IImpressionDataMapper): IImpressionService {

    override fun create(createRequest: CreateRequest): Response {
        mapper.validate(createRequest)

        repository.findImpressionByUserIdAndPostId(
            createRequest.userId, createRequest.postId
        ) ?: throw DataExistException()

        val data = repository.save(mapper.toImpression(createRequest))
        return mapper.toResponse(data)
    }

    override fun read(impressionId: String): Response {
        mapper.validate(impressionId)

        val impression = repository.findByIdOrNull(impressionId)
            ?: throw DataNotFoundException("impressionId")

        return mapper.toResponse(impression)
    }

    override fun update(impressionId: String, updateRequest: UpdateRequest): Response {
        mapper.validate(impressionId)

        val current = repository.findByIdOrNull(impressionId)
            ?: throw DataNotFoundException("impressionId")

        val impression = repository.save(
            mapper.toImpression(current, updateRequest))

        return mapper.toResponse(impression)
    }

    override fun delete(impressionId: String) {
        mapper.validate(impressionId)

        val current = repository.findByIdOrNull(impressionId)
            ?: throw DataNotFoundException("impressionId")

        repository.delete(current)
    }

    override fun list(listRequest: ListRequest): List<Response> {
        mapper.validate(listRequest)

        val paged = repository.findAll(PageRequest.of(listRequest.page, listRequest.size))

        return paged.stream().collect(Collectors.toList())
            .map(mapper::toResponse)
    }
}