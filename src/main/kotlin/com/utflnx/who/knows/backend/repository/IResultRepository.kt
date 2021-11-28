package com.utflnx.who.knows.backend.repository

import com.utflnx.who.knows.backend.entity.Result
import org.springframework.data.jpa.repository.JpaRepository

interface IResultRepository: JpaRepository<Result, String>