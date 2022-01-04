package com.utflnx.who.knows.backend.entity

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

/**
 * Tue, 04 Jan 2022
 * who-knows-backend by utifmd
 **/
@Entity
@Table(name = "files")
data class FileDb(
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private var _id: String? = null,

    @field:NotBlank
    val name: String? = null,

    @field:NotBlank
    val type: String? = null,

    @Lob
    @field:NotNull
    val data: ByteArray
) {
    val id: String? get() = _id

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as FileDb

        if (id != other.id) return false
        if (name != other.name) return false
        if (type != other.type) return false
        if (!data.contentEquals(other.data)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + type.hashCode()
        result = 31 * result + data.contentHashCode()
        return result
    }
}