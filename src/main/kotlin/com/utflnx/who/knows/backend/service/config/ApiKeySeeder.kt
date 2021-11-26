package com.utflnx.who.knows.backend.service.config

import com.utflnx.who.knows.backend.entity.ApiKey
import com.utflnx.who.knows.backend.repository.IApiKeyRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class ApiKeySeeder(
    private val repository: IApiKeyRepository): ApplicationRunner {
    private val secretKey = "utif.pages.dev"

    override fun run(args: ApplicationArguments?) {
        if(!repository.existsById(secretKey)){
            repository.save(ApiKey(secretKey))
        }
    }
}