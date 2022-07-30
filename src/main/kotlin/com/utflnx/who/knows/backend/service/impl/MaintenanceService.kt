package com.utflnx.who.knows.backend.service.impl

import com.utflnx.who.knows.backend.mapper.IMaintenanceDataMapper
import com.utflnx.who.knows.backend.model.maintenance.CreateRequest
import com.utflnx.who.knows.backend.model.maintenance.Response
import com.utflnx.who.knows.backend.model.maintenance.UpdateRequest
import com.utflnx.who.knows.backend.repository.IMaintenanceRepository
import com.utflnx.who.knows.backend.service.IMaintenanceService
import com.utflnx.who.knows.backend.validation.NotFoundException
import org.springframework.stereotype.Service
import java.util.stream.Collectors

/**
 * Sat, 30 Jul 2022
 * who-knows-backend by utifmd
 **/
@Service
class MaintenanceService(
    private val repository: IMaintenanceRepository,
    private val mapper: IMaintenanceDataMapper): IMaintenanceService {

    override fun create(createRequest: CreateRequest): Response {
        mapper.validate(createRequest)
        val maintenance = repository.save(mapper.toMaintenance(createRequest))

        return mapper.toResponse(maintenance)
    }

    override fun read(): Response {
        //val data = repository.findLatestByActiveOrNull() ?: throw NotFoundException()
        val data = repository.findAll().stream().collect(Collectors.toList()).getOrNull(0) ?: throw NotFoundException()
        return mapper.toResponse(data)
    }

    override fun delete() = repository.deleteAll()
}