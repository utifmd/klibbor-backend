package com.utflnx.who.knows.backend.controller

import com.utflnx.who.knows.backend.model.WebResponse
import com.utflnx.who.knows.backend.validation.*
import org.springframework.web.multipart.MaxUploadSizeExceededException
import org.springframework.web.multipart.MultipartException
import javax.validation.ConstraintViolationException

interface IErrorController {
    fun handleValidation(exception: ConstraintViolationException): WebResponse<String>
    fun handleNotFound(exception: NotFoundException): WebResponse<String>
    fun handleNotFound(exception: NoSuchElementException): WebResponse<String>
    fun handleUnauthorized(exception: UnauthorizedException): WebResponse<String>

    fun handleInvalidMultipart(exception: MultipartException): WebResponse<String>
    fun handleInvalidEmail(exception: InvalidEmailException): WebResponse<String>
    fun handleInvalidPassword(exception: InvalidPasswordException): WebResponse<String>
    fun handleInvalidPassword(exception: MaxUploadSizeExceededException): WebResponse<String>
}