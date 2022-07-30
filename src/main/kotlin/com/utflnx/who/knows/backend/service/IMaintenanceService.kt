package com.utflnx.who.knows.backend.service

import com.utflnx.who.knows.backend.model.maintenance.CreateRequest
import com.utflnx.who.knows.backend.model.maintenance.Response

/**
 * Sat, 30 Jul 2022
 * who-knows-backend by utifmd
 **/
interface IMaintenanceService {
    fun create(createRequest: CreateRequest): Response
    fun read(): Response
    //fun update(maintenanceId: String, updateRequest: UpdateRequest): Response
    fun delete()
}