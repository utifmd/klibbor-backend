package com.utflnx.who.knows.backend.mapper.impl

import com.utflnx.who.knows.backend.entity.Result
import com.utflnx.who.knows.backend.mapper.IResultDataMapper
import com.utflnx.who.knows.backend.model.result.CreateRequest
import com.utflnx.who.knows.backend.model.result.Response
import com.utflnx.who.knows.backend.model.result.UpdateRequest
import com.utflnx.who.knows.backend.validation.IDataValidator
import org.springframework.stereotype.Component
import java.util.*

@Component
class ResultDataMapper(val validator: IDataValidator): IResultDataMapper {
    override fun toResult(createRequest: CreateRequest): Result {
        validator.validate(createRequest)

        return Result(
            createRequest.resultId ?: "",
            createRequest.roomId ?: "",
            createRequest.userId ?: "",
            createRequest.correctQuiz ?: emptyList(),
            createRequest.wrongQuiz ?: emptyList(),
            createRequest.score ?: 0,
            Date(),
            null
        )
    }

    override fun toResult(current: Result, updateRequest: UpdateRequest): Result {
        validator.validate(updateRequest)

        current.apply {
                correctQuiz = updateRequest.correctQuiz ?: emptyList()
                wrongQuiz = updateRequest.wrongQuiz ?: emptyList()
                score = updateRequest.score
                updatedAt = Date()
        }

        return current
    }

    override fun toResponse(result: Result): Response {
        return Response(
            result.id,
            result.roomId,
            result.userId,
            result.correctQuiz,
            result.wrongQuiz,
            result.score ?: 0,
            Date(),
            result.updatedAt
        )
    }
}