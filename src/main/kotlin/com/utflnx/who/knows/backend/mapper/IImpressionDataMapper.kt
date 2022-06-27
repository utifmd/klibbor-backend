package com.utflnx.who.knows.backend.mapper

import com.utflnx.who.knows.backend.entity.Impression
import com.utflnx.who.knows.backend.model.impression.CreateRequest
import com.utflnx.who.knows.backend.model.impression.Response
import com.utflnx.who.knows.backend.model.impression.UpdateRequest

/**
 * Fri, 27 May 2022
 * who-knows-backend by utifmd
 **/
interface IImpressionDataMapper {
    fun toImpression(createRequest: CreateRequest): Impression
    fun toImpression(current: Impression, updateRequest: UpdateRequest): Impression
    fun toResponse(impression: Impression): Response
    fun validate(any: Any)
}