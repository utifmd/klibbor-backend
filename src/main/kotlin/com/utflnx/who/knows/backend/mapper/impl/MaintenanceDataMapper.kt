package com.utflnx.who.knows.backend.mapper.impl

import com.utflnx.who.knows.backend.entity.Maintenance
import com.utflnx.who.knows.backend.mapper.IMaintenanceDataMapper
import com.utflnx.who.knows.backend.model.maintenance.CreateRequest
import com.utflnx.who.knows.backend.model.maintenance.Response
import com.utflnx.who.knows.backend.model.maintenance.UpdateRequest
import com.utflnx.who.knows.backend.validation.IDataValidator
import org.springframework.stereotype.Component

/**
 * Sat, 30 Jul 2022
 * who-knows-backend by utifmd
 **/
@Component
class MaintenanceDataMapper(
    private val validator: IDataValidator): IMaintenanceDataMapper {
    override fun toMaintenance(createRequest: CreateRequest): Maintenance = createRequest.let {
        Maintenance(it.id, it.versionCode, it.versionName, it.active)
    }
    override fun toMaintenance(current: Maintenance, updateRequest: UpdateRequest): Maintenance = updateRequest.let {
        current.copy(versionCode = it.versionCode, versionName = it.versionName, active = it.active)
    }
    override fun toResponse(maintenance: Maintenance): Response = maintenance.let {
        Response(it.id, it.versionCode, it.versionName, it.active)
    }
    override fun validate(any: Any) = validator.validate(any)
}