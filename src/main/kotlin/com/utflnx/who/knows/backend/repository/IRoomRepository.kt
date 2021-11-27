package com.utflnx.who.knows.backend.repository

import com.utflnx.who.knows.backend.entity.Room
import org.springframework.data.jpa.repository.JpaRepository

interface IRoomRepository: JpaRepository<Room, String>