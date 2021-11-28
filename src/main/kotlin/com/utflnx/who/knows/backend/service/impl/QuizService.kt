package com.utflnx.who.knows.backend.service.impl

import com.utflnx.who.knows.backend.mapper.IQuizDataMapper
import com.utflnx.who.knows.backend.model.ListRequest
import com.utflnx.who.knows.backend.model.quiz.CreateRequest
import com.utflnx.who.knows.backend.model.quiz.Response
import com.utflnx.who.knows.backend.model.quiz.UpdateRequest
import com.utflnx.who.knows.backend.repository.IQuizRepository
import com.utflnx.who.knows.backend.service.IQuizService
import com.utflnx.who.knows.backend.validation.NotFoundException
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class QuizService(
    val repository: IQuizRepository,
    val mapper: IQuizDataMapper): IQuizService {

    override fun create(createRequest: CreateRequest): Response {
        val quiz = mapper.toQuiz(createRequest)

        repository.save(quiz)
        return mapper.toResponse(quiz)
    }

    override fun read(id: String): Response {
        val quiz = repository.findByIdOrNull(id) ?: throw NotFoundException()

        return mapper.toResponse(quiz)
    }

    override fun update(id: String, updateRequest: UpdateRequest): Response {
        val current = repository.findByIdOrNull(id) ?: throw NotFoundException()
        val updated = mapper.toQuiz(current, updateRequest)

        repository.save(updated)

        return mapper.toResponse(updated)
    }

    override fun delete(id: String) {
        val quiz = repository.findByIdOrNull(id) ?: throw NotFoundException()

        repository.delete(quiz)
    }

    override fun list(listRequest: ListRequest): List<Response> {
        val pagedQuestions = repository.findAll(PageRequest.of(listRequest.page, listRequest.size))
        val questions = pagedQuestions.get().collect(Collectors.toList())

        return questions.map { mapper.toResponse(it) }
    }

}