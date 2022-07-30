package com.utflnx.who.knows.backend.mapper

import com.utflnx.who.knows.backend.entity.Maintenance
import com.utflnx.who.knows.backend.model.maintenance.CreateRequest
import com.utflnx.who.knows.backend.model.maintenance.Response
import com.utflnx.who.knows.backend.model.maintenance.UpdateRequest

/**
 * Sat, 30 Jul 2022
 * who-knows-backend by utifmd
 **/
interface IMaintenanceDataMapper {
    fun toMaintenance(createRequest: CreateRequest): Maintenance
    fun toMaintenance(current: Maintenance, updateRequest: UpdateRequest): Maintenance
    fun toResponse(maintenance: Maintenance): Response
    fun validate(any: Any)
}