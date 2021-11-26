package com.utflnx.who.knows.backend.repository

import com.utflnx.who.knows.backend.entity.ApiKey
import org.springframework.data.jpa.repository.JpaRepository

interface IApiKeyRepository: JpaRepository<ApiKey, String>