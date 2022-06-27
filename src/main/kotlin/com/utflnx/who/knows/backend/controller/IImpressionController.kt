package com.utflnx.who.knows.backend.controller

import com.utflnx.who.knows.backend.model.ListRequest
import com.utflnx.who.knows.backend.model.WebResponse
import com.utflnx.who.knows.backend.model.impression.CreateRequest
import com.utflnx.who.knows.backend.model.impression.Response
import com.utflnx.who.knows.backend.model.impression.UpdateRequest

/**
 * Fri, 27 May 2022
 * who-knows-backend by utifmd
 **/
interface IImpressionController {
    fun create(createRequest: CreateRequest): WebResponse<Response>
    fun update(impressionId: String, updateRequest: UpdateRequest): WebResponse<Response>
    //fun read(impressionId: String): WebResponse<Response>
    //fun delete(impressionId: String)
    //fun list(listRequest: ListRequest): WebResponse<List<Response>>
}