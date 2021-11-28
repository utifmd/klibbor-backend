package com.utflnx.who.knows.backend.repository

import com.utflnx.who.knows.backend.entity.Participant
import org.springframework.data.jpa.repository.JpaRepository

interface IParticipantRepository: JpaRepository<Participant, String>