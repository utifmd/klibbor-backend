package com.utflnx.who.knows.backend.controller.impl

import com.utflnx.who.knows.backend.controller.IMaintenanceController
import com.utflnx.who.knows.backend.model.WebResponse
import com.utflnx.who.knows.backend.model.maintenance.CreateRequest
import com.utflnx.who.knows.backend.model.maintenance.Response
import com.utflnx.who.knows.backend.service.IMaintenanceService
import org.springframework.web.bind.annotation.*

/**
 * Sat, 30 Jul 2022
 * who-knows-backend by utifmd
 **/
@RestController
class MaintenanceController(
    val service: IMaintenanceService): IMaintenanceController {

    @PostMapping(value = ["/api/maintenance"], produces = ["application/json"], consumes = ["application/json"])
    override fun create(
        @RequestBody createRequest: CreateRequest): WebResponse<Response> {
        val response = service.create(createRequest)
        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }

    @GetMapping(value = ["/api/maintenance"], produces = ["application/json"])
    override fun read(): WebResponse<Response> {
        val response = service.read()

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }

    @DeleteMapping(value = ["/api/maintenance"], produces = ["application/json"])
    override fun delete(): WebResponse<String> {
        service.delete()

        return WebResponse(
            code = 200,
            status = "OK",
            data = "Delete successfully"
        )
    }
}