package com.utflnx.who.knows.backend.controller

import com.utflnx.who.knows.backend.model.WebResponse
import com.utflnx.who.knows.backend.model.maintenance.CreateRequest
import com.utflnx.who.knows.backend.model.maintenance.Response

/**
 * Sat, 30 Jul 2022
 * who-knows-backend by utifmd
 **/
interface IMaintenanceController {
    fun create(createRequest: CreateRequest): WebResponse<Response>
    fun read(): WebResponse<Response>
    fun delete(): WebResponse<String>
}