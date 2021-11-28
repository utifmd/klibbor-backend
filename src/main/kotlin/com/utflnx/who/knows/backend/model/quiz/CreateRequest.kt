package com.utflnx.who.knows.backend.model.quiz

import javax.validation.constraints.NotBlank

data class CreateRequest(

    @field:NotBlank
    val quizId: String?,

    @field:NotBlank
    val roomId: String?,

    @field:NotBlank
    val images: List<String>?,

    @field:NotBlank
    val question: String?,

    @field:NotBlank
    val options: List<String>?,

    @field:NotBlank
    val answer: String?,

    @field:NotBlank
    val createdBy: String?
)