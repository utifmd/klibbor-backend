package com.utflnx.who.knows.backend.mapper.impl

import com.utflnx.who.knows.backend.entity.Impression
import com.utflnx.who.knows.backend.mapper.IImpressionDataMapper
import com.utflnx.who.knows.backend.model.impression.CreateRequest
import com.utflnx.who.knows.backend.model.impression.Response
import com.utflnx.who.knows.backend.model.impression.UpdateRequest
import com.utflnx.who.knows.backend.validation.IDataValidator
import org.springframework.stereotype.Component

/**
 * Fri, 27 May 2022
 * who-knows-backend by utifmd
 **/
@Component
class ImpressionDataMapper(
    private val validator: IDataValidator): IImpressionDataMapper {
    override fun toImpression(createRequest: CreateRequest): Impression {
        return Impression(
            impressionId = createRequest.impressionId,
            postId = createRequest.postId,
            userId = createRequest.userId,
            good = createRequest.good
        )
    }

    override fun toImpression(current: Impression, updateRequest: UpdateRequest): Impression {
        return current.copy(
            good = updateRequest.good
        )
    }

    override fun toResponse(impression: Impression): Response {
        return Response(
            impressionId = impression.impressionId,
            postId = impression.postId,
            userId = impression.userId,
            good = impression.good
        )
    }

    override fun validate(any: Any) {
        validator.validate(any)
    }
}