package com.utflnx.who.knows.backend.service

import com.utflnx.who.knows.backend.model.ListRequest
import com.utflnx.who.knows.backend.model.impression.CreateRequest
import com.utflnx.who.knows.backend.model.impression.Response
import com.utflnx.who.knows.backend.model.impression.UpdateRequest

/**
 * Fri, 27 May 2022
 * who-knows-backend by utifmd
 **/
interface IImpressionService {
    fun create(createRequest: CreateRequest): Response
    fun read(impressionId: String): Response
    fun update(impressionId: String, updateRequest: UpdateRequest): Response
    fun delete(impressionId: String)
    fun list(listRequest: ListRequest): List<Response>
}