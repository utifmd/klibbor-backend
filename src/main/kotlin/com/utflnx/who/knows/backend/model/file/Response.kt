package com.utflnx.who.knows.backend.model.file

import com.utflnx.who.knows.backend.entity.FileDb
import com.utflnx.who.knows.backend.entity.Result
import java.util.*

data class Response(
    // val id: String,
    val name: String,
    val url: String,
    val type: String,
    val fileDb: FileDb,
    val size: Long
)