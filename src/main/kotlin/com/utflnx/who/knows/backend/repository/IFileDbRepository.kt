package com.utflnx.who.knows.backend.repository

import com.utflnx.who.knows.backend.entity.FileDb
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Tue, 04 Jan 2022
 * who-knows-backend by utifmd
 **/
interface IFileDbRepository: JpaRepository<FileDb, String>