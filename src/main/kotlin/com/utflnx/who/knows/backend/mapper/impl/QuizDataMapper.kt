package com.utflnx.who.knows.backend.mapper.impl

import com.utflnx.who.knows.backend.entity.Quiz
import com.utflnx.who.knows.backend.mapper.IQuizDataMapper
import com.utflnx.who.knows.backend.model.quiz.CreateRequest
import com.utflnx.who.knows.backend.model.quiz.Response
import com.utflnx.who.knows.backend.model.quiz.UpdateRequest
import com.utflnx.who.knows.backend.validation.IDataValidator
import org.springframework.stereotype.Component
import java.util.*

@Component
class QuizDataMapper(val validator: IDataValidator): IQuizDataMapper {
    override fun toQuiz(createRequest: CreateRequest): Quiz {
        validate(createRequest)

        return Quiz(
            createRequest.quizId ?: "",
            createRequest.roomId ?: "",
            createRequest.images ?: emptyList(),
            createRequest.question ?: "",
            createRequest.options ?: emptyList(),
            createRequest.answer ?: "",
            createRequest.createdBy ?: "",
            Date(),
            null,
            null
        )
    }

    override fun toQuiz(current: Quiz, updateRequest: UpdateRequest): Quiz {
        validate(updateRequest)

        current.apply {
            images = updateRequest.images
            question = updateRequest.question
            options = updateRequest.options
            answer = updateRequest.answer
            createdBy = updateRequest.createdBy
            updatedAt = Date()
        }

        return current
    }

    override fun toResponse(quiz: Quiz): Response {
        return Response(
            quiz.quizId,
            quiz.roomId,
            quiz.images,
            quiz.question,
            quiz.options,
            quiz.answer,
            quiz.createdBy,
            quiz.createdAt,
            quiz.updatedAt,
            quiz.user
        )
    }

    override fun validate(any: Any) {
        validator.validate(any)
    }
}