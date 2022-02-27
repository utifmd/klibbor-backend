package com.utflnx.who.knows.backend.service.impl

import com.utflnx.who.knows.backend.mapper.IQuizDataMapper
import com.utflnx.who.knows.backend.model.ListRequest
import com.utflnx.who.knows.backend.model.quiz.CreateRequest
import com.utflnx.who.knows.backend.model.quiz.Response
import com.utflnx.who.knows.backend.model.quiz.UpdateRequest
import com.utflnx.who.knows.backend.repository.IQuizRepository
import com.utflnx.who.knows.backend.repository.IRoomRepository
import com.utflnx.who.knows.backend.service.IQuizService
import com.utflnx.who.knows.backend.validation.DataExistException
import com.utflnx.who.knows.backend.validation.DataNotFoundException
import com.utflnx.who.knows.backend.validation.NotFoundException
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class QuizService(
    val reposQuiz: IQuizRepository,
    val reposRoom: IRoomRepository,
    val mapper: IQuizDataMapper): IQuizService {

    override fun create(createRequest: CreateRequest): Response {
        val quiz = mapper.toQuiz(createRequest)

        if (reposQuiz.existsById(quiz.quizId))
            throw DataExistException()

        reposRoom.findByIdOrNull(quiz.roomId) ?:
            throw DataNotFoundException("roomId")

        reposQuiz.save(quiz)

        return mapper.toResponse(quiz)
    }

    override fun read(id: String): Response {
        val quiz = reposQuiz.findByIdOrNull(id) ?: throw NotFoundException()

        return mapper.toResponse(quiz)
    }

    override fun update(id: String, updateRequest: UpdateRequest): Response {
        val current = reposQuiz.findByIdOrNull(id) ?: throw NotFoundException()
        val updated = mapper.toQuiz(current, updateRequest)

        reposQuiz.save(updated)

        return mapper.toResponse(updated)
    }

    override fun delete(id: String) {
        val quiz = reposQuiz.findByIdOrNull(id) ?: throw NotFoundException()

        reposQuiz.delete(quiz)
    }

    override fun list(listRequest: ListRequest): List<Response> {
        mapper.validate(listRequest)

        val questions = reposQuiz.findAll(PageRequest.of(listRequest.page, listRequest.size))
        //val questions = pagedQuestions.get().collect(Collectors.toList())

        return questions.map(mapper::toResponse).shuffled()
    }
}