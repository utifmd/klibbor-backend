package com.utflnx.who.knows.backend.controller.impl

import com.utflnx.who.knows.backend.controller.IImpressionController
import com.utflnx.who.knows.backend.model.WebResponse
import com.utflnx.who.knows.backend.model.impression.CreateRequest
import com.utflnx.who.knows.backend.model.impression.Response
import com.utflnx.who.knows.backend.model.impression.UpdateRequest
import com.utflnx.who.knows.backend.service.impl.ImpressionService
import org.springframework.web.bind.annotation.*

/**
 * Fri, 27 May 2022
 * who-knows-backend by utifmd
 **/
@RestController
class ImpressionController(val service: ImpressionService): IImpressionController {
    @PostMapping(value = ["/api/impressions"], produces = ["application/json"], consumes = ["application/json"])
    override fun create(
        @RequestBody createRequest: CreateRequest): WebResponse<Response> {
        val impression = service.create(createRequest)

        return WebResponse(
            code = 200,
            status = "OK",
            data = impression
        )
    }

    @PutMapping(value = ["/api/impressions/{impressionId}"], produces = ["application/json"], consumes = ["application/json"])
    override fun update(
        @PathVariable("impressionId") impressionId: String,
        @RequestBody updateRequest: UpdateRequest): WebResponse<Response> {
        val impression = service.update(impressionId, updateRequest)

        return WebResponse(
            code = 200,
            status = "OK",
            data = impression
        )
    }
}