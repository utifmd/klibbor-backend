package com.utflnx.who.knows.backend.model.file

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class CreateRequest(
    @field:NotBlank
    val name: String?,

    @field:NotBlank
    val type: String?,

    @field:NotNull // @field:Min(value = 0)
    val data: ByteArray,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CreateRequest

        if (name != other.name) return false
        if (type != other.type) return false
        if (!data.contentEquals(other.data)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name?.hashCode() ?: 0
        result = 31 * result + (type?.hashCode() ?: 0)
        result = 31 * result + data.contentHashCode()
        return result
    }
}